package com.codemcd.tobispringwithspringboot.user.service;

import com.codemcd.tobispringwithspringboot.user.dao.UserDao;
import com.codemcd.tobispringwithspringboot.user.domain.Level;
import com.codemcd.tobispringwithspringboot.user.domain.User;

import static com.codemcd.tobispringwithspringboot.user.service.UserService.MIN_LOGIN_COUNT_FOR_SILVER;
import static com.codemcd.tobispringwithspringboot.user.service.UserService.MIN_RECOMMEND_COUNT_FOR_GOLD;

public class UserLevelUpgradeNormalPolicy implements UserLevelUpgradePolicy {
    @Override
    public boolean canUpgradeLevel(User user) {
        Level currentLevel = user.getLevel();
        switch (currentLevel) {
            case BASIC: return (user.getLogin() >= MIN_LOGIN_COUNT_FOR_SILVER);
            case SILVER: return (user.getRecommend() >= MIN_RECOMMEND_COUNT_FOR_GOLD);
            case GOLD: return false;
            default: throw new IllegalArgumentException("Unkown Level: " + currentLevel);
        }
    }

    @Override
    public void upgradeLevel(UserDao userDao, User user) {
        user.upgradeLevel();
        userDao.update(user);
    }
}
