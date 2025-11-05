package com.shinhan.day10;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
//		f10();		
//		f13();
//		f14();
//		f15();
//		f16();
//		f17();
		f18();
	}

	
	private static void f18() {
		String exp2 = "\\w+@([0-9a-zA-z]+)\\.\\w{3}";
		String data2 = "gildong11@naver.com";

		String data4 = "dkjs23@daum.net master@naver.com 그랭ㄱㅇㅁㄹ 자바다 zzz@daum.net";
		Pattern emailPattern = Pattern.compile(exp2);
		Matcher emailMatcher = emailPattern.matcher(data4);
		
		while (emailMatcher.find()) {
			String company = emailMatcher.group(1);
			if (company.equals("daum")) {
				System.out.println(emailMatcher.group());
			}
		}
	}


	private static void f17() {
		String ex1 = "([01]{3})-([0-9]{3,4})-([0-9]{4})";
		String data = "111-234-5678";

		Pattern phonePattern = Pattern.compile(ex1);
		Matcher phoneMatcher = phonePattern.matcher(data);
		
		while (phoneMatcher.find()) {
			System.out.println(phoneMatcher.group());
			System.out.println(phoneMatcher.group(0));
			System.out.println(phoneMatcher.group(1));
			System.out.println(phoneMatcher.group(2));
			System.out.println(phoneMatcher.group(3));
		}
	}


	private static void f16() {
		String ex1 = "[01]{3}-[0-9]{3,4}-[0-9]{4}";
		String data = "111-234-5678";
		String exp2 = "\\w+@([0-9a-zA-z]+)\\.\\w{3}";
		String data2 = "gildong11@naver.com";
		boolean result2 = Pattern.matches(exp2, data2);
		System.out.println(result2);
		String data3 = "010-2121-1212 dkdkdkdkdk 010-1111-2222";
		Pattern phonePattern = Pattern.compile(ex1);
		Matcher phoneMatcher = phonePattern.matcher(data3);
		
		String data4 = "dkjs23@daum.net master@naver.com";
		
		
	}


	private static void f15() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dt = "2025-11-11";
		try {
			Date dt2 = sdf.parse(dt);
			System.out.println(dt2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private static void f14() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss a D일 w주");
		Date d = new Date();
		System.out.println(sdf.format(d));
	}


	private static void f13() {
		DecimalFormat df = new DecimalFormat("###,000,000.00");
		double value = 1234567.1345;
		String result = df.format(value);
		System.out.println(result);
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
