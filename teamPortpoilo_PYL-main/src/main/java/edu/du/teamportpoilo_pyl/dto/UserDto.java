package edu.du.teamportpoilo_pyl.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private Long id;
    private String userId;
    private String password;
    private String name;
    private String email;
    private LocalDateTime created;
}
