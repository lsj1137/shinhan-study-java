package com.shinhan.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.util.DBUtil;

public class DeptDAO {
	static final String SQL_SELECT_ALL = "select * from departments";
	static final String SQL_SELECT_BY_ID = """
select *
from departments
where department_id = ?
""";
	static final String SQL_SELECT_BY_CONDITION = """
select *
from departments
where department_id = ?
or department_name = ?
or manager_id = ?
or location_id = ?
""";
	static final String SQL_INSERT = """
insert into departments
values (?,?,?,?)
""";
	static final String SQL_INSERT_REQUIRED = """	
insert into departments (DEPARTMENT_ID, DEPARTMENT_NAME)
values (?,?)
""";
	static final String SQL_UPDATE = """
update departments set
department_name = ?, manager_id = ?, location_id = ?
where department_id=? 
""";
	static final String SQL_DELETE = """
delete
from departments
where department_id = ?
""";
	
	private DeptDTO makedept(ResultSet rs) throws SQLException {
		DeptDTO dept = new DeptDTO();
		dept.setDepartment_id(rs.getInt("Department_id"));
		dept.setDepartment_name(rs.getString("Department_name"));
		dept.setManager_id(rs.getInt("Manager_id"));
		dept.setLocation_id(rs.getInt("Location_id"));
		return dept;
	}
	
	// 모든 직원 조회
		public List<DeptDTO> selectAll() {
			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;
			List<DeptDTO> deptList = new ArrayList<>();
			try {
				conn = DBUtil.dbConnect();
				st = conn.createStatement();
				rs = st.executeQuery(SQL_SELECT_ALL);
				while (rs.next()) {
					DeptDTO dept = makedept(rs);
					deptList.add(dept);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, st, rs);
			}
			
			return deptList;
		}
		
		// ID로 특정 직원 조회
		public DeptDTO selectById(int deptId) {
			Connection conn = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			DeptDTO dept = null;
			
			try {
				conn = DBUtil.dbConnect();
				st = conn.prepareStatement(SQL_SELECT_BY_ID);
				st.setInt(1, deptId);
				rs = st.executeQuery();
				while (rs.next()) {
					dept = makedept(rs);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, st, rs);
			}
			
			return dept;
			
		}
		
		
		// 특정부서 + 급여(이상) + 입사일(이후) 직원조회
		public List<DeptDTO> selectByCondition(int depId, String department_name, int manager_id, int location_id) {
			Connection conn = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			List<DeptDTO> deptList = new ArrayList<>();
			
			try {
				conn = DBUtil.dbConnect();
				st = conn.prepareStatement(SQL_SELECT_BY_CONDITION);
				st.setInt(1, depId);
				st.setString(2, department_name);
				st.setInt(3, manager_id);
				st.setInt(4, location_id);
				rs = st.executeQuery();
				while (rs.next()) {
					DeptDTO dept = makedept(rs);
					deptList.add(dept);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, st, rs);
			}
			
			return deptList;
		}

		public String insert(DeptDTO dept) {
			String message = null;

			Connection conn = null;
			PreparedStatement st = null;
			
			try {
				conn = DBUtil.dbConnect();
				st = conn.prepareStatement(SQL_INSERT);
				st.setInt(1, dept.getDepartment_id());
				st.setString(2, dept.getDepartment_name());
				st.setInt(3, dept.getManager_id());
				st.setInt(4, dept.getLocation_id());
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

		public String insertRequired(DeptDTO dept) {
			String message = null;

			Connection conn = null;
			PreparedStatement st = null;
			
			try {
				conn = DBUtil.dbConnect();
				st = conn.prepareStatement(SQL_INSERT_REQUIRED);
				st.setInt(1, dept.getDepartment_id());
				st.setString(2, dept.getDepartment_name());
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

		public String update(DeptDTO modifiedDept) {
			String message = null;

			Connection conn = null;
			PreparedStatement st = null;
			try {
				conn = DBUtil.dbConnect();
				st = conn.prepareStatement(SQL_UPDATE);
				st.setString(1, modifiedDept.getDepartment_name());
				st.setInt(2, modifiedDept.getManager_id());
				st.setInt(3, modifiedDept.getLocation_id());
				st.setInt(4, modifiedDept.getDepartment_id());
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

		public String delete(int deptId) {
			String message = null;
			Connection conn = null;
			PreparedStatement st = null;
			try {
				conn = DBUtil.dbConnect();
				conn.setAutoCommit(false);
				st = conn.prepareStatement(SQL_DELETE);
				st.setInt(1, deptId);
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
}
