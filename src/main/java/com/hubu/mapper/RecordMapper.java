package com.hubu.mapper;

import com.hubu.pojo.ProjectFinishedCompletion;
import com.hubu.pojo.ProjectTeamFinishedCompletion;
import com.hubu.pojo.Record;
import com.hubu.pojo.RecordExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RecordMapper {
    int countByExample(RecordExample example);

    int deleteByExample(RecordExample example);

    int deleteByPrimaryKey(Integer recordNo);

    int insert(Record record);

    int insertSelective(Record record);

    //倒序
    List<Record> selectByExampleWithBLOBs(RecordExample example);

    List<Record> selectByExample(RecordExample example);

    List<ProjectTeamFinishedCompletion> analyzeProjectTeamFinishedCompletion(Map map);

    List<ProjectFinishedCompletion> analyzeProjectFinishedCompletion(Integer projectNo);

    Record selectByPrimaryKey(Integer recordNo);

}