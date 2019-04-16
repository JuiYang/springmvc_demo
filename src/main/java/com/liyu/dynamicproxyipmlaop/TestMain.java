package com.liyu.dynamicproxyipmlaop;

public class TestMain {

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
//        int result = calculator.add(3,6);
//        System.out.println(result);

        DynamicProxyImplAOP dynamicProxyImplAOP = new DynamicProxyImplAOP(calculator);
        int result = dynamicProxyImplAOP.getLoggingProxy().add(3,7);
        System.out.println(result);
    }
}
