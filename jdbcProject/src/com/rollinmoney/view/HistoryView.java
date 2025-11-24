package com.rollinmoney.view;

import java.math.BigDecimal;
import java.util.List;

import com.rollinmoney.dto.HistoryDTO;
import com.rollinmoney.util.DateUtil;
import com.rollinmoney.util.StringUtil;

public class HistoryView {

	public static void printHistory(List<HistoryDTO> historyList) {
		BigDecimal past = BigDecimal.ZERO;
		if (historyList.size() == 0) {
			System.out.println("기록이 없습니다.");
			return;
		}
		historyList.sort((HistoryDTO a, HistoryDTO b) -> a.getRecordDate().compareTo(b.getRecordDate()));
		for (HistoryDTO historyDTO : historyList) {
			BigDecimal curAsset = historyDTO.getTotalAsset();
			String time = DateUtil.formatTimestamp(historyDTO.getRecordDate());
			BigDecimal gap = curAsset.subtract(past);
			String strAsset = StringUtil.formatNumber(curAsset);
			String strGap = StringUtil.formatNumber(gap);
			String data = time + " | " + historyDTO.getActionType() + " | " + historyDTO.getProductName() + " | 자산: "
					+ strAsset + "원 | 변동: " + (gap.compareTo(BigDecimal.ZERO) > 0 ? "+" : "") + strGap + "원";
			System.out.println(data);
			past = curAsset;
		}
	}

}
