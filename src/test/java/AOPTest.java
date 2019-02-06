package com.wenyb.config;

import com.wenyb.service.MathCalculator;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author wenyabing
 * @Date 2019/2/6 15:23
 */
public class AOPTest {
    /**
     * 测试aop面向切面编程
     */
    @Test
    public void testAop() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AOPConfig.class);
        //不能是自己new的，必须是从容器中拿的
        MathCalculator mathCalculator = context.getBean(MathCalculator.class);
        mathCalculator.div(1, 1);
    }
}
