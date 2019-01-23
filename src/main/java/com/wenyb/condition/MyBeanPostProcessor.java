package com.wenyb.condition;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author wenyabing
 * @Date 2019/1/23 20:52
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(".........postProcessBeforeInitialization........" + "beanName: " + beanName + "bean: " + bean);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("........postProcessAfterInitialization............." + "beanName: " + beanName + "bean: " + bean);
        return bean;
    }
}
