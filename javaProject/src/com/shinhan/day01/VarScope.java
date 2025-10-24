package com.shinhan.day01;

public class VarScope {

	public static void main(String[] args) {
		//지역변수:함수내에서만 유효 
		f1();
		f2();
		boolean a = true;
		System.out.println(a);
		
		if(!a){
			double a2 = 3.14;
			System.out.println(a);
			System.out.println(a2);
		}
		
	}

	private static void f1() {
		int a=100;
		System.out.println(a);
		
	}
	private static void f2() {
		String a="100";
		System.out.println(a);
		
	}

}
