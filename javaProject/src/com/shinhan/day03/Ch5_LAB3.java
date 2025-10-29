package com.shinhan.day03;

import java.util.Scanner;

public class Ch5_LAB3 {
	enum Grade {
		A, B, C, D, F
	}

	public static void main(String[] args) {
		q1();
	}

	private static void enterInfo(Scanner sc, int studentCount, String[] names, int[] scores, Grade[] grades) {
		for (int i = 0; i < studentCount; i++) {
			System.out.printf("%d번째 학생 이름,점수> ", i + 1);
			String nameAndScore = sc.nextLine();
			String[] temp = nameAndScore.split(",");
			names[i] = temp[0];
			scores[i] = Integer.parseInt(temp[1]);
			if (scores[i] >= 90) {
				grades[i] = Grade.A;
			} else if (scores[i] >= 80) {
				grades[i] = Grade.B;
			} else if (scores[i] >= 70) {
				grades[i] = Grade.C;
			} else if (scores[i] >= 60) {
				grades[i] = Grade.D;
			} else {
				grades[i] = Grade.F;
			}
		}
	}

	private static void q1() {
		Scanner sc = new Scanner(System.in);
		boolean isRunning = true;
		int studentCount = 0;
		String[] names = new String[] {};
		int[] scores = new int[] {};
		Grade[] grades = new Grade[] {};
		while (isRunning) {
			System.out.println("\n----------------------------------------------------");
			System.out.println("1.학생수(이름,점수입력)  2.성적목록  3.최고 점수를 받은 학생 찾기\r\n" + "4.평균 점수  5.특정 점수 이상 학생  6.종료");
			System.out.println("----------------------------------------------------");
			System.out.print("선택> ");
			int cmd = Integer.parseInt(sc.nextLine());
			switch (cmd) {
			case 1 -> {
				System.out.printf("학생 수를 입력하세요: ");
				studentCount = Integer.parseInt(sc.nextLine());
				names = new String[studentCount];
				scores = new int[studentCount];
				grades = new Grade[studentCount];
				enterInfo(sc, studentCount, names, scores, grades);
			}
			case 2 -> {
				System.out.println("=== 학생 성적 목록 ===");
				for (int i = 0; i < studentCount; i++) {
					System.out.printf("%s - 점수: %d, 등급: %s\n", names[i], scores[i], grades[i]);
				}
			}
			case 3 -> {
				int highScore = 0;
				int bestStudent = 0;
				for (int i = 0; i < studentCount; i++) {
					if (scores[i] > highScore) {
						bestStudent = i;
						highScore = scores[i];
					}
				}
				System.out.printf("최고 점수를 받은 학생: %s (%d점)\n", names[bestStudent], scores[bestStudent]);
			}
			case 4 -> {
				int total = 0;
				for (int i = 0; i < studentCount; i++) {
					total += scores[i];
				}
				System.out.println("전체 학생의 평균 점수: " + (double) total / studentCount);
			}
			case 5 -> {
				System.out.printf("기준 점수를 입력하세요: ");
				int stdScore = Integer.parseInt(sc.nextLine());
				System.out.printf("\n=== %d점 이상 학생 목록 ===\n", stdScore);
				for (int i = 0; i < studentCount; i++) {
					if (scores[i]>=stdScore) {
						System.out.printf("%s - 점수: %d, 등급: %s\n", names[i], scores[i], grades[i]);
					}
				}
			}
			case 6 -> {
				isRunning = false;
			}
			default -> {
				System.out.println("1 ~ 6 사이의 숫자를 입력하세요.");
			}
			}
		}
		System.out.println("프로그램을 종료합니다.");
		sc.close();

	}

}
