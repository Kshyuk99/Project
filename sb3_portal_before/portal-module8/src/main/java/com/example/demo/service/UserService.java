package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ 회원가입 (비밀번호를 암호화하지 않고 저장)
    public void registerUser(String username, String password) {
        userRepository.save(new User(username, password, "ROLE_USER"));
    }

    // ✅ 로그인 확인 (비밀번호 비교)
    public boolean authenticate(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);

        // 🔹 DB에서 가져온 비밀번호와 입력한 비밀번호가 같은지 비교
        return user.isPresent() && password.equals(user.get().getPassword());
    }
}
