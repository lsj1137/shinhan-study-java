package com.shinhan.day01;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class KeyInput {

	public static void main(String[] args) throws IOException {
		f3();
		int modelName,$value,_age;
	}

	
private static void f3() {
		
	    InputStream a = System.in;
	    Scanner sc = new Scanner(a);
	    System.out.print("이름을 입력하세요>>");
	    String myname = sc.nextLine();
	    System.out.print("나이를 입력하세요>>");
	    int age = Integer.parseInt(sc.nextLine());
	    
	    System.out.printf("이름은 %s, 나이는 %d",myname, age );
	    sc.close();
	}


	private static void f2() {
		
	    InputStream a = System.in;
	    Scanner sc = new Scanner(a);
	    System.out.print("이름을 입력하세요>>");
	    String myname = sc.next();
	    System.out.print("나이를 입력하세요>>");
	    int age = sc.nextInt();
	    
	    System.out.printf("이름은 %s, 나이는 %d",myname, age );
	    sc.close();
	}

	private static void f1() throws IOException {
		//표준출력:모니터 System.out
		//표준입력:키보드 System.in
		
		System.out.print("입력하세요>>");
	    InputStream a = System.in;
		int i = a.read();
		System.out.println((char)i);
		
	}

}
