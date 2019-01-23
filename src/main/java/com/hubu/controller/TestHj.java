package com.hubu.controller;

import com.hubu.dao.LayoffMapper;
import com.hubu.pojo.Layoff;
import com.hubu.pojo.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestHj
{
    @Autowired
    LayoffMapper layoffMapper;


    @RequestMapping("hello")
    @ResponseBody
    public List<Layoff>  hello(){
        List<Layoff> layoffs = new  ArrayList();
        layoffs = layoffMapper.selectByExample(null);
        return layoffs;
    }
}
