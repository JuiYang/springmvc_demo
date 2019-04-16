package com.liyu.aopimpl;


import org.springframework.stereotype.Component;

// 注入bean
@Component("calculator")
public class CalculatorImpl implements Calculator {

    public int add(int x, int y) {
        return x + y;
    }

    public int sub(int x, int y) {
        return x - y;
    }

    public int div(int x, int y) {
        int result = x / y;
        return result;
    }

    public int mul(int x, int y) {
        return x * y;
    }
}
