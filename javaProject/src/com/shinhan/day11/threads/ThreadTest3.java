package com.shinhan.day11.threads;

public class ThreadTest3 {
	public static void main(String[] args) {
		BathRoom bathroom = new BathRoom();
		BathRoomThread t1 = new BathRoomThread(bathroom, "이");
		BathRoomThread t2 = new BathRoomThread(bathroom, "차");
		BathRoomThread t3 = new BathRoomThread(bathroom, "굥");
		BathRoomThread t4 = new BathRoomThread(bathroom, "임");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
