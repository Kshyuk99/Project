<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>회원가입</title>
</head>
<body>
<h2>회원가입</h2>
<form method="post" action="/register">
  이름: <input type="text" name="name" required><br>
  이메일: <input type="email" name="email" required><br>
  비밀번호: <input type="password" name="password" required><br>
  <button type="submit">가입</button>
</form>
</body>
</html>
