package com.shinhan.day14;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IOTest {
	public static void main(String[] args) throws IOException {
//		f1();
//		f2();
//		f3();
//		f4();
		f5();
	}

	private static void f5() throws IOException {
		FileOutputStream fos = new FileOutputStream("score2.data");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeBoolean(true);
		dos.writeInt(100);
		dos.writeDouble(3.14);
		dos.writeUTF("문자");
		dos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("score2.data");
		DataInputStream dis = new DataInputStream(fis);
		boolean b = dis.readBoolean();
		int i = dis.readInt();
		double d = dis.readDouble();
		String s = dis.readUTF();
		
		System.out.println(b);
		System.out.println(i);
		System.out.println(d);
		System.out.println(s);
		dis.close();
		fis.close();
		
	}

	private static void f4() throws IOException {
		FileReader fr = new FileReader("score.txt");
		BufferedReader br = new BufferedReader(fr);
		String data = br.readLine();
		System.out.println(data.replaceAll("/", "\t")+"\t총점");
		while ((data = br.readLine())!=null) {
			String[] arr = data.split("/");
			System.out.print(arr[0]);
			int total = Arrays.stream(arr,1,arr.length)
					.peek(s->System.out.print("\t"+s))
					.mapToInt(Integer::parseInt).sum();
			System.out.println("\t"+total);
		}
		br.close();
		fr.close();
	}

	private static void f3() throws IOException {
		FileWriter fw = new FileWriter("aa.txt");
		fw.write("파일에 출력하기1");
		fw.write("파일에 출력하기2");
		fw.write("파일에 출력하기3");
		fw.close();
	}

	private static void f2() throws IOException {
		FileInputStream fis = new FileInputStream("src/com/shinhan/day14/Review.java");
		int data;
		while((data=fis.read())!=-1) {
			System.out.println((char)data);
		}
	}

	private static void f1() throws IOException {
		// InputStream --> 자바프로그램 --> OutStream
		
		// 입력: 키보드, 파일, 네트웍프로그램
		InputStream is = System.in;
		// InputStreamReader : stream(1byte)-->reader(2byte) 한글 입력 가능
		InputStreamReader ir = new InputStreamReader(is);
		int data;
		while((data = ir.read())!=13) { // 엔터키까지 받음 = 13
			System.out.println((char)data);
		}
	}
}
