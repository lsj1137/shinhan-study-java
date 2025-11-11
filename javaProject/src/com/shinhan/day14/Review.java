package com.shinhan.day14;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

import lombok.AllArgsConstructor;
import lombok.ToString;

interface MyInterface{
	int method(int a, int b);
}

@AllArgsConstructor
@ToString
class Student{
	String name;
	int age;
}

class MyClass {
	static int method1 (int a, int b) {
		return a+b;
	}
	
	int method2(String a, String b) {
		return a.compareToIgnoreCase(b);
	}
}

public class Review {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
		f4();
	}

	private static void f4() {
		MyClass myclass = new MyClass();
		BiFunction<String, String, Integer> lambda1 = myclass::method2;
		int result = lambda1.apply("pofdsf", "bpiadfio");
		System.out.println(result);
	}

	private static void f3() {
		BiFunction<Integer, Integer, Integer> lambda1 = MyClass::method1;
		int result = lambda1.apply(40, 421);
		System.out.println(result);
	}

	private static void f2() {
		Function<String, Integer> lambda1 = s->Integer.parseInt(s);
		Function<String, Integer> lambda2 = Integer::parseInt;
		
		System.out.println(lambda1.apply("100")+200);
		System.out.println(lambda2.apply("130")+100);
		
		BiFunction<String, Integer, Student> lambda3 = (str, i)->new Student(str,i);
		BiFunction<String, Integer, Student> lambda4 = Student::new;
		
		System.out.println(lambda3.apply("차은우", 29));
		System.out.println(lambda4.apply("이도현", 27));
		
		
	}

	private static void f1() {
		MyInterface my1 = new MyInterface() {
			
			@Override
			public int method(int a, int b) {
				return Math.max(a, b);
			}
		};
		
		MyInterface my2 = (a,b)->Math.max(a, b);
		MyInterface my3 = Math::max;
		BiFunction<Integer, Integer, Integer> lambda1 = Math::max;
		BinaryOperator<Integer> lambda2 = Math::max;
		
		System.out.println(my1.method(100, 50));
		System.out.println(my2.method(100, 50));
		System.out.println(my3.method(100, 50));
		System.out.println(lambda1.apply(100, 50));
		System.out.println(lambda2.apply(100, 50));
	}
}
