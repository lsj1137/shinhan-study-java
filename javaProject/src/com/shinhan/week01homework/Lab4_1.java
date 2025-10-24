package com.shinhan.week01homework;

import java.util.Scanner;

public class Lab4_1 {
	public static void main(String[] args) {
		q1();
		
		
	}

	private static void q1() {
		Scanner sc = new Scanner(System.in);
		int i, limit, step, total=0;
		System.out.print("초기값을 정수로 입력하세요. : ");
		i = Integer.parseInt(sc.nextLine());

		System.out.print("마지막 값을 정수로 입력하세요. : ");
		limit = Integer.parseInt(sc.nextLine());

		System.out.print("증가분을 정수로 입력하세요. : ");
		step = Integer.parseInt(sc.nextLine());
		
		for (int j=i; j<=limit; j++) {
			total += j;
		}
		System.out.printf("총합은 %d 입니다.", total);
	}
}
