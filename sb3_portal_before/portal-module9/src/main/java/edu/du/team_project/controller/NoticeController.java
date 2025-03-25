package edu.du.team_project.controller;

import edu.du.team_project.model.Notice;


import edu.du.team_project.service.NoticeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {
    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    //게시판 목록 페이지
    @GetMapping
    public String listNotice(@RequestParam(defaultValue = "0") int page,
                             Model model) {
        int pageSize = 3;

        List<Notice> pagedNotices = noticeService.getNoticesByPage(page, pageSize);
        int totalNotices = noticeService.getTotalNoticeCount();
        int totalPages = (int) Math.ceil((double) totalNotices / pageSize);

        model.addAttribute("notice", pagedNotices);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        return "notice";
    }


    // 글 상세보기
    @GetMapping("/{id}")
    public String viewNotice(@PathVariable int id, Model model) {
        Notice notice = noticeService.getNoticeById(id);
        model.addAttribute("notice", notice);
        return "noticedetail";
    }

    // 글 작성 페이지
    @GetMapping("/write")
    public String newNoticeForm() {
        return "noticewrite";
    }

    // 글 작성 처리
    @PostMapping("/add")
    public String addNotice(@ModelAttribute Notice notice) {
        noticeService.addNotice(notice);
        return "redirect:/notice";
    }

    // 글 수정 페이지
    @GetMapping("/edit/{id}")
    public String editNoticeForm(@PathVariable int id, Model model) {
        Notice notice = noticeService.getNoticeById(id);
        model.addAttribute("notice", notice);
        return "editNotice";
    }

    // 글 수정 처리
    @PostMapping("/update")
    public String updateNotice(@ModelAttribute  Notice notice) {
        noticeService.updateNotice(notice);
        return "redirect:/notice";
    }

    // 글 삭제
    @PostMapping("/delete")
    public String deleteNotice(@RequestParam int id) {
        noticeService.deleteNotice(id);
        return "redirect:/notice";
    }
}