package com.shinhan.day06.accountApplication;

import java.util.Scanner;

// 사용자 요청 받아서 서비스를 이용할 수 있도록 함
// 서비스가 응답하면 받아서 View에 보냄
// 추후 Servlet으로 만들 예정(서버에서 실행되는 자바프로그램)
public class AccountController {
	private static AccountService service = new AccountService();
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean isRunning = true;
		while (isRunning) {
			AccountView.printMenu();
			String cmd = sc.nextLine();
			switch (cmd) {
			case "1" -> createAccount();
			case "2" -> getAccountList();
			case "3" -> deposit();
			case "4" -> withdraw();
			case "5" -> isRunning=false;
			}
		}
		AccountView.print("프로그램을 종료합니다...");
		sc.close();
	}

	private static void withdraw() {
		System.out.print("계좌번호: ");
		String acNum = sc.nextLine();
		System.out.print("출금액: ");
		int money = Integer.parseInt(sc.nextLine());
		String result = service.withdraw(acNum, money);
		AccountView.print(result);
	}

	private static void deposit() {
		System.out.print("계좌번호: ");
		String acNum = sc.nextLine();
		System.out.print("예금액: ");
		int money = Integer.parseInt(sc.nextLine());
		String result = service.deposit(acNum, money);
		AccountView.print(result);
	}

	private static void getAccountList() {
		AccountDTO[] accList = service.selectAllService();
		AccountView.print(accList);
	}

	private static void createAccount() {
		System.out.println("--------");
		System.out.println("계좌를 생성합니다");
		System.out.println("--------");
		System.out.print("계좌번호: ");
		String newNum = sc.nextLine();
		System.out.print("계좌주: ");
		String newName = sc.nextLine();
		System.out.print("초기입금액: ");
		int newBalance = Integer.parseInt(sc.nextLine());
		AccountDTO newAccount = new AccountDTO(newNum, newName, newBalance);
		String result = service.insertService(newAccount);
		AccountView.print(result);
	}
}
