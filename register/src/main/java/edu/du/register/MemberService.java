package edu.du.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private static MemberRepository memberRepository;

    public static void signup(MemberDTO memberDto) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setName(memberDto.getName());
        memberEntity.setMemberId(memberDto.getMemberId());
        memberEntity.setPassword(memberDto.getPassword());
        memberEntity.setEmail(memberDto.getEmail());
        memberEntity.setBirth(memberDto.getBirth());

        memberRepository.save(memberEntity);
    }
}