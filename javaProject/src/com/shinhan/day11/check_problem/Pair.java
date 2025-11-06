package com.shinhan.day11.check_problem;

public class Pair<K, V> {
	private K key;
	private V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}

class ChildPair<K, V> extends Pair<K, V> {
	public ChildPair(K k, V v) {
		super(k, v);
	}
}

class OtherPair<K, V> {
	private K key;
	private V value;

	public OtherPair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}
}