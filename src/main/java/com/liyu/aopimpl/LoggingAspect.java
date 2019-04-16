package com.liyu.aopimpl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

// 声明为切面, 并将切面对象添加到IOC中进行管理
@Order(2)
@Aspect
@Component
public class LoggingAspect {
    /**
     * 定义一个方法，声明切入点表达式，一般该方法不需要写其他代码
     * 使用@PointCut声明表达式， 后面的通知可以引用当前切入点表达式
     * @param joinPoint
     */
    @Pointcut(value = "execution(public int com.liyu.aopimpl.Calculator.*(..))")
    public void declareJoinPointExpression(){}

    @Before("declareJoinPointExpression()")
    // 连接点JoinPoint
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("前置通知...");
        System.out.println("method name: " + methodName + "; method before execute ... ; " + "args list: " + args.toString());
    }

    // 后置通知
    @After("declareJoinPointExpression()")
    // 连接点JoinPoint
    public void AfterMethod(JoinPoint joinPoint) {
        System.out.println("后置通知...");
    }

    // 后置返回通知
    @AfterReturning("declareJoinPointExpression()")
    // 连接点JoinPoint
    public void AfterReturningMethod(JoinPoint joinPoint) {
        System.out.println("后置返回通知...");
    }

    // 异常通知
    @AfterThrowing("declareJoinPointExpression()")
    // 连接点JoinPoint
    public void AfterThrowingMethod(JoinPoint joinPoint) {
        System.out.println("异常通知...");
    }
}
