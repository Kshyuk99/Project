<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


    <style>
        .card-body {
            padding: 2rem;
        }
        .post-title {
            font-size: 24px;
            font-weight: bold;
            padding: 0 0 15px 0;
            margin: 0;
            border-bottom: 1px solid #dee2e6;
        }
        .post-info {
            color: #6c757d;
            font-size: 14px;
            padding: 15px 0;
            margin: 0;
            border-bottom: 1px solid #dee2e6;
        }
        .post-content {
            padding: 30px 0 0 0;
            margin: 0;
            min-height: 300px;
            line-height: 1.8;
            white-space: pre-wrap;
        }
        .post-info span + span::before {
            content: "|";
            margin: 0 10px;
            color: #dee2e6;
        }
    </style>
<%@ include file="common/header.jsp" %>

<div class="container mt-5">
    <div class="card">
        <div class="card-body">
            <div class="post-title">
                ${post.title}
            </div>
            <div class="post-info">
                <span>작성자: ${post.author}</span>
                <span>작성일: <fmt:formatDate value="${post.createdAt}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></span>
            </div>
            <div class="post-content">
                ${post.content}
            </div>
        </div>
        <div class="card-footer">
            <div class="d-flex justify-content-between">
                <a href="/posts" class="btn btn-secondary">목록으로</a>
                <c:choose>
                    <c:when test="${sessionScope.loggedInUser.name eq post.author}">
                        <div>
                            <a href="/posts/edit/${post.id}" class="btn btn-primary">수정</a>
                            <form action="/posts/delete" method="post" style="display: inline;">
                                <input type="hidden" name="id" value="${post.id}">
                                <button type="submit" class="btn btn-danger" onclick="return confirm('정말 삭제하시겠습니까?')">삭제</button>
                            </form>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div>

                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>
<%@ include file="common/footer.jsp" %>