package edu.du.sb20250319.service;

import edu.du.sb20250319.entity.BoardTb;
import edu.du.sb20250319.repository.BoardTbRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardTbRepo boardTbRepo;

    public BoardService(BoardTbRepo boardTbRepo) {
        this.boardTbRepo = boardTbRepo;
    }

    public List<BoardTb> findAll() {
        return boardTbRepo.findAll();
    }

}
