package com.shinhan.day09;

/*
 * Exception (예외) : 프로그래머의 노력으로 프로그램이 죽지 않고 계속 진행하도록 할 수 있다.
 * 1. Unchecked Exception : 실행 예외 (Runtime Exception)
 * 2. Checked Exception : 일반 예외 (Runtime Exception 제외 모든 Exception)
 * 
 * Exception 처리: try / catch / finally
 * 자원 반납을 위해 finally 에서 코드 가능
 * 자동 자원 반납이 좋음. try 바로 뒤 괄호 안에서 생성된 자원은 자동 닫힘됨.
 */
public class ExceptionTest2 {
	public static void main(String[] args) {
//		f1();
		f5();
		
	}

	private static void f5() {
		try(MyResource src = new MyResource("src/com/shinhan/day09/Untitled 1")) {
			System.out.println(src.read1());
			System.out.println(src.read2());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static void f1() {
		int a = 10;
		int b = 2;
		int[] arr = {10, 20, 30};
		String num = "100";
		Object obj = new String("자바");
		
		try {
			System.out.println("나누기: " + a / b);
			System.out.println("배열의 4번째값 :"+arr[2]);
			System.out.println(Integer.parseInt(num)+200);
			Integer str = (Integer) obj;
			System.out.println("문자열의 길이: "+ str.toString());
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없음 ");
//			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 범위 초과");
//			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("숫자가 아님");
//			e.printStackTrace();
		} catch (ClassCastException e) {
			System.out.println("문자열을 숫자로 바꿀 수 없음 ");
//			e.printStackTrace();
		} catch (Exception ex) {
			System.out.println("기타 예외");
		}

	}
}
