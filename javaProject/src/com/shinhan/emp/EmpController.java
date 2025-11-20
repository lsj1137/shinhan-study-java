package com.shinhan.emp;

import java.sql.Date;
import java.util.Map;
import java.util.Scanner;

import com.shinhan.common.ControllerInterface;
import com.shinhan.util.DateUtil;

public class EmpController implements ControllerInterface {
	EmpService service = new EmpService();
	Scanner sc;

	@Override
	public void execute(Scanner sc) {
		this.sc = sc;
		boolean isStop = false;
		while (!isStop) {
			EmpView.menu();
			int job = Integer.valueOf(sc.nextLine());
			switch (job) {
			case 1 -> f_selectAll();
			case 2 -> f_selectById();
			case 3 -> f_selectByDepId();
			case 4 -> f_selectByCondition();
			case 5 -> f_insert();
			case 6 -> f_insertRequired();
			case 7 -> f_update();
			case 8 -> f_delete();
			case 9 -> f_sp_call();
			default -> isStop = true;
			}
		}
		System.out.println("종료합니다...");
	}

	private void f_sp_call() {
		EmpView.insertRequest("직원번호>> ");
		int empId = Integer.valueOf(sc.nextLine());
		EmpView.insertRequest("급여>> ");
		int salary = Integer.valueOf(sc.nextLine());
		Map<String, Object> map =  service.sp_call(empId, salary);
		EmpView.print(map);
	}

	private void f_delete() {
		EmpView.insertRequest("삭제하고자 하는 직원 번호>> ");
		int empId = Integer.valueOf(sc.nextLine());
		String message = service.delete(empId);
		EmpView.print(message);
	}

	private void f_update() {
		EmpView.insertRequest("수정하고자 하는 직원 번호>> ");
		int empId = Integer.valueOf(sc.nextLine());
		EmpDTO emp = service.selectById(empId);
		EmpView.print(emp);

		EmpDTO modifiedEmp = keyInput2(emp);
		modifiedEmp.setEmployee_id(empId);
		String messge = service.updateService(modifiedEmp);
		EmpView.print(messge);
	}

	private EmpDTO keyInput2(EmpDTO originEmp) {
		EmpDTO newEmp = new EmpDTO();
		EmpView.insertRequest("NEW first name >> ");
		String fname = sc.nextLine();
		if (fname.trim().isEmpty()) {
			fname = originEmp.getFirst_name();
			EmpView.print("기존 정보(" + fname + ")를 그대로 이용합니다.");
		}
		EmpView.insertRequest("NEW last name  >> ");
		String lname = sc.nextLine();
		if (lname.trim().isEmpty()) {
			lname = originEmp.getLast_name();
			EmpView.print("기존 정보(" + lname + ")를 그대로 이용합니다.");
		}
		EmpView.insertRequest("NEW e-mail     >> ");
		String email = sc.nextLine();
		if (email.trim().isEmpty()) {
			email = originEmp.getEmail();
			EmpView.print("기존 정보(" + email + ")를 그대로 이용합니다.");
		}
		EmpView.insertRequest("NEW phone num  >> ");
		String phone = sc.nextLine();
		if (phone.trim().isEmpty()) {
			phone = originEmp.getPhone_number();
			EmpView.print("기존 정보(" + phone + ")를 그대로 이용합니다.");
		}
		EmpView.insertRequest("NEW hire date  >> ");
		String strDate = sc.nextLine();
		Date hDate = null;
		if (!strDate.trim().isEmpty()) {
			hDate = DateUtil.convertToSQLDate(strDate);
		} else {
			hDate = originEmp.getHire_date();
			EmpView.print("기존 정보(" + hDate + ")를 그대로 이용합니다.");
		}
		EmpView.insertRequest("NEW salary     >> ");
		String strSalary = sc.nextLine();
		Double salary = null;
		if (!strSalary.trim().isEmpty()) {
			salary = Double.parseDouble(strSalary);
		} else {
			salary = originEmp.getSalary();
			EmpView.print("기존 정보(" + salary + ")를 그대로 이용합니다.");
		}
		EmpView.insertRequest("NEW commission >> ");
		String strCommission = sc.nextLine();
		Double commission = null;
		if (!strCommission.trim().isEmpty()) {
			commission = Double.parseDouble(strCommission);
		} else {
			commission = originEmp.getCommission_pct();
			EmpView.print("기존 정보(" + commission + ")를 그대로 이용합니다.");
		}
		EmpView.insertRequest("NEW manager id >> ");
		String strMngrId = sc.nextLine();
		Integer mngrId = null;
		if (!strMngrId.trim().isEmpty()) {
			mngrId = Integer.parseInt(strMngrId);
		} else {
			mngrId = originEmp.getManager_id();
			EmpView.print("기존 정보(" + mngrId + ")를 그대로 이용합니다.");
		}
		EmpView.insertRequest("NEW dept id    >> ");
		String strDeptId = sc.nextLine();
		Integer deptId = null;
		if (!strDeptId.trim().isEmpty()) {
			deptId = Integer.parseInt(strDeptId);
		} else {
			deptId = originEmp.getDepartment_id();
			EmpView.print("기존 정보(" + deptId + ")를 그대로 이용합니다.");
		}
		newEmp.setFirst_name(fname);
		newEmp.setLast_name(lname);
		newEmp.setEmail(email);
		newEmp.setPhone_number(phone);
		newEmp.setHire_date(hDate);
		newEmp.setSalary(salary == 0 ? 1 : salary);
		newEmp.setCommission_pct(commission);
		newEmp.setManager_id(mngrId);
		newEmp.setDepartment_id(deptId);
		return newEmp;
	}

