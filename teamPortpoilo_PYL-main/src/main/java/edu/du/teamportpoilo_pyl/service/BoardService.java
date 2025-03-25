package edu.du.teamportpoilo_pyl.service;

import edu.du.teamportpoilo_pyl.dto.BoardDto;
import edu.du.teamportpoilo_pyl.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<BoardDto> getAllBoardsByPage(int page, int size) {
        int offset = (page - 1) * size;
        return boardMapper.boardSelectAllByPage(size, offset);
    }

    public int getTotalPages(int size) {
        int totalBoards = boardMapper.countBoards();
        return (int) Math.ceil((double) totalBoards / size);
    }

    public BoardDto getBoardById (Long id) {
        boardMapper.boardViews(id);
        return boardMapper.boardSelectById(id);
    }

    public void insertBoard(BoardDto board) {
       boardMapper.boardInsert(board);
    }

    public void updateBoard(BoardDto board, Long id) {
        boardMapper.boardUpdate(board, id);
    }

    public void deleteBoard(Long id) {
        boardMapper.boardDelete(id);
    }

    public void likeBoard(Long id) {
        boardMapper.boardLikes(id);
    }
}
