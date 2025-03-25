package edu.du.team_project.model;

import java.sql.Timestamp;


public class Post {
    private int id;
    private String title;
    private String content;
    private String author;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // 생성자
    public Post() {}

    public Post(Timestamp updatedAt, Timestamp createdAt, String author, String content, String title, int id) {
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.author = author;
        this.content = content;
        this.title = title;
        this.id = id;
    }

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
