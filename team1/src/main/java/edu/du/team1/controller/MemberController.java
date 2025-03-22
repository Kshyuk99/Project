package edu.du.team1.controller;

import edu.du.team1.entity.Member;
import edu.du.team1.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("member", new Member());
        return "register";
    }

    @PostMapping("/register")
    public String registerMember(@ModelAttribute Member member) {
        memberService.registerMember(member);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {
        Member member = memberService.findByEmail(email);
        if (member != null && member.getPassword().equals(password)) {
            return "redirect:/board";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }

    @GetMapping("/board")
    public String board(Model model) {
        // 게시글 목록을 가져와서 화면에 표시
        return "board";
    }
}
