package edu.du.team1.service;

import edu.du.team1.entity.Member;
import edu.du.team1.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;

    public void registerMember(Member member) {
        memberMapper.insertMember(member);
    }

    public Member findByEmail(String email) {
        return memberMapper.findByEmail(email);
    }

    public Member findById(Long id) {
        return memberMapper.findById(id);
    }

    public int updateMember(Member member) {
        return memberMapper.updateMember(member);
    }
}
