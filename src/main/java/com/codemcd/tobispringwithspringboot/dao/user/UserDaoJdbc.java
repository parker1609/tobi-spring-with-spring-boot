package com.codemcd.tobispringwithspringboot.dao.user;

import com.codemcd.tobispringwithspringboot.domain.Level;
import com.codemcd.tobispringwithspringboot.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;

public class UserDaoJdbc implements UserDao {
    private JdbcTemplate jdbcTemplate;
    private RowMapper<User> userMapper = (rs, rowNum) -> {
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        user.setLevel(Level.valueOf(rs.getInt("level")));
        user.setLogin(rs.getInt("login"));
        user.setRecommend(rs.getInt("recommend"));

        return user;
    };

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void add(final User user) {
        this.jdbcTemplate.update("INSERT INTO users(id, name, password, level, login, recommend) " +
                        "VALUES (?, ?, ?, ?, ?, ?)",
                user.getId(), user.getName(), user.getPassword()
                , user.getLevel().getValue(), user.getLogin(), user.getRecommend());
    }

    public User get(String id) {
        return this.jdbcTemplate.queryForObject("select * from users where id = ?",
                new Object[]{id},
                this.userMapper
        );
    }

    public void deleteAll() {
        this.jdbcTemplate.update("delete from users");
    }

    public int getCount() {
        return this.jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
    }

    public List<User> getAll() {
        return this.jdbcTemplate.query("select * from users order by id",
                this.userMapper
        );
    }

    @Override
    public void update(User user) {
        this.jdbcTemplate.update(
                "UPDATE users SET name = ?, password = ?, level = ?, login = ?, recommend = ? WHERE id = ?",
                user.getName(), user.getPassword(), user.getLevel().getValue(), user.getLogin(), user.getRecommend(),
                user.getId());
    }
}
