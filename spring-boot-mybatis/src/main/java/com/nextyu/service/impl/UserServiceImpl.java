package com.nextyu.service.impl;

import com.nextyu.dao.UserMapper;
import com.nextyu.domain.User;
import com.nextyu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserMapper userMapper;

    @Override
    public Boolean saveUser(User user) {
        return userMapper.insertSelective(user) > 0;
    }

    @Override
    public Integer countAllUser() {
        return userMapper.countAllUser();
    }

    @Override
    public List<User> listALLUser() {
        return null;
    }

    @Override
    public Boolean deleteAllUser() {
        return userMapper.deleteAllUser() > 0;
    }
}
