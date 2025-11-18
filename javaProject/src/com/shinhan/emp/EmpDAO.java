package com.shinhan.emp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.util.DBUtil;

// Data Access Object: Service에서 요청받아서 DB에 요청 보내고 받은 것을 Service로 응답
public class EmpDAO {
	
	// 모든 직원 조회
	public List<EmpDTO> selectAll() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String query = """
select * from employees
""";
		List<EmpDTO> empList = new ArrayList<>();
		
		try {
			conn = DBUtil.dbConnect();
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				empList.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empList;
	}
	
	// ID로 특정 직원 조회
	public EmpDTO selectById(int empId) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String query = """
select *
from employees
where employee_id = ?
""";
		EmpDTO emp = null;
		
		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(query);
			st.setInt(1, empId);
			rs = st.executeQuery();
			while (rs.next()) {
				emp = makeEmp(rs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
		
	}
	
	// 부서로 조회
	public  List<EmpDTO>  selectByDepId(int depId) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String query = """
select *
from employees
where department_id = ?
""";
		 List<EmpDTO>  empList = null;
		
		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(query);
			st.setInt(1, depId);
			rs = st.executeQuery();
			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				empList.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empList;
		
	}
	
	// 특정부서 + 급여(이상) + 입사일(이후) 직원조회
	public List<EmpDTO> selectByCondition(int depId, String jobId, double salary, Date hireDate) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String query = """
select *
from employees
where department_id = ?
or job_id = ?
or salary >= ?
or hire_date >= ?
""";
		List<EmpDTO> empList = new ArrayList<>();
		
		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(query);
			st.setInt(1, depId);
			st.setString(2, jobId);
			st.setDouble(3, salary);
			st.setDate(4, hireDate);
			rs = st.executeQuery();
			while (rs.next()) {
				EmpDTO emp = makeEmp(rs);
				empList.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empList;
	}
	
	private EmpDTO makeEmp(ResultSet rs) throws SQLException {
		EmpDTO emp = new EmpDTO();
		emp.setCommission_pct(rs.getDouble("Commission_pct"));
		emp.setDepartment_id(rs.getInt("Department_id"));
		emp.setEmail(rs.getString("Email"));
		emp.setEmployee_id(rs.getInt("Employee_id"));
		emp.setFirst_name(rs.getString("First_name"));
		emp.setHire_date(rs.getDate("hire_date"));
		emp.setJob_id(rs.getString("Job_id"));
		emp.setLast_name(rs.getString("Last_name"));
		emp.setManager_id(rs.getInt("Manager_id"));
		emp.setPhone_number(rs.getString("Phone_number"));
		emp.setSalary(rs.getDouble("Salary"));
		return emp;
	}
	
}
