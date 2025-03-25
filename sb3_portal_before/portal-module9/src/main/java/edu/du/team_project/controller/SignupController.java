package edu.du.team_project.controller;

import edu.du.team_project.model.User;
import edu.du.team_project.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class SignupController {
    private final UserService userService;

    // 회원가입 페이지 (GET)
    @GetMapping("/register")
    public String goregister(Model model) {
        model.addAttribute("user", new User()); // JSP에서 사용할 모델 추가
        return "signup"; // /WEB-INF/views/signup.jsp로 이동 (ViewResolver 사용)
    }

    // 회원가입 처리 (POST)
    @PostMapping("/signup")
    public String register(@ModelAttribute("user") User user) {
        if (userService.registerUser(user)) {
            return "redirect:/"; // 성공 시 index.jsp로 이동
        } else {
            return "redirect:/register?error"; // 실패 시 다시 signup.jsp로 이동 (에러 메시지 전달)
        }
    }
}
