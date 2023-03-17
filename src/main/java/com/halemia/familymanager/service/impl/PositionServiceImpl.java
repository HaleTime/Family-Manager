package com.halemia.familymanager.service.impl;

import com.halemia.familymanager.dao.mapper.CommonDao;
import com.halemia.familymanager.dao.pojo.Item;
import com.halemia.familymanager.dao.pojo.Position;
import com.halemia.familymanager.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/2/12 23:46
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Resource
    private CommonDao commonDao;

    @Override
    public Position getPositionById(Long id) {
        return commonDao.getById(id, Position.class);
    }

    @Override
    public Long insert(Position position) {
        commonDao.insert(position);
        return position.getId();
    }

    @Override
    public boolean update(Position position) {
        return commonDao.update(position);
    }

    @Override
    public boolean delete(Long id) {
        return commonDao.delete(id, Position.class);
    }

    @Override
    public List<Position> getList() {
        return commonDao.getByDao(new Item());
    }
}
