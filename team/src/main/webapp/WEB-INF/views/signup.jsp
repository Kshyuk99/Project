<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<%@ include file="common/header.jsp" %>
<body>
    <style>
        .signup-container {
            max-width: 500px;
            margin: 60px auto;
            padding: 30px;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
        }
        
        .form-floating {
            margin-bottom: 1.2rem;
        }
        
        .form-control:focus {
            border-color: var(--primary-color);
            box-shadow: 0 0 0 0.2rem rgba(37, 99, 235, 0.25);
        }
        
        .signup-title {
            color: var(--primary-color);
            font-weight: 600;
            margin-bottom: 2rem;
            text-align: center;
        }
        
        .btn-signup {
            background-color: var(--primary-color);
            border-color: var(--primary-color);
            padding: 0.8rem;
            font-weight: 500;
            width: 100%;
            margin-top: 1rem;
        }
        
        .btn-signup:hover {
            background-color: var(--hover-color);
            border-color: var(--hover-color);
        }
        
        .btn-cancel {
            width: 100%;
            margin-top: 0.5rem;
        }
        
        .form-text {
            font-size: 0.875rem;
            color: #6b7280;
        }
        
        .invalid-feedback {
            font-size: 0.875rem;
        }
    </style>

    <div class="container">
        <div class="signup-container">
            <h2 class="signup-title">회원가입</h2>
            
            <form:form action="/signup" method="post" class="needs-validation" novalidate="true">
                <div class="form-floating">
                    <input type="text" class="form-control" id="name" name="name" placeholder="이름" required>
                    <label for="name">이름</label>
                    <div class="invalid-feedback">
                        이름을 입력해주세요.
                    </div>
                </div>

                <div class="form-floating">
                    <input type="email" class="form-control" id="email" name="email" placeholder="이메일" required>
                    <label for="email">이메일</label>
                    <div class="form-text">이메일은 로그인 아이디로 사용됩니다.</div>
                    <div class="invalid-feedback">
                        유효한 이메일 주소를 입력해주세요.
                    </div>
                </div>

                <div class="form-floating">
                    <input type="password" class="form-control" id="password" name="password" 
                           placeholder="비밀번호" required pattern=".{8,}" 
                           title="비밀번호는 최소 8자 이상이어야 합니다">
                    <label for="password">비밀번호</label>
                    <div class="form-text">8자 이상의 비밀번호를 입력해주세요.</div>
                    <div class="invalid-feedback">
                        비밀번호는 최소 8자 이상이어야 합니다.
                    </div>
                </div>

                <div class="form-floating">
                    <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" 
                           placeholder="전화번호" required pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}"
                           title="000-0000-0000 형식으로 입력해주세요">
                    <label for="phoneNumber">전화번호</label>
                    <div class="form-text">예시: 010-1234-5678</div>
                    <div class="invalid-feedback">
                        올바른 전화번호 형식으로 입력해주세요.
                    </div>
                </div>

                <button type="submit" class="btn btn-primary btn-signup">가입하기</button>
                <a href="/" class="btn btn-secondary btn-cancel">취소</a>
            </form:form>
        </div>
    </div>

    <script>
    // 폼 유효성 검사를 위한 JavaScript
    (function () {
        'use strict'
        var forms = document.querySelectorAll('.needs-validation')
        Array.prototype.slice.call(forms).forEach(function (form) {
            form.addEventListener('submit', function (event) {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }
                form.classList.add('was-validated')
            }, false)
        })
    })()

    // 전화번호 자동 하이픈 추가
    document.getElementById('phoneNumber').addEventListener('input', function(e) {
        var x = e.target.value.replace(/\D/g, '').match(/(\d{0,3})(\d{0,4})(\d{0,4})/);
        e.target.value = !x[2] ? x[1] : x[1] + '-' + x[2] + (x[3] ? '-' + x[3] : '');
    });
    </script>

    <%@ include file="common/footer.jsp" %>
</body>
</html>