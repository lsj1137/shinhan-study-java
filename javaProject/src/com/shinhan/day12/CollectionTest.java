package com.shinhan.day12;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;



public class CollectionTest {
	public static void main(String[] args) {
//		f1();
		f13();
		
	}

	private static void f13() {
		Properties pro = new Properties();
		InputStream is = CollectionTest.class.getResourceAsStream("/com/shinhan/util/oracleDB.properties");
		System.out.println(is);
		try {
			pro.load(is);
			String driver = pro.getProperty("driver");
			String url = pro.getProperty("url");
			String username = pro.getProperty("username");
			String password = pro.getProperty("password");
			String admin = pro.getProperty("admin");
			System.out.println(driver);
			System.out.println(url);
			System.out.println(username);
			System.out.println(password);
			System.out.println(admin);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Map.Entry<Object, Object> entry: pro.entrySet()) {
			String key = (String) entry.getKey();
			String value = pro.getProperty(key);
			System.out.println(key+": "+value);
		}
		
	}

	private static void f1() {
		// 배열: 연속공간, 개수고정, 1가지 타입
		// Collection <-- List(순서 있음, 중복 가능), Set(순서 없음, 중복 불가)
		// 			  <-- Map(키와 값의 쌍)
		// List <-- ArrayList, LinkedList, Vector
		
		List<String> data = new LinkedList<>();
		data.add("월요일");
		data.add("화요일");
		data.add("목요일");
		data.add("월요일");
		for (String s: data) {
			System.out.println(s);
		}
	}
}
