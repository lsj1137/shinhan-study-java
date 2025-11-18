package com.shinhan.day16.final_test;

public class Prob5 {
	public static void main(String[] args) {
		int[] answer = { 1, 4, 4, 3, 1, 4, 4, 2, 1, 3, 2 };
		int[] counter = new int[4];

		// 구현하시오 - 숫자들의 개수를 세어 저장하는 코드를 작성한다.
		for (int i = 1; i<counter.length+1; i++) {
			int iCount = 0;
			for (int n: answer) {
				if (n==i) iCount++;
			}
			counter[i-1] = iCount;
		}
		
		// 구현하시오 - 출력결과와 같이 나오도록 작성한다.
		for (int i=1; i<counter.length+1; i++) {
			System.out.printf("%d의 갯수는 %d개 입니다.\n", i, counter[i-1]);
		}

	}
}
