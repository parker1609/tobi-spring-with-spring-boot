package com.codemcd.tobispringwithspringboot.dao.user;

import com.codemcd.tobispringwithspringboot.domain.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    User get(String id);
    List<User> getAll();
    void deleteAll();
    int getCount();
}
