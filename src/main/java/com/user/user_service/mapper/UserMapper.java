package com.user.user_service.mapper;

import com.user.user_service.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user_info where id=1")
    User findById();

    @Select("select * from user_info")
    List<User> getAllUser();
}
