package com.shinhan.practice_exam;

import java.util.Arrays;

// 잘 작성되었는지 테스트 케이스 넣어 실행하는 클래스
public class Runner {
	public static void main(String[] args) {

		System.out.println("=========================Q1. AUCTION=========================");
		int n1 = 4;
		int[] amounts1 = {1000000, 490000, 700000, 290000};
		int[] result1 = Auction.run(n1, amounts1);
		System.out.println(Arrays.toString(result1));
		int n2 = 6;
		int[] amounts2 = {30000, 70000, 10000};
		int[] result2 = Auction.run(n2, amounts2);
		System.out.println(Arrays.toString(result2));
		
		System.out.println("=========================Q2. THEMEPARK TICKET=========================");
		int tickets1 = 10;
		int[][] requests1 = {{2,3},{1,7},{2,4},{3,5}};
		int result3 = ThemeParkTicket.run(tickets1, requests1);
		System.out.println(result3);
		int tickets2 = 8;
		int[][] requests2 = {{1,9},{3,6},{2,5}};
		int result4 = ThemeParkTicket.run(tickets2, requests2);
		System.out.println(result4);
		int tickets3 = 20000;
		int[][] requests3 = {{3,1},{2,5},{2,10},{3,8},{1,2}};
		int result5 = ThemeParkTicket.run(tickets3, requests3);
		System.out.println(result5);

		System.out.println("=========================Q3. MINUS ACCOUNT=========================");
		int m1 = 5000;
		int[] ledger1 = {10000, -13000, -4000, -2000, 6500, -20000};
		int result6 = MinusAccount.run(m1, ledger1);
		System.out.println(result6);
		int m2 = 34151;
		int[] ledger2 = {-34152, -40000, -50000};
		int result7 = MinusAccount.run(m2, ledger2);
		System.out.println(result7);
		
		System.out.println("=========================Q4. MEMBERSHIP VIP=========================");
		int[] periods1 = { 8, 23, 24 };
		int[][] payments1 = {
				{ 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000 },
				{ 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000 },
				{ 350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 }, };
		int[] estimates1 = { 100000, 100000, 100000 };
		
		int[] result8 = MembershipVIP.run(periods1, payments1, estimates1);
		System.out.println(Arrays.toString(result8));
//		
		int[] periods2 = { 24, 59, 59, 60 };
		int[][] payments2 = {
				{ 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 },
				{ 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 },
				{ 350000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 },
				{ 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000 }, };
		int[] estimates2 = { 350000, 50000, 40000, 50000 };
		
		int[] result9 = MembershipVIP.run(periods2, payments2, estimates2);
		System.out.println(Arrays.toString(result9));
	}
}
