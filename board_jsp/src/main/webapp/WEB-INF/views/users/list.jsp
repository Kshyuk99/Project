<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>사용자 목록</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">
    <h2 class="mb-4 text-center">사용자 목록</h2>

    <div class="mb-3 text-end">
        <a href="<c:url value='/users/write'/>" class="btn btn-primary">사용자 등록</a>
    </div>

    <div class="table-responsive">
        <table class="table table-bordered table-striped table-hover">
            <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>이름</th>
                <th>이메일</th>
                <th>작업</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>
                        <a href="<c:url value='/users/edit/${user.id}'/>" class="btn btn-warning btn-sm">수정</a>
                        <form action="<c:url value='/users/delete'/>" method="post" style="display: inline;">
                            <input type="hidden" name="id" value="${user.id}">
                            <button type="submit" class="btn btn-danger btn-sm" onclick="return confirm('삭제하시겠습니까?')">삭제</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
