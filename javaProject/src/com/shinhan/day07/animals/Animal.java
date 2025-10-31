package com.shinhan.day07.animals;

public class Animal {
	
	String name;
	String color;
	
	public Animal(String name, String color) {
		this.name = name;
		this.color = color;
	}
	
	void sing() {
		System.out.println("동물은 소리를 냅니다.");
	}
	
}
