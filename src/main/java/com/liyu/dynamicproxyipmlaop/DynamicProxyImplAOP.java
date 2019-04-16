package com.liyu.dynamicproxyipmlaop;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 手写动态代理实现AOP
 */
public class DynamicProxyImplAOP {
    // 代理对象
    private Calculator target;

    public DynamicProxyImplAOP(Calculator calculator) {
        this.target = calculator;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Calculator getLoggingProxy() {
        Calculator proxy = null;
        // 获取类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();
        // 获取代理对象方法
        Class[] interfaces = new Class[]{Calculator.class};

        // 调用代理对象中的方式时执行
        InvocationHandler invocationHandler = new InvocationHandler() {
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("dynamic proxy start...");
                Object result = method.invoke(target, objects);
                System.out.println("dynamic proxy end...");
                return result;
            }
        };
        proxy = (Calculator) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return proxy;
    }
}
