package com.example.demo.repository;

import com.example.demo.model.Board;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class BoardRepository {
    private final JdbcTemplate jdbcTemplate;

    public BoardRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // ✅ 게시글 목록 조회
    public List<Board> findAll() {
        String sql = "SELECT * FROM board ORDER BY created_at DESC";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Board(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("writer"),
                        rs.getTimestamp("created_at").toLocalDateTime()
                ));
    }
}
