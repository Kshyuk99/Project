<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>환영합니다</title>
</head>
<body>
<h2>환영합니다, <c:out value="${member.name}"/>님!</h2>

<!-- 회원 정보 수정 폼 -->
<h3>회원 정보 수정</h3>
<form method="post" action="/update">
  이름: <input type="text" name="name" value="${member.name}"><br>
  이메일: <input type="email" name="email" value="${member.email}" disabled><br>
  비밀번호: <input type="password" name="password" value="${member.password}"><br>
  <button type="submit">수정</button>
</form>

<!-- 회원 탈퇴 -->
<h3>회원 탈퇴</h3>
<a href="/delete">회원 탈퇴</a><br>

<!-- 로그아웃 -->
<a href="/logout">로그아웃</a>

</body>
</html>
