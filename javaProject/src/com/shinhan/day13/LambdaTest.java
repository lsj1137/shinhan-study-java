package com.shinhan.day13;

/*
 * 소비자:     (a)->{실행문;}
 * 공급자:     () ->{return 값;}
 * Function:  (a)->{return 값;}
 */

@FunctionalInterface
interface Calculable {
	double calc(double a, double b);
}

class Person {
	public void action3(Calculable calculable, double a, double b) {
		double result = calculable.calc(a,b);
		System.out.println(result);
	};
}

class MyThreadA extends Thread {
	@Override
	public void run() {
		System.out.println("Thread를 상속받은 클래스");
	}
}

class Parent {
}

class MyThreadB extends Parent implements Runnable {

	@Override
	public void run() {
		System.out.println("Runnable 인터페이스를 구현한 구현 클래스");
	}
}

@FunctionalInterface
interface MyCalculator {	
	int add(int a, int b);
}

@FunctionalInterface
interface MyInterface {
	void sum();
}
@FunctionalInterface
interface MyInterface2 {
	void sum(int a);
}
@FunctionalInterface
interface MyInterface3 {
	int sum();
}

public class LambdaTest {
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
		f6();
		
//		System.out.println(Thread.currentThread().getName() + " 종료");
		
	}

	private static void f6() {
		Calculable calculable = (a,b)->a+b;
		Person p1 = new Person();
		p1.action3(calculable, 20, 30);
		
	}

	private static void f5() {
		MyInterface my1 = ()->{System.out.println("매개변수 없고 리턴 없음");};
		my1.sum();
		MyInterface2 my2 = (a)->{System.out.println(a+" 받아옴");};
		my2.sum(100);
		MyInterface3 my3 = ()->{return 200;};
		System.out.println(my3.sum());
	}

	private static void f4() {
		MyCalculator cal = new MyCalculator() {

			@Override
			public int add(int a, int b) {
				int result = a+b;
				return result;
			}
		};
		System.out.println(cal.add(63, 25));
		MyCalculator cal2 = (a,b)->{return a+b;};
		System.out.println(cal2.add(5, 134));
	}

	private static void f3() {
		Runnable r1 = () -> System.out.println("람다 구현 클래스");
		Thread t1 = new Thread(r1);
		t1.start();
	}

	private static void f2() {
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("익명 구현 클래스");
			}
		};
		Thread t1 = new Thread(r1);
		t1.start();
	}

	private static void f1() {
		Thread mta = new MyThreadA();
		Thread mtb = new Thread(new MyThreadB());
		mta.start();
		mtb.start();
	}

}
