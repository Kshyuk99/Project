package edu.du.board_tymeleaf.controller;
import edu.du.board_tymeleaf.model.Member;
import edu.du.board_tymeleaf.service.MemberService;
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
        return "users/list";
    }


    @GetMapping("/{id}")
    public String viewMember(@PathVariable Long id, Model model) {
        Member member = memberService.getMemberById(id).orElse(null);
        model.addAttribute("member", member);
        return "users/form";
    }


    @GetMapping("/users/write")
    public String newPostForm() {
        return "users/write";
    }


    @PostMapping("/add")
    public String addMember(@ModelAttribute Member member) {
        member.setId(null); // id를 null로 설정하여 새로운 사용자 등록
        memberService.saveMember(member);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editPostForm(@PathVariable Long id, Model model) {
        if (id == 0) {
            // 새로운 사용자 등록 폼을 보여주는 로직
            model.addAttribute("member", new Member()); // 빈 Member 객체 전달
            return "users/edit";
        } else {
            // 기존 사용자 수정 폼을 보여주는 로직
            Member member = memberService.getMemberById(id).orElse(null);
            model.addAttribute("member", member);
            return "users/edit";
        }
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