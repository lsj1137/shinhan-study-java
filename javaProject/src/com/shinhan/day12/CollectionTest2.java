package com.shinhan.day12;

import java.util.TreeSet;

import com.shinhan.day11.threads.Account;

public class CollectionTest2 {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
		f5();
		
	}
	
	private static void f5() {
		TreeSet<Account> data = new TreeSet<Account>();
		data.add(new Account("1234124", "동길홍", 1000));
		data.add(new Account("1244213", "동길홍", 2000));
		data.add(new Account("1261134", "동길홍", 3000));
		data.add(new Account("1234124", "길홍동", 1400));
		data.add(new Account("1234124", "배홍동", 1600));
		System.out.println(data);
	}

	private static void f3() {
		TreeSet<Book> data = new TreeSet<Book>();
		data.add(new Book("A", "홍길동", 2000));
		data.add(new Book("A", "홍길동", 1000));
		data.add(new Book("A", "홍길동", 3000));
		data.add(new Book("A", "홍길동", 2500));
		System.out.println(data);
	}

	private static void f2() {
		TreeSet<String> data = new TreeSet<>();
		data.add("A");
		data.add("C");
		data.add("B");
		data.add("D");
		data.add("a");
		data.add("9");
		System.out.println(data);
	}

	private static void f1() {
		TreeSet<Integer> data = new TreeSet<Integer>();
		data.add(99);
		data.add(88);
		data.add(77);
		data.add(66);
		data.add(100);
		
		System.out.println(data);
		System.out.println(data.first());
		System.out.println(data.last());
		
		System.out.println(data.higher(88));
		System.out.println(data.floor(80));
	}
	
	
}
