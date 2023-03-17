package com.halemia.familymanager.controller;

import com.halemia.familymanager.bean.ResultResponse;
import com.halemia.familymanager.dao.pojo.Room;
import com.halemia.familymanager.service.RoomService;
import com.halemia.familymanager.utils.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/3/5 21:13
 */
@RestController
@RequestMapping("/rest/api")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value = "/room", method = RequestMethod.POST)
    public ResultResponse insert(@RequestBody Room room) {
        if (room.getRoomName() == null) {
            return ResponseBuilder.fail("400", "Room name cannot be null!");
        }
        return ResponseBuilder.success(roomService.insert(room));
    }

    @RequestMapping(value = "/room", method = RequestMethod.PATCH)
    public ResultResponse update(@RequestBody Room room) {
        if (room.getRoomName() == null) {
            return ResponseBuilder.fail("400", "Room name cannot be null!");
        }
        return ResponseBuilder.success(roomService.update(room));
    }

    @RequestMapping(value = "/room/{id}", method = RequestMethod.DELETE)
    public ResultResponse delete(Long id) {
        if (id == null) {
            return ResponseBuilder.fail("400", "Room Id cannot be null!");
        }
        return ResponseBuilder.success(roomService.delete(id));
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.GET)
    public ResultResponse list() {
        return ResponseBuilder.success(roomService.getList());
    }
}
