package edu.du.team_project.controller;

import edu.du.team_project.model.User;
import edu.du.team_project.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(produces = "text/html;charset=UTF-8")
public class LoginController {

    private final UserService userService;



    // 로그인 페이지 (GET)
    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // login.jsp 로 이동
    }

    // 로그인 처리 (POST)
    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpSession session, Model model) {

        User user = userService.login(email, password);

        if (user != null) {
            session.setAttribute("loggedInUser", user);
            return "redirect:/"; // 로그인 성공 시 index 페이지로 이동
        } else {
            model.addAttribute("error", "이메일 또는 비밀번호가 잘못되었습니다.");
            return "login"; // 로그인 실패 시 다시 로그인 페이지로 이동
        }
    }

    // 로그아웃 처리
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 삭제 (로그아웃)
        return "redirect:/"; // 로그아웃 후 메인 페이지로 이동
    }
}