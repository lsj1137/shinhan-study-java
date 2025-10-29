package com.shinhan.day03;

import java.util.Arrays;

//배열: 하나의 이름으로 같은 타입의 값을 여러개 저장하기 위해 만드는 연속공간
//1. 배열 참조변수 선언
//2. 배열 생성 (반드시 요소 개수 입력, 자동 초기화 됨)
//3. 배열 사용
	
public class ArrayTest {
	// 명령행 매개변수
	// cmd> java ArrayTest 10 20
	// 에서 10과 20이 명령행 매개변수임.
	
	//main(매개변수): 프로그램 시작점, JVM이 자동으로 수행
	//void: return 없음, main 수행 후 JVM에 return 되는 값 없음
	//public: 모든 패키지에서 접근가능
	//static: class load 시에 자동으로 메서드영역(코드영역)에 올림.
	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
		f6();
		
		System.out.println("명령행 매개변수 개수 : "+args.length);
//		System.out.println(args[0]);
//		System.out.println(args[1]);
	}

	private static void f6() {
		String[] arr = new String[5];
		String[] arr2 = new String[] {"java", "python", "C", "R", "Javascript"};
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));		
		
	}

	private static void f5() {
		int[][] arr1 = new int[][] {{1,2,3,}, {1,2,3,4,5}, {1,2}};
		System.out.println(arr1[0][1]);
		System.out.println(arr1[1][4]);
		
	}

	private static void f4() {
		int[][] arr1;
//		int[] arr2[];
//		int arr3[][];
		
		arr1 = new int[3][];
		arr1[0] = new int[4];
		arr1[1] = new int[3];
		arr1[2] = new int[2];
		System.out.println(Arrays.toString(arr1[0]));
		System.out.println(Arrays.toString(arr1[1]));
		System.out.println(Arrays.toString(arr1[2]));
	}

	private static void f3() {
		int[] arr1 = {10, 20, 30, 40, 50};
		System.out.println("배열의 길이: "+arr1.length);
		for (int i=0; i<arr1.length; i++) {
			System.out.println(arr1[i]);
		}
	}

	private static void f2() {
		// 선언 + 생성 + 초기화 한번에
		int[] arr1 = new int[] {1,2,3,4,5,6,7,8,9,10}; // new int[]에 요소 개수 안씀에 주의!
		System.out.println(Arrays.toString(arr1));
		int[] arr2 = {1,2,3,4,5,6,7,8,9,10}; // new int[] 생략 가능
		System.out.println(Arrays.toString(arr1));
		
		// 선언 먼저, 생성+초기화 나중에
		int[] arr3;
		arr3 = new int[] {1,2,3,4,5,6,7,8,9,10}; // new int[] 생략 불가
		System.out.println(Arrays.toString(arr1));
	}

	private static void f1() {
		int[] arr1;
		double[] arr2;
		boolean[] arr3 = new boolean[10]; // 선언 + 생성 같이 해도 됨.
		String[] arr4 = new String[10];
		arr1 = new int[10];
		arr2 = new double[10];
		System.out.println(Arrays.toString(arr1)); // 자동초기화 확인
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arr4));
	}

}
