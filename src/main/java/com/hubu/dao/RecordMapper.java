package com.hubu.dao;

import com.hubu.pojo.ProjectFinishedCompletion;
import com.hubu.pojo.ProjectTeamFinishedCompletion;
import com.hubu.pojo.Record;
import com.hubu.pojo.RecordExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecordMapper {
    int countByExample(RecordExample example);

    int deleteByExample(RecordExample example);

    int deleteByPrimaryKey(Integer recordNo);

    int insert(Record record);

    int insertSelective(Record record);

    List<Record> selectByExampleWithBLOBs(RecordExample example);

    List<Record> selectByExample(RecordExample example);

    List<ProjectTeamFinishedCompletion> analyzeProjectTeamFinishedCompletion(Map map);

    List<ProjectFinishedCompletion> analyzeProjectFinishedCompletion(Integer projectNo);

    Record selectByPrimaryKey(Integer recordNo);

    int updateByExampleSelective(@Param("record") Record record, @Param("example") RecordExample example);

    int updateByExampleWithBLOBs(@Param("record") Record record, @Param("example") RecordExample example);

    int updateByExample(@Param("record") Record record, @Param("example") RecordExample example);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKeyWithBLOBs(Record record);

    int updateByPrimaryKey(Record record);
}