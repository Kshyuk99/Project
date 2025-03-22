package edu.du.login.controller;

import edu.du.login.model.Member;
import edu.du.login.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class UserController {

    private final MemberService memberService;

    @Autowired
    public UserController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/") // 루트 URL 매핑 추가
    public String home() {
        return "login"; // 경로를 "login"으로 수정
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register"; // 경로를 "register"로 수정
    }

    @PostMapping("/register")
    public String register(Member member) {
        memberService.register(member);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login"; // 경로를 "login"으로 수정
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        Optional<Member> memberOptional = memberService.login(email, password);

        if (memberOptional.isPresent()) {
            session.setAttribute("loggedInUser", memberOptional.get());
            return "redirect:/welcome";
        } else {
            model.addAttribute("error", "이메일 또는 비밀번호가 잘못되었습니다.");
            return "login"; // 경로를 "login"으로 수정
        }
    }

    @GetMapping("/welcome")
    public String welcome(HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/login";
        }
        return "welcome"; // 경로를 "welcome"으로 수정
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
