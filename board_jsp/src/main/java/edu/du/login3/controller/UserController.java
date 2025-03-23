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

    @GetMapping
    public String listMembers(Model model) {
        model.addAttribute("users", memberService.getAllMembers());
        return "list";
    }

    @GetMapping("/{id}")
    public String viewMember(@PathVariable Long id, Model model) {
        Member member = memberService.getMemberById(id).orElse(null);
        model.addAttribute("member", member);
        return "form";
    }

    @GetMapping("/write")
    public String newPostForm() {
        return "write";
    }

    @PostMapping("/add")
    public String addMember(@ModelAttribute Member member) {
        memberService.saveMember(member);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editPostForm(@PathVariable Long id, Model model) {
        Member member = memberService.getMemberById(id).orElse(null);
        model.addAttribute("member", member);
        return "edit";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute Member member) {
        memberService.saveMember(member);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deletePost(@RequestParam Long id) {
        memberService.deleteMember(id);
        return "redirect:/users";
    }
}
