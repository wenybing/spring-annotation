package com.wenyb.service;

import com.wenyb.dao.PoetDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Author wenyabing
 * @Date 2019/1/22 20:41
 */
@Service
public class PoetService {
    @Qualifier("poetDao")
    @Autowired(required = false)
    private PoetDao poetDao;

    public void print() {
        System.out.println(poetDao);
    }

    @Override
    public String toString() {
        return "PoetService{" +
                "poetDao=" + poetDao +
                '}';
    }
}
