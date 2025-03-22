package edu.du.login3.service;

import edu.du.login3.model.Member;
import edu.du.login3.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {

    private final UserRepository userRepository;

    public MemberService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 기존 메소드들
    public List<Member> getAllMembers() {
        return userRepository.findAll();  // userRepository에서 모든 회원 정보를 가져옵니다.
    }

    public Optional<Member> getMemberById(Long id) {
        return Optional.ofNullable(userRepository.findById(id));
    }

    public void saveMember(Member member) {
        userRepository.save(member);
    }

    public void deleteMember(Long id) {
        userRepository.deleteById(id);
    }
}
