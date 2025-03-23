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
        return memberRepository.save(member); // 새 회원을 DB에 저장
    }

    public Optional<Member> login(String email, String password) {
        Optional<Member> memberOptional = memberRepository.findByEmail(email);
        if (memberOptional.isPresent() && memberOptional.get().getPassword().equals(password)) {
            return memberOptional; // 이메일과 비밀번호 일치 시 로그인 성공
        } else {
            return Optional.empty(); // 일치하지 않으면 로그인 실패
        }
    }

    public Member update(Member member) {
        return memberRepository.save(member); // 회원 정보를 DB에서 업데이트
    }

    public void delete(Long memberId) {
        memberRepository.deleteById(memberId); // 회원 삭제
    }
}
