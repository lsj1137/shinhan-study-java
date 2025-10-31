package com.shinhan.day07;

public class Account {
	private String accNo;
	private String owner;
	private int balance;
	
	public Account() {
		// 디폴트 상속자 없으면 상속 받을때 자식에서 오류남.
		System.out.println("Account 생성자");
	}
	
	public Account(String accNo, String owner, int balance) {
		this.accNo = accNo;
		this.owner = owner;
		this.balance = balance;
	}
	
	public void deposit(int amount) {
		balance+=amount;
	}
	
	public int withdraw(int amount) {
		int result = -1;
		if (balance>=amount) {
			balance -= amount;
			result = balance;
		}
		return result;
	}

	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "계좌> "
				+ "번호: "
				+ accNo
				+ ", 예금주: "
				+ owner
				+ ", 잔고: "
				+ balance;
	}
}
