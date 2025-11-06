package com.shinhan.day11.threads;

class Parent {
	int v;
}

// 이미 상속받으면 다중상속 불가 -> 인터페이스 구현해서 사용
public class UpperCaseThread extends Parent implements Runnable{
	@Override
	public void run() {
		for (int i=65; i<65+26; i++) {
			System.out.println(Thread.currentThread().getName()+" >> "+(char)Character.toUpperCase(i));
		}
	}
}
