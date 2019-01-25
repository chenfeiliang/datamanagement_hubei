package com.hubu.utils;

import com.hubu.pojo.Record;
import com.hubu.pojo.RecordExample;

import java.util.List;

public class RecordHelper {
    public static List<Record> setRecordDateString(List<Record>  records){
        for(Record record:records)
        {
            record.setStr_beginTime((DateUtil.DateToString(record.getBeginTime())));
            record.setStr_endTime((DateUtil.DateToString(record.getEndTime())));
            record.setStr_gatherTime((DateUtil.DateToString(record.getGatherTime())));
        }
        return records;
    }


}
