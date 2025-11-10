package com.shinhan.day13;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class LambdaTest2 {
	public static void main(String[] args) {
		f1();
		f2();
	}

	private static void f2() {
		
	}

	private static void f1() {
		Consumer<Integer> consumer = (i) -> System.out.println(i);
		consumer.accept(20);
		BiConsumer<Integer, String> biConsumer = (i, s) -> System.out.println(i+s);
		biConsumer.accept(61, " 이 왔어요");
		Supplier<String> supplier = () -> "문자를 공급합니다";
		System.out.println(supplier.get());
		
	}
}
