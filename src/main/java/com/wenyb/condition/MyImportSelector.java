package com.wenyb.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author wenyabing
 * @Date 2019/1/23 12:48
 */
public class MyImportSelector implements ImportSelector {
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.wenyb.bean.Dog", "com.wenyb.bean.Pig"};
    }
}
