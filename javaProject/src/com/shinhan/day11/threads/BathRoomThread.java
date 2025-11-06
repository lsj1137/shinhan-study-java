package com.shinhan.day11.threads;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BathRoomThread extends Thread{
	BathRoom room;
	String name;
	
	@Override
	public void run() {
		room.use(name);	
//		for (int i=0; i<3; i++) {
//		}
	}
}
