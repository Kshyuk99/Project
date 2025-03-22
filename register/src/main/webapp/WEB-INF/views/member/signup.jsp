<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입</title>
</head>
<body>
<h2>회원가입</h2>
<form action="/api/signup" method="post">
    ID: <input type="text" name="memberId" id="memberId"><br>
    Password: <input type="password" name="password" id="password"><br>
    Name: <input type="text" name="name" id="name"><br>
    Email: <input type="text" name="email" id="email"><br>
    Birth: <input type="date" name="birth" id="birth"><br>
    <input type="submit" value="회원가입">
</form>
</body>
</html>