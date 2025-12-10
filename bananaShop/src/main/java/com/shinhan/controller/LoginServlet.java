package com.shinhan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinhan.emp.EmpDTO;
import com.shinhan.emp.EmpService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/auth/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그인 페이지 보여주기
		// 서블릿이 요청받은 정보와 응답정보를 jsp에게 위임함.
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST 요청받음!");
		String uid = req.getParameter("userid");
		String upw = req.getParameter("userpw");
		String message = "";
		System.out.println(uid+ upw);
		if (uid==null || uid.trim().isEmpty()) return;
		int empId = Integer.parseInt(uid);
		
		EmpService empService = new EmpService();
		EmpDTO empDTO = empService.selectById(empId); 
		
		if (empDTO == null) {
			message = "해당직원 없음";
		} else if (empDTO.getEmail().equals(upw)) {
			message = empDTO.getFirst_name() + "님 환영합니다.";
		} else {
			message = "비밀번호 오류";
			empDTO = null;
		}
		System.out.println(message);
		
		// 뷰 여기서 만들지 않기
//		resp.setContentType("text/html;charset=utf-8");
//		PrintWriter out = resp.getWriter();
//		out.printf("<h1>%s</h1>", message);
		
		req.setAttribute("result", message);
		req.setAttribute("emp", empDTO);
		RequestDispatcher rd = req.getRequestDispatcher("login-result.jsp");
		rd.forward(req, resp);
		
	}

}
