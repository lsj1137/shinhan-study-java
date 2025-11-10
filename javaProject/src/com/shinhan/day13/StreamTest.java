package com.shinhan.day13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;



public class StreamTest {

	public static void main(String[] args) {
//		f1();
//		f8();
		f11();
		f12();
		
	}

	private static void f12() {
		List<String> data = List.of("this is java", "I am the best developer");
		data.stream()
		.flatMap(str->Arrays.stream(str.split(" ")))
		.forEach(str->System.out.println(str));
	}

	private static void f11() {
		int[] arr = {1,2,3,4,5};
		
		Arrays.stream(arr)
		.boxed()
		.forEach(data->System.out.println(data.compareTo(3)));
		

		Arrays.stream(arr)
		.asDoubleStream()
		.forEach(data->System.out.println(data));
	}

	private static void f8() {
		List<String> data = new ArrayList<String>();
		data.add("홍고추");
		data.add("김가루");
		data.add("동그라미");
		data.add("전투화");
		data.add("홍소육");
		data.add("김자반");
		data.add("동그랑땡");
		data.add("전복");
		// 중복제거
		data.stream().distinct().forEach(name->System.out.println(name));
		// 신으로 시작하는 이름만 출력
		data.stream().filter(name->name.startsWith("홍")).forEach(name->System.out.println(name));
		data.stream().filter(name->name.length()>3).forEach(name->System.out.println(name));
		System.out.println(data);
	}

	private static void f1() {
		Set<String> set = new HashSet<String>();
		set.add("홍길동");
		set.add("김자바");
		set.add("임파썬");
		set.add("조씨샵");
		// 외부 반복자
		for (String name: set) {
			System.out.println(name);
		}
		// 내부 반복자
		Stream<String> stream = set.stream();
		stream.forEach(name->System.out.println(name));
	}

}
