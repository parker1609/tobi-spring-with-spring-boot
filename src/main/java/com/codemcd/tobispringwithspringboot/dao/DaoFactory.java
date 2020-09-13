package com.codemcd.tobispringwithspringboot.dao;

import com.codemcd.tobispringwithspringboot.dao.account.AccountDao;
import com.codemcd.tobispringwithspringboot.dao.message.MessageDao;
import com.codemcd.tobispringwithspringboot.dao.user.UserDao;

public class DaoFactory {
    public UserDao userDao() {
        return new UserDao(getConnectionMaker());
    }

    public AccountDao accountDao() {
        return new AccountDao(getConnectionMaker());
    }

    public MessageDao messageDao() {
        return new MessageDao(getConnectionMaker());
    }

    private ConnectionMaker getConnectionMaker() {
        return new DConnectionMaker();
    }
}
