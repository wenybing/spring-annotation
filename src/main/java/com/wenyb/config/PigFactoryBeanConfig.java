package com.wenyb.config;

/**
 * @Author wenyabing
 * @Date 2019/1/23 13:58
 */

import com.wenyb.bean.PigFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 */
@Configuration
public class PigFactoryBeanConfig {
    @Bean
    public PigFactoryBean pigFactoryBean() {
        return new PigFactoryBean();
    }
}
