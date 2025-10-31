package com.shinhan.day07.check_problems;

interface Remocon {
	public void powerOn();
}

public class TV implements Remocon{	
	public static void main(String[] args) {
		Remocon r = new TV();
		r.powerOn();
	}

	@Override
	public void powerOn() {
		System.out.println("TV를 켰습니다.");
	}
}
