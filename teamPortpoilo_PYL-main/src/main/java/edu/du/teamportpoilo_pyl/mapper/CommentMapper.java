package edu.du.teamportpoilo_pyl.mapper;

import edu.du.teamportpoilo_pyl.dto.CommentDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("select * from comments where post_id = #{postId}")
    @Results({
            @Result(property = "created", column = "created_at")
    })
    public List<CommentDto> commentSelectByPostId(Long id);

    @Insert("insert into comments (post_id, author, comment) values (#{postId}, #{author}, #{comment})")
    public void insertComment(CommentDto comment);

    @Delete("delete from comments where id = #{id}")
    public void deleteComment(Long id);
}
