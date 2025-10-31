package com.shinhan.day07.Ch8_LAB2;

public abstract class Shape {
	int numSides;
	
	public Shape(int numSides) {
		this.numSides = numSides;
	}
	
	public int getNumSides() {
		return numSides;
	}
	
	abstract double getArea();
	abstract double getPerimeter();
}
