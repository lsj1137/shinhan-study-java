package com.rollinmoney.service;

import java.util.List;

import com.rollinmoney.dao.HoldingDAO;
import com.rollinmoney.dto.HoldingDTO;
import com.rollinmoney.dto.MemberDTO;
import com.rollinmoney.dto.StockDTO;

public class HoldingService {
	private final HoldingDAO holdingDAO = new HoldingDAO();

	public List<HoldingDTO> getAllHoldings(Long loggedInMemberId) {
		return holdingDAO.getAllHoldings(loggedInMemberId);
	}

	public String buyStock(MemberDTO member, StockDTO stock, int quantity) {
		return holdingDAO.buyStock(member, stock, quantity);
	}
	
}
