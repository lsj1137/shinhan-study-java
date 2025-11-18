package com.shinhan.emp;

import java.sql.Date;
import java.util.List;

public class EmpService {
	static EmpDAO empDAO = new EmpDAO();
	
	public List<EmpDTO> selectAll() {
		return empDAO.selectAll();
		
	}
	
	public EmpDTO selectById(int empId) {
		return empDAO.selectById(empId);
		
	}
	public  List<EmpDTO>  selectByDepId(int depId) {
		return empDAO.selectByDepId(depId);
	}
	
	public List<EmpDTO> selectByCondition(int depId, String jobId, double salary, Date hireDate) {
		return empDAO.selectByCondition(depId, jobId, salary, hireDate);
		
	}
	
}
