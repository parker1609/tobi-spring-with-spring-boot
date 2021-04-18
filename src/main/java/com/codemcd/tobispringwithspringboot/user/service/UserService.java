package com.codemcd.tobispringwithspringboot.user.service;

import com.codemcd.tobispringwithspringboot.user.dao.UserDao;
import com.codemcd.tobispringwithspringboot.user.domain.Level;
import com.codemcd.tobispringwithspringboot.user.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class UserService {
    public static final int MIN_LOGIN_COUNT_FOR_SILVER = 50;
    public static final int MIN_RECOMMEND_COUNT_FOR_GOLD = 30;

    private UserDao userDao;
    private final UserLevelUpgradePolicy userLevelUpgradePolicy;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void upgradeLevels() {
        List<User> users = userDao.getAll();
        for (User user: users) {
            if (userLevelUpgradePolicy.canUpgradeLevel(user)) {
                userLevelUpgradePolicy.upgradeLevel(userDao, user);
            }
        }
    }

    public void add(User user) {
        if (user.getLevel() == null) {
            user.setLevel(Level.BASIC);
        }

        userDao.add(user);
    }
}
