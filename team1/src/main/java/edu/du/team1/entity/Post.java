package edu.du.team1.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Post {
    private Long id;
    private String title;
    private String content;
    private Long memberId;  // 작성자 ID (member 테이블의 ID 참조)
    private LocalDateTime createdAt;
}
