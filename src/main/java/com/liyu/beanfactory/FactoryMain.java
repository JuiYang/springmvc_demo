package com.liyu.beanfactory;

import com.liyu.bean.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanfactory_properties.xml");

        // 通过静态工厂模式
//        Car car = (Car) applicationContext.getBean("staticFactory");

        // 通过动态工厂模式
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car.toString());
    }
}
