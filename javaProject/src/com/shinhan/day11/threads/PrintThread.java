package com.shinhan.day11.threads;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PrintThread extends Thread{
	private ShareArea shareArea;
	
	@Override
	public void run() {
		for (int i=0;i<3;i++) {
			shareArea.print();
		}
	}
}
