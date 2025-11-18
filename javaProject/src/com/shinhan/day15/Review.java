package com.shinhan.day15;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
class HighStudent {
	String name;
	String gender;
	int score;
}

@AllArgsConstructor
@Getter @Setter
@ToString
class Member {
	private String name;
	private int age;
}

@AllArgsConstructor
@Getter @Setter
@ToString
class Member2 {
	private String name;
	private String job;
}

public class Review {
	static List<HighStudent> totalList = List.of(
			new HighStudent("홍길돈", "남", 100),
			new HighStudent("홍길동", "남", 94),
			new HighStudent("홍길순", "여", 97),
			new HighStudent("홍길송", "여", 98),
			new HighStudent("홍박사", "남", 87));
	
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
		f6();
	}

	private static void f6() {
		String fileName = "./src/com/shinhan/day14/NetworkTest.java";
		try (FileReader fr = new FileReader(fileName)) {
			String data;
			BufferedReader br = new BufferedReader(fr);
			int lineNumber = 0;
			while ((data=br.readLine())!=null) {
				System.out.println(data);
				lineNumber++;
			}
			System.out.println("라인 수 "+lineNumber);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void f5() {
		String fileName = "./src/com/shinhan/day14/NetworkTest.java";
		try (FileReader fr = new FileReader(fileName)) {
			int data;
			while ((data=fr.read())!=-1) {
				System.out.print((char)data);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void f4() {
		List<Member2> memberList = Arrays.asList(
				new Member2("홍기동", "개발자"),
				new Member2("홍길동", "의사"),
				new Member2("홍길덕", "고깃집사장"),
				new Member2("홍거덩", "회사원"),
				new Member2("홍기둥", "개발자"),
				new Member2("홍가담", "회사원")
				);
		Map<String, List<Member2>> groups = memberList.stream()
		 .collect(Collectors.groupingBy(m->m.getJob()));
		System.out.println(groups);
		System.out.println(groups.keySet());
		System.out.println(groups.values());
	}

	private static void f3() {
		List<Member2> memberList = Arrays.asList(
				new Member2("홍기동", "개발자"),
				new Member2("홍길동", "의사"),
				new Member2("홍길덕", "고깃집사장"),
				new Member2("홍거덩", "회사원"),
				new Member2("홍기둥", "개발자")
				);
		 List<Member2> developerList = memberList.stream()
		 .filter(m->m.getJob().equals("개발자"))
		 .toList();
		 System.out.println(developerList.toString());
	}

	private static void f2() {
		List<Member> memberList = Arrays.asList(
				new Member("홍기동", 16),
				new Member("홍길동", 26),
				new Member("홍길덕", 61),
				new Member("홍거덩", 34),
				new Member("홍기둥", 22)
				);
		double avgAge = memberList.stream()
		.mapToInt(m -> m.getAge())
		.average()
		.orElse(0);
		System.out.println(avgAge);
	}

	private static void f1() {
		double average = totalList.stream()
		.filter(s->s.score>90)
		.mapToInt(s->s.score)
		.peek(s->System.out.println(s))
		.average()
		.getAsDouble();
		
		System.out.println("90점 이상 평균 : "+average);
	}
}
