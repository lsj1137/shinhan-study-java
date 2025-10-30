package com.shinhan.day06.inheritance;

public class InheritanceTest {
	public static void main(String[] args) {
		f1();
//		f2();
		
	}

	private static void f2() {
		String accNo = "123-42314-12512";
		String cardNo = "2314-12512";
		String owner = "이도루";
		int balance = 10000000;
		CheckingAccount acc = new CheckingAccount(accNo, owner, balance, cardNo);
		System.out.println(acc);
		acc.deposit(2000);
		acc.deposit(100);
		System.out.println(acc.getBalance());
		acc.withdraw(1000000);
		System.out.println(acc.getBalance());
	}

	private static void f1() {
		String cardNo = "2314-12512";
		CheckingAccount acc = new CheckingAccount();
		acc.deposit(100);
		acc.deposit(300);
		System.out.println(acc.getBalance());
		System.out.println(acc.withdraw(150));
		System.out.println(acc);
		acc.setCardNo(cardNo);
		System.out.println(acc.getCardNo());
		System.out.println(acc.pay(cardNo, 400));
		System.out.println(acc.pay(cardNo, 200));
	}
}
