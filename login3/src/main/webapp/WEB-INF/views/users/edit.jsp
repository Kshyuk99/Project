<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">
                    <h2 class="card-title h4 mb-0">사용자 수정</h2>
                </div>
                <div class="card-body">
                    <form action="/users/update" method="post">
                        <input type="hidden" name="id" value="${member.id}">

                        <div class="mb-3">
                            <label for="name" class="form-label">이름</label>
                            <input type="text" class="form-control" id="name" name="name" value="${member.name}" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">이메일</label>
                            <input type="email" class="form-control" id="email" name="email" value="${member.email}" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">비밀번호</label>
                            <input type="password" class="form-control" id="password" name="password" value="${member.password}" required>
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