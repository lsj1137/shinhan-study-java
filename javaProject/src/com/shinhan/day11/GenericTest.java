package com.shinhan.day11;

import com.shinhan.day10.Car;

public class GenericTest {
	public static void main(String[] args) {
//		f1();
		f2();
		f4();
		f5();
		f6();
	}

	private static void f6() {
		BoxManagement2 obj = new BoxManagement2();
		Box<String, Integer> box = obj.makeBox("java", 100);
		Box<String, String> box2 = obj.makeBox("java", "small");
		System.out.println(box);
		System.out.println(box2);
		
	}

	private static void f5() {
		BoxManagement<String,Integer> obj = new BoxManagement<String, Integer>();
		Box<String, Integer> box = obj.makeBox("자바", 300);
		System.out.println(box);
	}

	private static void f4() {
		Box<String, Integer> obj, obj2;
		obj = new Box<>("커피", 100);
		obj2 = obj.makeBox("computer", 200);
		System.out.println(obj);
		System.out.println(obj2);
	}

	private static void f2() {
		Car car1 = new Car("ABC", 1000, "white");
		Box<Car, String> box1 = new Box<>(car1, "히히");
		System.out.println(box1);
		
	}

	private static void f1() {
		Box<String, Integer> box1 = new Box<>("커피", 100);
		System.out.println(box1);
		System.out.println(box1.getKind());
		// String s = (String) box1.getKind(); 처음에 타입 안주면 Object형 반환해서 형변환 필요
		String s = box1.getKind();
		int size = box1.getSize();
		System.out.println(s + size);
	}
}
