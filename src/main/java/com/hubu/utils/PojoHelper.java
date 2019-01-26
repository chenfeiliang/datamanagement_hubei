package com.hubu.utils;

import com.hubu.pojo.ProjectFinishedCompletion;
import com.hubu.pojo.ProjectTeamFinishedCompletion;
import com.hubu.pojo.Record;
import com.hubu.pojo.RecordExample;

import java.util.List;

public class PojoHelper {
    public static List<Record> setRecordDateString(List<Record>  list){
        for(Record record:list)
        {
            record.setStr_beginTime((DateUtil.DateTimeToString(record.getBeginTime())));
            record.setStr_endTime((DateUtil.DateTimeToString(record.getEndTime())));
            record.setStr_gatherTime((DateUtil.DateTimeToString(record.getGatherTime())));
        }
        return list;
    }

    public static List<ProjectFinishedCompletion> setProjectFinishedCompletionDateString(List<ProjectFinishedCompletion>  list){
        for(ProjectFinishedCompletion record:list)
        {
            record.setStr_beginTime((DateUtil.DateToString(record.getBeginTime())));
            record.setStr_endTime((DateUtil.DateToString(record.getEndTime())));
        }
        return list;
    }

    public static List<ProjectTeamFinishedCompletion> setProjectTeamFinishedCompletionDateString(List<ProjectTeamFinishedCompletion>  list){
        for(ProjectTeamFinishedCompletion record:list)
        {
            record.setStr_beginTime((DateUtil.DateToString(record.getBeginTime())));
            record.setStr_endTime((DateUtil.DateToString(record.getEndTime())));
        }
        return list;
    }
}
