package com.shinhan.day11.threads;

public class WorkThread extends Thread{
	boolean work = true;
	WorkThread(String threadName) {
		setName(threadName);
	}
	
	@Override
	public void run() {
		while (true) {
			if (work) {
				System.out.println(getName()+"작업 내용");
			} else {
				Thread.yield();
			}
		}
	}
}
