package edu.du.sb20250319.repository;


import edu.du.sb20250319.dto.UserDto;
import edu.du.sb20250319.entity.UserTb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserTbRepo extends JpaRepository<UserTb, Integer> {
    List<UserTb> findAllById(String id);

    void deleteByNo(int no);

    UserDto findAllByNo(int no);
}
