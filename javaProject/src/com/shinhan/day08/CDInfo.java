package com.shinhan.day08;

//class => 변수(속성,값저장목적)+함수(기능,메서드)
public class CDInfo {
    
}

//자바는 다중상속 불가하다. 
//interface이용한다. (규격),상수+기능(abstract, default,static,private)
interface Lendable{
	public abstract void checkOut(String a, boolean b);
    default void defaultMethod() {
    	System.out.println("interface에서 defaultMethod구현함");
    }
    static void staticMethod() {
    	System.out.println("interface에서 staticMethod구현함");
    }
}
class LendableA implements Lendable{

	@Override
	public void checkOut(String a, boolean b) {
		// TODO Auto-generated method stub
		
	}
	
}
class LendableB implements Lendable{

	@Override
	public void checkOut(String a, boolean b) {
		// TODO Auto-generated method stub
		
	}
	
}

//기존class에 있는 기능을 재사용, 기존class변경에 적용받고자한다.
//구현class는 반드시 추상메서드를 구현할 의무가있다. 
//구현하지않을거라면 추상class이다. 
abstract class AppCDInfo extends CDInfo implements Lendable{
	abstract void f1();
	@Override
	public void defaultMethod() {
    	System.out.println("구현class가 재정의");
    }
	
	//@Override가 아님 
	public static void staticMethod() {
    	System.out.println("구현class staticMethod구현함");
    }
	
	
}
class AppCDInfoChild extends AppCDInfo{

	@Override
	public void checkOut(String a, boolean b) {
		System.out.println(a);
		System.out.println(b);
		
	}

	@Override
	void f1() {
		// TODO Auto-generated method stub
		
	}
	
}




