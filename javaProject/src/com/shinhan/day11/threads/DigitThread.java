package com.shinhan.day11.threads;

public class DigitThread extends Thread{
	@Override
	public void run() {
		for (int i=0; i<26; i++) {
			System.out.println(getName()+" >> "+i);
		}
	}
}
