package com.hubu.utils;

import com.hubu.pojo.ProjectFinishedCompletion;
import com.hubu.pojo.ProjectTeamFinishedCompletion;
import com.hubu.pojo.Record;
import com.hubu.pojo.RecordExample;

import java.util.List;

/*
 * 功能描述: Pojo（模型） 的工具类，协助填充字段的功能
 *
 * @author : chenfeiliang
 */
public class PojoHelper {

    //将Record的Date类型的beginTime 等字段 转换成字符串 存到 Record的String类型的str_beginTime字段，方便前台输出
    public static List<Record> setRecordDateString(List<Record>  list){
        for(Record record:list)
        {
            record.setStr_beginTime((DateUtil.DateTimeToString(record.getBeginTime())));
            record.setStr_endTime((DateUtil.DateTimeToString(record.getEndTime())));
            record.setStr_gatherTime((DateUtil.DateTimeToString(record.getGatherTime())));
        }
        return list;
    }

    //将ProjectFinishedCompletion的Date类型的beginTime 等字段 转换成字符串 存到 ProjectFinishedCompletion的String类型的str_beginTime字段，方便前台输出
    public static List<ProjectFinishedCompletion> setProjectFinishedCompletionDateString(List<ProjectFinishedCompletion>  list){
        for(ProjectFinishedCompletion record:list)
        {
            record.setStr_beginTime((DateUtil.DateToString(record.getBeginTime())));
            record.setStr_endTime((DateUtil.DateToString(record.getEndTime())));
        }
        return list;
    }
    //将ProjectTeamFinishedCompletion的Date类型的beginTime 等字段 转换成字符串 存到ProjectTeamFinishedCompletion的String类型的str_beginTime字段，方便前台输出

    public static List<ProjectTeamFinishedCompletion> setProjectTeamFinishedCompletionDateString(List<ProjectTeamFinishedCompletion>  list){
        for(ProjectTeamFinishedCompletion record:list)
        {
            record.setStr_beginTime((DateUtil.DateToString(record.getBeginTime())));
            record.setStr_endTime((DateUtil.DateToString(record.getEndTime())));
        }
        return list;
    }
}
