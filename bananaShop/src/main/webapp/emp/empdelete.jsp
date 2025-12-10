<%@page import="com.shinhan.dept.DeptDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.dept.DeptService"%>
<%@page import="com.shinhan.emp.EmpDTO"%>
<%@page import="com.shinhan.emp.EmpService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String s_empid = request.getParameter("empid");
EmpDTO emp = null;
String message="";
if(s_empid!=null && s_empid !=""){
	int empid = Integer.parseInt(s_empid);
	EmpService empService = new EmpService();
	message = empService.delete(empid);
    if(message==null) message="삭제실패";
}
%>    


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="3;emplist.jsp">
<title>정보삭제</title>
</head>
<body>
<h1>직원정보 삭제</h1>
<p>삭제결과:<%=message %></p>

 
</body>
</html>

<!-- 
HTML : 구조적 data, 웹에서 사용하는 data, Browser 해석 
CSS : 디자인 , style



 -->
 
 
 
 
 
 
 

