package com.nextyu.service.impl;

import com.nextyu.domain.User;
import com.nextyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created on 2017-05-05 10:41
 *
 * @author nextyu
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Boolean saveUser(User user) {
        return jdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", user.getName(), user.getAge()) > 0;
    }

    @Override
    public Integer countAllUser() {
        return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }

    @Override
    public List<User> listALLUser() {
        return null;
    }

    @Override
    public Boolean deleteAllUser() {
        return jdbcTemplate.update("delete from USER") > 0;
    }
}
