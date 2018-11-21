package com.user.user_service.response;

import com.user.user_service.entity.User;

public class GetUserResponse extends HttpResult {
    private User data;

    public void setData(User data) {
        this.data = data;
    }

    public User getData() {
        return data;
    }
}
