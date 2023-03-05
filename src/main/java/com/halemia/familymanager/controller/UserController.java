package com.halemia.familymanager.controller;

import com.halemia.familymanager.dao.pojo.User;
import com.halemia.familymanager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/rest/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Long insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @RequestMapping(value = "/", method = RequestMethod.PATCH)
    public Boolean update(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return userService.delete(id);
    }

}
