package com.shinhan.day06.inheritance;

sealed class Person permits Employee, Manager {
	
}

final class Employee extends Person {
	
}

non-sealed class Manager extends Person {
	
}



public class InheritanceTest3 {
	public static void main(String[] args) {
		f1();
		
	}

	private static void f1() {
		//abstract class는 instance생성 불가
//		new Number() 
		Integer a = new Integer(100);
		Integer b = 100;
	}
}
