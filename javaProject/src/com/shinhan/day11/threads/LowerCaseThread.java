package com.shinhan.day11.threads;

public class LowerCaseThread implements Runnable{
	@Override
	public void run() {
		for (int i=65; i<65+26; i++) {
			System.out.println(Thread.currentThread().getName()+" >> "+(char)Character.toLowerCase(i));
		}
	}
}
