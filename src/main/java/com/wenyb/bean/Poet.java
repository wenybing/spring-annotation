package com.wenyb.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Author wenyabing
 * @Date 2019/1/22 18:03
 */
public class Poet {
    /**
     * 姓名
     */
    @Value("李白")
    private String name;
    /**
     * 年龄
     */
    @Value("#{20 - 2}")
    private Integer age;
    /**
     * 昵称
     */
    @Value("${person.nickName}")
    private String nickName;

    public Poet() {
    }

    public Poet(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Poet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
