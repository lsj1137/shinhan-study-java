package com.shinhan.day06.Ch7_LAB;

public class Circle extends Shape{
	double radius;
	double circumference;

	public Circle(String color, int radius) {
		super(color, "Circle");
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double calculateArea() {
		double area = Math.PI * radius * radius;
		return area;
	}

	@Override
	public double calculatePerimeter() {
		circumference = 2 * Math.PI * radius;
		return circumference;
	}


}
