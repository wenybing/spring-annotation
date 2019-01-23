package com.wenyb.bean;

/**
 * @Author wenyabing
 * @Date 2019/1/23 9:06
 */
public class Person {
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
