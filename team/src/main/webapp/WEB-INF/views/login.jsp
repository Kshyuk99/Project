<%@ page language="java"  pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@ include file="common/header.jsp" %>
<body>
    <style>
        .login-container {
            max-width: 400px;
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
        
        .login-title {
            color: var(--primary-color);
            font-weight: 600;
            margin-bottom: 2rem;
            text-align: center;
        }
        
        .btn-login {
            background-color: var(--primary-color);
            border-color: var(--primary-color);
            padding: 0.8rem;
            font-weight: 500;
            width: 100%;
            margin-top: 1rem;
        }
        
        .btn-login:hover {
            background-color: var(--hover-color);
            border-color: var(--hover-color);
        }
        
        .signup-link {
            text-align: center;
            margin-top: 1.5rem;
            color: #6b7280;
        }
        
        .signup-link a {
            color: var(--primary-color);
            text-decoration: none;
            font-weight: 500;
        }
        
        .signup-link a:hover {
            color: var(--hover-color);
            text-decoration: underline;
        }
        
        .alert {
            border-radius: 8px;
            margin-bottom: 1.5rem;
        }
    </style>

    <div class="container">
        <div class="login-container">
            <h2 class="login-title">로그인</h2>

            <c:if test="${not empty error}">
                <div class="alert alert-danger" role="alert">
                    ${error}
                </div>
            </c:if>

            <form action="${pageContext.request.contextPath}/login" method="post" class="needs-validation" novalidate="true">
                <div class="form-floating">
                    <input type="email" class="form-control" id="email" name="email" placeholder="이메일" required>
                    <label for="email">이메일</label>
                    <div class="invalid-feedback">
                        유효한 이메일 주소를 입력해주세요.
                    </div>
                </div>

                <div class="form-floating">
                    <input type="password" class="form-control" id="password" name="password" placeholder="비밀번호" required>
                    <label for="password">비밀번호</label>
                    <div class="invalid-feedback">
                        비밀번호를 입력해주세요.
                    </div>
                </div>

                <button type="submit" class="btn btn-primary btn-login">로그인</button>
            </form>

            <div class="signup-link">
                아직 회원이 아니신가요? <a href="${pageContext.request.contextPath}/register">회원가입</a>
            </div>
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
    </script>

    <%@ include file="common/footer.jsp" %>
</body>
</html>