package com.shinhan.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBUtil {
	// Connection Pooling 이용해서 Connection 열기
	public static Connection dbConnect() {

		Connection conn=null;
		Context initContext;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle2");
			conn = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static Connection dbConnect2() {
		
		Connection conn =null;
		
		Properties pro = new Properties();
		String path ="oracleDB.properties";
		InputStream is = DBUtil.class.getResourceAsStream(path);

		try {
			pro.load(is); //정보 파일 로드
			String driver = pro.getProperty("driver");
			String url = pro.getProperty("url");
			String id = pro.getProperty("username");
			String password = pro.getProperty("password");
			
			Class.forName(driver); //드라이버 로드
			
			conn = DriverManager.getConnection(url,id, password); //드라이브매니저로 connection
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}


	public static void dbDisconnect(Connection conn, Statement st, ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			//생성된게 있으면 닫아라
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}