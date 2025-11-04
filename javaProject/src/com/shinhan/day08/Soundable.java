package com.shinhan.day08;

public interface Soundable {
	public String sound();
}

class Dog implements Soundable{
	@Override
	public String sound() {
		return "멍멍";
	}
}
class Cat implements Soundable{
	@Override
	public String sound() {
		return "야옹";
	}
}