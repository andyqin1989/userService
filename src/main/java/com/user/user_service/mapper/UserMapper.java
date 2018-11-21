package com.user.user_service.mapper;

import com.user.user_service.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user_info where id = #{id}")
    User findById(int id);

    @Select("select * from user_info")
    List<User> getAllUser();
}
