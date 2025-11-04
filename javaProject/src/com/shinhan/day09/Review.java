package com.shinhan.day09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Review {
	public static void main(String[] args) throws IOException {
//		f1();
//		f2();
		f3();
	}
	
	private static void f3() {
		int data;
		// 자동 Resource 닫기
		try (FileReader fr = new FileReader("src\\com\\shinhan\\day09\\Review.java")) {			
			while ((data = fr.read()) != -1) {
				System.out.println((char) data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("읽기 오류");
			e.printStackTrace();
		}
		
	}

	private static void f2() {
		int data;
		FileReader fr = null;
		try {
			fr = new FileReader("szcxzrc\\com\\shinhan\\day09\\Review.java");
			while ((data = fr.read()) != -1) {
				System.out.println((char) data);
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않음");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("읽기 오류");
			e.printStackTrace();
		} finally {
			try {
				if (fr!=null) fr.close();
			} catch (IOException e) {
				System.out.println("fr이 널");
				e.printStackTrace();
			}
		}
		
	}

	private static void f1() throws IOException {
		int data;
		FileReader fr = null;
		fr = new FileReader("src\\com\\shinhan\\day09\\Review.java");
		// EOF(End of File) == -1
		while ((data = fr.read()) != -1) {
			System.out.println((char) data);
		}
		fr.close();
		
	}
}
