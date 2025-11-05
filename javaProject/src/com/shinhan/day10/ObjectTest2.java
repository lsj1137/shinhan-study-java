package com.shinhan.day10;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ObjectTest2 {
	public static void main(String[] args) throws ClassNotFoundException{
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		q11();
//		q12();
//		q13();
//		f6();
//		f7();
		q17();
	}
	
	private static void q17() {
		String id="5Angel1004";
		String id2 = "A123dafv13";
		String regExp = "^[a-zA-Z][a-zA-Z0-9]{7,11}$";
		boolean isMatch = Pattern.matches(regExp, id);
		if (isMatch) {
			System.out.println("ID로 사용가능합니다.");
		} else {
			System.out.println("ID로 사용할 수 없습니다.");
		}
	}

	private static void f7() {
		Duration dr = Duration.between(LocalDateTime.now(),LocalDateTime.of(2025, 12, 25,0,0));
		System.out.println(dr.toDays());
		
	}

	private static void f6() {
		Random random = new Random();
		List<Integer> lottos = new ArrayList<Integer>();
		for (int i=0; i<6; i++) {
			int n = random.nextInt(0,45)+1;
			while (lottos.contains(n)) {
				n = random.nextInt(0,45)+1;
			}
			lottos.add(n);
		}
		System.out.println(lottos.toString());
		
	}

	private static void q13() {
		System.out.println(Math.round(5.7));
		
	}

	private static void q12() {
		Integer i1 = 100; // byte 범위에 있으면 같은 주소
		Integer i2 = 100;
		Integer i3 = 300;
		Integer i4 = 300;
		System.out.println(i1==i2);
		System.out.println(i3==i4);
		System.out.println(i1.equals(i2));
		System.out.println(i3.equals(i4));
	}

	private static void q11() {
		String s = "아이디,이름,패스워드|전화번호 가족";
		StringTokenizer st = new StringTokenizer(s,",| ");
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		
	}

	private static void display(PrintAnnotation printAnnotation) {
		if (printAnnotation==null) return;
		int num = printAnnotation.number();
		String value = printAnnotation.value();
		System.out.println("num: "
				+ num
				+ " / value: "
				+ value);
	}
	
	private static void f5(){
		Method[] arr = PrintService.class.getDeclaredMethods();
		for (Method m:arr) {
			System.out.println(m.getName());
			PrintAnnotation pa = m.getAnnotation(PrintAnnotation.class);
			display(pa);
			
//			try {
//				m.invoke(new PrintService());
//			} catch (IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvocationTargetException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
	}


	private static void f4() {
		// class의 resource 정보얻기
		Class c1 = Car.class;
		URL url = c1.getResource("application.txt");
		System.out.println(url.getPath());
		InputStream is = c1.getResourceAsStream("application.txt");
		Scanner sc = new Scanner(is);
		try {
			String data;
			while ((data=sc.nextLine())!=null) {
				System.out.println(data);
			}
		} catch (NoSuchElementException e) {
			System.out.println("더 이상 읽을게 없습니다.");
		}
	}


	private static void printParameters(Class[] parameters) {
		for (int i=0; i<parameters.length; i++) {
			System.out.print(parameters[i].getName());
			if (i<(parameters.length-1)) {
				System.out.print(", ");
			}
		}
	}

	private static void f3() {
		Class clazz = Car.class;
		System.out.println("[생성자 정보]");
		Constructor[] constructors = clazz.getDeclaredConstructors();
		for (Constructor c: constructors) {
			System.out.print(c.getName()+"(");
			Class[] parameters = c.getParameterTypes();
			printParameters(parameters);
			System.out.println(")");
		}
		System.out.println();
		
		System.out.println("[필드 정보]");
		Field[] fields = clazz.getDeclaredFields();
		for (Field f: fields) {
			System.out.println(f.getType().getName()+" "+f.getName());
		}
		System.out.println();
		
		System.out.println("[메소드 정보]");
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m: methods) {
			System.out.print(m.getName() + "(");
			Class[] parameters = m.getParameterTypes();
			printParameters(parameters);
			System.out.println(")");
		}
	}

	private static void f2() {
		Class c1 = Car.class;
		Field[] arr = c1.getDeclaredFields();
		for (Field f:arr) {
			System.out.println(f.getName());
		}
		
	}

	private static void f1() throws ClassNotFoundException {
		Class c1 = Car.class;
		Class c2 = Class.forName("com.shinhan.day10.Car");
		Car car = new Car("AA", 100, "black");
		Class c3 = car.getClass();
		
		Constructor[] arr = c1.getDeclaredConstructors();
		for (Constructor cc:arr) {
			System.out.println("이름: "+cc.getName());
			System.out.println("param 갯수: "+cc.getParameterCount());
			System.out.println("param 타입: "+Arrays.toString(cc.getParameters()));
			System.out.println("======================");
		}
	}
}
