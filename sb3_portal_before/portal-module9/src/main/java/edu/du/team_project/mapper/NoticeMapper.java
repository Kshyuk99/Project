package edu.du.team_project.mapper;

import edu.du.team_project.model.Notice;

import edu.du.team_project.model.Post;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoticeMapper {

    @Select("SELECT id, title, content, author, created_at as createdAt, updated_at as updatedAt FROM notices ORDER BY id desc ")
    List<Notice> getAllNotices();

    @Select("SELECT id, title, content, author, created_at as createdAt, updated_at as updatedAt FROM notices WHERE id=#{id}")
    Notice getNoticeById(int id);

    @Insert("INSERT INTO notices (title, content, author, created_at) VALUES (#{title}, #{content}, #{author}, NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertNotice(Notice notice);

    @Update("UPDATE notices SET title=#{title}, content=#{content}, updated_at = NOW() WHERE id=#{id}")
    void updateNotice(Notice notice);

    @Delete("DELETE FROM notices WHERE id=#{id}")
    void deleteNotice(int id);
}