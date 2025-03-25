package com.example.demo.controller;

import com.example.demo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "welcome"; // 홈 화면
    }

    @GetMapping("/register")  // 회원가입 폼
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        userService.registerUser(username, password);
        return "redirect:/login";
    }

    @GetMapping("/login")  // 로그인 폼
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        if (userService.authenticate(username, password)) {
            // 로그인 성공 → 세션에 사용자 정보 저장
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            return "redirect:board/list";  // 로그인 성공 시 리스트 페이지로 이동
        }
        return "redirect:/login?error";  // 로그인 실패 시 다시 로그인 페이지로 이동
    }


}
