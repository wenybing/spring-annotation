package com.wenyb.bean;

/**
 * @Author wenyabing
 * @Date 2019/1/22 18:03
 */
public class Poet {
    private String name;
    private Integer age;

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

    @Override
    public String toString() {
        return "Poet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
