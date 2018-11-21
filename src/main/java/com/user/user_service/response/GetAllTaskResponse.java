package com.user.user_service.response;

import com.user.user_service.entity.BlogEntity;

import java.util.List;

public class GetAllTaskResponse extends HttpResult {
    private List<BlogEntity> data;

    public List<BlogEntity> getData() {
        return data;
    }

    public void setData(List<BlogEntity> data) {
        this.data = data;
    }
}
