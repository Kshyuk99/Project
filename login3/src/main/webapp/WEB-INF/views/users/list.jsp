<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>게시판</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-3">
    <h2 class="mb-4">목록</h2>
    <a href="<c:url value='/users/write'/>" class="btn btn-primary mb-3">등록</a>
    <table class="table table-bordered table-sm">
        <thead>
        <tr>
            <th>ID</th>
            <th>이름</th>
            <th>이메일</th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>
                    <a href="<c:url value='/users/edit/${user.id}'/>" class="btn btn-sm btn-warning">수정</a>
                    <form action="<c:url value='/users/delete'/>" method="post" style="display: inline;">
                        <input type="hidden" name="id" value="${user.id}">
                        <button type="submit" class="btn btn-sm btn-danger" onclick="return confirm('삭제하시겠습니까?')">삭제</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>