package com.shinhan.day07;

public class InheritanceTest {
	public static void main(String[] args) {
		f1();
		f2();
	}

	private static void f2() {
		Account acc1 = new Account();
		// 자동형변환 => 부모 타입 = 자식 값
		Account acc2 = new CheckingAccount();
//		CheckingAccount acc3 = new Account(); 에러
		// 강제형변환 => 자식 타입 = (자식 타입) 부모 값
//		CheckingAccount acc3 = (CheckingAccount) new Account(); 실행시 에러
//		CheckingAccount acc4 = (CheckingAccount) acc1; 실행시 에러
		CheckingAccount acc5 = (CheckingAccount) acc2; // acc2가 담고 있던 인스턴스가 원래 CheckingAccount여서 괜찮음
		
		
	}

	private static void f1() {
		// 형변환
		// 1) 자동형변환 => 큰 타입 = 작은값
		int a = 100;
		double b;
		b = a;
		System.out.println(b);
		// 2) 강제형변환 => 작은 타입 = (작은 타입) 큰값 
		a = (int) b;
		System.out.println(a);
	}
	
	
}
