package com.user.user_service.controller;

import com.user.user_service.entity.*;
import com.user.user_service.mapper.AppMapper;
import com.user.user_service.response.HttpResult;
import com.user.user_service.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app")
public class AppController {
    @Autowired
    AppMapper appMapper;

    @RequestMapping(value = "/register", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8", consumes = "application/json;charset=UTF-8")
    public HttpResult registerAccount(@RequestBody RegisterEntity registerEntity) {
        String phone = registerEntity.getPhoneNum();
        String passWord = registerEntity.getPassWord();
        String name = registerEntity.getUserName();

        HttpResult response = new HttpResult();

        if (!StringUtil.getNameError(name).isEmpty()) {
            response.setMessage(StringUtil.getNameError(name));
            return response;
        }

        if (StringUtil.isNotPhoneNum(phone)) {
            response.setMessage(StringUtil.getPhoneNumError(phone));
            return response;
        }

        if (StringUtil.isNotPassWord(passWord)) {
            response.setMessage(StringUtil.getPassWordError(passWord));
            return response;
        }

        if (appMapper.getUserByPhoneNum(phone) != null) {
            response.setMessage("账号已存在，请直接登录");
            response.setCode(10000);
            return response;
        }

        int result = appMapper.registerAccount(name, phone, passWord);
        System.out.println("result = " + result);
        if (result >= 0) {
            response.setMessage("账号注册成功");
            return response;
        } else {
            response.setMessage("账号注册失败");
            response.setCode(10000);
            return response;
        }
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8", consumes = "application/json")
    public HttpResult<AccountEntity> loginByPhoneNum(@RequestBody LoginEntity loginEntity) {
        HttpResult<AccountEntity> response = new HttpResult<>();
        if (StringUtil.isEmpty(loginEntity.getPhoneNum())) {
            response.setMessage("电话号码不能为空");
            response.setCode(10000);
            return response;
        }

        AccountEntity accountEntity = appMapper.getUserByPhoneNum(loginEntity.getPhoneNum());
        if (accountEntity != null) {
            if (accountEntity.getPassWord().equals(loginEntity.getPassWord())) {
                response.setData(accountEntity);
                response.setMessage("登录成功");
            } else {
                response.setCode(10000);
                response.setMessage("密码不正确，请重新输入");
            }
        } else {
            response.setCode(10000);
            response.setMessage("用户不存在，请先注册");
        }
        return response;
    }

    @RequestMapping(value = "addBlog", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8", consumes = "application/json")
    public HttpResult addBlogSucceed(@RequestBody AddBlogEntity blogEntity) {
        HttpResult response = new HttpResult();
        String phoneNum = blogEntity.getPhoneNum();
        String titleName = blogEntity.getTitleName();
        String titleContent = blogEntity.getBlogContent();

        if (phoneNum == null || phoneNum.isEmpty()) {
            response.setCode(10000);
            response.setMessage("电话号码不能为空");
            return response;
        }

        if (titleName == null || titleName.isEmpty()) {
            response.setCode(10000);
            response.setMessage("博文名称不能为空");
            return response;
        }
        int result = appMapper.addBlog(phoneNum, titleName, titleContent, blogEntity.getContentType());
        response.setCode(result > 0 ? 0 : 10000);
        response.setMessage(result > 0 ? "博文添加成功" : "博文添加失败");
        return response;
    }

    @RequestMapping(value = "getAllBlog", method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8", consumes = "application/json")
    public HttpResult<List<BlogEntity>> getAllBlog(@RequestBody PhoneEntity phoneEntity) {
        HttpResult<List<BlogEntity>> response = new HttpResult<>();
        String phoneNum = phoneEntity.getPhoneNum();

        if (phoneNum == null || phoneNum.isEmpty()) {
            response.setCode(10000);
            response.setMessage("电话号码不能为空");
            return response;
        }

        List<BlogEntity> result = appMapper.getAllBlog(phoneNum);
        response.setData(result);
        response.setCode(result != null ? 0 : 10000);
        response.setMessage(result != null ? "获取所有博文成功" : "获取所有博文失败");
        return response;
    }
}