package com.shinhan.day05;

import java.time.LocalDate;
import java.util.Date;

// class: object를 만들기 위한 틀(template, 설계도), field+method
public class Customer {
	// 고객(고객번호, 이름, 전화번호, 생일, 등록일, level(gold, silver, brown))
	/*
	 * 1. field (instance 변수: 멤버 변수, static 변수: 클래스 변수)
	 * 2. constructor
	 * 3. method
	 * 4. instance block : 값을 전달 받지 않아도 되지만 객체 생성시 수행됨
	 * 5. static block : 클래스 로드시 1회 수행됨
	 */
	
	int id;
	String name;
	String phoneNum;
	LocalDate birthday;
	Date regDate;
	CustomerLevel level;
	
	private static int custCount = 0;
	
	public Customer() {
		this(null, null, null);
	}
	
	public Customer(String name, String phoneNum) {
		this(name, phoneNum, null);
	}
	
	public Customer(String name, String phoneNum, LocalDate birthday) {
		this.id = custCount++;
		this.name = name;
		this.phoneNum = phoneNum;
		this.regDate = new Date();
		this.birthday = birthday;
		this.level = CustomerLevel.BRONZE;
	}
	
	@Override
	public String toString() {
		return "Customer#"+id+" >> name: "+name+" / phoneNum: "+phoneNum+" / birthday: "+birthday+" / level: "+level;
	}
	
	static int getCustCount () {
		return custCount;
	}
	
//	{
//		System.out.println("객체 생성시 수행");
//	}
//	
//	static {
//		System.out.println("클래스 로드시 수행");
//	}
}
