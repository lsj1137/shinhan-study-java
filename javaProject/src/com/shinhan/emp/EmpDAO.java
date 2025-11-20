package com.shinhan.emp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
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
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
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
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
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
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
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

	public String insert(EmpDTO emp) {
		String message = null;

		Connection conn = null;
		PreparedStatement st = null;
		String query = """
insert into employees
values (?,?,?,?,?,?,?,?,?,?,?)
""";
		
		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(query);
			st.setInt(1, emp.getEmployee_id());
			st.setString(2, emp.getFirst_name());
			st.setString(3, emp.getLast_name());
			st.setString(4, emp.getEmail());
			st.setString(5, emp.getPhone_number());
			st.setDate(6, emp.getHire_date());
			st.setString(7, emp.getJob_id());
			st.setDouble(8, emp.getSalary());
			st.setDouble(9, emp.getCommission_pct());
			st.setInt(10, emp.getManager_id());
			st.setInt(11, emp.getDepartment_id());
			int result = st.executeUpdate(); // insert, delete, update는 executeUpdate()
			message = result + "건 입력 완료";
		} catch (SQLException e) {
			e.printStackTrace();
			message = "입력 실패";
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
		
		return message;
	}

	public String insertRequired(EmpDTO emp) {
		String message = null;

		Connection conn = null;
		PreparedStatement st = null;
		String query = """
insert into employees (EMPLOYEE_ID, LAST_NAME, EMAIL, HIRE_DATE, JOB_ID)
values (?,?,?,?,?)
""";
		
		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(query);
			st.setInt(1, emp.getEmployee_id());
			st.setString(2, emp.getLast_name());
			st.setString(3, emp.getEmail());
			st.setDate(4, emp.getHire_date());
			st.setString(5, emp.getJob_id());
			int result = st.executeUpdate(); // insert, delete, update는 executeUpdate()
			message = result + "건 입력 완료";
		} catch (SQLException e) {
			e.printStackTrace();
			message = "입력 실패";
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
		
		return message;
	}

	public String update(EmpDTO modifiedEmp) {
		String message = null;

		Connection conn = null;
		PreparedStatement st = null;
		String sql = new String("""
update employees set
first_name=?, last_name=?, email=?, phone_number=?, hire_date=?,
salary=?, commission_pct=?, manager_id=?, department_id=? 
where employee_id = ?
""");
		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(sql);
			st.setString(1, modifiedEmp.getFirst_name());
			st.setString(2, modifiedEmp.getLast_name());
			st.setString(3, modifiedEmp.getEmail());
			st.setString(4, modifiedEmp.getPhone_number());
			st.setDate(5, modifiedEmp.getHire_date());
			st.setDouble(6, modifiedEmp.getSalary());
			st.setDouble(7, modifiedEmp.getCommission_pct());
			st.setInt(8, modifiedEmp.getManager_id());
			st.setInt(9, modifiedEmp.getDepartment_id());
			st.setInt(10, modifiedEmp.getEmployee_id());
			int result = st.executeUpdate(); // insert, delete, update는 executeUpdate()
			message = result + "건 수정 완료";
		} catch (SQLException e) {
			e.printStackTrace();
			message = "수정 실패";
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
		
		return message;
	}

	public String delete(int empId) {
		String message = null;
		Connection conn = null;
		PreparedStatement st = null;
		String sql = """
delete
from employees
where employee_id = ?
""";
		try {
			conn = DBUtil.dbConnect();
			conn.setAutoCommit(false);
			st = conn.prepareStatement(sql);
			st.setInt(1, empId);
			int result = st.executeUpdate(); // insert, delete, update는 executeUpdate()
			message = result + "건 삭제 완료";
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			message = "삭제 실패";
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
		
		return message;
	}

	public Map<String, Object> sp_call(int empId, int salary) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Connection conn = null;
		CallableStatement st = null;
		String sql = "{ call sp_2(?,?,?)}";
		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareCall(sql);
			st.setInt(1, empId);
			st.registerOutParameter(2, java.sql.Types.VARCHAR);
			st.setInt(3, salary);
			st.registerOutParameter(3, java.sql.Types.INTEGER);
			st.execute();
			String jobId = st.getString(2);
			int newSalary = st.getInt(3);
			resultMap.put("jobId", jobId);
			resultMap.put("salary", newSalary);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultMap;
	}
	
}
