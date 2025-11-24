package com.rollinmoney.service;

import java.math.BigDecimal;
import java.util.List;

import com.rollinmoney.dao.HistoryDAO;
import com.rollinmoney.dto.HistoryDTO;
import com.rollinmoney.dto.HoldingDTO;
import com.rollinmoney.dto.MemberDTO;

public class HistoryService {
	private final HistoryDAO historyDAO = new HistoryDAO();
	private final HoldingService holdingService = new HoldingService();
	
	public String insertHistory(MemberDTO member, String actionType, String productName) {
		HistoryDTO newHistory = new HistoryDTO();
		BigDecimal total = member.getCash();
		newHistory.setMemberId(member.getMemberId());
		List<HoldingDTO> holdingList = holdingService.getAllHoldings(member.getMemberId());
		for (HoldingDTO holding: holdingList) {
			total = total.add(holding.getBuyAmount());
		}
		newHistory.setTotalAsset(total);
		newHistory.setActionType(actionType);
		newHistory.setProductName(productName);
		return historyDAO.insertHistory(newHistory);
	}

	public List<HistoryDTO> loadHistory(MemberDTO member) {
		return historyDAO.loadHistory(member);
	}
}
