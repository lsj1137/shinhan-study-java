package com.shinhan.dept;

import java.util.Scanner;

import com.shinhan.common.ControllerInterface;

public class DeptController implements ControllerInterface {
	DeptService service = new DeptService();
	Scanner sc = new Scanner(System.in);

	@Override
	public void execute(Scanner sc) {
		boolean isStop = false;
		while (!isStop) {
			DeptView.menu();
			int job = Integer.valueOf(sc.nextLine());
			switch (job) {
			case 1 -> f_selectAll();
			case 2 -> f_selectById();
			case 3 -> f_selectByCondition();
			case 4 -> f_insert();
			case 5 -> f_insertRequired();
			case 6 -> f_update();
			case 7 -> f_delete();
			default -> isStop = true;
			}
		}
		System.out.println("종료합니다...");
	}

	private void f_delete() {
		DeptView.insertRequest("삭제하고자 하는 부서 번호>> ");
		int deptId = Integer.valueOf(sc.nextLine());
		String message = service.delete(deptId);
		DeptView.print(message);
	}

	private void f_update() {
		DeptView.insertRequest("수정하고자 하는 부서 번호>> ");
		int deptId = Integer.valueOf(sc.nextLine());
		DeptDTO dept = service.selectById(deptId);
		DeptView.print(dept);

		DeptDTO modifiedDept = keyInput2(dept);
		modifiedDept.setDepartment_id(deptId);
		String messge = service.updateService(modifiedDept);
		DeptView.print(messge);
	}

	private DeptDTO keyInput2(DeptDTO originDept) {
		DeptDTO newdept = new DeptDTO();
		DeptView.insertRequest("NEW dept id    >> ");
		String strDeptId = sc.nextLine();
		Integer deptId = null;
		if (!strDeptId.trim().isEmpty()) {
			deptId = Integer.parseInt(strDeptId);
		} else {
			deptId = originDept.getDepartment_id();
			DeptView.print("기존 정보(" + deptId + ")를 그대로 이용합니다.");
		}
		DeptView.insertRequest("NEW dept name  >> ");
		String deptName = sc.nextLine();
		if (deptName.trim().isEmpty()) {
			deptName = originDept.getDepartment_name();
			DeptView.print("기존 정보(" + deptName + ")를 그대로 이용합니다.");
		}
		DeptView.insertRequest("NEW manager id >> ");
		String strMngrId = sc.nextLine();
		Integer mngrId = null;
		if (!strMngrId.trim().isEmpty()) {
			mngrId = Integer.parseInt(strMngrId);
		} else {
			mngrId = originDept.getManager_id();
			DeptView.print("기존 정보(" + mngrId + ")를 그대로 이용합니다.");
		}
		DeptView.insertRequest("NEW location id >> ");
		String strLocId = sc.nextLine();
		Integer locId = null;
		if (!strLocId.trim().isEmpty()) {
			locId = Integer.parseInt(strLocId);
		} else {
			locId = originDept.getLocation_id();
			DeptView.print("기존 정보(" + locId + ")를 그대로 이용합니다.");
		}
		newdept.setDepartment_id(deptId);
		newdept.setDepartment_name(deptName);
		newdept.setManager_id(mngrId);
		newdept.setLocation_id(locId);
		return newdept;
	}

	private void f_insertRequired() {
		DeptDTO dept = keyRequiredInput();
		String message = service.insertRequiredService(dept);
		DeptView.print(message);
	}

	private DeptDTO keyRequiredInput() {
		DeptDTO newDept = new DeptDTO();
		DeptView.insertRequest("dept id    >> ");
		int deptId = Integer.valueOf(sc.nextLine());
		DeptView.insertRequest("dept name  >> ");
		String deptName = sc.nextLine();
		newDept.setDepartment_id(deptId);
		newDept.setDepartment_name(deptName);
		return newDept;
	}

	private void f_insert() {
		DeptDTO dept = keyInput();
		String message = service.insertService(dept);
		DeptView.print(message);
	}

	private DeptDTO keyInput() {
		DeptDTO newDept = new DeptDTO();
		DeptView.insertRequest("dept id    >> ");
		int deptId = Integer.valueOf(sc.nextLine());
		DeptView.insertRequest("dept name  >> ");
		String deptName = sc.nextLine();
		DeptView.insertRequest("manager id >> ");
		String strMngrId = sc.nextLine();
		Integer mngrId = null;
		if (!strMngrId.trim().isEmpty()) {
			mngrId = Integer.valueOf(strMngrId);
		}
		DeptView.insertRequest("location id>> ");
		String strLocationId = sc.nextLine();
		Integer locationId = null;
		if (!strLocationId.trim().isEmpty()) {
			locationId = Integer.valueOf(strLocationId);
		}
		newDept.setDepartment_id(deptId);
		newDept.setDepartment_name(deptName);
		newDept.setManager_id(mngrId);
		newDept.setLocation_id(locationId);
		return newDept;
	}

	private void f_selectByCondition() {
		int deptId = 0;
		String data = null;
		System.out.print("어떤 ID를 조회할까요? ");
		data = sc.nextLine();
		if (!data.trim().isEmpty()) {
			deptId = Integer.valueOf(data);
		}
		String deptName = "";
		System.out.print("어떤 이름를 조회할까요? ");
		data = sc.nextLine();
		if (!data.trim().isEmpty()) {
			deptName = data;
		}
		int managerId = 0;
		System.out.print("어떤 매니저 ID로 조회할까요? ");
		data = sc.nextLine();
		if (!data.trim().isEmpty()) {
			managerId = Integer.valueOf(data);
		}
		int locationId = 0;
		System.out.print("어떤 지역 ID로 조회할까요? ");
		data = sc.nextLine();
		if (!data.trim().isEmpty()) {
			locationId = Integer.valueOf(data);
		}
		DeptView.print(service.selectByCondition(deptId, deptName, managerId, locationId));
	}

	private void f_selectById() {
		System.out.print("어떤 ID를 조회할까요? ");
		int id = Integer.parseInt(sc.nextLine());
		DeptView.print(service.selectById(id));
	}

	private void f_selectAll() {
		DeptView.print(service.selectAll());
	}

}