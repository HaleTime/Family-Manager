package com.halemia.familymanager.service.impl;

import com.halemia.familymanager.dao.mapper.CommonDao;
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
    private CommonDao commonDao;

    @Override
    public User getUserById(Long id) {
        return commonDao.getById(id, User.class);
    }

    @Override
    public Long insert(User user) {
        commonDao.insert(user);
        return user.getId();
    }

    @Override
    public boolean update(User user) {
        return commonDao.update(user);
    }

    @Override
    public boolean delete(Long id) {
        return commonDao.delete(id, User.class);
    }
}
