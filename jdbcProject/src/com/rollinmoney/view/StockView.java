package com.rollinmoney.view;

import java.util.List;

import com.rollinmoney.dto.StockDTO;
import com.rollinmoney.util.StringUtil;


public class StockView {

	public static void showStockMenu() {
		System.out.println("\n=============================");
		System.out.println("          주식 메뉴");
		System.out.println("=============================");
		System.out.println("1. 주식 조회");
		System.out.println("2. 주식 매수");
		System.out.println("3. 주식 매도");
		System.out.println("4. 뒤로 가기");
		System.out.print("선택 >> ");
	}

	public static void showStockSearchMenu() {
		System.out.println("\n=============================");
		System.out.println("       주식 조회 메뉴");
		System.out.println("=============================");
		System.out.println("1. 한국 주식(KOSPI, KOSDAQ) 전체 조회"); // ID > 7763
		System.out.println("2. 미국 주식(NASDAQ, NYSE) 전체 조회"); // ID < 7764
		System.out.println("3. 주식명으로 조회");
		System.out.println("4. 티커로 조회");
		System.out.println("5. 뒤로 가기");
		System.out.print("선택 >> ");
	}

	public static void printStock(StockDTO stock) {
		System.out.println("** 주식 정보 **");
		System.out.println("종목 이름: " + stock.getProductName());
		System.out.println("티커명:   " + stock.getTicker());
		System.out.println("현재가:   " + stock.getCurPrice());
	}

	public static void printStockList(List<StockDTO> list) {
		if (list==null) {
			System.out.println("해당되는 주식이 없습니다..");
			return;
		}
		// 헤더 출력 (칸 너비를 조금 넉넉하게 조정했습니다)
	    System.out.println("┌────────────┬──────────────────────────┬───────────┬────────────┐");
	    System.out.println("│    티커    │        종목 이름         │   현재가  │   축약명   │");
	    System.out.println("├────────────┼──────────────────────────┼───────────┼────────────┤");

	    for (StockDTO stock : list) {
	        
	        String originalName = stock.getProductName();
	        String dispName = StringUtil.getPaddingString(originalName, 12);
	        
	        String dispAbrv = stock.getAbrvName();
	        if (dispAbrv == null || dispAbrv.equals(originalName)) {
	            dispAbrv = "-";
	        }

	        System.out.printf("│ %10s │ %-12s │ %9s │ %-10s │\n", 
	                stock.getTicker(), 
	                dispName, 
	                stock.getCurPrice(),
	                dispAbrv);
	    }
	    System.out.println("└────────────┴──────────────────────────┴───────────┴────────────┘");
	    System.out.println("총 " + list.size() + "건 조회됨");
	}
}
