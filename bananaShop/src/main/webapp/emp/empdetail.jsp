<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>직원정보 수정</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	background-color: #f7f9fb; /* 토스 앱 배경색과 유사한 연한 회색 */
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
		"Helvetica Neue", Arial, sans-serif;
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
/* 버튼 스타일 */
.btn-delete {
	background-color: #ffffff;
	border-color: #FC6161;
	color: #FC6161;
	border-radius: 12px;
	font-weight: 700;
	padding: 12px 0;
	margin-top: 20px;
}

.btn-primary:hover {
	background-color: #005ce6;
	border-color: #005ce6;
}

.btn-delete:hover {
	background-color: #FC6161;
	color: white;
}
/* 직원번호는 수정 불가로 가정하고 비활성화 스타일 적용 */
#employee_id {
	background-color: #f0f0f0;
}
</style>
</head>
<body>
	<div id="container">
		<h1 class="mb-5 fw-bold text-center">직원정보 수정</h1>

		<form action="update.do" method="post">

			<div class="mb-3">
				<label for="employee_id" class="form-label">직원번호</label> <input
					type="number" class="form-control" id="employee_id"
					name="employee_id" autofocus="autofocus"
					value="${empInfo.employee_id}" readonly>
			</div>

			<div class="mb-3">
				<label for="first_name" class="form-label">이름</label> <input
					type="text" class="form-control" id="first_name" name="first_name"
					maxlength="20" value="${empInfo.first_name}">
			</div>

			<div class="mb-3">
				<label for="last_name" class="form-label">성</label> <input
					type="text" class="form-control" id="last_name" name="last_name"
					maxlength="25" required="required" value="${empInfo.last_name}">
			</div>

			<div class="mb-3">
				<label for="email" class="form-label">이메일</label> <input
					type="email" class="form-control" id="email" name="email"
					maxlength="25" required="required" value="${empInfo.email}">
			</div>

			<div class="mb-3">
				<label for="phone_number" class="form-label">전화</label> <input
					type="tel" class="form-control" id="phone_number"
					name="phone_number" placeholder="000.000.0000"
					pattern="[0-9]{3}\.[0-9]{3}\.[0-9]{4}"
					value="${empInfo.phone_number}">
			</div>

			<div class="mb-3">
				<label for="hire_date" class="form-label">입사일</label> <input
					type="date" class="form-control" id="hire_date" name="hire_date"
					required="required" value="${empInfo.hire_date}">
			</div>

			<div class="mb-3">
				<label for="job_id" class="form-label">직책</label>
				<select
					class="form-select" id="job_id" name="job_id">
					
		            <c:forEach items="${ joblist}" var="job">
		            	<option value="${ job.job_id}" ${empInfo.job_id eq job.job_id ? 'selected' : ''}>${job.job_title}</option>
		            </c:forEach>
				</select>
			</div>

			<div class="mb-3">
				<label for="commission_pct" class="form-label">커미션</label> <input
					type="text" class="form-control" id="commission_pct"
					name="commission_pct" placeholder="0보다 작은 실수"
					value="${empInfo.commission_pct}">
			</div>

			<div class="mb-3">
				<label for="department_id" class="form-label">부서번호</label>
				<select
					class="form-select" id="department_id" name="department_id">
					<c:forEach items="${ deptlist}" var="dept">
		            	<option value="${ dept.department_id}" ${dept.department_id eq empInfo.department_id ? 'selected' : ''}>${dept.department_name}</option>
		            </c:forEach>
				</select> <small class="form-text text-muted d-block mt-1">본래 직원의
					근무부서번호: ${empInfo.department_id}</small>
			</div>

			<div class="mb-3">
				<label for="manager_id" class="form-label">메니저번호</label> <select
					class="form-select" id="manager_id" name="manager_id">
					<c:forEach items="${ emplist}" var="emp">
		            	<option value="${ emp.employee_id}" ${empInfo.manager_id eq emp.employee_id ? 'selected' : ''}>${emp.employee_id} - ${emp.first_name}</option>
		            </c:forEach>
				</select>
			</div>

			<div class="mb-3">
				<label for="salary" class="form-label">급여</label> <input
					type="number" class="form-control" id="salary" name="salary"
					placeholder="0보다 큰 정수" value="${empInfo.salary}">
			</div>

			<button type="submit" class="btn btn-primary w-100">직원 정보 수정</button>
		</form>
		<button id="delBtn" class="btn btn-delete w-100">삭제</button>
	</div>
	<script>
		let delButton = document.getElementById("delBtn");
		delButton.addEventListener("click", f_delete);
		function f_delete() {
			let empId = $
			{
				empInfo.employee_id
			}
			;
			location.href = "delete.do?empid=" + empId;
		}
	</script>
</body>
</html>