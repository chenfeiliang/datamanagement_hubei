package com.hubu.service;

import com.hubu.dao.LayoffMapper;
import com.hubu.pojo.Layoff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LayoffService {
    @Autowired
    LayoffMapper layoffMapper;
    public void insert(Layoff layoff){
        layoffMapper.insertSelective(layoff);
    }
}
