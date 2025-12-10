<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" ></script> 
<title>직원 조회</title>
<style>
/* 토스 스타일 기본 설정 */
body {
    background-color: #f7f9fb; /* 연한 배경색 */
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
}
#container {
    max-width: 1200px; /* 테이블이 넓으므로 컨테이너 폭 확장 */
    margin: 40px auto;
    padding: 30px;
    background-color: #ffffff; /* 흰색 카드 배경 */
    border-radius: 16px; /* 둥근 모서리 */
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08); /* 은은한 그림자 */
}

/* 헤더 스타일 */
#main-header {
	display:flex;
    font-weight: 700;
    color: #1a1a1a;
    margin-bottom: 30px;
    text-align: left;
    padding: 10px 0;
    border-bottom: 2px solid #e1e5e8; /* 하단에 얇은 구분선 */
}

.title{
	flex:1;
}

/* 테이블 스타일 */
.table-custom {
    /* Bootstrap 기본 테이블 스타일 유지 (border-collapse: collapse) */
    border-radius: 12px;
    overflow: hidden; /* 모서리 둥글게 적용을 위해 필요 */
}
.table-custom th, .table-custom td {
    padding: 12px;
    border: none; /* Bootstrap border-less 적용을 위해 기본 border 제거 */
    vertical-align: middle;
}
/* 헤더 배경색 */
.table-custom thead th {
    background-color: #f7f9fb; 
    font-weight: 600;
    color: #464646;
    border-bottom: 1px solid #e1e5e8; /* 헤더와 본문 구분선 */
}

/* 3. 액션 버튼/링크 스타일 */
.btn-toss-blue {
	color: white;
    background-color: #0066ff; /* 토스 블루 */
    border-color: #0066ff;
    border-radius: 8px;
    font-weight: 600;
    padding: 8px 15px;
    transition: background-color 0.2s;
}
.btn-toss-blue:hover {
    background-color: #005ce6;
    border-color: #005ce6;
    color: white;
}
.btn-toss-delete {
    background-color: #dc3545; /* 빨간색 (위험 요소) */
    border-color: #dc3545;
    border-radius: 8px;
    padding: 5px 10px;
}

/* 4. 기존 CSS 스타일 유지 (조건부 스타일링) */
/* 홀수/짝수 배경색은 Bootstrap의 .table-striped로 대체 가능하나, 토스는 보통 단색 배경 선호 */
.table-custom tbody tr:nth-child(even){
    background-color: #fcfcfc; /* 짝수 행을 아주 약간만 다르게 */
}
.table-custom tbody tr:hover{
    background-color: #e6f0ff; /* 마우스 오버 시 연한 블루 */
    cursor: pointer;
}
/* 자식으로 3번째 나오는 td들의 font-weigth:bold */
.table-custom tr td:nth-child(3){
    font-weight: bold;
}
.myemail::before{
    content: "!!";
    color:red;
}
.salary7000{
     color: #0066ff; /* 토스 블루로 변경 */
     font-weight: 700;
}
.salary0{
     color: #1a1a1a; 
}
/* 직원번호 링크 스타일 */
.detail-link {
    color: #0066ff; 
    text-decoration: none;
    font-weight: 600;
}
.detail-link:hover {
    text-decoration: underline;
}
/* 테이블 내 '삭제' 버튼 (휴지통 아이콘) 스타일 */
.delBtn {
    /* 버튼 기본 스타일 초기화 */
    background: none;
    border: none;
    padding: 0; /* 패딩 제거 */
    cursor: pointer;
    
    /* 아이콘 스타일 */
    color: #ff4d4d; /* 빨간색 */
    font-size: 1.15rem; /* 아이콘 크기 조정 */
    line-height: 1; 
    display: inline-flex; /* 아이콘 중앙 정렬 */
    align-items: center;
    justify-content: center;
    transition: color 0.2s, transform 0.2s;
}
.delBtn:hover {
    color: #cc0000;
    transform: scale(1.1); /* 호버 시 약간 커지는 효과 */
}
</style> 
</head>
<body>
 <div id="container">
 <div id="main-header">
 <h1 class="title">직원 조회 목록</h1>
 <div id="newempBtn" class="d-flex justify-content-end mb-4">
     <a class="btn btn-toss-blue" href="insert.do">
        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-plus-fill me-1" viewBox="0 0 16 16">
            <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm5-7a3 3 0 1 0 0-6 3 3 0 0 0 0 6"/>
            <path fill-rule="evenodd" d="M12.5 15a.5.5 0 0 1 0-1h3a.5.5 0 0 1 0 1zM13 13.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1h-2a.5.5 0 0 1-.5-.5z"/>
        </svg>
        신규 직원 등록
     </a>
 </div>
 </div>
 
 <table class="table table-borderless table-custom">
   <caption>HR 계정의 직원 정보</caption>
   <thead>
     <tr>
       <th>직원번호</th>
       <th>이름(Fname)</th>
       <th>성(Lname)</th>
       <th>이메일</th>
       <th>전화번호</th>
       <th>입사일</th>
       <th>직책</th>
       <th>커미션</th>
       <th>부서</th>
       <th>매니저</th>
       <th>급여</th>
       <th>삭제</th>
     </tr>
   </thead>
   <tbody>
     <c:forEach items="${emplist}" var="emp">
     	<tr>
     		<td>
     		<a href="update.do?empid=${emp.employee_id }">
     		${emp.employee_id }
     		</a>
     		</td>
     		<td>${emp.first_name }</td>
     		<td>${emp.last_name }</td>
     		<td>${emp.email }</td>
     		<td>${emp.phone_number }</td>
     		<td>${emp.hire_date }</td>
     		<td>${emp.job_id }</td>
     		<td>${emp.commission_pct }</td>
     		<td>${emp.department_id }</td>
     		<td>${emp.manager_id }</td>
     		<td>${emp.salary }</td>
     		<td>
            <button class="delBtn" data-empid="${emp.employee_id}">
                <i class="fas fa-trash-can"></i>
            </button>
            </td>
     	</tr>
     </c:forEach>
   </tbody>
 </table>
 </div>
 <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
 <script>
$(function(){
	$(".delBtn").click((e)=>{ 
		let deptid = $(e.target).attr("data-empid"); 

	    location.href = `delete.do?empid=${empid}`;
	});
});
</script>
</body>
</html>