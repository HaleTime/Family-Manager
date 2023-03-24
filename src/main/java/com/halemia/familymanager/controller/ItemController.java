package com.halemia.familymanager.controller;

import com.halemia.familymanager.bean.ResultResponse;
import com.halemia.familymanager.dao.pojo.Item;
import com.halemia.familymanager.service.ItemService;
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
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    public ResultResponse insert(@RequestBody Item item) {
        if (item.getItemName() == null) {
            return ResponseBuilder.fail("400", "Item name cannot be null!");
        }
        return ResponseBuilder.success(itemService.insert(item));
    }

    @RequestMapping(value = "/item", method = RequestMethod.PATCH)
    public ResultResponse update(@RequestBody Item item) {
        if (item.getItemName() == null) {
            return ResponseBuilder.fail("400", "Item name cannot be null!");
        }
        return ResponseBuilder.success(itemService.update(item));
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
    public ResultResponse delete(@PathVariable("id") Long id) {
        if (id == null) {
            return ResponseBuilder.fail("400", "Item Id cannot be null!");
        }
        return ResponseBuilder.success(itemService.delete(id));
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public ResultResponse list() {
        return ResponseBuilder.success(itemService.getList());
    }
}
