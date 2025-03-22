package edu.du.team1.controller;

import edu.du.team1.entity.Post;
import edu.du.team1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // 게시글 목록 페이지
    @GetMapping("/board")
    public String showBoard(Model model) {
        model.addAttribute("posts", postService.findAllPosts());
        return "board";
    }

    // 게시글 작성 페이지
    @GetMapping("/write")
    public String showWritePage(Model model) {
        model.addAttribute("post", new Post());
        return "write";
    }

    // 게시글 작성 완료 처리
    @PostMapping("/write")
    public String createPost(@ModelAttribute Post post) {
        postService.insertPost(post);
        return "redirect:/board";
    }

    // 게시글 상세 보기
    @GetMapping("/post/{id}")
    public String showPost(@PathVariable Long id, Model model) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        return "post";
    }

    // 게시글 수정 페이지
    @GetMapping("/edit/{id}")
    public String showEditPage(@PathVariable Long id, Model model) {
        Post post = postService.findById(id);
        model.addAttribute("post", post);
        return "edit";
    }

    // 게시글 수정 처리
    @PostMapping("/edit/{id}")
    public String updatePost(@PathVariable Long id, @ModelAttribute Post post) {
        post.setId(id);
        postService.updatePost(post);
        return "redirect:/post/" + id;
    }

    // 게시글 삭제 처리
    @GetMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return "redirect:/board";
    }
}
