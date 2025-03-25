package edu.du.team_project.service;
import edu.du.team_project.mapper.PostRepository;
import edu.du.team_project.mapper.UserMapper;
import edu.du.team_project.model.User;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final PostRepository postRepository;

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

    // UserService.java
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
    public User getUserById(Long id) {
        return userMapper.findById(id);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public void deleteUser(Long id) {
        userMapper.deleteUser(id);
    }


    public void deleteUserAndAnonymizePosts(Long userId) {
        User user = userMapper.findById(userId);
        postRepository.anonymizeAuthor(user.getName()); // 작성자명 변경
        userMapper.deleteUser(userId);
    }
}
