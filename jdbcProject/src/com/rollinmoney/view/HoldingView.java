package com.rollinmoney.view;

import java.math.BigDecimal;
import java.util.List;

import com.rollinmoney.dto.BankProductDTO;
import com.rollinmoney.dto.HoldingDTO;
import com.rollinmoney.dto.MemberDTO;
import com.rollinmoney.dto.StockDTO;
import com.rollinmoney.service.StockService;
import com.rollinmoney.util.Calculator;

public class HoldingView {
	static StockService stockService = new StockService();

	public static void printHoldings(MemberDTO member, List<HoldingDTO> allHoldings) {
		System.out.println("┌ 보유 자산 현황 ───────────────────────────────────────");
		BigDecimal total = member.getCash();
		System.out.println("│ 현금 | " + total + "원");
		if (allHoldings == null || allHoldings.size() == 0) {
			System.out.println("그 외 보유한 주식/은행 자산이 없습니다.");
			return;
		}

		for (HoldingDTO holding : allHoldings) {
			total = total.add(holding.getBuyAmount());
			if (holding.getProductType().equals("STOCK")) {
				StockDTO stock = stockService.findById(holding.getProductId());
				BigDecimal profit = Calculator.calProfit(holding.getBuyPrice(), stock.getCurPrice(),
						holding.getQuantity());
				System.out.println("│ 주식 | " + stock.getProductName() + " | 수량: " + holding.getQuantity() + " | 평단가: "
						+ holding.getBuyPrice() + " | 현재가: " + stock.getCurPrice() + " | 차익: " + profit);
				total = total.add(profit);
			} else {
				BankProductDTO bank = null;
				System.out.println("│ 은행 | " + bank.getProductName() + " | 납입 금액: " + holding.getBuyAmount());
			}
		}
		System.out.println("└ 총 평가 금액: " + total + "원");

	}

	public static void printStocks(List<HoldingDTO> stocks, List<StockDTO> stockInfos) {
		System.out.println("┌ 보유 주식 현황 ───────────────────────────────────────");
		if (stocks == null || stocks.size() == 0) {
			System.out.println("│ 보유한 주식이 없습니다.");
			return;
		}

		for (HoldingDTO holding : stocks) {
			StockDTO stock = null;
			for (StockDTO stockInfo: stockInfos) {
				if (holding.getProductId() == stockInfo.getProductId()) {
					stock = stockInfo;
					break;
				}
			}
			BigDecimal profit = Calculator.calProfit(holding.getBuyPrice(), stock.getCurPrice(), holding.getQuantity());
			System.out.println("│ " + stock.getTicker() + " | " + stock.getProductName() + " | 수량: "
					+ holding.getQuantity() + " | 평단가: " + holding.getBuyPrice() + " | 현재가: " + stock.getCurPrice()
					+ " | 차익: " + profit);
		}

	}

}
