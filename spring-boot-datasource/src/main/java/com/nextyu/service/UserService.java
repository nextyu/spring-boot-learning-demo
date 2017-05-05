package com.nextyu.service;

import com.nextyu.domain.User;

import java.util.List;

/**
 * created on 2017-05-05 10:40
 *
 * @author nextyu
 */
public interface UserService {
    Boolean saveUser(User user);

    Integer countAllUser();

    List<User> listALLUser();

    Boolean deleteAllUser();
}
