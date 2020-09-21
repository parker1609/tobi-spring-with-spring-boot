package com.codemcd.tobispringwithspringboot.dao;

import com.codemcd.tobispringwithspringboot.dao.user.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao userDao = context.getBean("userDao", UserDao.class);
    }

    @Test
    void list_1_20() {
        DaoFactory daoFactory = new DaoFactory();
        UserDao userDao1 = daoFactory.userDao();
        UserDao userDao2 = daoFactory.userDao();

        System.out.println(userDao1);
        System.out.println(userDao2);
    }
}
