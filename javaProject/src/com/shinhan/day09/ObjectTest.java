package com.shinhan.day09;

import java.util.HashSet;
import java.util.Set;

public class ObjectTest {
	public static void main(String[] args) {
//		f1();
		f5();
	}

	private static void f5() {
		Set<Car> data = new HashSet();
		data.add(new Car("A",100,"white"));
		data.add(new Car("A",100,"white"));
		data.add(new Car("A",200,"white"));
		data.add(new Car("A",100,"white"));
		System.out.println(data.size());
	}

	private static void f1() {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		System.out.println(obj1);
		System.out.println(obj1.toString());
		System.out.println(obj1.hashCode());
		System.out.println(obj2);
		System.out.println(obj2.toString());
		System.out.println(obj2.hashCode());
	}
}
