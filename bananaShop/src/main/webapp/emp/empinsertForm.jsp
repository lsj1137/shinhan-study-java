<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>신규 직원 등록</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
body {
    background-color: #f7f9fb; /* 토스 앱 배경색과 유사한 연한 회색 */
    font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
}
#container {
    max-width: 600px; /* 폼 컨테이너 최대 폭 제한 */
    margin: 40px auto;
    padding: 30px;
    background-color: #ffffff; /* 흰색 카드 배경 */
    border-radius: 16px; /* 둥근 모서리 */
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08); /* 은은한 그림자 */
}
.form-label {
    font-weight: 600; /* 라벨 굵게 */
    color: #464646;
    margin-bottom: 4px;
}
/* 입력 필드 스타일 */
.form-control, .form-select {
    border-radius: 8px; /* 둥근 입력 필드 */
    border: 1px solid #e1e5e8;
    padding: 10px 12px;
    height: auto;
    transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
}
.form-control:focus, .form-select:focus {
    border-color: #0066ff; /* 포커스 시 토스 블루 */
    box-shadow: 0 0 0 3px rgba(0, 102, 255, 0.2); /* 은은한 포커스 그림자 */
}
/* 버튼 스타일 */
.btn-primary {
    background-color: #0066ff; /* 토스 블루 */
    border-color: #0066ff;
    border-radius: 12px;
    font-weight: 700;
    padding: 12px 0;
    margin-top: 20px;
}
.btn-primary:hover {
    background-color: #005ce6;
    border-color: #005ce6;
}
/* 라디오 버튼 그룹 스타일 */
#jobSelect {
    display: flex;
    gap: 10px;
    margin-bottom: 20px;
}
#jobSelect input[type="radio"] {
    display: none;
}
#jobSelect label.radio-label {
    flex-grow: 1;
    text-align: center;
    padding: 10px 15px;
    border: 1px solid #e1e5e8;
    border-radius: 8px;
    cursor: pointer;
    background-color: #ffffff;
    transition: all 0.2s ease;
    font-weight: 500;
}
#jobSelect input[type="radio"]:checked + label.radio-label {
    background-color: #e6f0ff; /* 선택 시 연한 블루 배경 */
    border-color: #0066ff; /* 테두리 블루 */
    color: #0066ff;
}
</style>
</head>
<body>
<div id="container">

	<h1 class="mb-4 fw-bold">신규직원 등록</h1>
	
    <hr class="mb-4">
	
	<form action="insert.do" method="post" class="needs-validation" novalidate>
        
        <div class="mb-3">
            <label for="employee_id" class="form-label">직원번호</label>
            <input type="number" class="form-control" id="employee_id" name="employee_id" 
                placeholder="(필수) 숫자로 입력" autofocus required>
            <div class="invalid-feedback">직원 번호는 필수이며 숫자여야 합니다.</div>
        </div>
        
        <div class="mb-3">
            <label for="first_name" class="form-label">이름</label>
            <input type="text" class="form-control" id="first_name" name="first_name" maxlength="20">
        </div>
        
        <div class="mb-3">
            <label for="last_name" class="form-label">성</label>
            <input type="text" class="form-control" id="last_name" name="last_name" maxlength="25" required>
            <div class="invalid-feedback">성은 필수입니다.</div>
        </div>
        
        <div class="mb-3">
            <label for="email" class="form-label">이메일</label>
            <input type="email" class="form-control" id="email" name="email" maxlength="25" required>
            <div class="invalid-feedback">이메일은 필수이며 유효한 형식이어야 합니다.</div>
        </div>
        
        <div class="mb-3">
            <label for="phone_number" class="form-label">전화</label>
            <input type="tel" class="form-control" id="phone_number" name="phone_number" placeholder="예: 000.000.0000" pattern="[0-9]{3}\.[0-9]{3}\.[0-9]{4}">
             <div class="invalid-feedback">전화번호 형식(000.000.0000)을 확인해주세요.</div>
        </div>
        
        <div class="mb-3">
            <label for="hire_date" class="form-label">입사일</label>
            <input type="date" class="form-control" id="hire_date" name="hire_date" required>
            <div class="invalid-feedback">입사일은 필수입니다.</div>
        </div>
        
        <div class="mb-3">
            <label for="job_id" class="form-label">직책</label>
            <select class="form-select" id="job_id" name="job_id">
            <c:forEach items="${ joblist}" var="job">
            	<option value="${ job.job_id}">${job.job_title}</option>
            </c:forEach>
            </select>
        </div>
        
        <div class="mb-3">
            <label for="commission_pct" class="form-label">커미션</label>
            <input type="text" class="form-control" id="commission_pct" name="commission_pct" placeholder="0 ~ 1 사이 실수">
        </div>
        
        <div class="mb-3">
            <label for="department_id" class="form-label">부서</label>
            <select class="form-select" id="department_id" name="department_id">
            <c:forEach items="${ deptlist}" var="dept">
            	<option value="${ dept.department_id}">${dept.department_name}</option>
            </c:forEach>
            </select>
        </div>
        
        <div class="mb-3">
            <label for="manager_id" class="form-label">메니저</label>
            <select class="form-select" id="manager_id" name="manager_id">
            <c:forEach items="${ emplist}" var="emp">
            	<option value="${ emp.employee_id}">${emp.employee_id} - ${emp.first_name}</option>
            </c:forEach>
            </select>
        </div>
        
        <div class="mb-3">
            <label for="salary" class="form-label">급여</label>
            <input type="number" class="form-control" id="salary" name="salary" placeholder="0보다 큰 정수">
        </div>
        
        <button type="submit" class="btn btn-primary w-100">직원 입력</button>
	</form>
 </div>
 
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
    // Bootstrap의 클라이언트 측 유효성 검사를 활성화하는 스크립트
    (function () {
      'use strict'

      // 모든 유효성 검사가 필요한 폼 가져오기
      var forms = document.querySelectorAll('.needs-validation')

      // 루프를 돌면서 제출(submit) 시 유효성 검사 적용
      Array.prototype.slice.call(forms)
        .forEach(function (form) {
          form.addEventListener('submit', function (event) {
            if (!form.checkValidity()) {
              event.preventDefault()
              event.stopPropagation()
            }

            form.classList.add('was-validated')
          }, false)
        })
    })()
</script>
</body>
</html>