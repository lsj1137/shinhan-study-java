package com.shinhan.practice_exam;

import java.util.Arrays;
import java.util.Comparator;

public class Auction {
	public static int[] run(int n, int[] amounts) {
		int[] result = new int[n];
		Integer[] amountsArr = new Integer[amounts.length];
		for (int i=0; i<amounts.length; i++) {
			amountsArr[i] = amounts[i];
		}
		Comparator<Integer> amountComparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		};
		for (int i=0; i<n; i++) {
			Arrays.sort(amountsArr, amountComparator);
			if (amountsArr[0].equals(amountsArr[1])) {
				result[i] = amountsArr[0];
				amountsArr[0] = 0;
			} else {
				result[i] = amountsArr[1]+10000;
				amountsArr[0] -= amountsArr[1]+10000;
			}
		}
		return result;
	}
}
