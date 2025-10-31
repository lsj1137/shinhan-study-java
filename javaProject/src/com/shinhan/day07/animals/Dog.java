package com.shinhan.day07.animals;

public class Dog extends Animal {
	int a = 100;
	
	public Dog(String name, String color, int a) {
		super(name, color);
		this.a = a;
	}



	void fDog() {
		System.out.println("Dog이 추가한 함수");
	}
	
	@Override
	void sing() {
		super.sing();
		System.out.println(getClass().getName());
		System.out.println(name+"가 소리를 냅니다.");
	}
}
