package com.hubu.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hubu.dao.RecordMapper;
import com.hubu.pojo.Record;
import com.hubu.utils.DateUtil;
import com.hubu.utils.RecordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecorderService {
    @Autowired
    RecordMapper recordMapper;

    public PageInfo<Record> findRecordWithPage(int currentPage ,int pageSize){

        //分页
        PageHelper.startPage(currentPage,pageSize);
        List<Record> records = recordMapper.selectByExampleWithBLOBs(null);

        //把Record里的Date类型日期 如 beginTime，赋值到String 类型 的str_beginTime 方便前台显示
        records = RecordHelper.setRecordDateString(records);

        PageInfo<Record> pageInfo = new PageInfo<>(records);

        return pageInfo;
    }
}
