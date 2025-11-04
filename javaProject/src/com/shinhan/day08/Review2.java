package com.shinhan.day08;

interface MyInterface{
	default void f1() {
		System.out.println("모든 구현class에 동일한 기능사용..재정의가능 ");
	}
}
class B implements MyInterface{}
class C implements MyInterface{}
class D extends B{}
class E extends C{} 

public class Review2 {

	
	public static void main(String[] args) {
		
		dbWork(new OracleDAO());
		dbWork(new MySQLDAO());
	}
	
	
	private static void dbWork(DataAccessObject dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
		
		if(dao instanceof MySQLDAO my) {
			//MySQLDAO my = (MySQLDAO)dao;
			my.f1();
		}
		
		
	}


	public static void main4(String[] args) {
		sound(new Dog());
		sound(new Cat());
	}
	public static void  sound(Soundable aa) {
		System.out.println(aa.sound());
	}
	
	
	
	public static void main3(String[] args) {
		Remocon a = new TV();
		TV a2 = new TV();
		a2.powerOn();
	}
	
	
	public static void main2(String[] args) {
		method(new B() );
		method(new C() );
		method(new D() );
		method(new E() );

	}

	private static void method(MyInterface a) {
		a.f1();
		
	}
	
	

}
