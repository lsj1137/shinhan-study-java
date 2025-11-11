package com.shinhan.day14.check_problem;

import java.util.Arrays;

@FunctionalInterface
interface Function<T> {
	public double apply(T t);
}

public class Example2 {
	private static Student[] students = { new Student("홍길동", 90, 96), new Student("신용권", 95, 93) };

	static double avg(Function<Student> f) {
		double result = Arrays.stream(students)
		.mapToDouble(s->f.apply(s))
		.average().orElse(0);
		return result;
	}

	public static void main(String[] args) {
		double englishAvg = avg(s -> s.getEnglishScore());
		System.out.println("영어 평균 점수: " + englishAvg);
		double mathAvg = avg(s -> s.getMathScore());
		System.out.println("수학 평균 점수: " + mathAvg);
		double englishAvg2 = avg(Student::getEnglishScore);
		System.out.println("영어 평균 점수: " + englishAvg2);
		double mathAvg2 = avg(Student::getMathScore);
		System.out.println("수학 평균 점수: " + mathAvg2);
	}
}
