package com.shinhan.day07.Ch8_LAB2;

public class Rectangle extends Shape implements Resizeable {
	double width;
	double height;
	
	public Rectangle(double w, double h) {
		super(4);
		width = w;
		height = h;
	}

	@Override
	public void resize(double s) {
		width *= s;
		height *= s;
	}

	@Override
	double getArea() {
		double area = width * height;
		return area;
	}

	@Override
	double getPerimeter() {
		double perimeter = (width + height)*2;
		return perimeter;
	}

}
