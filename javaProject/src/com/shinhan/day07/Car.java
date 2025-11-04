package com.shinhan.day07;


//컴파일시에 기본생성자를 추가해준다. 
public class Car extends Machine{
	public Car(){
		//부모의 기본생성자가 없다면 자식이 부모의 생성자를 명시적으로 호출  
		//super();
		//super("**");
		System.out.println("Car의 생성자");
		
	}
}