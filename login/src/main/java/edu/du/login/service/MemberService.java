package edu.du.login.service;

import edu.du.login.model.Member;
import edu.du.login.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member register(Member member) {
        return memberRepository.save(member);
    }

    public Optional<Member> login(String email, String password) {
        Optional<Member> memberOptional = memberRepository.findByEmail(email);

        if (memberOptional.isPresent() && memberOptional.get().getPassword().equals(password)) {
            return memberOptional;
        } else {
            return Optional.empty();
        }
    }
}