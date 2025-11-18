package com.shinhan.day15.final_test;

class Animal {

	void eat() {
		System.out.println("--");
	}

}

public class Person extends Animal {

	String name;

	Person(String name) {

		this.name = name;

	}

	void eat(String food) {
		System.out.println(food);
	}

	public static void main(String[] args) {
		Person p = new Person("이순신");
		Animal a = new Animal();
		a.eat();
		p.eat();
		p.eat("음식");
	}
}
