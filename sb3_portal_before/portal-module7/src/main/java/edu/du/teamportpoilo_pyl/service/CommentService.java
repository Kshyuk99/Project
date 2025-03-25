package edu.du.teamportpoilo_pyl.service;

import edu.du.teamportpoilo_pyl.dto.CommentDto;
import edu.du.teamportpoilo_pyl.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentMapper commentMapper;

    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    public List<CommentDto> getAllComments(Long id) {
        return commentMapper.commentSelectByPostId(id);
    }

    public void insertComment(CommentDto comment) {
        commentMapper.insertComment(comment);
    }

    public void deleteComment(Long id) {
        commentMapper.deleteComment(id);
    }
}
