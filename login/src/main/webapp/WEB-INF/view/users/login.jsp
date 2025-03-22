<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>로그인</title>
</head>
<body>
<h2>로그인</h2>
<form method="post" action="/login">
  이메일: <input type="email" name="email"><br>
  비밀번호: <input type="password" name="password"><br>
  <button type="submit">로그인</button>
</form>
<p style="color:red;">${error}</p> <!-- error 메시지를 JSP에서 출력 -->
</body>
</html>
