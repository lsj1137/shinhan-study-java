package com.shinhan.day11;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 제네릭: A,B 타입은 사용시 구체적으로 결정할 것임.
@ToString
@Getter @Setter
@AllArgsConstructor
public class Box<A,B> {
	A kind;
	B Size;
	
	public Box<A,B> makeBox (A kind, B size) {
		return new Box<>(kind, size);
	}
}
