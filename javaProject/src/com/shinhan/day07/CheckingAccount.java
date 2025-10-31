package com.shinhan.day07;

public class CheckingAccount extends Account {
	
	String cardNo;
	
	public CheckingAccount() {
		// super(); 생략되어 있음. 명시하려면 첫줄에 있어야함.
		System.out.println("CheckingAccount 생성자");
	}
	
	public CheckingAccount(String accNo, String owner, int balance, String cardNo) {
		setAccNo(accNo);
		setOwner(owner);
		setBalance(balance);
		this.cardNo = cardNo;
		System.out.println("CheckingAccount 생성자2");
	}
	
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	public int pay(String cardNo, int amount) {
		if (!cardNo.equals(this.cardNo)) {
			return -1;
		} else {
			return withdraw(amount);
		}
	}
	
	@Override
	public String toString() {
		return super.toString()+", 카드번호: "+cardNo;
	}
}
