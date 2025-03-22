package edu.du.team_project.service;

import edu.du.team_project.mapper.UserMapper;
import edu.du.team_project.model.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public boolean registerUser(User user) {
        if (userMapper.existsByEmail(user.getEmail())) {
            return false; // 이메일 중복 시 회원가입 실패
        }
        userMapper.insertUser(user);
        return true;
    }
    public User login(String email, String password) {
        return userMapper.findByEmailAndPassword(email, password);
    }
}
