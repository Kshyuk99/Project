package edu.du.board_tymeleaf.service;

import edu.du.board_tymeleaf.model.Member;
import edu.du.board_tymeleaf.repository.UserRepository;
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

    public List<Member> getAllMembers() {
        return userRepository.findAll();
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
