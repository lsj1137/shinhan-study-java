package com.shinhan.day10.Ch12_LAB3;

import java.util.Arrays;

public class Median {
	public static void main(String[] args) {
		Median median = new Median();
		int[] values1 = { 10, 4, 53, 63, 17, 37, 52, 16, 33, 65 };
		System.out.println("input : " + Arrays.toString(values1));
		System.out.println("median : " + median.findMedian(values1));
		System.out.println("===============================");

		int[] values2 = { 32, 53, 52, 76, 15, 98, 76, 65, 36, 10 };
		System.out.println("input : " + Arrays.toString(values2));
		System.out.println("median : " + median.findMedian(values2));
	}

	public int findMedian(int[] values) {
		int total = 0, average = 0;
		for (int v : values) {
			total += v;
		}
		average = total / values.length;
		int gap = total;
		int result = total;
		for (int v : values) {
			if (Math.abs(v-average)<gap) {
				gap = Math.abs(v-average);
				result = v;
			} else if (Math.abs(v-average)==gap) {
				result = Math.min(v, result);
			}
		}
		return result;
	}

}
