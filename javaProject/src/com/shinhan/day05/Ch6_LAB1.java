package com.shinhan.day05;

public class Ch6_LAB1 {
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person(19, "홍길동");
		Person p3 = new Person(25, "동길홍");
		p1.selfIntroduce();
		p2.selfIntroduce();
		p3.selfIntroduce();
		Person.getPopulation();
	}
}

// javaBeans 기술: field는 외부에서 접근불가(정보은닉) -- private, getter/setter
class Person {
	int numberOfPersons;
	int age;
	String name;
	static int population = 0;
	
	Person() {
		this(12, "Anonymous");
	}
	
	Person(int age, String name) {
		this.age = age;
		this.name = name;
		population++;
	}
	
	void selfIntroduce() {
		System.out.printf("내 이름은 %s이며, 나이는 %d살 입니다.\n", this.name, this.age);
	}
	
	public static int getPopulation() {
		return population;
	}

}