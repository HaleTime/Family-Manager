package com.halemia.familymanager.service.impl;

import com.halemia.familymanager.dao.mapper.CommonDao;
import com.halemia.familymanager.dao.pojo.Item;
import com.halemia.familymanager.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/2/12 23:46
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private CommonDao commonDao;

    @Override
    public Item getItemById(Long id) {
        return commonDao.getById(id, Item.class);
    }

    @Override
    public Long insert(Item item) {
        commonDao.insert(item);
        return item.getId();
    }

    @Override
    public boolean update(Item item) {
        return commonDao.update(item);
    }

    @Override
    public boolean delete(Long id) {
        return commonDao.delete(id, Item.class);
    }
}
