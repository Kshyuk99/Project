package edu.du.teamportpoilo_pyl.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime created;
    private LocalDateTime updated;
    private Long views;
    private Long likes;
}
