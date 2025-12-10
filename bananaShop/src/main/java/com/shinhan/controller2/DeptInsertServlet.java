package com.shinhan.controller2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.dept.DeptDTO;
import com.shinhan.dept.DeptService;

/**
 * Servlet implementation class DeptInsertServlet
 */
@WebServlet("/dept/insert.do")
public class DeptInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("deptinsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int deptid = convertInteger(request.getParameter("department_id")) ;
		int mid = convertInteger(request.getParameter("manager_id"));
		int locid = convertInteger(request.getParameter("location_id"));
		String deptname = request.getParameter("department_name");
		DeptDTO dept = new DeptDTO(deptid, deptname, mid, locid);
		
		DeptService deptService = new DeptService();
		String result = deptService.insertService(dept);
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().printf("<h1>%s</h1>", result);
	}

	private int convertInteger(String data) {
		if (data==null || data.trim().isEmpty()) return 0;
		return Integer.parseInt(data);
	}

}
