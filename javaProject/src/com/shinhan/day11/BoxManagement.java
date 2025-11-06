package com.shinhan.day11;

public class BoxManagement <A,B>  {
	
	// 메소드가 제네릭을 사요할때 리턴타입 앞에 표시해두면 됨
	public Box<A,B> makeBox (A kind, B size) {
		return new Box<>(kind, size);
	}
}
