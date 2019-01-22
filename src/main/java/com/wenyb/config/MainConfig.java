package com.wenyb.config;

import com.wenyb.bean.Poet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wenyabing
 * @Date 2019/1/22 19:32
 */

/**
 * 配置类 == (配置文件)bean.xml
 */
//@Configuration 注解告诉spring这是一个配置类

@Configuration
public class MainConfig {
    //@Bean 给容器注册一个bean 类型为返回值类型，id为方法名

    @Bean
    public Poet poet01() {
        return new Poet("杜甫", 33);
    }
}
