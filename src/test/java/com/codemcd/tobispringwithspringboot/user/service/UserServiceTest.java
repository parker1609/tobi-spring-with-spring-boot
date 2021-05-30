package com.codemcd.tobispringwithspringboot.user.service;

import com.codemcd.tobispringwithspringboot.config.DaoFactory;
import com.codemcd.tobispringwithspringboot.user.dao.UserDao;
import com.codemcd.tobispringwithspringboot.user.domain.Level;
import com.codemcd.tobispringwithspringboot.user.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.codemcd.tobispringwithspringboot.user.service.UserService.MIN_LOGIN_COUNT_FOR_SILVER;
import static com.codemcd.tobispringwithspringboot.user.service.UserService.MIN_RECOMMEND_COUNT_FOR_GOLD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoFactory.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    @Qualifier("testMailSender")
    private MailSender mailSender;

    private UserDao userDao;
    private List<User> users;

    @BeforeEach
    void setUp() {
        userDao = userService.getUserDao();

        users = Arrays.asList(
                new User("bumjin", "bumjin@spring.io", "박범진", "p1", Level.BASIC, MIN_LOGIN_COUNT_FOR_SILVER - 1, 0),
                new User("joytouch", "joytouch@spring.io", "강명성", "p2", Level.BASIC, MIN_LOGIN_COUNT_FOR_SILVER, 0),
                new User("erwins", "erwins@spring.io", "신승한", "p3", Level.SILVER, 60, MIN_RECOMMEND_COUNT_FOR_GOLD - 1),
                new User("madnite1", "madnite1@spring.io", "이상호", "p4", Level.SILVER, 60, MIN_RECOMMEND_COUNT_FOR_GOLD),
                new User("green", "green@spring.io", "오민규", "p5", Level.GOLD, 100, Integer.MAX_VALUE)
        );
    }

    @Test
    void bean() {
        assertThat(this.userService).isNotNull();
    }

    @Test
    @DirtiesContext
    void upgradeLevels() {
        userDao.deleteAll();
        for (User user : users) {
            userDao.add(user);
        }

        MockMailSender mockMailSender = new MockMailSender();
        userService.setMailSender(mockMailSender);

        userService.upgradeLevels();

        checkLevelUpgraded(users.get(0), false);
        checkLevelUpgraded(users.get(1), true);
        checkLevelUpgraded(users.get(2), false);
        checkLevelUpgraded(users.get(3), true);
        checkLevelUpgraded(users.get(4), false);

        List<String> requests = mockMailSender.getRequests();
        assertThat(requests).hasSize(2);
        assertThat(requests.get(0)).isEqualTo(users.get(1).getEmail());
        assertThat(requests.get(1)).isEqualTo(users.get(3).getEmail());
    }

    private void checkLevelUpgraded(User user, boolean upgraded) {
        User userUpdate = userDao.get(user.getId());
        if (upgraded) {
            assertThat(userUpdate.getLevel()).isEqualTo(user.getLevel().nextLevel());
        } else {
            assertThat(userUpdate.getLevel()).isEqualTo(user.getLevel());
        }
    }

    @Test
    void add() {
        userDao.deleteAll();

        User userWithLevel = users.get(4);
        User userWithoutLevel = users.get(0);
        userWithoutLevel.setLevel(null);

        userService.add(userWithLevel);
        userService.add(userWithoutLevel);

        User userWithLevelRead = userDao.get(userWithLevel.getId());
        User userWithoutLevelRead = userDao.get(userWithoutLevel.getId());

        assertThat(userWithLevelRead.getLevel()).isEqualTo(userWithLevel.getLevel());
        assertThat(userWithoutLevelRead.getLevel()).isEqualTo(userWithoutLevel.getLevel());
    }

    @Test
    void upgradeAllOrNothing() {
        UserService testUserService = new UserService.TestUserService(users.get(3).getId());
        testUserService.setUserDao(this.userDao);
        testUserService.setTransactionManager(transactionManager);
        testUserService.setMailSender(mailSender);

        userDao.deleteAll();
        for (User user : users) {
            userDao.add(user);
        }

        try {
            testUserService.upgradeLevels();
            fail("TestUserServiceException exception");
        } catch (UserService.TestUserService.TestUserServiceException e) {

        }

        checkLevelUpgraded(users.get(1), false);
    }

    static class MockMailSender implements MailSender {

        private List<String> requests = new ArrayList<>();

        public List<String> getRequests() {
            return requests;
        }

        @Override
        public void send(SimpleMailMessage simpleMessage) throws MailException {
            requests.add(Objects.requireNonNull(simpleMessage.getTo())[0]);
        }

        @Override
        public void send(SimpleMailMessage... simpleMessages) throws MailException {

        }
    }
}
