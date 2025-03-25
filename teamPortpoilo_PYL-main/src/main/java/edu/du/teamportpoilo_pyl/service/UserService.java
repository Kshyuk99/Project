package edu.du.teamportpoilo_pyl.service;

import edu.du.teamportpoilo_pyl.dto.UserDto;
import edu.du.teamportpoilo_pyl.mapper.UserMapper;

public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public void insertUser(UserDto user) {
        userMapper.insertUser(user);
    }
}
