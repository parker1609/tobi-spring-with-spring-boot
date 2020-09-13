package com.codemcd.tobispringwithspringboot.dao.message;

import com.codemcd.tobispringwithspringboot.dao.ConnectionMaker;

public class MessageDao {
    private final ConnectionMaker connectionMaker;

    public MessageDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }
}
