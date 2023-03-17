package com.halemia.familymanager.service;

import com.halemia.familymanager.dao.pojo.Room;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/2/12 23:45
 */
@Service
public interface RoomService {

    Room getRoomById(Long id);

    Long insert(Room room);

    boolean update(Room room);

    boolean delete(Long id);

    List<Room> getList();
}
