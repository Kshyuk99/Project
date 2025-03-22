package edu.du.team_project.service;

import edu.du.team_project.mapper.NoticeMapper;

import edu.du.team_project.model.Notice;

import edu.du.team_project.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class NoticeService {
    private final NoticeMapper noticeMapper;

    public NoticeService( NoticeMapper noticeMapper) {
        this.noticeMapper = noticeMapper;
    }

    public List<Notice> getAllNotices() {
        return noticeMapper.getAllNotices();
    }

    public Notice getNoticeById(int id) {
        return noticeMapper.getNoticeById(id);
    }

    public void addNotice(Notice notice) {
        noticeMapper.insertNotice(notice);
    }

    public void updateNotice(Notice notice) {
        noticeMapper.updateNotice(notice);
    }

    public void deleteNotice(int id) {
        noticeMapper.deleteNotice(id);
    }
}