package com.shinhan.day08;

import com.shinhan.day07.Car;

class Bus extends Car{
	
	void f4() {
		System.out.println(password);
	}
}




public class InheritenceTest {

	public static void main(String[] args) {
		Car car = new Car();
		System.out.println(car.a);
		//System.out.println(car.a2);
		System.out.println(Car.b);
		car.f1();
		//car.f2();
		Car.f3();
		
		//System.out.println(car.password);

	}

}
