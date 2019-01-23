package com.wenyb.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author wenyabing
 * @Date 2019/1/23 19:09
 */
@Component
public class Rat {
    public Rat() {
        System.out.println("rat....constructor......");
    }

    //对象创建完成并赋值之后调用

    @PostConstruct
    public void init() {
        System.out.println("rat...........@PostConstruct......");
    }

    //容器移除对象之前调用

    @PreDestroy
    public void destroy() {
        System.out.println("rat..........@PreDestroy............");
    }

}
