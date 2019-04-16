package com.liyu.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppleMain {

    public static void main(String[] args) {
//        Person apple = new Person();
//        apple.setPrice(10);
//        apple.setName("apple");

//        通过IOC实现注入bean对象
        // 1. 创建IOC容器对象, 从类路径下获取配置文件
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        // 2. 从IOC中获取bean实例
        Person person = (Person) applicationContext.getBean("person");
        // 3. 获取实例对象的方法、参数
        System.out.println(person.toString());

        Person person1 = (Person) applicationContext.getBean("person1");
        System.out.println(person1.toString());


        Apple apple = (Apple) applicationContext.getBean("apple");
        System.out.println(apple.toString());

        Banana banana = (Banana) applicationContext.getBean("apple1");
        System.out.println(banana.toString());

        // 关闭容器
        applicationContext.close();
    }
}
