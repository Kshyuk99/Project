package edu.du.login3.repository;

import edu.du.login3.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 사용자 ID로 회원 조회
    public Member findById(Long id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM member WHERE id = ?", new UserRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            return null; // 예외 처리
        }
    }

    // 회원 저장 또는 수정
    public void save(Member member) {
        if (member.getId() == null) {
            jdbcTemplate.update(
                    "INSERT INTO member (name, password, email) VALUES (?, ?, ?)",
                    member.getName(), member.getPassword(), member.getEmail()
            );
        } else {
            jdbcTemplate.update(
                    "UPDATE member SET name = ?, email = ?, password = ? WHERE id = ?",
                    member.getName(), member.getEmail(), member.getPassword(), member.getId()
            );
        }
    }

    // 사용자 삭제
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM member WHERE id = ?", id);
    }

    // 모든 회원 조회
    public List<Member> findAll() {
        return jdbcTemplate.query("SELECT * FROM member", new UserRowMapper());
    }

    // 사용자 정보를 RowMapper로 변환
    private static class UserRowMapper implements RowMapper<Member> {
        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Member(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("email")
            );
        }
    }
}
