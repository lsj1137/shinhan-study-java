<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>부서 목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
/* 토스 스타일 기본 설정 */
body {
    background-color: #f7f9fb; /* 연한 배경색 */
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
}
#container {
    max-width: 900px; 
    margin: 40px auto;
    padding: 30px;
    background-color: #ffffff; /* 흰색 카드 배경 */
    border-radius: 16px; /* 둥근 모서리 */
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08); /* 은은한 그림자 */
}

/* 1. 헤더 스타일 */
.main-header {
    font-weight: 700;
    color: #1a1a1a;
    margin-bottom: 30px;
    text-align: left;
    padding: 10px 0;
    border-bottom: 2px solid #e1e5e8;
}

/* 2. 테이블 스타일 */
.table-toss {
    border-radius: 12px;
    overflow: hidden;
    box-shadow: 0 1px 4px rgba(0, 0, 0, 0.05);
}
.table-toss th, .table-toss td {
    padding: 15px 12px;
    border: none;
    vertical-align: middle;
}
.table-toss thead th {
    background-color: #f7f9fb;
    font-weight: 600;
    color: #464646;
    border-bottom: 1px solid #e1e5e8;
}
.table-toss tbody tr:hover {
    background-color: #e6f0ff;
    cursor: pointer;
}
.table-toss tbody tr {
    border-bottom: 1px solid #f0f2f5;
}
.table-toss tbody tr:last-child {
    border-bottom: none;
}

/* 3. 링크 스타일 */
.detail-link {
    color: #0066ff;
    text-decoration: none;
    font-weight: 600;
    transition: color 0.2s;
}
.detail-link:hover {
    color: #005ce6;
    text-decoration: underline;
}

/* 4. '신규부서 등록' 버튼 스타일 */
.btn-toss-blue {
    background-color: #0066ff;
    border-color: #0066ff;
    color: #fff;
    border-radius: 12px;
    font-weight: 600;
    padding: 10px 20px;
    text-decoration: none;
    display: inline-block;
    transition: background-color 0.2s;
}
.btn-toss-blue:hover {
    background-color: #005ce6;
    color: #fff;
}
.btn-area {
    margin-bottom: 20px;
    text-align: right;
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
/* 아이콘만 있으므로 텍스트 숨김 처리는 필요 없습니다. */
</style>
</head>
<body>
<div id="container">

    <h1 class="main-header">부서 목록</h1>
    
    <div class="btn-area">
        <a href="insert.do" class="btn-toss-blue">신규부서 등록</a>
    </div>

    <table class="table table-borderless table-toss">
        <thead>
            <tr>
                <th>부서 번호</th>
                <th>부서 이름</th>
                <th>매니저</th>
                <th>위치</th>
                <th>삭제</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${deptList}" var="dept">
                <tr>
                    <td>
                        <a href="detail.do?deptid=${dept.department_id}" class="detail-link">
                            ${dept.department_id}
                        </a>
                    </td>
                    <td>${dept.department_name}</td>
                    <td>${dept.manager_id}</td>
                    <td>${dept.location_id}</td>
                    <td>
                        <button class="delBtn" data-deptid="${dept.department_id}">
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
		
		let deptid = $(e.target).attr("data-deptid"); 
        
	    location.href = `delete.do?deptid=${deptid}`;
	});
});
</script>
</body>
</html>