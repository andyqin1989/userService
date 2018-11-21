package com.user.user_service.controller;

import com.user.user_service.entity.GetUserByIdEntity;
import com.user.user_service.entity.User;
import com.user.user_service.mapper.UserMapper;
import com.user.user_service.response.AllUserResponse;
import com.user.user_service.response.HttpResult;
import com.user.user_service.response.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "/getUser", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8", consumes = "application/json")
    public HttpResult getUserById(@RequestBody GetUserByIdEntity entity) {
        int id = entity.getId();
        User user = userMapper.findById(id);

        GetUserResponse response = new GetUserResponse();
        response.setData(user);
        response.setCode(1);
        response.setMessage("获取用户信息成功");

        return response;
    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public HttpResult getAllUser() {
        List<User> users = userMapper.getAllUser();
        AllUserResponse response = new AllUserResponse();
        response.setCode(1);
        response.setMessage("获取所以用户信息成功");
        response.setData(users);
        return response;
    }
}