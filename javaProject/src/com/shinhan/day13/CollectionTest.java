package com.shinhan.day13;

import java.util.ArrayList;
import java.util.List;

public class CollectionTest {
	public static void main(String[] args) {
		f1();
	}

	private static void f1() {
		List<String> data = new ArrayList<>();
		data.add("월");
		System.out.println(data.toString());
		data.set(data.indexOf("월"), "화");
		System.out.println(data.toString());
		
	}
}
