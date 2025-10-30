package com.shinhan.day06.accountApplication;

public class AccountDTO {
	private String accNo;
	private String owner;
	private int balance;
	
	public AccountDTO(String accNo, String owner, int balance) {
		this.accNo = accNo;
		this.owner = owner;
		this.balance = balance;
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
