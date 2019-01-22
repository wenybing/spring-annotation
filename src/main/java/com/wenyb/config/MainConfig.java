package com.wenyb.config;

import com.wenyb.bean.Poet;
import com.wenyb.filter.MyTypeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @Author wenyabing
 * @Date 2019/1/22 19:32
 */

/**
 * 配置类 == (配置文件)bean.xml
 */
//@Configuration 注解告诉spring这是一个配置类

@Configuration

//@ComponentScan(value = "com.wenyb") value的值为指定要扫描的包

/**
 * 指定只扫com.wenyb包下描标注@Controller注解的类,不使用默认拦截,扫描的filter的规则为注解
 * @ComponentScan value:指定要扫描的包
 * excludeFilters=Filter[] ：指定扫描时按照什么规则排除那些组件
 * includeFilters=Filter[] : 指定扫描时只包含那些组件
 * 过滤规则：
 * FilterType.ANNOTATION ：按照注解
 * FilterType.ASSIGNABLE_TYPE：按照指定类型
 * FilterType.ASPECTJ: 按照ASPECTJ表达式
 * FilterType.REGEX: 按照正则表达式
 * FilterType.CUSTOM: 使用自定义规则
 */
@ComponentScan(value = "com.wenyb", includeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class}),
//        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {PoetService.class}),
        @ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})
}, useDefaultFilters = false)
public class MainConfig {
    //@Bean 给容器注册一个bean 类型为返回值类型，id为方法名

    @Bean
    public Poet poet01() {
        return new Poet("杜甫", 33);
    }
}
