package com.shinhan.day14;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetworkTest {
	public static void main(String[] args) throws Exception {
		f1();
	}

	private static void f1() throws UnknownHostException {
		InetAddress local = InetAddress.getLocalHost();
		System.out.println(local.getHostName()+local.getHostAddress());
	}
}
