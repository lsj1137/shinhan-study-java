package com.shinhan.day06.inheritance;

class Parent{
	private int money=1000;
	public Parent() {
		System.out.println("부모의 생성자");
	}
	public int getMoney() {
		return money-100;
	}
	public void setMoney(int money) {
		this.money = money;
	}
}
class Child extends Parent{
	public Child() {
		System.out.println("자식의 생성자");
	}
}

public class InheritanceTest2 {
	public static void main(String[] args) {
		Child ch1 = new Child();
		System.out.println(ch1.getMoney());
	}
}
