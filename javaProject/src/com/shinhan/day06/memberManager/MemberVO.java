package com.shinhan.day06.memberManager;

// ~ VO (Value Object) : data 저장 목적
// ~ DTO (Data Transfer Object) : data 전송 목적
// ~ Bean[s] :자바 객체
public class MemberVO {
	String name;
	String id;
	String password;
	int age;
	
	public MemberVO(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "MemberVO [name="+name+", id="+id+", password="+password+", age="+age+"]";
	}
	
	public static void main(String[] args) {
		MemberVO user1 = new MemberVO("홍길동", "hong");
		System.out.println(user1);
		
	}
}
