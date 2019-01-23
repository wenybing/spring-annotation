package com.wenyb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

/**
 * @Author wenyabing
 * @Date 2019/1/23 18:38
 */
@ComponentScan(value = {"com.wenyb.bean", "com.wenyb.condition"}, includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Component.class})
})
@Configuration
public class CatConfig {

}
