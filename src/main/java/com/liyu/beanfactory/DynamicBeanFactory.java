package com.liyu.beanfactory;

import com.liyu.bean.Car;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 静态工厂模式
 */
public class DynamicBeanFactory {

    private Map<String, Car> map = null;

    public DynamicBeanFactory(){
        map = new HashMap<String, Car>();
        map.put("audi", new Car("audi", 1200.0));
        map.put("benz", new Car("audi", 1200.0));
    }

    public Car getInstance(String carName) {
        return map.get(carName);
    }
}