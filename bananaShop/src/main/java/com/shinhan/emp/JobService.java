package com.shinhan.emp;

import java.util.List;

public class JobService {

	JobDAO jobDAO = new JobDAO();
	
	public List<JobDTO> selectAll() {
		return jobDAO.selectAll();
	}
}
