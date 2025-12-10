<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>직책 목록</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

<style>
/* 토스 스타일 기본 설정 */
body {
    background-color: #f7f9fb;
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
}
#container {
    max-width: 800px; /* 테이블에 맞게 너비를 조정했습니다. */
    margin: 40px auto;
    padding: 30px;
    background-color: #ffffff;
    border-radius: 16px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
}

/* 헤더 스타일 */
.main-header {
    font-weight: 700;
    color: #1a1a1a;
    margin-bottom: 30px;
    text-align: left;
    padding: 10px 0;
    border-bottom: 2px solid #e1e5e8;
}

/* 테이블 스타일 (Job List 전용) */
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
    cursor: default; /* 클릭 이동이 없으므로 커서를 default로 설정 */
}
.table-toss tbody tr {
    border-bottom: 1px solid #f0f2f5;
}
.table-toss tbody tr:last-child {
    border-bottom: none;
}
/* 숫자 컬럼 오른쪽 정렬 (금액 표시) */
.table-toss td:nth-child(3), 
.table-toss td:nth-child(4) {
    text-align: right;
    font-weight: 500;
    color: #2b7a78; /* 금액을 강조하는 색상 */
}

/* 직책 ID는 왼쪽, 직책 이름은 중앙 정렬 */
.table-toss td:nth-child(1) {
    font-weight: 600;
    color: #0066ff; /* 토스 블루 */
}
</style>
</head>
<body>
<div id="container">

    <h1 class="main-header">직책 목록</h1>
    
    <table class="table table-borderless table-toss">
        <thead>
            <tr>
                <th>직책 번호</th>
                <th>직책 이름</th>
                <th>최소 급여</th>
                <th>최대 급여</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${ joblist}" var="job">
                <tr>
                    <td>${job.job_id}</td>
                    <td>${job.job_title}</td>
                    <td>${job.min_salary}</td>
                    <td>${job.max_salary}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>