package com.halemia.familymanager.service.impl;

import com.halemia.familymanager.dao.mapper.UserDao;
import com.halemia.familymanager.dao.pojo.User;
import com.halemia.familymanager.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/2/12 23:46
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }

    @Override
    public boolean delete(int id) {
        return userDao.delete(id);
    }
}
