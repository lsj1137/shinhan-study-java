<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>직원 정보 상세 보기</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    
    <style>
        /* 기본 리셋 및 폰트 설정 */
        body {
            font-family: 'Roboto', sans-serif;
            margin: 0;
            padding: 0;
            /* 화려한 그라데이션 배경 */
            background: linear-gradient(135deg, #6a11cb 0%, #2575fc 100%);
            color: #333;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }

        /* 메인 컨테이너 (결과 메시지 포함) */
        .main-container {
            width: 90%;
            max-width: 800px;
            padding: 20px;
            text-align: center;
        }

        /* 결과 메시지 (Result Header) 스타일 */
        .result-header {
            color: #ffffff; /* 흰색 텍스트 */
            font-size: 2.5em;
            margin-bottom: 40px;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3); /* 그림자 효과 */
            font-weight: 700;
        }

        /* 직원 정보 카드 컨테이너 */
        .employee-card {
            background-color: #ffffff;
            border-radius: 15px;
            padding: 30px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.25); /* 입체적인 그림자 */
            backdrop-filter: blur(5px); /* 약간의 블러 효과 */
            transition: transform 0.3s ease-in-out;
        }

        .employee-card:hover {
            transform: translateY(-5px); /* 마우스 오버 시 살짝 떠오르는 효과 */
        }

        /* 직원 이름 스타일 */
        .employee-name {
            font-size: 1.8em;
            color: #007bff; /* 포인트 색상 */
            margin-bottom: 25px;
            border-bottom: 3px solid #f0f0f0;
            padding-bottom: 10px;
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .employee-name i {
            margin-right: 10px;
            color: #2575fc;
        }
        
        /* 정보 리스트 스타일 (Flexbox 사용) */
        .info-list {
            display: flex;
            flex-direction: column;
            gap: 15px; /* 항목 간 간격 */
        }

        .info-item {
            background-color: #f7f9fc;
            padding: 15px;
            border-radius: 8px;
            text-align: left;
            display: flex;
            align-items: center;
            box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.05); /* 내부 그림자로 깊이감 */
        }

        .info-item i {
            font-size: 1.2em;
            color: #ff6b6b; /* 아이콘 포인트 색상 */
            width: 30px;
            text-align: center;
            margin-right: 15px;
        }

        .info-label {
            font-weight: 700;
            color: #555;
            min-width: 80px;
        }

        .info-value {
            font-weight: 400;
            color: #333;
            flex-grow: 1;
        }
    </style>
</head>
<body>
    <div class="main-container">
        <h1 class="result-header">${result}</h1>
        
        <div class="employee-card">
            <div class="employee-name">
                <i class="fas fa-user-circle"></i> 
                ${emp.first_name}님의 상세 정보
            </div>
            
            <div class="info-list">
                <div class="info-item">
                    <i class="fas fa-envelope"></i>
                    <span class="info-label">이메일:</span>
                    <span class="info-value">${emp.email}</span>
                </div>
                
                <div class="info-item">
                    <i class="fas fa-money-bill-wave"></i>
                    <span class="info-label">급여:</span>
                    <span class="info-value">
                        ₩ ${emp.salary}
                    </span>
                </div>
                
                <div class="info-item">
                    <i class="fas fa-briefcase"></i>
                    <span class="info-label">부서:</span>
                    <span class="info-value">개발팀</span>
                </div>
            </div>
        </div>
    </div>
</body>
</html>