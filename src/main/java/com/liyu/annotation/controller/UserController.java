package com.liyu.annotation.controller;

import com.liyu.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void execute(){
        userService.add();
        System.out.println("controller ...");
    }
}
