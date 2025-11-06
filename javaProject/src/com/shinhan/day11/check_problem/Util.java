package com.shinhan.day11.check_problem;

public class Util {

	public static <K,V> V getValue(Pair<K, V> pair, K key) {
		if (pair.getKey().equals(key)) {
			return pair.getValue();
		}
		return null;
	}
}
