package com.shinhan.dept;

import java.util.List;


public class DeptService {

	static DeptDAO deptDAO = new DeptDAO();
	
	public List<DeptDTO> selectAll() {
		return deptDAO.selectAll();
		
	}
	
	public DeptDTO selectById(int empId) {
		return deptDAO.selectById(empId);
		
	}
	
	public List<DeptDTO> selectByCondition(int depId, String department_name, int manager_id, int location_id) {
		return deptDAO.selectByCondition(depId, department_name, manager_id, location_id);
		
	}

	public String insertService(DeptDTO emp) {
		return deptDAO.insert(emp);
	}

	public String insertRequiredService(DeptDTO emp) {
		return deptDAO.insertRequired(emp);
	}

	public String updateService(DeptDTO modifiedEmp) {
		return deptDAO.update(modifiedEmp);
	}

	public String delete(int empId) {
		return deptDAO.delete(empId);
	}
}
