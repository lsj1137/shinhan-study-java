package com.shinhan.day03;

public class ClassAndObject2 {

	public static void main(String[] args) {
		int i;
		Car c1;
		i = 100;
		c1 = new Car();
		System.out.println(i);
		System.out.println(c1);
		System.out.println(System.identityHashCode(c1));
		c1.model = "Palisade";
	}

}
