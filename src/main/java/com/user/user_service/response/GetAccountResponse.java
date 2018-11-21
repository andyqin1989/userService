package com.user.user_service.response;

import com.user.user_service.entity.AccountEntity;

public class GetAccountResponse extends HttpResult {
    private AccountEntity data;

    public void setData(AccountEntity data) {
        this.data = data;
    }

    public AccountEntity getData() {
        return data;
    }
}
