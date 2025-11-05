package com.shinhan.day10;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.StringTokenizer;

import com.shinhan.util.DateUtil;

public class ObjectTest {
	public static void main(String[] args) {
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
//		f8();
//		f9();
		f10();		
		
	}

	
	private static void f10() {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DATE));
	}


	private static void f9() {
		Date d1 = new Date();
		System.out.println(DateUtil.convertToSQLDate(d1));
		java.sql.Date d2 = new java.sql.Date(new Date().getTime());
		System.out.println(DateUtil.convertToUtilDate(d2));
		
	}

	private static void f8() {
		int a = 10;
		System.out.println(a>10);
		System.out.println(++a);
		
		Integer b = 100; // new Integer(100) auto boxing
		System.out.println(b.intValue()); // unboxing
		System.out.println(b>100);
		System.out.println(++b);
		System.out.println(b.floatValue());
		
	}

	private static void f7() {
		String data = "홍길동/이수홍/박연수,김길동 박길동";
		String[] arr = data.split("/|,| ");
		System.out.println(arr.length);
		for (String s:arr) {
			System.out.println(s);
		}
	}

	private static void f6() {
		String data = "홍길동/이수홍/박연수,김길동 박길동";
		StringTokenizer st = new StringTokenizer(data,"/, ");
		System.out.println(st.countTokens());
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

	private static void f5() {
		String s1 = "이것이 자바다";
		System.out.println(s1.replace("자바", "JAVA"));
		System.out.println(s1);
		s1 = s1.replace("자바", "JAVA");
		System.out.println(s1);
		
		StringBuilder sb = new StringBuilder("이것이 자바다");
		sb.replace(4, 6, "JAVA");
		System.out.println(sb);
	}

	private static void f4() {
		String s1 = "이것이 자바다";
		String s2 = new String("이것이 자바다");
		char[] arr1 = s1.toCharArray();
		System.out.println(Arrays.toString(arr1));
		
 		
	}

	private static void f3() {
		Map<String, String> map = System.getenv();
		for(String key: map.keySet()) {
			System.out.println(key +">> "+map.get(key));
		}
	}
}
