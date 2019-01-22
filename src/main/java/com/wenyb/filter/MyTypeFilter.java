package com.wenyb.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @Author wenyabing
 * @Date 2019/1/22 22:00
 */
public class MyTypeFilter implements TypeFilter {
    /**
     * @param metadataReader        :读取到当前正在扫描的类的信息
     * @param metadataReaderFactory ：可以获取到其他任何类信息
     * @return
     * @throws IOException
     */
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        /**
         *获取当前类注解的信息
         */
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        /**
         * 获取当前正在扫描的类信息
         */
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        /**
         * 获取当前类资源（类路径）
         */
        Resource resource = metadataReader.getResource();
        String className = classMetadata.getClassName();
        System.out.println("---->" + className);
        if (className.contains("service")) {
            return true;
        }
        return false;
    }
}
