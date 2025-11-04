package com.shinhan.day09;

import java.io.IOException;
import java.io.InputStream;

/*
 * cmd> java ExceptionTest
 * JVM은 class load한다.
 * 검증
 * main 시작 --> main 이 끝나면 종료
 */

public class ExceptionTest {
	// 런타임 예외 발생
	private static void f1() {
		int a = 10;
		int b = 0;
		System.out.println(a / b); // 0으로 나누기 불가능 
		System.out.println("f1 End");
	}
	
	
	// 일반예외 (Exception 상속받은 예외) 발생 가능 => 컴파일 시에 체크함
	// 방법1 ) 내가 처리함 => try-catch
	// 방법2 ) 넘김 => throw ~Exception
	private static void f2() {
		InputStream is = System.in;
		int data;
		try {
			data = is.read();
			System.out.println("읽은 값:"+ (char) data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("예외랑 상관없이 수행");
		}
	}
	
	private static void f3() {
		try {
			Class.forName("com.shinhan.day08.Book");
			System.out.println("Load Success");
		} catch (ClassNotFoundException e) {
			System.out.println("Load Fail");
			e.printStackTrace();
		}
	}


	private static void f4() throws ClassNotFoundException {
		Class.forName("AA");
		
	}

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
		try {
			f4();
		} catch (ClassNotFoundException e) {
			System.out.println("Exception 발생");
			e.printStackTrace();
		}
		
		System.out.println("main End");
	}
}
