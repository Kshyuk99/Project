package com.example.demo.controller;

import com.example.demo.model.Board;
import com.example.demo.service.BoardService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // ✅ 게시글 목록 조회
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("boards", boardService.getAllBoards());
        return "/list";
    }
}
