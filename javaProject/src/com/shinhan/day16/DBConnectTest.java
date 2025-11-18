package com.shinhan.day16;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectTest {
	// 1. Oracle 제공하는 Driver를 메모리에 load
	// 2. Connection
	// 3. Statement
	// 4. SQL문 작성해서 DB에 보내고 결과를 받는다.
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("1. Oracle 제공하는 Driver를 메모리에 load됨.");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "hr", userPw = "hr";
		Connection conn = DriverManager.getConnection(url,userId,userPw);
		System.out.println("2. Connection 성공: " +conn);
		String sql = """
select
    *
from
    employees
where
    (hire_date>'1999/12/31' and hire_date<'2010/01/01')
    and
    department_id in (30,50,80)
    and
    salary between 5000 and 17000
    and
    commission_pct is not null
order by
    hire_date asc,
    salary desc			
""";
		Statement st = conn.createStatement();
		System.out.println("3. Statement(통로) 만들기");
		ResultSet rs = st.executeQuery(sql);
		System.out.println("4. Query 실행 완료: "+ rs);
		
		while(rs.next()) {
			System.out.print(rs.getInt(1)+"  ");
			System.out.printf("%-17s",rs.getString("first_name"));
			System.out.printf("%7d",rs.getInt("salary"));
			System.out.println();
		}
		System.out.println("5. 자원 반납");
		rs.close();
		st.close();
		conn.close();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,userId,userPw);							
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				String first_name = rs.getString(1);
				Date hire_date = rs.getDate(5);
				int department_id = rs.getInt(10);
				double salary = rs.getDouble(7);
				double commision_pct = rs.getDouble(8);
				System.out.printf("%s | %s | %d | %f | %f",
						first_name,
						hire_date, 
						department_id,
						salary,
						commision_pct
						);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs!=null) rs.close();
			if (st!=null) st.close();
			if (conn!=null) conn.close();
		}
		
	}
}
