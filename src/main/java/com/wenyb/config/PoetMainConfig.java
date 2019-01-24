package com.wenyb.config;

import com.wenyb.bean.Poet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author wenyabing
 * @Date 2019/1/23 21:35
 */

/**
 * 使用@PropertySource注解读取外部属性文件中的key-value保存到运行环境中,加载完外部的属性配置文件后使用${key}取出配置文件的值
 */

@PropertySource(value = "classpath:/person.properties")
@Configuration
public class PoetMainConfig {
    @Bean
    public Poet poet() {
        return new Poet();
    }
}
