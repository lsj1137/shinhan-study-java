package com.shinhan.day03;

import java.util.Arrays;

public class Ch5_LAB1 {
	public static void main(String[] args) {
		System.out.println("=========== Q1 ===========");
		q1();
		System.out.println("=========== Q2 ===========");
		q2();
		
	}

	public static int[][] sub(int[][] a, int[][] b, int[][] c) {
		for (int i=0; i<a.length; i++) {
			for (int j=0; j<a[0].length; j++) {
				c[i][j] = a[i][j] - b[i][j];
			}
		}
		return c;
	}
	
	public static void prn(int[][] c) {
		for (int[] row : c) {
			for (int col : row) {
				System.out.print(col+" ");
			}
			System.out.println();
		}
	}
	
	private static void q2() {
		int[][] a,b,c;
		a = new int[][] { {30, 30, 30, 30}, {40, 40, 40, 40}, {50, 50, 50, 50} };
		b = new int[][] { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12} };
		c = new int[a.length][a[0].length];
		sub(a,b,c);
		prn(c);
	}

	private static void q1() {
		int[] arr = {3, 24, 1, 55, 17, 43, 5};
		for (int i=0; i<arr.length-1; i++) {
			for (int j=i; j<arr.length; j++) {
				if (arr[i]>arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
