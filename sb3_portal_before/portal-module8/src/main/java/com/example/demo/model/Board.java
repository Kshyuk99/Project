package com.example.demo.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Board {
    private int id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt; // LocalDate 대신 LocalDateTime 사용
}
