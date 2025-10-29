package com.shinhan.day05;

public class Ch6_LAB3 {
	public static void main(String[] args) {
		Duck d = new Duck("꽥꽥이", 2, 15);
		Sparrow s = new Sparrow("짹짹", 2, 10);
		d.fly();
		d.sing();
		System.out.println(d.toString());
		s.fly();
		s.sing();
		System.out.println(s.toString());
	}
}

class Bird {
	String name;
	int legs;
	int length;
	
	public Bird() {
		this(null, 0, 0);
	}
	
	public Bird(String name, int legs, int length) {
		this.name = name;
		this.legs = legs;
		this.length = length;
	}
	
	void fly() {}
	void sing() {
		System.out.println("가 소리 내어 웁니다.");
	}
	void setName(String name) {
		this.name = name;
	}
}

class Duck extends Bird {
	public Duck(String name, int legs, int length) {
		super(name, legs, length);
	}

	@Override
	void fly() {
		System.out.println("오리는 날지 않습니다.");
	}
	
	@Override
	void sing() {
		System.out.printf("오리(%s)", name);
		super.sing();
	}
	
	@Override
	public String toString() {
		String s = "오리의 이름은 "+this.name+"입니다. 다리는 "+this.legs+"개이고 길이는 "+this.length+"입니다.";
		return s;
	}
}

class Sparrow extends Bird {
	public Sparrow(String name, int legs, int length) {
		super(name, legs, length);
	}
	
	@Override
	void fly() {
		System.out.println("참새는 날아다닙니다.");
	}
	
	@Override
	void sing() {
		System.out.printf("참새(%s)", name);
		super.sing();
	}
	
	@Override
	public String toString() {
		String s = "참새의 이름은 "+this.name+"입니다. 다리는 "+this.legs+"개이고 길이는 "+this.length+"입니다.";
		return s;
	}
}