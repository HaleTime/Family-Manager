package com.halemia.familymanager.controller;

import com.halemia.familymanager.bean.ResultResponse;
import com.halemia.familymanager.dao.pojo.Family;
import com.halemia.familymanager.dao.pojo.User;
import com.halemia.familymanager.service.FamilyService;
import com.halemia.familymanager.service.UserService;
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
@RequestMapping("/rest/api/family")
public class FamilyController {

    @Autowired
    private FamilyService familyService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResultResponse insert(@RequestBody Family family) {
        if (family.getFamilyName() == null) {
            return ResponseBuilder.fail("400", "Family name cannot be null!");
        }
        return ResponseBuilder.success(familyService.insert(family));
    }

    @RequestMapping(value = "/", method = RequestMethod.PATCH)
    public ResultResponse update(@RequestBody Family family) {
        if (family.getFamilyName() == null) {
            return ResponseBuilder.fail("400", "Family name cannot be null!");
        }
        return ResponseBuilder.success(familyService.update(family));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResultResponse delte(Long id) {
        if (id == null) {
            return ResponseBuilder.fail("400", "Family Id cannot be null!");
        }
        return ResponseBuilder.success(familyService.delete(id));
    }
}
