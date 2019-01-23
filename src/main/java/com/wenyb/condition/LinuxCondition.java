package com.wenyb.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Author wenyabing
 * @Date 2019/1/23 9:36
 */
public class LinuxCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //如果操作系统是Linus才注册bean
        Environment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        if (property.contains("Linux")) {
            return true;
        }
        return false;
    }
}
