package com.shinhan.day12;

/*
 * Thread
 * run 메소드를 구현 후 start로 시작
 */

class ThreadA extends Thread {
	public void run() {System.out.println("ThreadA 실행");}
}
class Parent{}
class RunnubleImpl extends Parent implements Runnable {
	@Override
	public void run() {
		System.out.println("ThreadB 실행");
	}
}

class MyClass {
	void method() {
		System.out.println("본래 구현 내용");
	}
}

public class Review {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " 쓰레드 시작");
		f1();
		ThreadA t1 = new ThreadA();
		Thread t2 = new ThreadA();
		Thread t3 = new Thread(new RunnubleImpl());
		t1.start();
		t2.start();
		t3.start();
		
		// 익명 구현 클래스
		(new MyClass() {
			@Override
			void method() {
				System.out.println("새로 구현 내용");
			}
		}).method();
		
		new Thread() {
			public void run() {System.out.println("익명 쓰레드 시작");};
		}.start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Runnable 익명 구현");
			}
		}).start();
		
		System.out.println(Thread.currentThread().getName() + " 쓰레드 종료");
		
	}

	private static void f1() {
		System.out.println("함수 f1");
		
	}
}
