package com.shinhan.day06.Ch7_LAB;

public class Rectangle extends Shape{
	double length;
	double width;
	
	public Rectangle(String color, int length, int width) {
		super(color, "Rectangle");
		this.length = length;
		this.width = width;
	}

	@Override
	public double calculateArea() {
		double result = length * width;
		return result;
	}

	@Override
	public double calculatePerimeter() {
		double result = (length+width) * 2;
		return result;
	}

}
