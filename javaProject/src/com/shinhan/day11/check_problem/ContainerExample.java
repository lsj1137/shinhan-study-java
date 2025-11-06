package com.shinhan.day11.check_problem;

public class ContainerExample {
	public static void main(String[] args) {
		Container<String> container1 = new Container<String>();
		container1.set("홍길동");
		String str = container1.get();
		Container<Integer> container2 = new Container<Integer>();
		container2.set(6);
		int value = container2.get();
		
		Container2<String, String> container3 = new Container2<String, String>();
		container3.set("홍길동", "도적");
		String name1 = container3.getKey();
		String job = container3.getValue();
		Container2<String, Integer> container4 = new Container2<String, Integer>();
		container4.set("홍길동", 35);
		String name2 = container4.getKey();
		int age = container4.getValue();
	}
}
