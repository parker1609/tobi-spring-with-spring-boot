package com.codemcd.tobispringwithspringboot.user.service;

import com.codemcd.tobispringwithspringboot.config.DaoFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoFactory.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void bean() {
        assertThat(this.userService).isNotNull();
    }
}
