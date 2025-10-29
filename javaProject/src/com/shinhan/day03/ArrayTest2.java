package com.shinhan.day03;

import java.util.Arrays;

public class ArrayTest2 {

	public static void main(String[] args) {
//		calScores();
		int[] arr = {100,99,88};
		arr[0] = 200;
		System.out.println("before: "+Arrays.toString(arr));
		call(arr);
		System.out.println("after: "+Arrays.toString(arr));
		
		// 주소할당, 값복사가 아님.
		int[] arr2 = arr;
		arr2[1] = 400;
		System.out.println("arr"+Arrays.toString(arr));
		System.out.println("arr2: "+Arrays.toString(arr2));
		
		int[] arr3 = new int[10];
		System.arraycopy(arr, 0, arr3, 0, arr.length);
		System.out.println(Arrays.toString(arr3));
		int[] arr4 = Arrays.copyOf(arr, arr.length);
		System.out.println(Arrays.toString(arr4));
 	}

	private static void call(int[] arr) {
		arr[0] = 300;
		
	}

	private static void calScores() {
		// case) 3명의 학생의 점수, 각각의 학생마다 과목의 수가 다름. 총점과 평균 출력하기
		int[][] scores;
		scores = new int[3][];
		scores[0] = new int[]{80, 90, 40};
		scores[1] = new int[]{80, 60, 70, 55};
		scores[2] = new int[]{10, 90, 90, 90, 80};
		for (int row=0; row<scores.length; row++) {
			int total = 0;
			for (int score:scores[row]) {
				total += score;
			}
			System.out.printf("%d번째 학생의 총점 & 평균 : %d....%.2f\n", row+1, total, (double)total/scores[row].length);
		}
	}

}
