package com.rollinmoney.view;

import java.util.List;

import com.rollinmoney.dto.HoldingDTO;
import com.rollinmoney.dto.MemberDTO;

public class HoldingView {

	public static void printHoldings(MemberDTO member, List<HoldingDTO> allHoldings) {
		System.out.println("보유 현금: "+ member.getCash()+"원");
		if (allHoldings == null || allHoldings.size()==0) {
			System.out.println("그 외 보유한 주식/은행 자산이 없습니다.");
			return;
		}
		for (HoldingDTO holding: allHoldings) {
			System.out.println(holding);
		}
	}
	
}
