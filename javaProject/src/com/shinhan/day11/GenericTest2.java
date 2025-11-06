package com.shinhan.day11;

public class GenericTest2 {
	public static void main(String[] args) {
//		f1();
//		f2();
		System.out.println(f3(new TV(),300));
		Box<String, Integer> b1 = new Box<>("ABC",100);
		printBox(b1);
		Box<String, Integer> b2 = new Box<>("ABC",100);
		printBox2(b2);
	}
	
	// 매개변수 타입 제한
	private static void printBox2(Box<? extends String, ? extends Number> b1) {
		System.out.println(b1);
	}
	
	private static <A,B> void printBox(Box<A,B> b1) {
		System.out.println(b1);
	}

	private static <K,M> Box<K,M> f3(K kind,M model) {
		Box<K,M> b1 = new Box<K,M>(kind, model);
		return b1;
		
	}

	private static void f2() {
		HomeAgency ha = new HomeAgency();
		Home home = ha.rent();
		home.turnOnLight();
		
	}

	private static void f1() {
		Product<TV, String> p1 = new Product<>(new TV("삼성",200), "TV-abc");
		Product<Computer, Integer> p2 = new Product<>(new Computer("MacOS"), 200);
	}
}
