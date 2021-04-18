package com.codemcd.tobispringwithspringboot.user.service;

import com.codemcd.tobispringwithspringboot.user.dao.UserDao;
import com.codemcd.tobispringwithspringboot.user.domain.User;

public interface UserLevelUpgradePolicy {
    boolean canUpgradeLevel(User user);
    void upgradeLevel(UserDao userDao, User user);
}
