package com.user.user_service.entity;

import java.io.Serializable;

public class GetUserByIdEntity implements Serializable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
