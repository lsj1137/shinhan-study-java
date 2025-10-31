package com.shinhan.day07.animals;

public class InheritanceTest2 {
	public static void main(String[] args) {
//		Animal ani = new Animal("","");
		Dog dog = new Dog("멍멍이","white",4);
		Cat cat = new Cat("냐옹이","black", true);
		
		call(dog);
		call(cat);
	}

	// 자동형변환되어 들어감
	private static void call(Animal animal) {
		System.out.println("------------------");
		System.out.println(animal.name);
		System.out.println(animal.color);
		animal.sing();
		
		if (animal instanceof Dog) {
			Dog d = (Dog) animal;
			System.out.println(d.a);
			d.fDog();
		} else if (animal instanceof Cat) {
			Cat c = (Cat) animal;
			System.out.println(c.b);
			c.fCat();
		}
	}
	
	
}
