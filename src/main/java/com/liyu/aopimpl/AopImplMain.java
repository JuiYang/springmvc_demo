package com.liyu.aopimpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopImplMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("aopimpl_properties.xml");

        Calculator calculator = applicationContext.getBean(Calculator.class);
        int result = calculator.div(3,0);
        System.out.println(result);
    }
}
