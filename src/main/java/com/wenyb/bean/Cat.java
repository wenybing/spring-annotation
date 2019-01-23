package com.wenyb.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Author wenyabing
 * @Date 2019/1/23 18:35
 */
@Component
public class Cat implements InitializingBean, DisposableBean {
    public Cat() {
        System.out.println("cat......constructor.........");
    }

    /**
     * 销毁时调用
     */
    public void destroy() throws Exception {
        System.out.println("cat.....destory..........");
    }

    /**
     * 所有属性设置完后调用
     */
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat......afterPropertiesSet......");
    }
}
