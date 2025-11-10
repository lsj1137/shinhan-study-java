package com.shinhan.day13;

import java.util.Arrays;
import java.util.Comparator;

class MyDescendingInteger implements Comparator<Integer> {
	public int compare(Integer o1, Integer o2) {
		return o2-o1;
	}
}

public class Review {

	public static void main(String[] args) {
//		f1();
//		f2();
		f3();
	}

	private static void f3() {
		Integer[] arr = {59, 14, 32, 62, 69, 42, 11};
//		Arrays.sort(arr, new Comparator<Integer>() {
//
//			@Override
//			public int compare(Integer o1, Integer o2) {
//				return o2-o1;
//			}
//			
//		});
		Arrays.sort(arr, (o1, o2) -> o2-o1);
		System.out.println(Arrays.toString(arr));
	}

	private static void f2() {
		Integer[] arr = {59, 14, 32, 62, 69, 42, 11};
		Arrays.sort(arr, new MyDescendingInteger());
		System.out.println(Arrays.toString(arr));
	}

	private static void f1() {
		Integer a = 10;
		Integer b = 15;
		int result = a.compareTo(b);
		System.out.println(result);
		String c = "ab";
		String d = "zw";
		int result2 = c.compareTo(d);
		System.out.println(result2);
	}

}
