package edu.du.sb20250319.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDto {
    private int no;

    @NotBlank(message = "{erorr.common.blank}")
    @Size(min = 5, max = 15, message = "{error.id}")
    private String id;

    @NotBlank(message = "{erorr.common.blank}")
    @Size(min = 7, max = 20, message = "{error.password}")
    private String password;

    @NotBlank(message = "{erorr.common.blank}")
    @Size(min = 1, max = 15, message = "{error.name}")
    private String name;
    private String email;

    public int getNo() {
        return no;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
