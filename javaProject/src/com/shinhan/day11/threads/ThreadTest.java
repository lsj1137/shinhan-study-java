package com.shinhan.day11.threads;

// 쓰레드 만드는 법
// 1. Thread 상속 받기
// 2. Runnable 인터페이스 구현하기
public class ThreadTest {
	public static void main(String[] args) {
		System.out.println("main 시작");
		// 숫자 출력
		Thread t1 = new DigitThread();
		// 대문자 출력
		UpperCaseThread uct = new UpperCaseThread();
		Thread t2 = new Thread(uct);
		// 소문자 출력
		LowerCaseThread dct = new LowerCaseThread();
		Thread t3 = new Thread(dct);
		
		t1.start();
		t2.start();
		t3.start();
		for (int i=0; i<26; i++) {
			System.out.println(" >> "+i);
		}
		
		System.out.println("main 끝");
	}
}
