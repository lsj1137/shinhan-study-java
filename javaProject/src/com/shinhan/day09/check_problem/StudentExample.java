package com.shinhan.day09.check_problem;

import java.util.HashSet;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(of= {"studentNum"})
class Student {
	private String studentNum;
	
	public Student(String studentNum) {
		this.studentNum = studentNum;
	}
	
	public String getStudentNum() {
		return studentNum;
	}
	
	
}


class StudentExample {
	public static void main(String[] args) {
		HashSet<Student> hashSet = new HashSet<>();
		hashSet.add(new Student("1"));
		hashSet.add(new Student("1"));
		hashSet.add(new Student("2"));
		System.out.println("저장된 Student 수: "+ hashSet.size());
	}
}