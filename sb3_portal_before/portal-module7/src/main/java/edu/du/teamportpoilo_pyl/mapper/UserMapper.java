package edu.du.teamportpoilo_pyl.mapper;

import edu.du.teamportpoilo_pyl.dto.UserDto;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("insert into users (username, password, name, email) values (#{userid}, #{password}, #{name}, #{email})")
    @Results({
            @Result(property = "userId", column = "username"),
            @Result(property = "created", column = "created_at")
    })
    public void insertUser(UserDto user);
}
