package com.shinhan.day06.Ch7_LAB;

public class VehicleTest {
	
	public static void main(String[] args) {
		Car c = new Car("승용차", 180, 15);
		Bus b = new Bus("시내버스", 100, 40);
		Truck t = new Truck("화물트럭", 90, 5000);
		System.out.println(c.info());
		c.start();
		c.stop();
		System.out.println(b.info());
		b.start();
		b.stop();
		System.out.println(t.info());
		t.start();
		t.stop();
	}

}
