create database if not exists teamproject;

CREATE TABLE board (
    id INT AUTO_INCREMENT PRIMARY KEY,      -- 게시글 고유 ID
    title VARCHAR(255) NOT NULL,            -- 게시글 제목
    content TEXT NOT NULL,                  -- 게시글 내용
    author VARCHAR(100) NOT NULL,            -- 작성자
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 작성일
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- 수정일
    views INT DEFAULT 0,                     -- 조회수
    likes INT DEFAULT 0                       -- 좋아요 수
);

INSERT INTO board (title, content, author, views, likes) VALUES
('첫 번째 게시글', '이것은 첫 번째 게시글의 내용입니다.', '작성자1', 10, 2),
('두 번째 게시글', '이것은 두 번째 게시글의 내용입니다.', '작성자2', 25, 5),
('세 번째 게시글', '이것은 세 번째 게시글의 내용입니다.', '작성자3', 8, 1);

CREATE TABLE comments (
    id INT AUTO_INCREMENT PRIMARY KEY,  
    post_id INT NOT NULL,  -- 게시글 ID (board 테이블과 연결)
    author VARCHAR(100) NOT NULL,  
    comment TEXT NOT NULL,  
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
    FOREIGN KEY (post_id) REFERENCES board(id) ON DELETE CASCADE
);

INSERT INTO comments (post_id, author, comment) VALUES
(1, '댓글작성자1', '첫 번째 게시글의 첫 번째 댓글입니다.'),
(1, '댓글작성자2', '첫 번째 게시글의 두 번째 댓글입니다.'),
(2, '댓글작성자3', '두 번째 게시글에 대한 댓글입니다.');

CREATE TABLE users (
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,  -- 사용자 고유 ID
    username    VARCHAR(50) NOT NULL UNIQUE,       -- 아이디 (중복 불가)
    password    VARCHAR(255) NOT NULL,             -- 비밀번호 (암호화 저장)
    name        VARCHAR(100) NOT NULL,             -- 사용자 이름
    email       VARCHAR(100) NOT NULL UNIQUE,      -- 이메일 (중복 불가)
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- 가입 날짜
);

INSERT INTO users (username, password, name, email) 
VALUES 
('user1', '1234', '홍길동', 'user1@example.com'),
('user2', '1234', '김철수', 'user2@example.com'),
('user3', '1234', '이영희', 'user3@example.com'),
('user4', '1234', '박민수', 'user4@example.com'),
('user5', '1234', '최지우', 'user5@example.com');

-- table comments;
 drop table board;
 drop table comments;