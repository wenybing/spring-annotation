package com.wenyb.config;

import com.wenyb.bean.Poet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Author wenyabing
 * @Date 2019/1/22 22:46
 */
@Configuration
public class PoetConfig {
    /**
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE
     * ConfigurableBeanFactory#SCOPE_SINGLETON
     * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST
     * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION
     * prototype：多实例
     * singleton：单实例
     * request：同一次请求创建一个实例
     * session：同一次会话创建一个实例
     */
    @Scope(value = "prototype")
    @Bean(value = "poet")
    public Poet poet() {
        System.out.println("给容器中添加poet.....");
        return new Poet("李白", 44);
    }
}
