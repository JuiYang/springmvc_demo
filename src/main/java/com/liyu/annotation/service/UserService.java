package com.liyu.annotation.service;

import com.liyu.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void add(){
        userRepository.save();
        System.out.println("user service add ...");
    }
}
