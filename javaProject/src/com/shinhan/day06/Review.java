package com.shinhan.day06;

public class Review {
	// field, constructor method, method, block, static block
	int i=10;
	static int j=1;
	
	{
		i++;
		j++;
	}
	
	static {
//		i++; 에러
		j++;
	}
	
	public Review(int data) {
		System.out.println(i);
		j++;
//		System.out.println(s); s는 f1() 안에만 있음
		
	}
	
	void f1() {
		String s = "자바";
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		Review r = new Review(10);
		
	}
	
}
