package com.shinhan.day07.interfaces;

// 두개의 객체를 연결하는 역할
// interface는 규격서 : 상수 + 구현 클래스들의 규칙
public interface MyInterface {
	/*
	 *  1. 상수
	 *  2. abstract method
	 *  3. default method
	 *  4. static method
	 *  5. private method
	 *  6. private static method
	 *  
	 *  멤버변수, 생성자 없음!
	 */
	
//	int a;
//	MyInterface() {} 에러
	
	// 1
	int MAX_VALUE = 100;
	public static final int MAX_VALUE2 = 200;
	
	// 2
	void method1();
//	void method2() {}; 구현 불가
	public abstract void method2();
	
	// 3
	default void method3 () {
		System.out.println("MyInterface의 default method... 구현 class가 재정의 가능");
		method5();
	}
	
	// 4
	static void method4 () {
		System.out.println("MyInterface의 static method... 구현 class가 재정의 불가능");
		method6();
	}
	
	// 5 외부 접근 불가. 내부의 default 메서드에서 사용하기 위함.
	private void method5 () {
		System.out.println("MyInterface의 private method... interfcae 내에서만 접근 가능");
	}
	
	// 6 외부 접근 불가. 내부의 static 메서드에서 사용하기 위함
	private static void method6() {
		System.out.println("MyInterface의 private static method... interface 내에서만 접근 가능");
	}
	
}
