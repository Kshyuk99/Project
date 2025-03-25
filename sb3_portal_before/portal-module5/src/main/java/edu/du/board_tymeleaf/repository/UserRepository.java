package edu.du.board_tymeleaf.repository;

import edu.du.board_tymeleaf.model.Member;
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
    public Member findById(Long id) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM member WHERE id = ?", new UserRowMapper(), id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

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

    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM member WHERE id = ?", id);
    }

    public List<Member> findAll() {
        return jdbcTemplate.query("SELECT * FROM member", new UserRowMapper());
    }

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
