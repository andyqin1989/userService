package com.user.user_service.mapper;

import com.user.user_service.entity.AccountEntity;
import com.user.user_service.entity.BlogEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AppMapper {

    @Insert({"insert ignore into account (userName,phoneNum, passWord, createTime) values (#{name}, #{phone}, #{pass}, now())"})
    int registerAccount(@Param("name") String userName, @Param("phone") String phoneNum, @Param("pass") String passWord);

    @Select("select * from account where phoneNum = #{phoneNum}")
    AccountEntity getUserByPhoneNum(String phoneNum);

    @Insert({"insert ignore into blog (phoneNum, titleName, blogContent, contentType, createTime) values (#{phone}, #{titleName}, #{blogContent}, #{type},now())"})
    int addBlog(@Param("phone") String phoneNum, @Param("titleName") String titleName, @Param("blogContent") String blogContent, @Param("type") int type);

    @Select("select * from blog where phoneNum = #{phoneNum} order by createTime desc")
    List<BlogEntity> getAllBlog(String phoneNum);
}