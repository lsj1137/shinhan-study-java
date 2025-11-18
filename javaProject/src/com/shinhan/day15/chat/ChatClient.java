package com.shinhan.day15.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("localhost", 5001);
		System.out.println("서버에 연결됨.");
       
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
		PrintWriter out = new PrintWriter(new java.io.OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);//autoFlush
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

		// 메시지 수신 쓰레드
		new Thread(() -> {
			try {
				String message;
				while ((message = in.readLine()) != null) {
					System.out.println(message);
				}
			} catch (IOException e) {
				System.out.println("서버 연결 종료.");
			}
		}).start();

		// 메시지 전송 루프
		String input;
		while ((input = userInput.readLine()) != null) {
			out.println(input);
			if("/bye".equalsIgnoreCase(input)){
				System.out.println("채팅종료합니다.");
				break;
			}
		}

		socket.close();
	}
}
