package com.shinhan.practice_exam;

import java.util.Arrays;

// MembershipVIP가 잘 작성되었는지 테스트 케이스 넣어 실행하는 클래스
public class Runner {
	public static void main(String[] args) {
		System.out.println("=========================TEST1=========================");
		int[] periods1 = { 8, 23, 24 };
		int[][] payments1 = {
				{ 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000 },
				{ 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000 },
				{ 350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 }, };
		int[] estimates1 = { 100000, 100000, 100000 };
		
		int[] result = MembershipVIP.run(periods1, payments1, estimates1);
		System.out.println(Arrays.toString(result));
		
		System.out.println("=========================TEST2=========================");
		int[] periods2 = { 24, 59, 59, 60 };
		int[][] payments2 = {
				{ 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 },
				{ 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 },
				{ 350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 },
				{ 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 }, };
		int[] estimates2 = { 350000, 50000, 40000, 50000 };
		
		int[] result2 = MembershipVIP.run(periods2, payments2, estimates2);
		System.out.println(Arrays.toString(result2));
	}
}
