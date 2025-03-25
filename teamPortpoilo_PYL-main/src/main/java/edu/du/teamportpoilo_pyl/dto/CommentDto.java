package edu.du.teamportpoilo_pyl.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {
    private Long id;
    private Long postId;
    private String author;
    private String comment;
    private LocalDateTime created;
}
