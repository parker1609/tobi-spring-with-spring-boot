package com.codemcd.tobispringwithspringboot.dao.account;

import com.codemcd.tobispringwithspringboot.dao.ConnectionMaker;

public class AccountDao {
    private final ConnectionMaker connectionMaker;

    public AccountDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }
}
