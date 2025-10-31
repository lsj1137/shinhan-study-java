package com.shinhan.day07.Ch8_LAB2;

public class RectTriangle extends Shape{
	double width;
	double height;

	public RectTriangle(double w, double h) {
		super(3);
		width = w;
		height = h;
	}

	@Override
	double getArea() {
		double area = width * height * 0.5;
		return area;
	}

	@Override
	double getPerimeter() {
		double hypotenuse = Math.sqrt(width*width + height*height);
		double perimeter = width+height+hypotenuse;
		return perimeter;
	}

}
