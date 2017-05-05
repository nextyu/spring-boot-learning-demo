package com.nextyu.service.impl;

import com.nextyu.domain.User;
import com.nextyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate primaryJdbcTemplate;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate secondaryJdbcTemplate;

    @Override
    public Boolean saveUser(User user) {
        secondaryJdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", user.getName(), user.getAge());
        return primaryJdbcTemplate.update("insert into USER(NAME, AGE) values(?, ?)", user.getName(), user.getAge()) > 0;
    }

    @Override
    public Integer countAllUser() {
        return primaryJdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }

    @Override
    public List<User> listALLUser() {
        return null;
    }

    @Override
    public Boolean deleteAllUser() {
        secondaryJdbcTemplate.update("delete from USER");
        return primaryJdbcTemplate.update("delete from USER") > 0;
    }
}
