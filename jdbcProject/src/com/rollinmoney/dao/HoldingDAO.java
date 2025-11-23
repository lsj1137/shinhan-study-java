package com.rollinmoney.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.rollinmoney.dto.HoldingDTO;
import com.rollinmoney.dto.MemberDTO;
import com.rollinmoney.dto.StockDTO;
import com.rollinmoney.util.DBUtil;
import com.rollinmoney.util.DateUtil;

public class HoldingDAO {
	static final String SQL_SELECT_WITH_ID = """
select *
from HOLDINGS
where MEMBER_ID = ?
""";
	
	static final String SQL_SELECT_STOCK_WITH_ID = """
select *
from HOLDINGS
where PRODUCT_TYPE='STOCK' and MEMBER_ID = ?
""";
	
	static final String SQL_INSERT = """
insert into holdings (member_id, product_id, product_type, quantity, buy_price, buy_amount, buy_date, matured_at)
values (?,?,?,?,?,?,?,?)
""";
	
	static final String SQL_UPDATE_CASH = """
update MEMBERS
set CASH = ?
where MEMBER_ID = ?
""";
	
	static final String SQL_UPDATE_QUANTITY = """
update HOLDINGS
set QUANTITY = ?
where holding_id = ?
""";

	private HoldingDTO makeHolding(ResultSet rs) throws SQLException {
		HoldingDTO holding = new HoldingDTO();
		holding.setHoldingId(rs.getLong("holding_id"));
		holding.setProductId(rs.getLong("product_id"));
		holding.setProductType(rs.getString("product_type"));
		holding.setMemberId(rs.getLong("member_id"));
		holding.setQuantity(rs.getInt("quantity"));
		holding.setBuyDate(rs.getDate("buy_date"));
		holding.setBuyPrice(rs.getBigDecimal("buy_price"));
		holding.setBuyAmount(rs.getBigDecimal("buy_amount"));
		holding.setMaturedAt(rs.getDate("matured_at"));
		return holding;
	}

	public List<HoldingDTO> getAllHoldings(Long loggedInMemberId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
		List<HoldingDTO> holdingList = new ArrayList<>();

        try {
            conn = DBUtil.dbConnect();
            pstmt = conn.prepareStatement(SQL_SELECT_WITH_ID);
            pstmt.setLong(1, loggedInMemberId);
            rs = pstmt.executeQuery();
			while (rs.next()) {
				HoldingDTO newStock = makeHolding(rs);
				holdingList.add(newStock);
			}
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbDisconnect(conn, pstmt, rs);
        }
		return holdingList;
	}
	
	// TODO 이미 있으면 UPDATE 해야함!!!
	public String buyStock(MemberDTO member, StockDTO stock, int quantity) {
		String message = null;

		Connection conn = null;
        PreparedStatement insertStmt = null;
        PreparedStatement updateStmt = null;
		
		try {
			conn = DBUtil.dbConnect();
			conn.setAutoCommit(false);
			insertStmt = conn.prepareStatement(SQL_INSERT);
			BigDecimal amount = stock.getCurPrice().multiply(new BigDecimal(quantity));
			insertStmt.setLong(1, member.getMemberId());
			insertStmt.setLong(2, stock.getProductId());
			insertStmt.setString(3, stock.getProductType());
			insertStmt.setLong(4, quantity);
			insertStmt.setBigDecimal(5, stock.getCurPrice());
			insertStmt.setBigDecimal(6, amount);
			insertStmt.setDate(7, DateUtil.convertToSQLDate(Date.valueOf(LocalDate.now())));
			insertStmt.setDate(8, null);
			int result1 = insertStmt.executeUpdate(); // insert, delete, update는 executeUpdate()

			updateStmt = conn.prepareStatement(SQL_UPDATE_CASH);
			BigDecimal curCash = member.getCash();
			BigDecimal newCash = curCash.subtract(amount);
			updateStmt.setBigDecimal(1, newCash);
			updateStmt.setLong(2, member.getMemberId());
			int result2 = updateStmt.executeUpdate();
			if (result1>0 && result2>0) {
				message = "✅ 매수 체결되었습니다.\n가격: "+stock.getCurPrice()+"\n수량: "+quantity+"\n총액: "+amount;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			message = "❌ 매수에 실패했습니다";
		} finally {
			if (updateStmt != null)
				try {
					updateStmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			DBUtil.dbDisconnect(conn, insertStmt, null);
		}
		
		return message;
	}


	public List<HoldingDTO> getAllStocks(Long loggedInMemberId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
		List<HoldingDTO> holdingList = new ArrayList<>();

        try {
            conn = DBUtil.dbConnect();
            pstmt = conn.prepareStatement(SQL_SELECT_STOCK_WITH_ID);
            pstmt.setLong(1, loggedInMemberId);
            rs = pstmt.executeQuery();
			while (rs.next()) {
				HoldingDTO newStock = makeHolding(rs);
				holdingList.add(newStock);
			}
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.dbDisconnect(conn, pstmt, rs);
        }
		return holdingList;
	}
	
	
	public String sellStock(MemberDTO member, StockDTO stock, HoldingDTO holding, int quantity) {
		String message = null;

		Connection conn = null;
        PreparedStatement updateStmt1 = null;
        PreparedStatement updateStmt2 = null;
		
		try {
			conn = DBUtil.dbConnect();
			conn.setAutoCommit(false);
			updateStmt1 = conn.prepareStatement(SQL_UPDATE_QUANTITY);
			updateStmt1.setLong(1, holding.getQuantity()-quantity);
			updateStmt1.setLong(2, holding.getHoldingId());
			int result1 = updateStmt1.executeUpdate(); // insert, delete, update는 executeUpdate()

			updateStmt2 = conn.prepareStatement(SQL_UPDATE_CASH);
			BigDecimal curCash = member.getCash();
			BigDecimal amount = stock.getCurPrice().multiply(new BigDecimal(quantity));
			BigDecimal newCash = curCash.add(amount);
			updateStmt2.setBigDecimal(1, newCash);
			updateStmt2.setLong(2, member.getMemberId());
			int result2 = updateStmt2.executeUpdate();
			if (result1>0 && result2>0) {
				message = "✅ 매도 체결되었습니다.\n가격: "+stock.getCurPrice()+"\n수량: "+quantity+"\n총액: "+amount;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			message = "❌ 매도에 실패했습니다";
		} finally {
			if (updateStmt2 != null)
				try {
					updateStmt2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			DBUtil.dbDisconnect(conn, updateStmt1, null);
		}
		
		return message;
	}
}
