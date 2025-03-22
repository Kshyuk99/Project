package edu.du.team1.mapper;

import edu.du.team1.entity.Post;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface PostMapper {
    List<Post> findAllPosts();
    Post findById(Long id);
    void insertPost(Post post);
    void updatePost(Post post);
    void deletePost(Long id);
}
