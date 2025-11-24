package com.rollinmoney.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rollinmoney.dto.StockDTO;
import com.rollinmoney.util.DBUtil;

public class StockDAO {
	static final String SQL_SELECT_KOR_STOCKS = """
select *
from stocks join products using (product_id)
where product_id>7763
""";
	static final String SQL_SELECT_US_STOCKS = """
select *
from stocks join products using (product_id)
where product_id<7764
""";
	static final String SQL_SELECT_WITH_NAME = """
select *
from stocks join products using (product_id)
where product_NAME like ?
""";
	static final String SQL_SELECT_WITH_TICKER = """
select *
from stocks join products using (product_id)
where ticker like ?
""";
	static final String SQL_SELECT_WITH_ID = """
select *
from stocks join products using (product_id)
where product_id = ?
""";
	
	private StockDTO makeStock(ResultSet rs) throws SQLException {
		StockDTO stock = new StockDTO();
		stock.setProductId(rs.getLong("Product_id"));
		stock.setProductType(rs.getString("Product_type"));
		stock.setProductName(rs.getString("Product_name"));
		stock.setCurPrice(rs.getBigDecimal("st_cur_price"));
		stock.setTicker(rs.getString("ticker"));
		stock.setAbrvName(rs.getString("st_abrv_name"));
		stock.setEngName(rs.getString("st_eng_name"));
		return stock;
	}
	
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

    // 가격만 업데이트
    public void updateStockPrice(StockDTO stock) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DBUtil.dbConnect();
            
            // 현재가만 수정
            String sql = "UPDATE STOCKS SET ST_CUR_PRICE = ? WHERE TICKER = ?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setBigDecimal(1, stock.getCurPrice());
            pstmt.setString(2, stock.getTicker());
            
            int result = pstmt.executeUpdate();

//            System.out.println("🔄 [" + stock.getAbrvName() + "] 가격 갱신 완료: " + stock.getCurPrice());

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
            conn = DBUtil.dbConnect();
            
            // 두 테이블(Products, Stocks)에 모두 성공적으로 들어가야만 저장하도록 오토커밋 끄기
            conn.setAutoCommit(false);

            String sqlProduct = "INSERT INTO PRODUCTS (PRODUCT_TYPE, PRODUCT_NAME) VALUES ('STOCK', ?)";
            
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

	public List<StockDTO> getKorStocks() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<StockDTO> stockList = new ArrayList<>();
		try {
			conn = DBUtil.dbConnect();
			st = conn.createStatement();
			rs = st.executeQuery(SQL_SELECT_KOR_STOCKS);
			while (rs.next()) {
				StockDTO newStock = makeStock(rs);
				stockList.add(newStock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		
		return stockList;
	}

	public List<StockDTO> getUSStocks() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<StockDTO> stockList = new ArrayList<>();
		
		try {
			conn = DBUtil.dbConnect();
			st = conn.createStatement();
			rs = st.executeQuery(SQL_SELECT_US_STOCKS);
			while (rs.next()) {
				StockDTO newStock = makeStock(rs);
				stockList.add(newStock);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		
		return stockList;
	}

    // 해당 종목이 이미 DB에 있는지 체크
    public StockDTO findById(long id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StockDTO stock = null;

        try {
            conn = DBUtil.dbConnect();
            pstmt = conn.prepareStatement(SQL_SELECT_WITH_ID);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
			while (rs.next()) {
				stock = makeStock(rs);
			}
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbDisconnect(conn, pstmt, rs);
        }
        return stock;
    }
    
	public List<StockDTO> findByName(String name) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
		List<StockDTO> stockList = new ArrayList<>();

        try {
            conn = DBUtil.dbConnect();
            pstmt = conn.prepareStatement(SQL_SELECT_WITH_NAME);
            pstmt.setString(1, "%"+name+"%");
            rs = pstmt.executeQuery();
			while (rs.next()) {
				StockDTO newStock = makeStock(rs);
				stockList.add(newStock);
			}
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbDisconnect(conn, pstmt, rs);
        }
		return stockList;
	}

	public List<StockDTO> findByTicker(String ticker) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
		List<StockDTO> stockList = new ArrayList<>();

        try {
            conn = DBUtil.dbConnect();
            pstmt = conn.prepareStatement(SQL_SELECT_WITH_TICKER);
            pstmt.setString(1, "%"+ticker+"%");
            rs = pstmt.executeQuery();
			while (rs.next()) {
				StockDTO newStock = makeStock(rs);
				stockList.add(newStock);
			}
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbDisconnect(conn, pstmt, rs);
        }
		return stockList;
	}

}