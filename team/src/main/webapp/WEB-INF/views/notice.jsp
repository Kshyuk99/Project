<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="common/header.jsp" %>

<div class="container mt-5">
    <h2 class="mb-4">게시판</h2>
    <div class="text-end mb-3">
        <a href="/notice/write" class="btn btn-primary">글쓰기</a>
    </div>
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
                <c:forEach items="${notice}" var="notice">
                    <tr>
                        <td>${notice.id}</td>
                        <td><a href="/notice/${notice.id}" class="text-decoration-none">${notice.title}</a></td>
                        <td>${notice.author}</td>
                        <td><fmt:formatDate value="${notice.createdAt}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@ include file="common/footer.jsp" %>