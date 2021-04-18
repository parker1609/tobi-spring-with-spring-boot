package com.codemcd.tobispringwithspringboot.message;

import com.codemcd.tobispringwithspringboot.connection.ConnectionMaker;

public class MessageDao {
    private final ConnectionMaker connectionMaker;

    public MessageDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }
}
