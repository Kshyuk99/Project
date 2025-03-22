package edu.du.team1.mapper;

import edu.du.team1.entity.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    void insertMember(Member member);
    Member findByEmail(String email);
    Member findById(Long id);
    int updateMember(Member member);
}
