package edu.du.team1.service;

import edu.du.team1.entity.Post;
import edu.du.team1.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;

    public List<Post> findAllPosts() {
        return postMapper.findAllPosts();
    }

    public Post findById(Long id) {
        return postMapper.findById(id);
    }

    public void insertPost(Post post) {
        postMapper.insertPost(post);
    }

    public void updatePost(Post post) {
        postMapper.updatePost(post);
    }

    public void deletePost(Long id) {
        postMapper.deletePost(id);
    }
}
