package com.hubu.dao;

import com.hubu.pojo.Layoff;
import com.hubu.pojo.LayoffExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LayoffMapper {
    int countByExample(LayoffExample example);

    int deleteByExample(LayoffExample example);

    int deleteByPrimaryKey(String machineNo);

    int insert(Layoff record);

    int insertSelective(Layoff record);

    List<Layoff> selectByExample(LayoffExample example);

    Layoff selectByPrimaryKey(String machineNo);

    int updateByExampleSelective(@Param("record") Layoff record, @Param("example") LayoffExample example);

    int updateByExample(@Param("record") Layoff record, @Param("example") LayoffExample example);

    int updateByPrimaryKeySelective(Layoff record);

    int updateByPrimaryKey(Layoff record);
}