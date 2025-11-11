package com.shinhan.day14;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(50001);
			System.out.println("[서버] 시작됨.");
			Socket socket = serverSocket.accept();
			
			InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
			System.out.println("[서버] "+isa.getAddress().getHostName()+"의 요청을 수락함");
			System.out.println("[서버] "+isa.getAddress().getHostAddress()+"의 요청을 수락함");

			byte[] bytes = null;
			String message = null;
			OutputStream os = socket.getOutputStream();
			message = "Hello I'm Server";
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("[서버] 메시지 송신 완료 :: " + message);

			
			InputStream is = socket.getInputStream();
			bytes = new byte[100];
			int readByteCount = is.read(bytes);
			message = new String(bytes, 0, readByteCount, "UTF-8");
			System.out.println("[서버] 메시지 수신 :: "+message);
			
			socket.close();
			System.out.println("[서버] "+isa.getHostString()+"의 연결을 끊음");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
