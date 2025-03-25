package edu.du.team_project.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String role;
}