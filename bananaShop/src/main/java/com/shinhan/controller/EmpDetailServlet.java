package com.shinhan.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DeptDTO;
import com.shinhan.dept.DeptService;
import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;
import com.shinhan.emp.JobService;
import com.shinhan.util.DateUtil;

/**
 * Servlet implementation class EmpDetailServlet
 */
@WebServlet("/emp/update.do")
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DeptService deptService = new DeptService();
		List<DeptDTO> deptlist = deptService.selectAll();
		
		String s_empid = request.getParameter("empid");
		EmpDTO emp = null;
		if(s_empid!=null && s_empid !=""){
			int empid = Integer.parseInt(s_empid);
			EmpService empService = new EmpService();
			emp = empService.selectById(empid);
			request.setAttribute("empInfo", emp);
		}
		request.setAttribute("deptlist", deptlist);
		request.setAttribute("joblist", new JobService().selectAll());
		request.setAttribute("emplist", new EmpService().selectAll());
		
		RequestDispatcher rd = request.getRequestDispatcher("empdetail.jsp");
		rd.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 깨짐 방지
		request.setCharacterEncoding("utf-8");
		
		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone_number");
		String job_id = request.getParameter("job_id");
		
		int empid = convertInt(request.getParameter("employee_id"));
		int mid = convertInt(request.getParameter("manager_id"));
		int deptid = convertInt(request.getParameter("department_id"));

		double comm = convertDouble(request.getParameter("commission_pct"));
		double sal = convertDouble(request.getParameter("salary"));

		String s_hdate = request.getParameter("hire_date");
		Date hdate = null;
		if(s_hdate != null && s_hdate != ""){
			hdate = DateUtil.convertToSQLDate(s_hdate);
		}

		EmpDTO emp = new EmpDTO();
		emp.setCommission_pct(comm);
		emp.setDepartment_id(deptid);
		emp.setEmail(email);
		emp.setEmployee_id(empid);
		emp.setFirst_name(fname);
		emp.setHire_date(hdate);
		emp.setJob_id(job_id);
		emp.setLast_name(lname);
		emp.setManager_id(mid);
		emp.setPhone_number(phone);
		emp.setSalary(sal);
		 
		//DB에 저장하기 
		EmpService empService = new EmpService();
		String message = empService.updateService(emp);
		
//		request.setAttribute("message", message);
//		RequestDispatcher rd = request.getRequestDispatcher("empinsertForm.jsp");
//		rd.forward(request, response);
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().printf("<h1>%s</h1>",message);
	}
	
	private int convertInt(String data){
		if(data ==null || data == "") return 0;
		return Integer.parseInt(data);
	}
	private double convertDouble(String data){
		if(data ==null || data == "") return 0;
		return Double.parseDouble(data);
	}

}
