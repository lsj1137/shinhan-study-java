package com.shinhan.day11.threads;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShareArea {
	Account lee;
	Account sung;
	
	public synchronized void print() {
		int total = lee.getBalance()+sung.getBalance();
		System.out.println(">> 잔고의 합: " + total);
	}
}
