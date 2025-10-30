package com.shinhan.day06;

public class SingletonTest {
	public static void main(String[] args) {
		f1();
		f2();
		
	}

	private static void f2() {
		ShopService obj1 = ShopService.getInstance();
		ShopService obj2 = ShopService.getInstance();
		if (obj1==obj2) {
			System.out.println("같은 ShopService 객체입니다.");
		} else {
			System.out.println("다른 ShopService 객체입니다.");
		}
		
	}

	private static void f1() {
//		Singleton a = new Singleton(); 사용불가 (생성자 private)
		Singleton a = Singleton.getInstance();
		Singleton b = Singleton.getInstance();
		
		System.out.println(System.identityHashCode(a));
		System.out.println(System.identityHashCode(b));
		System.out.println(a==b);
		
	}
}
