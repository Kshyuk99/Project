package edu.du.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class memberController {
    @Autowired

    @PostMapping("/api/signup")
    public void signup(@RequestParam String name, @RequestParam String memberId, @RequestParam String password, @RequestParam String email, @RequestParam Date birth){
        MemberDTO memberDto = new MemberDTO();
        memberDto.setMemberId(memberId);
        memberDto.setPassword(password);
        memberDto.setBirth(birth);
        memberDto.setName(name);
        memberDto.setEmail(email);
        MemberService.signup(memberDto);
    }

    // view 반환
    @GetMapping("/member/signup")
    public String signupForm(){
        return "signup";
    }
}


