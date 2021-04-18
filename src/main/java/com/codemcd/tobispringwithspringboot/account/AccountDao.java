package com.codemcd.tobispringwithspringboot.account;

import com.codemcd.tobispringwithspringboot.connection.ConnectionMaker;

public class AccountDao {
    private final ConnectionMaker connectionMaker;

    public AccountDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }
}
