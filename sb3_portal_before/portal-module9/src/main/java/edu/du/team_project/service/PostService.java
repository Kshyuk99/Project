package edu.du.team_project.service;

import edu.du.team_project.mapper.PostRepository;
import edu.du.team_project.model.Post;


import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.getAllPosts();
    }

    public Post getPostById(int id) {
        return postRepository.getPostById(id);
    }

    public void addPost(Post post) {
        postRepository.insertPost(post);
    }

    public void updatePost(Post post) {
        postRepository.updatePost(post);
    }

    public void deletePost(int id) {
        postRepository.deletePost(id);
    }

    public List<Post> getPostsByPage(int page, int size) {
        int start = page * size;
        int end = Math.min(start + size, postRepository.getAllPosts().size());
        return postRepository.getAllPosts().subList(start, end);
    }

    public int getTotalPostCount() {
        return postRepository.getAllPosts().size();
    }
}