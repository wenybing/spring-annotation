package com.wenyb.bean;

/**
 * @Author wenyabing
 * @Date 2019/1/23 13:48
 */

import org.springframework.beans.factory.FactoryBean;

/**
 * 自定义factoryBean
 */
public class PigFactoryBean implements FactoryBean {
    /**
     * 返回一个Pig对象，添加到IOC容器中
     */
    public Object getObject() throws Exception {
        return new Pig();
    }

    /**
     * 指定对象的返回类型
     */
    public Class<?> getObjectType() {
        return Pig.class;
    }

    /**
     * 是否单例
     */
    public boolean isSingleton() {
        return false;
    }
}
