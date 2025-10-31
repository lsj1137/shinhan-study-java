package com.shinhan.practice_exam;

// 문제 해답
public class MembershipVIP {
	
	// 속성이 적은 경우 배열에 담는것도 좋지만, 속성이 많아질 수록 순서별로 어떤 값을 의미했는지 기억하기 힘들어집니다.
	// 따라서 저는 별도로 Member 클래스를 만들어서 구현했습니다.
	public static int[] run(int[] periods, int[][] payments, int[] estimates) {
		int[] result = { 0, 0 };
		// 문제에서 periods 의 길이가 고객의 수라고 명시됨
		int MEMBER_COUNT = periods.length;
		// Member 타입의 배열을 고객수만큼의 크기를 갖게 선언
		Member[] members = new Member[MEMBER_COUNT];

		for (int i = 0; i < MEMBER_COUNT; i++) {
			// 가입기간, 납부 기록을 주고 새 Member 인스턴스 생성 
			Member newMember = new Member(periods[i], payments[i]);
			// 받은 납부 기록을 가지고 현재 등급 계산
			decideLevel(newMember);
			// 멤버 배열에 새 Member 인스턴스 할당
			members[i] = newMember;
		}
		
		for (int i = 0; i < MEMBER_COUNT; i++) {
			// 이전 레벨 (=현재 멤버 인스턴스가 갖고 있는 레벨) 임시 저장
			Level beforeLevel = members[i].level;
			// 납부 기록의 첫 번째 값을 예상치로 치환
			// 1개월 후의 값을 추가하고 12개월 전의 값을 제거하는 것과 동일한 효과임
			members[i].payHistory[0] = estimates[i];
			// 가입 기간 1개월 증가
			members[i].period += 1;
			// 1년 납부 금액 다시 계산
			members[i].calTotal();
			// 새로운 멤버 등급 결정
			decideLevel(members[i]);
			// 다음달 등급 가져오기
			Level afterLevel = members[i].level;
			
			// 비교를 통해 결과값에 추가
			if (beforeLevel != Level.VIP && afterLevel == Level.VIP) {
				result[0] += 1;
			} else if (beforeLevel == Level.VIP && afterLevel != Level.VIP) {
				result[1] += 1;
			}
		}

		return result;
	}

	// 현재 등급 판별 메소드
	static void decideLevel(Member m) {
		Level result;
		if (m.period < 24) {
			if (m.total < 600000) {
				result = Level.SILVER;
			} else {
				result = Level.GOLD;
			}
		} else if (m.period >= 24 && m.period < 60) {
			if (m.total < 480000) {
				result = Level.SILVER;
			} else if (m.total < 900000) {
				result = Level.GOLD;
			} else {
				result = Level.VIP;
			}
		} else {
			if (m.total < 360000) {
				result = Level.SILVER;
			} else if (m.total < 600000) {
				result = Level.GOLD;
			} else {
				result = Level.VIP;
			}
		}
		m.level = result;
	}
}

class Member {
	// 가입 기간, 납부 금액 기록, 12개월 납부 총액, 현재 등급
	int period = 0;
	int[] payHistory;
	int total = 0;
	Level level;

	public Member(int period, int[] payHistory) {
		this.period = period;
		this.payHistory = payHistory;
		calTotal();
	}
	
	@Override
	public String toString() {
		return "Member >> 기간:"+period+"개월, 금액:"+total+"원 => 등급:"+level;
	}

	// 12개월 납부액 총합 계산용 메소드
	public void calTotal() {
		int temp = 0;
		for (int i = 0; i < 12; i++) {
			temp += payHistory[i];
		}
		total = temp;
	}

}

// 멤버십 등급 Enum
enum Level {
	SILVER, GOLD, VIP
}