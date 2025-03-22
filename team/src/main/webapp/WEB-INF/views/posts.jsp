<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="common/header.jsp" %>

<div class="container mt-5">
    <h2 class="mb-4">게시판</h2>
    <c:choose>
        <c:when test="${empty sessionScope.loggedInUser}">
            <div class="text-end mb-3">

            </div>
        </c:when>
        <c:otherwise>
            <div class="text-end mb-3">
                <a href="/posts/write" class="btn btn-primary">글쓰기</a>
            </div>
        </c:otherwise>
    </c:choose>
    <div class="card">
        <div class="card-body">
            <table class="table table-hover">
                <thead class="table-light">
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${posts}" var="post">
                    <tr>
                        <td>${post.id}</td>
                        <td><a href="/posts/${post.id}" class="text-decoration-none">${post.title}</a></td>
                        <td>${post.author}</td>
                        <td><fmt:formatDate value="${post.createdAt}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@ include file="common/footer.jsp" %>