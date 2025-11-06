package com.shinhan.day11.threads;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TransferThread extends Thread {
	private ShareArea shareArea;

	@Override
	public void run() {
		for (int i = 0; i < 12; i++) {
			synchronized (shareArea) {
				int amount = shareArea.lee.withdraw(100);
				System.out.println("출금됨! " + amount);
				shareArea.sung.deposit(amount);
				System.out.println("입금됨! ");
			}

		}
	}

}
