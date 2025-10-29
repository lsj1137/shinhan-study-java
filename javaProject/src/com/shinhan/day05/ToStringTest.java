package com.shinhan.day05;

class Keyboard{
	String model;
	String color;
	public Keyboard(String model, String color) {
		super();
		this.model = model;
		this.color = color;
	}
	
	// Override 할때는 함수이름, 매개변수 사양, 리턴타입 동일해야 함. 접근지정자는 같거나 더 넓어져야 함.
	@Override
	public String toString() {
		return "model: "+ model+", color: "+color;
	}
}

public class ToStringTest {

	public static void main(String[] args) {
		Keyboard key1 = new Keyboard("ABC","black");
		System.out.println(key1);
	}

}
