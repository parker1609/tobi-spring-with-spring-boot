package com.codemcd.tobispringwithspringboot.dao;

import com.codemcd.tobispringwithspringboot.dao.user.UserDao;
import com.codemcd.tobispringwithspringboot.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDaoTest {

    @Test
    void addAndGet() throws SQLException {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao dao = ac.getBean("userDao", UserDao.class);
        User user = new User();
        user.setId("gyumee");
        user.setName("박성철");
        user.setPassword("springno1");

        dao.add(user);

        User user2 = dao.get(user.getId());

        assertThat(user2.getName()).isEqualTo(user.getName());
        assertThat(user2.getPassword()).isEqualTo(user.getPassword());
    }
}
