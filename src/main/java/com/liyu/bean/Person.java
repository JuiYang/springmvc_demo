package com.liyu.bean;


import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Person {

    private String userName;
    private int age;
    private Car car;
    // List集合属性
    private List<Car> carList;

    // Map集合属性
    private Map<String, Car> carMap;

    public Person(){}
}
