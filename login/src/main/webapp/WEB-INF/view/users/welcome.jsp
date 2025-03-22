<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>환영합니다</title>
</head>
<body>
<h2>환영합니다, <c:out value="${loggedInUser.name}"/>님!</h2>
<a href="/logout">로그아웃</a>
</body>
</html>
