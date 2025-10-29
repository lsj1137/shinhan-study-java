package com.shinhan.day05;

public class Ch6_LAB5 {
	public static void main(String[] args) {
		q1();
		q2();
		
	}

	private static void q2() {
		Employee e1 = new Employee(1, "이부장", 1500000);
		Employee e2 = new Employee(2, "김과장", 1300000 );
		Employee e3 = new Employee(3, "최대리", 1200000 );
		Employee e4 = new Employee(4, "박사원", 1000000 );
		System.out.println(e1.getSalary(0.5));
		System.out.println(e2.getSalary(0.5));
		System.out.println(e3.getSalary(0.5));
		System.out.println(e4.getSalary(0.5));
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		System.out.println(e4);
	}

	private static void q1() {
		Employee e1 = new Employee("이부장", "부장", 1500000);
		Employee e2 = new Employee("김과장", "과장", 1300000 );
		Employee e3 = new Employee("최대리", "대리", 1200000 );
		Employee e4 = new Employee("박사원", "사원", 1000000 );
		e1.print();
		e2.print();
		e3.print();
		e4.print();
	}
}

class Employee {
	int id;
	private String name;
	private String title;
	private int baseSalary;
	private int totalSalary;

	public Employee(int id, String name, int baseSalary) {
		this.id = id;
		this.name = name;
		this.baseSalary = baseSalary;
	}
	
	public Employee(String name, String title, int baseSalary) {
		this.name = name;
		this.title = title;
		this.baseSalary = baseSalary;
		this.getTotalSalary();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public int getBaseSalary() {
		return baseSalary;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	double getSalary(double bonus) {
		double salary = this.baseSalary + this.baseSalary*bonus;
		return salary;
	}
	
	public int getTotalSalary() {
		this.totalSalary = switch (this.title) {
		case "부장" -> this.baseSalary + (int) (this.baseSalary*0.25);
		case "과장" -> this.baseSalary + (int) (this.baseSalary*0.15);
		default -> this.baseSalary + (int) (this.baseSalary*0.05);
		};
		return this.totalSalary;
	}
	
	public void print() {
		System.out.println(this.title
				+ " 직급의 "
				+ this.name
				+ "씨의 본봉은 "
				+ this.baseSalary
				+ "원이고 총급여는 "
				+ this.totalSalary
				+ "원입니다.");
	}
	
	@Override
	public String toString() {
		return this.name
				+ "("
				+ this.id
				+ ")"
				+ " 사원의 기본급은 "
				+ this.baseSalary
				+ "원 입니다.";
	}
}


