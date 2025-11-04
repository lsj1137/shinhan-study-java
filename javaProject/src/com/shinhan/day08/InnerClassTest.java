package com.shinhan.day08;

public class InnerClassTest {

	public static void main(String[] args) {
		f2();

	}

	private static void f2() {
		System.out.println(OuterClass.InnerClass.staticVar2);
		OuterClass.InnerClass.staticF();
		
		
		OuterClass outer = new OuterClass();
		OuterClass.InnerClass inner = outer.new InnerClass();
		
		System.out.println(inner.instanceVar2);
		System.out.println(inner.score);
		inner.instanceF();
		
		
	}

	private static void f1() {
		OuterClass outer = new OuterClass();
		System.out.println(outer.instanceVar);
		System.out.println(outer.score);
		System.out.println(OuterClass.staticVar);
		outer.instanceF();
		OuterClass.staticF();
		
	}

}
