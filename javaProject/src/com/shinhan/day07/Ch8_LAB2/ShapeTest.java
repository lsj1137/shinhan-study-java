package com.shinhan.day07.Ch8_LAB2;

public class ShapeTest {
	public static void main(String[] args) {
		Shape[] shArr = new Shape[2];
		Shape r = new Rectangle(5, 6);
		Shape rt = new RectTriangle(2, 6);
		shArr[0] = r;
		shArr[1] = rt;
		for (Shape s : shArr) {
			System.out.println("area: "+ s.getArea());
			System.out.println("perimeter: "+ s.getPerimeter());
			if (s instanceof Rectangle) {
				Rectangle temp = (Rectangle) s;
				temp.resize(0.5);
				System.out.println("new area: "+ temp.getArea());
				System.out.println("new perimeter: "+ temp.getPerimeter());
			}
		}
	}
}
