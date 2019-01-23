package com.wenyb.config;

/**
 * @Author wenyabing
 * @Date 2019/1/23 17:20
 */

import com.wenyb.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 生命周期配置类
 */

/**
 * bean的生命周期：
 * bean创建----》初始化-----》销毁的过程
 * 容器管理bean的生命周期；
 * 我们可以自定义初始化和销毁方法，容器在bean进行到当前生命周期的时候来调用我们自定义的初始化和销毁方法
 * 构造（对象创建）：
 * 单实例：在容器启动的时候创建对象
 * 多实例：在每次获取的时候创建对象
 * <p>
 * 初始化：
 * 对象创建完成，并赋值好，调用初始化方法。。
 * 销毁：
 * 单实例：容器关闭的时候
 * 多实例：容器不会管理这个bean,容器不会调用销毁方法
 * 指定初始化和销毁方法：通过@Bean指定init-method和destory-method
 */
@Configuration
public class BeanLifeCycleConfig {

//  @Scope(value = "prototype") 多实例

    @Bean(initMethod = "init", destroyMethod = "destory")
    public Car Car() {
        return new Car();
    }
}
