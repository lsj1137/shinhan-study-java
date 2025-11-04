package com.shinhan.day08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//다형성 => 자동형변환 + override
public class Review {

	Lendable lendA = new LendableA();
	Lendable lendB = new LendableB();
	List aList = new ArrayList();
	List bList = new LinkedList();
	
	Lendable[] arr = new Lendable[10];
	{
		arr[0] = new LendableA();
		LendableA aa = (LendableA)lendA;
	}
	
	void call(Lendable lend) {
		
	}
	void call2() {
		call(new LendableA());
		call(new LendableB());
	}
	
	
	public static void main(String[] args) {
		f1();

	}

	private static void f1() {
		CDInfo a = new AppCDInfoChild();
		Lendable b = new AppCDInfoChild();
		AppCDInfo c = new AppCDInfoChild();
		b.checkOut("**", false);
		
		b.defaultMethod();
		Lendable.staticMethod();
		
		AppCDInfo.staticMethod();
	}

}
