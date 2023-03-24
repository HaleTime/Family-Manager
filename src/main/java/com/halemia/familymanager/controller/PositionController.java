package com.halemia.familymanager.controller;

import com.halemia.familymanager.bean.ResultResponse;
import com.halemia.familymanager.dao.pojo.Position;
import com.halemia.familymanager.service.PositionService;
import com.halemia.familymanager.utils.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: shangchy
 * @Date: 2023/3/5 21:13
 */
@RestController
@RequestMapping("/rest/api")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @RequestMapping(value = "/position", method = RequestMethod.POST)
    public ResultResponse insert(@RequestBody Position position) {
        if (position.getPositionName() == null) {
            return ResponseBuilder.fail("400", "Position name cannot be null!");
        }
        return ResponseBuilder.success(positionService.insert(position));
    }

    @RequestMapping(value = "/position", method = RequestMethod.PATCH)
    public ResultResponse update(@RequestBody Position position) {
        if (position.getPositionName() == null) {
            return ResponseBuilder.fail("400", "Position name cannot be null!");
        }
        return ResponseBuilder.success(positionService.update(position));
    }

    @RequestMapping(value = "/position/{id}", method = RequestMethod.DELETE)
    public ResultResponse delete(@PathVariable("id") Long id) {
        if (id == null) {
            return ResponseBuilder.fail("400", "Position Id cannot be null!");
        }
        return ResponseBuilder.success(positionService.delete(id));
    }

    @RequestMapping(value = "/positions", method = RequestMethod.GET)
    public ResultResponse list() {
        return ResponseBuilder.success(positionService.getList());
    }
}
