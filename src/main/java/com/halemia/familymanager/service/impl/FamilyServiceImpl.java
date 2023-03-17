package com.halemia.familymanager.service.impl;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.halemia.familymanager.context.ThreadContext;
import com.halemia.familymanager.dao.mapper.CommonDao;
import com.halemia.familymanager.dao.mapper.SqlProvider;
import com.halemia.familymanager.dao.pojo.Family;
import com.halemia.familymanager.dao.pojo.User;
import com.halemia.familymanager.dao.pojo.base.Dao;
import com.halemia.familymanager.service.FamilyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/2/12 23:46
 */
@Service
public class FamilyServiceImpl implements FamilyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SqlProvider.class);


    private static final RSA RSA = new RSA();

    @Resource
    private CommonDao commonDao;

    @Override
    public Family getFamilyById(Long id) {
        return commonDao.getById(id, Family.class);
    }

    @Override
    public Long insert(Family family) {
        try {
            User user = new User();
            user.setOpenId(ThreadContext.getInstance().getOpenId());
            List<User> users = commonDao.getByDao(user);
            if (users.size() > 0) {
                family.setId(users.get(0).getFamilyId());
                commonDao.update(family);
            }else {
                commonDao.insert(family);
                user.setFamilyId(family.getId());
                commonDao.insert(user);
            }
        }catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return family.getId();
    }

    @Override
    public boolean update(Family family) {
        return commonDao.update(family);
    }

    @Override
    public boolean delete(Long id) {

        return commonDao.delete(id, Family.class);
    }

    @Override
    public List<Family> getList() {
        User user = new User();
        user.setOpenId(ThreadContext.getInstance().getOpenId());
        List<Dao> users = commonDao.getByDao(user);
        if (users.size() < 1) {
            throw new RuntimeException("User is null");
        }

        Family family = new Family();
        return commonDao.getByDao(family);
    }

    @Override
    public String invite() {
        return null;
    }

    @Override
    public boolean join(String code) {
        String openId = RSA.decryptStr(code, KeyType.PublicKey);
        Family family = new Family();
        return false;
    }


}
