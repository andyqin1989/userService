package com.user.user_service.response;

import com.user.user_service.entity.User;

import java.util.List;

public class AllUserResponse extends HttpResult {
    private List<User> data;

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
