package com.shinhan.day07.animals;

public class Cat extends Animal{
	boolean b = true;
	
	public Cat(String name, String color, boolean b) {
		super(name, color);
		this.b = b;
	}



	void fCat() {
		System.out.println("Cat이 추가한 함수");
	}
	
	@Override
	void sing() {
		super.sing();
		System.out.println(getClass().getName());
		System.out.println(name+"가 소리를 냅니다.");
	}
}
