package com.shinhan.day14;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {

		try {
			Socket socket = new Socket("192.168.0.100", 50001);
			System.out.println(socket.getInetAddress().getHostName());
			System.out.println(socket.getInetAddress().getHostAddress());
			System.out.println("[클라이언트] 서버에 접속됨");
			
			byte[] bytes = null;
			String message = null;
			InputStream is = socket.getInputStream();
			bytes = new byte[100];
			int readByteCount = is.read(bytes);
			message = new String(bytes, 0, readByteCount, "UTF-8");
			System.out.println("[클라이언트] 메시지 수신 :: "+message);
			
			OutputStream os = socket.getOutputStream();
			message = "Hello I'm Client";
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("[클라이언트] 메시지 송신 완료 :: " + message);
			
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
