package com.shinhan.day06.accountApplication;

// 보여주는 용도 : 추후 JSP로 만들 예정
public class AccountView {
	public static void printMenu() {
		System.out.println("------------------------------------------------");
		System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
		System.out.println("------------------------------------------------");
		System.out.print("선택> ");
	}
	public static void print(String message) {
		System.out.println("[알림] "+message);
	}
	public static void print(AccountDTO acc) {
		System.out.println("========== 계좌 정보 ==========");
		System.out.println(acc);
	}
	public static void print(AccountDTO[] accArr) {
		System.out.println("========== 계좌 리스트 ==========");
		for (AccountDTO acc: accArr) {
			if (acc==null) continue;
			System.out.println(acc);
		}
	}
}
