<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">
                    <h2 class="card-title h4 mb-0">게시글 수정</h2>
                </div>
                <div class="card-body">
                    <form action="/users/update" method="post">
                        <input type="hidden" name="id" value="${member.id}">

                        <div class="mb-3">
                            <label for="title" class="form-label">제목</label>
                            <input type="text" class="form-control" id="title" name="title" value="${member.title}" required>
                        </div>
                        <div class="mb-3">
                            <label for="author" class="form-label">작성자</label>
                            <input type="text" class="form-control" id="author" value="${member.author}" readonly>
                        </div>
                        <div class="mb-3">
                            <label for="content" class="form-label">내용</label>
                            <textarea class="form-control" id="content" name="content" rows="10" required>${member.content}</textarea>
                        </div>
                        <div class="mb-3">
                            <c:if test="${not empty errors}">
                                <div class="alert alert-danger">
                                    <c:forEach items="${errors}" var="error">
                                        <p>${error}</p>
                                    </c:forEach>
                                </div>
                            </c:if>
                        </div>
                        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                            <a href="/users" class="btn btn-secondary me-2">취소</a>
                            <button type="submit" class="btn btn-primary">수정완료</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>