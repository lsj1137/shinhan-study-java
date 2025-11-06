package com.shinhan.day11;

public class BoxManagement2 {
	public <A,B> Box<A,B> makeBox (A kind, B size) {
		return new Box<>(kind, size);
	}

}
