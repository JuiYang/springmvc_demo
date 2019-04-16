package com.liyu.beanfactory;

import com.liyu.bean.Car;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 静态工厂模式
 */
public class StaticBeanFactory {

    private static Map<String, Car> map = null;

    static {
        map = new HashMap<String, Car>();
        map.put("audi", new Car("audi", 1200.0));
        map.put("benz", new Car("audi", 1200.0));
    }

    public static Car getInstance(String carName) {
        return map.get(carName);
    }
}