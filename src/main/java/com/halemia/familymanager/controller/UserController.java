package com.halemia.familymanager.controller;

import com.halemia.familymanager.dao.pojo.User;
import com.halemia.familymanager.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Integer insert(@RequestBody User user) {
        return userService.insert(user);
    }
}
