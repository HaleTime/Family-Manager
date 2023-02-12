package com.halemia.familymanager.service;

import com.halemia.familymanager.dao.pojo.User;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/2/12 23:45
 */
@Service
public interface UserService {

    User getUserById(int id);

    int insert(User user);

    boolean update(User user);

    boolean delete(int id);

}
