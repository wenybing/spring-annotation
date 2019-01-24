package com.wenyb.config;

import com.wenyb.dao.PoetDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @Author wenyabing
 * @Date 2019/1/23 23:30
 */

/**
 * 配置类
 */
@ComponentScan({"com.wenyb.service", "com.wenyb.dao"})
@Configuration
public class AutowiredConfig {
    @Bean
    public PoetDao poetDao02() {
        PoetDao poetDao = new PoetDao();
        poetDao.setLabel("label-2");
        return poetDao;
    }

    @Primary
    @Bean(value = "poetDao03")
    public PoetDao poetDao() {
        PoetDao poetDao = new PoetDao();
        poetDao.setLabel("label-3");
        return poetDao;
    }
}
