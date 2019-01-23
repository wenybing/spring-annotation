package com.wenyb.config;

import com.wenyb.bean.Poet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

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
//    @Scope(value = "prototype")

    /**
     * 懒加载注解@Lazy
     * 单实例bean:默认在容器启动的时候创建对象
     * 懒加载：容器启动时不创建对象，第一次获取（使用)bean时创建对象，并初始化
     */
    @Lazy
    @Bean(value = "poet")
    public Poet poet() {
        System.out.println("给容器中添加poet.....");
        return new Poet("李白", 44);
    }
}
