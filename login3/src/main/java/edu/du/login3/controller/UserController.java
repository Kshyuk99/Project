package edu.du.login3.controller;

import edu.du.login3.model.Member;
import edu.du.login3.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final MemberService memberService;

    public UserController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 게시판 목록
    @GetMapping
    public String listMembers(Model model) {
        model.addAttribute("users", memberService.getAllMembers());
        return "list"; // list.jsp
    }

    // 글 상세보기
    @GetMapping("/{id}")
    public String viewMember(@PathVariable Long id, Model model) {
        Member member = memberService.getMemberById(id).orElse(null); // Optional 처리
        model.addAttribute("member", member);
        return "form"; // form.jsp
    }

    // 글 작성 페이지
    @GetMapping("/write")
    public String newPostForm() {
        return "write"; // write.jsp
    }

    // 글 작성 처리
    @PostMapping("/add")
    public String addMember(@ModelAttribute Member member) {
        memberService.saveMember(member); // saveMember 호출
        return "redirect:/users";
    }

    // 글 수정 페이지
    @GetMapping("/edit/{id}")
    public String editPostForm(@PathVariable Long id, Model model) {
        Member member = memberService.getMemberById(id).orElse(null); // Optional 처리
        model.addAttribute("member", member);
        return "edit"; // edit.jsp
    }

    // 글 수정 처리
    @PostMapping("/update")
    public String updatePost(@ModelAttribute Member member) {
        memberService.saveMember(member); // saveMember 호출
        return "redirect:/users";
    }

    // 글 삭제
    @PostMapping("/delete")
    public String deletePost(@RequestParam Long id) {
        memberService.deleteMember(id);
        return "redirect:/users";
    }
}