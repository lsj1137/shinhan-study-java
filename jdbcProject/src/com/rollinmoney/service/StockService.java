package com.rollinmoney.service;

import java.math.BigDecimal;
import java.util.List;

import com.rollinmoney.api.KisApiManager;
import com.rollinmoney.dao.StockDAO;
import com.rollinmoney.dto.StockDTO;

public class StockService {
	private final KisApiManager kisApiManager = new KisApiManager();
	private final StockDAO stockDAO = new StockDAO();
	
	// KIS API를 통해 현재가를 조회하고, DB에 저장(혹은 갱신)하는 메서드
    public void registerStockWithKis(String ticker, String stockName) {
        try {
            // API(한국투자증권)로 현재가 가져오기
            BigDecimal currentPrice = kisApiManager.getStockPrice(ticker);

            // 가격을 못 가져왔으면(0원 or null) 중단
            if (currentPrice == null || currentPrice.compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println("⚠️ [" + stockName + "] 시세 조회 실패 (장 종료 혹은 에러)");
                return;
            }

            // API에서는 약어명, 영문명을 안 주므로 일단 한글명, null로 채움
            StockDTO stockDTO = new StockDTO(stockName, ticker, currentPrice, stockName, null);

            // DAO 내부에서 (있으면 UPDATE, 없으면 INSERT) 로직이 돕니다.
            stockDAO.saveOrUpdate(stockDTO);

            System.out.println("✅ [" + stockName + "] 시세 반영 완료: " + currentPrice + "원");
        } catch (Exception e) {
            System.err.println("❌ [" + stockName + "] 서비스 처리 중 에러: " + e.getMessage());
            e.printStackTrace();
        }
    }

	public List<StockDTO> getKorStocks() {
		return stockDAO.getKorStocks();
	}

	public List<StockDTO> getUSStocks() {
		return stockDAO.getUSStocks();
	}

	public List<StockDTO> findByName(String name) {
		return stockDAO.findByName(name);
	}

	public List<StockDTO> findByTicker(String ticker) {
		return stockDAO.findByTicker(ticker);
	}
	
}
