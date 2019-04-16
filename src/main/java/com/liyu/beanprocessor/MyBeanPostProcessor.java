package com.liyu.beanprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

// 自定义后置处理器
public class MyBeanPostProcessor implements BeanPostProcessor {

    // 初始化方法前的后置处理器
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean+" , " + beanName);
        return bean;
    }

    // 初始化方法后的后置处理器
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(bean+" , " + beanName);
        return bean;
    }
}
