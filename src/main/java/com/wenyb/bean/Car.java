package com.wenyb.bean;

/**
 * @Author wenyabing
 * @Date 2019/1/23 17:20
 */
public class Car {

    public Car() {
        System.out.println("-------Car constructor-----------");
    }

    /**
     * 初始化方法
     */
    public void init() {
        System.out.println("----------Car intit---------");
    }

    /**
     * 销毁方法
     */
    public void destory() {
        System.out.println("------Car destory-------");
    }
}
