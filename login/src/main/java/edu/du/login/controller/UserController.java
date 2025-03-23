package edu.du.login.controller;

import edu.du.login.model.Member;
import edu.du.login.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping("/") // 루트 URL 매핑, 기본 경로
    public String home() {
        return "register"; // 회원가입 페이지로 리다이렉트
    }

    @GetMapping("/register")
    public String registerForm() {
        return "register"; // 회원가입 폼
    }

    @PostMapping("/register")
    public String register(Member member, Model model) {
        try {
            memberService.register(member);
            return "redirect:/login"; // 회원가입 후 로그인 페이지로 리다이렉트
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage()); // 중복 이메일 처리
            return "register";  // 오류 발생 시 다시 회원가입 페이지로 돌아가기
        }
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login"; // 로그인 폼
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        Optional<Member> memberOptional = memberService.login(email, password);

        if (memberOptional.isPresent()) {
            session.setAttribute("loggedInUser", memberOptional.get()); // 세션에 로그인 사용자 저장
            return "redirect:/welcome"; // 로그인 후 환영 페이지로 이동
        } else {
            model.addAttribute("error", "이메일 또는 비밀번호가 잘못되었습니다."); // 로그인 실패 시 오류 메시지
            return "login"; // 로그인 폼으로 다시 돌아가기
        }
    }

    @GetMapping("/welcome")
    public String welcome(HttpSession session, Model model) {
        Member loggedInUser = (Member) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login"; // 로그인 안된 경우 로그인 페이지로 리다이렉트
        }
        model.addAttribute("member", loggedInUser); // 로그인한 사용자의 정보를 모델에 추가
        return "welcome"; // 회원 정보를 보여주는 페이지
    }

    @PostMapping("/update")
    public String updateMember(@ModelAttribute Member member, HttpSession session) {
        Member loggedInUser = (Member) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login"; // 로그인되지 않은 경우 로그인 페이지로 이동
        }
        member.setId(loggedInUser.getId()); // 로그인한 사용자의 ID로 업데이트
        memberService.update(member); // 회원 정보를 서비스에서 업데이트
        session.setAttribute("loggedInUser", member); // 세션에 업데이트된 정보 반영
        return "redirect:/welcome"; // 수정 후 환영 페이지로 이동
    }

    @GetMapping("/delete")
    public String deleteMember(HttpSession session) {
        Member loggedInUser = (Member) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login"; // 로그인되지 않은 경우 로그인 페이지로 이동
        }

        memberService.delete(loggedInUser.getId()); // 사용자 삭제
        session.invalidate(); // 세션 무효화
        return "redirect:/"; // 홈으로 리다이렉트 (로그인 페이지로 이동)
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 무효화
        return "redirect:/login"; // 로그아웃 후 로그인 페이지로 리다이렉트
    }
}