	private void f_insertRequired() {
		EmpDTO emp = keyRequiredInput();
		String message = service.insertRequiredService(emp);
		EmpView.print(message);
	}

	private EmpDTO keyRequiredInput() {
		EmpDTO newEmp = new EmpDTO();
		EmpView.insertRequest("employee id>> ");
		int empId = Integer.valueOf(sc.nextLine());
		EmpView.insertRequest("last name  >> ");
		String lname = sc.nextLine();
		EmpView.insertRequest("e-mail     >> ");
		String email = sc.nextLine();
		EmpView.insertRequest("hire date  >> ");
		Date hDate = DateUtil.convertToSQLDate(sc.nextLine());
		EmpView.insertRequest("job id     >> ");
		String jobId = sc.nextLine();
		newEmp.setEmployee_id(empId);
		newEmp.setLast_name(lname);
		newEmp.setEmail(email);
		newEmp.setHire_date(hDate);
		newEmp.setJob_id(jobId);
		return newEmp;
	}

	private void f_insert() {
		EmpDTO emp = keyInput();
		String message = service.insertService(emp);
		EmpView.print(message);
	}

	private EmpDTO keyInput() {
		EmpDTO newEmp = new EmpDTO();
		EmpView.insertRequest("employee id>> ");
		int empId = Integer.valueOf(sc.nextLine());
		EmpView.insertRequest("first name >> ");
		String fname = sc.nextLine();
		EmpView.insertRequest("last name  >> ");
		String lname = sc.nextLine();
		EmpView.insertRequest("e-mail     >> ");
		String email = sc.nextLine();
		EmpView.insertRequest("phone num  >> ");
		String phone = sc.nextLine();
		EmpView.insertRequest("hire date  >> ");
		Date hDate = DateUtil.convertToSQLDate(sc.nextLine());
		EmpView.insertRequest("job id     >> ");
		String jobId = sc.nextLine();
		EmpView.insertRequest("salary     >> ");
		double salary = Double.valueOf(sc.nextLine());
		EmpView.insertRequest("commission >> ");
		double commission = Double.valueOf(sc.nextLine());
		EmpView.insertRequest("manager id >> ");
		int mngrId = Integer.valueOf(sc.nextLine());
		EmpView.insertRequest("dept id    >> ");
		int deptId = Integer.valueOf(sc.nextLine());
		newEmp.setEmployee_id(empId);
		newEmp.setFirst_name(fname);
		newEmp.setLast_name(lname);
		newEmp.setEmail(email);
		newEmp.setPhone_number(phone);
		newEmp.setHire_date(hDate);
		newEmp.setJob_id(jobId);
		newEmp.setSalary(salary);
		newEmp.setCommission_pct(commission);
		newEmp.setManager_id(mngrId);
		newEmp.setDepartment_id(deptId);
		return newEmp;
	}

	private Object f_selectByCondition() {
		// TODO Auto-generated method stub
		return null;
	}

	private void f_selectByDepId() {
		System.out.print("어떤 부서ID로 조회할까요? ");
		int depId = Integer.parseInt(sc.nextLine());
		EmpView.print(service.selectByDepId(depId));
	}

	private void f_selectById() {
		System.out.print("어떤 ID를 조회할까요? ");
		int id = Integer.parseInt(sc.nextLine());
		EmpView.print(service.selectById(id));
	}

	private void f_selectAll() {
		EmpView.print(service.selectAll());
	}

}
