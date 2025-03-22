package edu.du.login.repository;

import edu.du.login.model.Member;
import java.util.Optional;
import java.util.List;

public interface MemberRepository {
    Member findById(Long id);
    Optional<Member> findByEmail(String email);
    List<Member> findAll();
    Member save(Member member);
}