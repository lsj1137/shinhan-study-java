<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>부서 생성</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="../static/css/dept.css" rel="stylesheet">
</head>
<body>
<div id="container">
    <h1 class="main-header">부서 생성</h1>
 
    <form action="insert.do" method="post">
      
      <div class="mb-3">
          <label for="department_id" class="form-label">부서 번호</label>
          <input class="form-control-plaintext" type="number" name="department_id" id="department_id">
      </div>
      
      <div class="mb-3">
          <label for="department_name" class="form-label">부서 이름</label>
          <input class="form-control-plaintext" name="department_name" id="department_name">
      </div>
       
      <div class="mb-3">
          <label for="manager_id" class="form-label">매니저 번호</label>
          <input class="form-control-plaintext"type="number" name="manager_id"  id="manager_id" >
      </div>
     
      <div class="mb-3">
          <label for="location_id" class="form-label">위치 번호</label>
          <input class="form-control-plaintext"type="number" name="location_id" id="location_id">
      </div>
      
      <div class="d-grid gap-2">
          <button type="submit" class="btn btn-toss-blue">생성하기</button>
          <a href="javascript:history.back()" class="btn btn-outline-secondary" style="border-radius: 12px;">목록으로 돌아가기</a>
      </div>
      
    </form>
</div>
</body>
</html>