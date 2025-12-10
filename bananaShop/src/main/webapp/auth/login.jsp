<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
		<meta charset="UTF-8">
		<title>로그인</title>
    <style>
      /* 전체 페이지 스타일 */
      body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f4f7f6; /* 은은한 배경색 */
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
      }

      /* 로그인 컨테이너 (폼 전체) */
      .login-container {
        background-color: #ffffff;
        padding: 40px;
        border-radius: 12px;
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1); /* 입체감 있는 그림자 */
        width: 320px;
        text-align: center;
      }

      /* 헤더 (제목) */
      .login-container h2 {
        margin-bottom: 30px;
        color: #333;
        font-weight: 600;
      }

      /* 필드셋 제거, 인풋 그룹 */
      .input-group {
        margin-bottom: 20px;
      }

      /* 텍스트 인풋 스타일 */
      .login-input {
        width: 100%;
        padding: 12px 15px;
        margin: 8px 0;
        box-sizing: border-box;
        border: 1px solid #ddd;
        border-radius: 6px;
        font-size: 16px;
        transition: border-color 0.3s;
      }

      .login-input:focus {
        border-color: #007bff; /* 포커스 시 색상 변경 */
        outline: none;
      }

      /* 로그인 버튼 기본 스타일 */
      .login-btn {
        width: 100%;
        padding: 12px;
        border: none;
        border-radius: 6px;
        font-size: 18px;
        font-weight: bold;
        cursor: pointer;
        transition: background-color 0.3s, transform 0.1s;
        margin-bottom: 10px; /* 버튼 간 간격 */
      }

      /* 폼 전송용 (액션 수행) 버튼 스타일 */
      .login-submit-btn {
        background-color: #007bff; /* 파란색 계열 */
        color: white;
      }

      .login-submit-btn:hover {
        background-color: #0056b3;
      }
      
      /* Ajax 전송용 버튼 스타일 */
      #btn_login {
        background-color: #28a745; /* 초록색 계열 */
        color: white;
        margin-top: 5px; 
      }

      #btn_login:hover {
        background-color: #1e7e34;
      }
      
      /* 결과 표시 영역 스타일 */
      #here {
        margin-top: 20px;
        padding: 15px;
        border: 1px solid #ccc;
        border-radius: 6px;
        min-height: 50px;
        background-color: #f9f9f9;
        text-align: left;
        color: #333;
        white-space: pre-wrap; /* 결과를 줄바꿈 처리 */
      }

	 </style>
  </head>
  <body>
    <div class="login-container">
      <h2>로그인</h2>
      
      <form action="login.do" method="post">
        <div class="input-group">
          <input type="text" id="userid" name="userid" class="login-input" placeholder="아이디" value="100">
        </div>
        <div class="input-group">
          <input type="password" id="userpw" name="userpw" class="login-input" placeholder="비밀번호" value="SKING">
        </div>
        
        <input type="submit" value="로그인 (Form Submit)" class="login-btn login-submit-btn">
      </form>

      <button id="btn_login" class="login-btn">로그인 (Ajax Post)</button>

      <div id="here">Ajax 호출 결과</div> 
    </div>

    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <script>
      // 기존 JQuery AJAX 로직은 그대로 유지
      $("#btn_login").click(()=>{
        // jQuery의 .val() 함수가 input 값을 가져옵니다.
        let emp = {userid: $("#userid").val(), userpw:$("#userpw").val()};
        
        // 서버 URL이 빈 문자열("")이므로 현재 페이지에 POST 요청을 보냅니다.
        $.post("", emp, (response)=>{
          $("#here").html(response);
        })
      });
    </script>
  </body>
</html>