package com.shinhan.day05;

public class Ch6_LAB2 {
	public static void main(String[] args) {
		Account acc = new Account("078-3762-293", 1000000);
		acc.deposit(2000000);
		acc.withdraw(500000);
//		System.out.println( acc.getBalance());
//		System.out.println( acc.getAccNo());
	}
}

class Account {
	String accNo;
	int balance;
	
	public Account(String accNo, int balance) {
		this.accNo = accNo;
		this.balance = balance;
		System.out.println(accNo+" 계좌가 개설되었습니다.");
		System.out.println(accNo+" 계좌의 잔고는 "+this.balance+"원입니다.");
	}
	
	void deposit(int money) {
		this.balance += money;
		System.out.println(accNo+" 계좌에 "+money+"원이 입금되었습니다.");
		System.out.println(accNo+" 계좌의 잔고는 "+this.balance+"원입니다.");
	}
	
	void withdraw(int money) {
		this.balance -= money;
		System.out.println(accNo+" 계좌에 "+money+"원이 출금되었습니다.");
		System.out.println(accNo+" 계좌의 잔고는 "+this.balance+"원입니다.");
	}
	
	public int getBalance() {
		return balance;
	}
	
	public String getAccNo() {
		return accNo;
	}
	
}