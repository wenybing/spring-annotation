package com.wenyb.dao;

import org.springframework.stereotype.Repository;

/**
 * @Author wenyabing
 * @Date 2019/1/22 20:40
 */
@Repository
public class PoetDao {
    private String label = "label-1";

    public PoetDao() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "PoetDao{" +
                "label='" + label + '\'' +
                '}';
    }
}
