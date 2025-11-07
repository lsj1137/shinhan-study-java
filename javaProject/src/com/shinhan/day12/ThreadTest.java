package com.shinhan.day12;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class SharedArea {
	String s = "1";
}

public class ThreadTest {
	// 쓰레드풀: 작업 처리에 사용되는 스레드 개수를 제한하고
	// 작업큐에 들어오는 작업들을 스레드가 하나씩 맡아 처리하는 방식
	public static void main(String[] args) {
//		threadpool();
		String[][] mails = new String[100][3];
		for (int i = 0; i < mails.length; i++) {
			mails[i][0] = "me@my.com";
			mails[i][1] = "memeber" + i + "@my.com";
			mails[i][2] = "파격 할인 정보";
		}
		send2(mails);
		test();
	}

	private static void test() {
		SharedArea sa = new SharedArea();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public synchronized void run() {
				for (int i=0; i<1000; i++) {
					System.out.println(i+sa.s);
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i=0; i<1000; i++) {
					System.out.println((char)i);
				}
			}
		});
		t1.start();
		t2.start();
		
	}

	private static void send2(String[][] arr) {
		ExecutorService es = Executors.newFixedThreadPool(5);
//		ExecutorService es = Executors.newCachedThreadPool();
		for (int i=0; i<arr.length; i++) {
			int index = i;
			Future<String> future = es.submit(new Callable<String>() {
				@Override
				public String call() throws Exception {
					String result = Thread.currentThread().getName()+": 보내는 사람="
							+ arr[index][0]
							+", 받는 사람="
							+ arr[index][1]
							+", 제목="
							+ arr[index][2];
					return result;
				}
				
			});
			try {
				String message = future.get();
				System.out.println(message);
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		es.shutdown();
	}

	private static void send(String[][] arr) {
		ExecutorService es = Executors.newFixedThreadPool(5);
//		ExecutorService es = Executors.newCachedThreadPool();
		for (int i = 0; i < arr.length; i++) {
			int index = i;
			es.execute(new Runnable() {
				@Override
				public void run() {
//					System.out.println("익명 구현 객체");
					System.out.println(Thread.currentThread().getName() + "| 보내는 사람: " + arr[index][0]); // i 그대로 사용 못함.
																											// 지역변수를 익명
																											// 구현 객체에서
																											// 사용할때는
																											// final (수정
																											// 안되는 값)
																											// 이어야 함.
				}
			});
		}
		es.shutdown();
	}

	private static void threadpool() {
		System.out.println(Runtime.getRuntime().availableProcessors()); // 코어수 확인
		ExecutorService es = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 100; i++) {
			es.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + " 쓰레드");
				}
			});
		}
		es.shutdown();
	}

	public static void main2(String[] args) {
		AutoSaveThread t1 = new AutoSaveThread();
		t1.setDaemon(true);
		t1.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		t1.interrupt();
		System.out.println("메인 종료");
	}
}
