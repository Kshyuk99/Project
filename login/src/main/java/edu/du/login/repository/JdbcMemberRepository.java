package edu.du.login.repository;

import edu.du.login.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcMemberRepository implements MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcMemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Member> rowMapper = new RowMapper<Member>() {
        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Member(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("password"),
                    rs.getString("email")
            );
        }
    };

    @Override
    public Member findById(Long id) {
        String sql = "SELECT * FROM member WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        String sql = "SELECT * FROM member WHERE email = ?";
        List<Member> members = jdbcTemplate.query(sql, rowMapper, email);
        if (members.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(members.get(0));
        }
    }

    @Override
    public List<Member> findAll() {
        String sql = "SELECT * FROM member";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Member save(Member member) {
        String sql;
        if (member.getId() == null) {
            sql = "INSERT INTO member (name, password, email) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, member.getName(), member.getPassword(), member.getEmail());
            return findByEmail(member.getEmail()).get();
        } else {
            sql = "UPDATE member SET name = ?, password = ?, email = ? WHERE id = ?";
            jdbcTemplate.update(sql, member.getName(), member.getPassword(), member.getEmail(), member.getId());
            return member;
        }
    }

    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM member WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
