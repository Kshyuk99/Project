package edu.du.team_project.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Notice {
    private int id;
    private String title;
    private String content;
    private String author;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
