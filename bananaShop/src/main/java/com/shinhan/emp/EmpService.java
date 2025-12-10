package com.shinhan.emp;

import java.sql.Date;
import java.util.List;
import java.util.Map;

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

	public String insertService(EmpDTO emp) {
		return empDAO.insert(emp);
	}

	public String insertRequiredService(EmpDTO emp) {
		return empDAO.insertRequired(emp);
	}

	public String updateService(EmpDTO modifiedEmp) {
		return empDAO.update(modifiedEmp);
	}

	public String delete(int empId) {
		return empDAO.delete(empId);
	}

	public Map<String, Object> sp_call(int empId, int salary) {
		return empDAO.sp_call(empId, salary);
	}
	
}
