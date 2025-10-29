package com.shinhan.day03;

import java.util.Arrays;
import java.util.Scanner;
// class : object를 만드는 틀
// Object : class를 이용해 만든 실체(instance). heap 메모리에 생성됨.
// 기본 타입은 값을 저장하고, 참조 타입은 객체가 생성된 메모리 주소를 저장함.

class Car {
	String model="No Model";
	
	void go() {
		System.out.println("차가 움직입니다." + model);
	}
	
	@Override
	public String toString() {
		return model;
	}
	
}

public class ClassAndObject {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
		f5();
		
	}
	


	private static void f5() {
		String str = "햄버거 김밥,포케:커피";
		String[] arr = str.split(" |,|:");
		System.out.println(Arrays.toString(arr));
	}



	private static void f4() {
		String str = "이것이 자바다";
		System.out.println(str.length());
		System.out.println(str.charAt(4));
		System.out.println(str.substring(4,7));
		System.out.println(str.replace("자바", "java"));
		System.out.println(str); // String은 고정 문자열이기 때문에 replace로 변경 불가. 재할당하여 사용하면 주소가 바뀜.
		str = str.replace("자바", "java");
		System.out.println(str);
	}


	private static void f3() {
		String s1 = null; // null = 참조된 주소가 없다
		Integer i = null;
//		int i2 = null; 기본형은 주소를 참조하는게 아니므로 에러
		System.out.println(s1);
		
	}


	private static void f2() {
		String s1 = "자바"; // 컴파일시에 리터럴 주소 해시값 결정
		String s2 = "자바"; // 같은 리터럴은 재사용
		String s3 = new String("자바"); // 실행시에 생성됨
		String s4 = new String("자바");
		System.out.println(s1==s2); // 주소비교 true
		System.out.println(s3==s4); // false
		String s5 = "자바"; // 컴파일시에 리터럴 주소 해시값 결정
		
		s1 += "program";
		s2 += "program";
		s4 += "program";

		System.out.println(s1==s2); // 주소 비교 false
		System.out.println(s1.equals(s2)); // 값 비교 true
		System.out.println(s1.equals(s4));
		
	}


	private static void f1() {
		Car c1 = new Car();
		Car c2 = new Car();
		c1.model = "Avante";
		c2.model = "Santa Fe";
		System.out.println(c1);
		System.out.println(c2);
	}
}
