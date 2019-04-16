package com.liyu.annotation;

import com.liyu.annotation.controller.UserController;
import com.liyu.annotation.repository.UserRepository;
import com.liyu.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationMain {



    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("annotation_properties.xml");

        TestObject testObject = (TestObject) applicationContext.getBean("testObject");
        System.out.println(testObject.toString());

        UserRepository userRepository = (UserRepository) applicationContext.getBean("userRepository");
        System.out.println(userRepository.toString());

        UserService userService = (UserService) applicationContext.getBean("userService");
        System.out.println(userService.toString());

        UserController userController = (UserController) applicationContext.getBean("userController");
        System.out.println(userController.toString());

//        @Autowired
//        private UserController userController1;
//
//        userController1.execute();

    }
}
