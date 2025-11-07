package com.shinhan.day12;

public class AutoSaveThread extends Thread{
	public void save() {
		System.out.println("작업 내용 저장");
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				save();
				sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("메인으로부터 인터럽트!");
		}
		System.out.println("--- 자원저장 ---");
		System.out.println("--- 쓰레드 종료 ---");
	}
}
