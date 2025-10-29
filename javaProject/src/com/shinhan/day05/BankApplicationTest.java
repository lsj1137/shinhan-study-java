package com.shinhan.day05;

import java.util.Scanner;

class Account2 {
	String num;
	String ownerName;
	int balance;
	
	public Account2(String num, String ownerName, int balance) {
		this.num = num;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return this.num +"  "+this.ownerName+"  "+this.balance;
	}
}

class BankApplication {
	Account2[] accountList = new Account2[100];
	int seq = 0;
	
	void run() {
		boolean isRunning = true;
		Scanner sc = new Scanner(System.in);
		while (isRunning) {
			printMenu();
			String cmd = sc.nextLine();
			switch (cmd) {
			case "1" -> createAccount(sc);
			case "2" -> getAccountList();
			case "3" -> deposit(sc);
			case "4" -> withdraw(sc);
			case "5" -> isRunning=false;
			
			}
		}
		System.out.println("프로그램 종료");
		
	}


	private static void printMenu() {
		System.out.println("------------------------------------------------");
		System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 종료");
		System.out.println("------------------------------------------------");
		System.out.print("선택> ");
	}
	
	private void createAccount(Scanner sc) {
		System.out.println("--------");
		System.out.println("계좌를 생성합니다");
		System.out.println("--------");
		System.out.print("계좌번호: ");
		String newNum = sc.nextLine();
		System.out.print("계좌주: ");
		String newName = sc.nextLine();
		System.out.print("초기입금액: ");
		int newBalance = Integer.parseInt(sc.nextLine());
		Account2 newAccount = new Account2(newNum, newName, newBalance);
		accountList[seq++] = newAccount;
	}
	
	public void getAccountList() {
		System.out.println("--------");
		System.out.println("계좌 목록을 불러옵니다");
		System.out.println("--------");
		for (Account2 ac: accountList) {
			if (ac==null) break;
			System.out.println(ac);
		}
	}

	private void deposit(Scanner sc) {
		System.out.print("계좌번호: ");
		String acNum = sc.nextLine();
		System.out.print("예금액: ");
		int money = Integer.parseInt(sc.nextLine());
		for (Account2 ac: accountList) {
			if (ac==null) continue;
			if (ac.num.equals(acNum)) {
				ac.balance+=money;
				break;
			}
		}
	}


	private void withdraw(Scanner sc) {
		System.out.print("계좌번호: ");
		String acNum = sc.nextLine();
		System.out.print("출금액: ");
		int money = Integer.parseInt(sc.nextLine());
		for (Account2 ac: accountList) {
			if (ac==null) continue;
			if (ac.num.equals(acNum)) {
				ac.balance-=money;
				System.out.println("결과: 출금이 성공되었습니다.");
				break;
			}
		}
	}
	
}


public class BankApplicationTest {
	Account2[] accountList = new Account2[100];
	int seq = 0;
	
	public static void main(String[] args) {
		BankApplication ba = new BankApplication();
		ba.run();
	}
	
}