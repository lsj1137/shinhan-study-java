package com.rollinmoney.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rollinmoney.dto.StockDTO;
import com.rollinmoney.util.DBUtil;

public class StockDAO {
	
	// 통합 메서드
    public void saveOrUpdate(StockDTO stock) {
        if (isStockExist(stock.getTicker())) {
            // 이미 있으면 -> 가격 업데이트
            updateStockPrice(stock);
        } else {
            // 없으면 -> 신규 등록
            insertStock(stock);
        }
    }
    
    // 해당 종목이 이미 DB에 있는지 체크
    public boolean isStockExist(String ticker) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean exists = false;

        try {
            conn = DBUtil.dbConnect();
            // Ticker로 검색해서 카운트
            String sql = "SELECT count(*) FROM STOCKS WHERE TICKER = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ticker);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                exists = (count > 0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbDisconnect(conn, pstmt, rs);
        }
        return exists;
    }

    // 3. 가격만 업데이트 (UPDATE)
    public void updateStockPrice(StockDTO stock) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtil.dbConnect();
            
            // 현재가(ST_CUR_PRICE)만 수정
            String sql = "UPDATE STOCKS SET ST_CUR_PRICE = ? WHERE TICKER = ?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setBigDecimal(1, stock.getCurPrice());
            pstmt.setString(2, stock.getTicker());
            
            int result = pstmt.executeUpdate();
            
            if (result > 0) {
                System.out.println("🔄 [" + stock.getAbrvName() + "] 가격 갱신 완료: " + stock.getCurPrice());
                // update는 자동 커밋(Auto Commit) 써도 무방하지만, 명시적으로 하려면:
                // conn.commit(); (DBUtil 연결이 AutoCommit true 상태라면 생략 가능)
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbDisconnect(conn, pstmt, null);
        }
    }

    // 주식 정보 저장 메서드
    public boolean insertStock(StockDTO stock) {
        Connection conn = null;
        PreparedStatement pstmtProduct = null;
        PreparedStatement pstmtStock = null;
        ResultSet rs = null;
        boolean isSuccess = false;

        try {
            // 1. DB 연결
            conn = DBUtil.dbConnect();
            
            // [핵심] 트랜잭션 시작: 자동 커밋을 끕니다.
            // 두 테이블(Products, Stocks)에 모두 성공적으로 들어가야만 저장하기 위함입니다.
            conn.setAutoCommit(false);

            // ==========================================
            // STEP 1: PRODUCTS 테이블에 먼저 저장 (부모)
            // ==========================================
            String sqlProduct = "INSERT INTO PRODUCTS (PRODUCT_TYPE, PRODUCT_NAME) VALUES ('STOCK', ?)";
            
            // Oracle 11g/Trigger 사용 시: 생성된 키(PRODUCT_ID)를 돌려받겠다고 명시해야 함
            pstmtProduct = conn.prepareStatement(sqlProduct, new String[]{"PRODUCT_ID"});
            
            pstmtProduct.setString(1, stock.getProductName());
            int result1 = pstmtProduct.executeUpdate();

            // 생성된 PRODUCT_ID 가져오기
            long generatedId = 0;
            rs = pstmtProduct.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getLong(1);
            } else {
                throw new SQLException("PRODUCT_ID 생성 실패");
            }

            // ==========================================
            // STEP 2: STOCKS 테이블에 저장 (자식)
            // ==========================================
            String sqlStock = "INSERT INTO STOCKS (PRODUCT_ID, TICKER, ST_CUR_PRICE, ST_ABRV_NAME, ST_ENG_NAME) "
                            + "VALUES (?, ?, ?, ?, ?)";
            
            pstmtStock = conn.prepareStatement(sqlStock);
            
            pstmtStock.setLong(1, generatedId);       // 위에서 받은 ID 사용
            pstmtStock.setString(2, stock.getTicker());
            pstmtStock.setBigDecimal(3, stock.getCurPrice());
            pstmtStock.setString(4, stock.getAbrvName());
            pstmtStock.setString(5, stock.getEngName());
            
            int result2 = pstmtStock.executeUpdate();

            // 둘 다 성공했을 때만 커밋
            if (result1 > 0 && result2 > 0) {
                conn.commit();
                isSuccess = true;
                System.out.println("✅ 주식 저장 완료: " + stock.getAbrvName() + " (ID: " + generatedId + ")");
            } else {
                conn.rollback();
                System.out.println("❌ 저장 실패: 롤백됨");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // 에러 발생 시 롤백
            if (conn != null) {
                try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            }
        } finally {
            // 자원 해제 (DBUtil 사용)
            // PreparedStatement가 두 개라 각각 닫아주는 게 정석이지만, 
            // DBUtil.dbDisconnect는 하나만 받으므로 여기서 따로 닫거나 DBUtil을 수정해서 사용
            try {
                if (pstmtProduct != null) pstmtProduct.close();
                // pstmtStock과 conn은 DBUtil로 정리
                DBUtil.dbDisconnect(conn, pstmtStock, rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return isSuccess;
    }
}