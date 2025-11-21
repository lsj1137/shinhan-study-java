package com.rollinmoney.service;

import java.math.BigDecimal;

import com.rollinmoney.api.KisApiManager;
import com.rollinmoney.dao.StockDAO;
import com.rollinmoney.dto.StockDTO;

public class StockService {
	private final KisApiManager kisApiManager = new KisApiManager();
	private final StockDAO stockDAO = new StockDAO();
	
	/**
     * KIS API를 통해 현재가를 조회하고, DB에 저장(혹은 갱신)하는 메서드
     * @param ticker 종목코드 (예: 005930)
     * @param stockName 종목명 (예: 삼성전자) - API에서 가격만 오므로 이름은 받아야 함
     */
    public void registerStockWithKis(String ticker, String stockName) {
        try {
            // 1. 외부 API(한국투자증권)를 찔러서 현재가 가져오기
            BigDecimal currentPrice = kisApiManager.getStockPrice(ticker);

            // 2. 가격을 못 가져왔으면(0원 or null) 중단
            if (currentPrice == null || currentPrice.compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println("⚠️ [" + stockName + "] 시세 조회 실패 (장 종료 혹은 에러)");
                return;
            }

            // 3. DTO 생성 (데이터 포장)
            // 생성자 순서: (productName, ticker, price, abrvName, engName)
            // API에서는 약어명, 영문명을 안 주므로 일단 한글명, null로 채움
            StockDTO stockDTO = new StockDTO(stockName, ticker, currentPrice, stockName, null);

            // 4. DAO에게 던지기 (저장해!)
            // DAO 내부에서 (있으면 UPDATE, 없으면 INSERT) 로직이 돕니다.
            stockDAO.saveOrUpdate(stockDTO);

            // 로그 출력
            System.out.println("✅ [" + stockName + "] 시세 반영 완료: " + currentPrice + "원");

        } catch (Exception e) {
            System.err.println("❌ [" + stockName + "] 서비스 처리 중 에러: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
