package com.hubu.controller;

import com.github.pagehelper.PageInfo;
import com.hubu.dao.RecordMapper;
import com.hubu.pojo.Msg;
import com.hubu.pojo.Record;
import com.hubu.service.RecorderService;
import com.hubu.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.tags.Param;

import java.util.List;

@Controller
public class RecordController
{
    @Autowired
    private RecorderService recorderService;

    private final int PAGESIZE = 5;

    @RequestMapping("test")
    @ResponseBody
    public Msg  test(  @RequestParam(value = "cp") int currentPage ){
        PageInfo<Record> records = recorderService.findRecordWithPage(1,PAGESIZE);
        return new Msg().success().add("result",records);
    }
}
