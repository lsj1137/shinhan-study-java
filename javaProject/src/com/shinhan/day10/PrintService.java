package com.shinhan.day10;

public class PrintService {

	@PrintAnnotation
	public void method1() {
		System.out.println("메소드1 실행");
	}

	@PrintAnnotation(value = "*", number = 3, number2 = 20)
	public void method2() {
		System.out.println("메소드2 실행");
	}

	@PrintAnnotation(value = "?", number = 10, number2 = 40)
	public void method3() {
		System.out.println("메소드3 실행");

	}

	public static void main(String[] args) {
		PrintService ps = new PrintService();
		ps.method1();
		ps.method2();
		ps.method3();
	}
}
