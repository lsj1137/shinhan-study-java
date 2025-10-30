package com.shinhan.day06.Ch7_LAB;

public class Vehicle {
	private String name;
	private int speed;
	
	public Vehicle() {
		
	}
	
	public Vehicle(String name, int speed) {
		this.name = name;
		this.speed = speed;
	}
	
	public void start() {
		System.out.println(name+" 출발합니다. (속도 : "+speed+"km/h)");
	}
	
	public void stop() {
		System.out.println(name+" 멈춥니다.");
		
	}
	
	public String info() {
		return "차량명 : "
				+ name
				+ ", 최고속도 : "
				+ speed
				+ "km/h";
	}
}

class Car extends Vehicle {
	private int gasMileage;
	
	public Car(String name, int speed, int gasMileage) {
		super(name, speed);
		this.gasMileage = gasMileage;
	}
	
	@Override
	public String info() {
		return super.info()+", 연비 : "+gasMileage+"km/h";
	}
}

class Bus extends Vehicle {
	private int passengerCount;
	
	public Bus(String name, int speed, int passengerCount) {
		super(name, speed);
		this.passengerCount = passengerCount;
	}
	
	@Override
	public String info() {
		return super.info()+", 승객 수용 가능 인원 : "+passengerCount+"명";
	}
}

class Truck extends Vehicle {
	private int maxLoad;
	
	public Truck(String name, int speed, int maxLoad) {
		super(name, speed);
		this.maxLoad = maxLoad;
	}
	
	@Override
	public String info() {
		return super.info()+", 최대 적재량 : "+maxLoad+"kg";
	}
}