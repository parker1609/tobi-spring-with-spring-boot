package com.codemcd.tobispringwithspringboot.dao;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDao userDao = new DaoFactory().userDao();
    }
}
