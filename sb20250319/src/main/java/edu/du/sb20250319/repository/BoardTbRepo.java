package edu.du.sb20250319.repository;

import edu.du.sb20250319.entity.BoardTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardTbRepo extends JpaRepository<BoardTb, Integer> {

}
