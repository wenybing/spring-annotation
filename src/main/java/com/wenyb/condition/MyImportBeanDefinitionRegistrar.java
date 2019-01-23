package com.wenyb.condition;

/**
 * @Author wenyabing
 * @Date 2019/1/23 13:12
 */

import com.wenyb.bean.Sleep;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义bean注册类
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     * AnnotationMetadata:当前类的注解信息
     * BeanDefinitionRegistry：BeanDefinition注册类
     */
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean beanDefinition1 = registry.containsBeanDefinition("com.wenyb.bean.Pig");
        boolean beanDefinition2 = registry.containsBeanDefinition("com.wenyb.bean.Dog");
        if (beanDefinition1 && beanDefinition2) {
            //指定一个bean的信息（bean的类型）
            RootBeanDefinition beanDefinition = new RootBeanDefinition(Sleep.class);
            //注册一个bean,指定bean名
            registry.registerBeanDefinition("sleep", beanDefinition);
        }
    }
}
