package com.shinhan.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shinhan.dept.DeptDTO;
import com.shinhan.util.DBUtil;

public class JobDAO {

	static final String SQL_SELECT = "select * from jobs ";
	
	public List<JobDTO> selectAll() {
		List<JobDTO> jobList = new ArrayList<JobDTO>();
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(SQL_SELECT);
			rs = st.executeQuery();
			while(rs.next()) {
				JobDTO job = new JobDTO(rs.getString(1), rs.getString(2), 
						   rs.getInt(3), rs.getInt(4));
				jobList.add(job);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		
		return jobList;
	}

	
}
