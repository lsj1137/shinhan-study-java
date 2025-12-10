package com.shinhan.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 * Servlet: 서버(WAS, 컨테이너)에서 실행가능한 자바프로그램
 * @WebServlet("/FirstServlet"): 브라우저에서 요청주소
 */
@WebServlet({"/FirstServlet", "/first"})
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
    	System.out.print(LocalDateTime.now()+ "생성자");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
    	System.out.println(LocalDateTime.now()+"  >> 서버 시작");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println(LocalDateTime.now()+"  >> destroy: Stop 시 발생");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp); 
		System.out.println(LocalDateTime.now()+"  >> FirstServlet service");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(LocalDateTime.now()+"  >> doGet: get 요청시 수행");
		// getContextPath(): 웹서버에 등록된 웹 어플리케이션 /bananaShop
		// response.getWriter(): 응답 문서를 만듦
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(LocalDateTime.now()+"  >> doPost: post 요청시 수행");
		doGet(request, response);
	}

}
