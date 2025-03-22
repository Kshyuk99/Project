package edu.du.board.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String email;
    private String phone;

    public User(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
