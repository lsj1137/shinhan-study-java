package com.shinhan.day12;

class MovieThread extends Thread{
	@Override
	public void run() {
		while (true) {
			System.out.println("동영상을 재생합니다");
			if (isInterrupted()) break; 
		}
		System.out.println("자원을 정리하고 종료합니다.");
	}
}

public class ThreadTest2 {
	public static void main(String[] args) {
		Thread t1 = new MovieThread();
		t1.start();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		t1.interrupt();
		System.out.println("메인 종료");
	}
}
