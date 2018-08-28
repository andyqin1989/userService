package com.user.user_service.controller;

import com.user.user_service.entity.User;
import com.user.user_service.mapper.UserMapper;
import com.user.user_service.response.AllUserResponse;
import com.user.user_service.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserMapper userMapper;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello";
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public User getUserById() {
        User user = userMapper.findById();
        return user;
    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public BaseResponse getAllUser() {
        List<User> users = userMapper.getAllUser();
        AllUserResponse response = new AllUserResponse();
        response.setStatus(1);
        response.setMessage("获取所以用户信息成功");
        response.setData(users);
        return response;
    }
}