package edu.du.team1.entity;

import lombok.Data;

import javax.persistence.Entity;



@Data
public class Member {
    private Long id;
    private String name;
    private String password;
    private String email;
}
