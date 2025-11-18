package com.shinhan.day15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONtest {
	public static void main(String[] args) {
//		f1();
		f2();
	}
	
	private static double call (String market) {
		double startPrice = 0;
		String strUrl = "https://api.bithumb.com/v1/ticker?markets="+market;
		URL url;
		try {
			url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");//대소문자구분
			conn.setRequestProperty("Accept", "application/json");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String data = "";
			StringBuffer sb = new StringBuffer();
			while ((data=br.readLine())!=null) {
				sb.append(data);
			}
			String result = sb.toString();
//			System.out.println(result);
			JSONArray jsonArray = new JSONArray(result);
			List<Double> priceList = new ArrayList<>();
			for (int i=0; i<jsonArray.length(); i++) {
				JSONObject obj = jsonArray.getJSONObject(i);
//				System.out.println(obj);
				startPrice = obj.getDouble("opening_price");
			}
//			System.out.println(startPrice);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return startPrice;
	}

	private static void f2() {
		String strUrl = "https://api.bithumb.com/v1/market/all";
		URL url;
		try {
			url = new URL(strUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");//대소문자구분
			conn.setRequestProperty("Accept", "application/json");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String data = "";
			StringBuffer sb = new StringBuffer();
			while ((data=br.readLine())!=null) {
				sb.append(data);
			}
			String result = sb.toString();
			JSONArray jsonArray = new JSONArray(result);
//			System.out.println(jsonArray);
			List<String> marketList = new ArrayList<>();
			for (int i=0; i<jsonArray.length(); i++) {
				JSONObject obj = jsonArray.getJSONObject(i);
				System.out.println(obj);
				marketList.add(obj.getString("market"));
			}
//			System.out.println(marketList.toString());
//			for (String s: marketList) {
//				System.out.println(s+"시가: "+call(s));
//			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void f1() {
		JSONObject jsonObj = new JSONObject();
		JSONObject jsonObj2 = new JSONObject();
		jsonObj.put("홍길동", 100);
		jsonObj2.put("홍길동", "개발자");
		System.out.println(jsonObj);
		System.out.println(jsonObj2);
	}
}
