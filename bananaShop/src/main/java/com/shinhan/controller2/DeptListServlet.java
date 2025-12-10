package com.shinhan.controller2;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.shinhan.dept.DeptDTO;
import com.shinhan.dept.DeptService;

/**
 * Servlet implementation class DeptListServlet
 * MVC1 모델
 * Browser 요청 ---> Controller에서 응답 ---> Browser
 * Browser 요청 ---> Controller(JSP)에서 응답(view 역할) ---> Browser
 * 
 * MVC2 모델
 * Browser 요청 ---> Servlet(Controller) ---> JSP(View) ---> Browser
 */
@WebServlet("/dept/list.do")
public class DeptListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("----- DeptListServlet get 요청 -----");
		
		// Servlet에서 응답 문서를 생성해서 반환(MVC1 모델)
//		DeptService deptService = new DeptService();
//		List<DeptDTO> deptList = deptService.selectAll(); 
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
//		out.print("<h1>/dept/list.do 요청응답함</h1>");
//		out.print(deptList.toString());
		
		// HTML 응답을 JSP에 위임(MVC2 모델)
		DeptService deptService = new DeptService();
		List<DeptDTO> deptList = deptService.selectAll(); 
		Gson gson = new Gson();
		String deptJson = gson.toJson(deptList);
		request.setAttribute("deptJson", deptJson);
		request.setAttribute("deptList", deptList);
		RequestDispatcher rd = request.getRequestDispatcher("deptlist.jsp");
		rd.forward(request, response);
	}
}
