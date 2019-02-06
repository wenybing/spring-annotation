package com.wenyb.service;

/**
 * @Author wenyabing
 * @Date 2019/2/6 14:48
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 切面类
 */
@Aspect
public class LogAspect {
    /**
     * 切入方法（切入点表达式）
     */
    @Pointcut("execution(public * com.wenyb.service.MathCalculator.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "运行.....参数列表{" + Arrays.asList(joinPoint.getArgs()) +
                "}");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "运行结束...参数列表{" + Arrays.asList(joinPoint.getArgs()) + "}");
    }

    @AfterReturning(value = "pointCut()", returning = "object")
    public void logReturn(JoinPoint joinPoint, Object object) {
        System.out.println(joinPoint.getSignature().getName() + "正常返回...返回值{" + object + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println(joinPoint.getSignature().getName() + "出现异常...异常信息{" + exception + "}");
    }
}
