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
                ${notice.title}
            </div>
            <div class="post-info">
                <span>작성자: ${notice.author}</span>
                <span>작성일: <fmt:formatDate value="${notice.createdAt}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></span>
            </div>
            <div class="post-content">
                ${notice.content}
            </div>
        </div>
        <div class="card-footer">
            <div class="d-flex justify-content-between">
                <a href="/notice" class="btn btn-secondary">목록으로</a>
                <div>
                    <a href="/notice/edit/${notice.id}" class="btn btn-primary">수정</a>
                    <form action="/notice/delete" method="post" style="display: inline;">
                        <input type="hidden" name="id" value="${notice.id}">
                        <button type="submit" class="btn btn-danger" onclick="return confirm('정말 삭제하시겠습니까?')">삭제</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="common/footer.jsp" %>