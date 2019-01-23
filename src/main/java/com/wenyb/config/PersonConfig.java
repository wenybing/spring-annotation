package com.wenyb.config;

import com.wenyb.bean.Animal;
import com.wenyb.bean.Color;
import com.wenyb.bean.Person;
import com.wenyb.condition.LinuxCondition;
import com.wenyb.condition.MyImportBeanDefinitionRegistrar;
import com.wenyb.condition.MyImportSelector;
import com.wenyb.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author wenyabing
 * @Date 2019/1/23 9:09
 */

/**
 * 告诉spring这是一个注解类
 */
@Configuration
/**
 * 注解 @Import():导入组件，id默认是组件全类名
 */
@Import(value = {Animal.class, Color.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class PersonConfig {
    /**
     * 注解@Conditional：按照一定的条件进行判断，满足条件给容器中注册bean
     * 如果是windows系统，给容器中注册（"Bill"）
     * 如果是linux系统，给容器中注册（"Linux"）
     */

    @Conditional(value = {WindowsCondition.class})
    @Bean(value = "Bill")
    public Person person01() {
        return new Person("Bill Gates", 60);
    }

    @Conditional(value = {LinuxCondition.class})
    @Bean(value = "Linus")
    public Person Person02() {
        return new Person("Linus", 45);
    }

}
