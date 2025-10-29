package com.shinhan.day05;

public class Ch6_LAB6 {
	public static void main(String[] args) {
		Student s1 = new Student("홍길동", 20, 200201);
		Teacher t1 = new Teacher("이순신", 30, "JAVA");
		Employee2 e1 = new Employee2("유관순", 40, "교무과");
		s1.print();
		t1.print();
		e1.print();
	}
}

class Human {
	private String name;
	private int age;
	
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	void print() {
		System.out.printf("이   름 : %-6s 나 이 : %-6d ", this.name, this.age);
	}
}

class Student extends Human {
	private int id;
	
	public Student(String name, int age, int id) {
		super(name, age);
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	void print() {
		super.print();
		System.out.printf("학   번 : %d\n",this.id);
	}
}

class Teacher extends Human  {
	private String subject;
	
	public Teacher(String name, int age, String subject) {
		super(name, age);
		this.subject = subject;
	}
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@Override
	void print() {
		super.print();
		System.out.printf("담당과목 : %s\n",this.subject);
	}

}

class Employee2 extends Human  {
	private String dept;
	
	public Employee2(String name, int age, String dept) {
		super(name, age);
		this.dept = dept;
	}
	
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	@Override
	void print() {
		super.print();
		System.out.printf("부   서 : %s\n",this.dept);
	}
}