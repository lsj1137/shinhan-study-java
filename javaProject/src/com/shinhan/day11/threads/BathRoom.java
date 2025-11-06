package com.shinhan.day11.threads;

public class BathRoom {
	boolean isFirst = true;
	
	public void use(String name) {
		synchronized (this) {
			if (isFirst && name.equals("이")) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(name+" 화장실 입장");
			System.out.println(name+" 사용");
			System.out.println(name+" 퇴장");
			System.out.println("====================");
			isFirst = false;
			notify();
		}
	}
}
