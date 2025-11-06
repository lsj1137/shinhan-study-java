package com.shinhan.day11.threads;

class PrintThread2 extends Thread {
	boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
//	@Override
//	public void run() {
//		while (!stop) {
//			System.out.println("실행 중");
//		}
//		System.out.println("리소스 정리");
//		System.out.println("실행 종료");
//	}

	@Override
	public void run() {
		try {
			while (true) {
				System.out.println("실행 중");
				sleep(1);
			}			
		} catch (InterruptedException e) {}
		System.out.println("리소스 정리");
		System.out.println("실행 종료");
	}

	
}

public class SafeStopExample {
	public static void main(String[] args) {
		PrintThread2 printThread = new PrintThread2();
		printThread.start();
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
		printThread.interrupt();
	}
	
}
