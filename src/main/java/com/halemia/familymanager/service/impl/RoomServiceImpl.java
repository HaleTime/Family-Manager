package com.halemia.familymanager.service.impl;

import com.halemia.familymanager.dao.mapper.CommonDao;
import com.halemia.familymanager.dao.pojo.Room;
import com.halemia.familymanager.service.RoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/2/12 23:46
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Resource
    private CommonDao commonDao;

    @Override
    public Room getRoomById(Long id) {
        return commonDao.getById(id, Room.class);
    }

    @Override
    public Long insert(Room room) {
        commonDao.insert(room);
        return room.getId();
    }

    @Override
    public boolean update(Room room) {
        return commonDao.update(room);
    }

    @Override
    public boolean delete(Long id) {
        return commonDao.delete(id, Room.class);
    }
}
