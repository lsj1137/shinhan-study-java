package com.shinhan.day11.threads;

public class ThreadTest2 {
	public static void main(String[] args) {
		ShareArea sa = new ShareArea(new Account("123", "이몽룡", 2000), new Account("123", "성춘향", 1000));
		Thread t1 = new TransferThread(sa);
		Thread t2 = new PrintThread(sa);
		
		t1.start();
		t2.start();
		
	}
}
