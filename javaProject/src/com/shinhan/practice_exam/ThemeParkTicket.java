package com.shinhan.practice_exam;

import java.util.Arrays;
import java.util.Comparator;

public class ThemeParkTicket {
	public static int run(int tickets, int[][] requests) {
		int result = 0;
		Integer[][] requestsArr = new Integer[requests.length][];
		for (int i = 0; i < requests.length; i++) {
			requestsArr[i] = new Integer[requests[i].length];
			for (int j = 0; j < requests[0].length; j++) {
				requestsArr[i][j] = requests[i][j];
			}
		}
		
		Comparator<Integer[]> requestComparator = new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] a, Integer[] b) {
				if (a[0] == b[0]) {
					return b[1] - a[1];
				} else {
					return a[0] - b[0];
				}
			}
		};
		Arrays.sort(requestsArr, requestComparator);
		
		for (Integer[] arr : requestsArr) {
			if (tickets >= arr[1]) {
				tickets -= arr[1];
				result += arr[1];
			}
		}
		return result;
	}
}
