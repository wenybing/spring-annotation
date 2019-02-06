package com.wenyb.config;

import com.wenyb.service.LogAspect;
import com.wenyb.service.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author wenyabing
 * @Date 2019/2/6 15:31
 * <p>
 * 主配置类
 */
/**
 * 主配置类
 */

/**
 * 开启aop模式
 */
@EnableAspectJAutoProxy
@Configuration
public class AOPConfig {
    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }
}
