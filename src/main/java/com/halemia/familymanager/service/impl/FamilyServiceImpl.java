package com.halemia.familymanager.service.impl;

import com.halemia.familymanager.dao.mapper.CommonDao;
import com.halemia.familymanager.dao.pojo.Family;
import com.halemia.familymanager.service.FamilyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/2/12 23:46
 */
@Service
public class FamilyServiceImpl implements FamilyService {

    @Resource
    private CommonDao commonDao;

    @Override
    public Family getFamilyById(Long id) {
        return commonDao.getById(id, Family.class);
    }

    @Override
    public Long insert(Family family) {
        commonDao.insert(family);
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
}
