package com.hubu.pojo;

import java.util.Date;

public class Record {
    private Integer recordNo;

    private String machineNo;

    private String pileNo;

    private Integer firstWeight;

    private Integer secondWeight;

    private Float firstDepth;

    private Float secondDepth;

    private Float sumDepth;

    private String collectData;

    private Date gatherTime;

    private String str_gatherTime;

    private Date beginTime;

    private String str_beginTime;

    private Date endTime;

    private String str_endTime;

    private String weightRecord;

    public Integer getRecordNo() {
        return recordNo;
    }

    public void setRecordNo(Integer recordNo) {
        this.recordNo = recordNo;
    }

    public String getMachineNo() {
        return machineNo;
    }

    public void setMachineNo(String machineNo) {
        this.machineNo = machineNo == null ? null : machineNo.trim();
    }

    public String getPileNo() {
        return pileNo;
    }

    public void setPileNo(String pileNo) {
        this.pileNo = pileNo == null ? null : pileNo.trim();
    }

    public Integer getFirstWeight() {
        return firstWeight;
    }

    public void setFirstWeight(Integer firstWeight) {
        this.firstWeight = firstWeight;
    }

    public Integer getSecondWeight() {
        return secondWeight;
    }

    public void setSecondWeight(Integer secondWeight) {
        this.secondWeight = secondWeight;
    }

    public Float getFirstDepth() {
        return firstDepth;
    }

    public void setFirstDepth(Float firstDepth) {
        this.firstDepth = firstDepth;
    }

    public Float getSecondDepth() {
        return secondDepth;
    }

    public void setSecondDepth(Float secondDepth) {
        this.secondDepth = secondDepth;
    }

    public Float getSumDepth() {
        return sumDepth;
    }

    public void setSumDepth(Float sumDepth) {
        this.sumDepth = sumDepth;
    }

    public String getCollectData() {
        return collectData;
    }

    public void setCollectData(String collectData) {
        this.collectData = collectData == null ? null : collectData.trim();
    }

    public Date getGatherTime() {
        return gatherTime;
    }

    public void setGatherTime(Date gatherTime) {
        this.gatherTime = gatherTime;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStr_gatherTime() {
        return str_gatherTime;
    }

    public void setStr_gatherTime(String str_gatherTime) {
        this.str_gatherTime = str_gatherTime;
    }

    public String getStr_beginTime() {
        return str_beginTime;
    }

    public void setStr_beginTime(String str_beginTime) {
        this.str_beginTime = str_beginTime;
    }

    public String getStr_endTime() {
        return str_endTime;
    }

    public void setStr_endTime(String str_endTime) {
        this.str_endTime = str_endTime;
    }

    public String getWeightRecord() {
        return weightRecord;
    }

    public void setWeightRecord(String weightRecord) {
        this.weightRecord = weightRecord == null ? null : weightRecord.trim();
    }

    @Override
    public String toString() {
        return "Record{" +
                "recordNo=" + recordNo +
                ", machineNo='" + machineNo + '\'' +
                ", pileNo='" + pileNo + '\'' +
                ", firstWeight=" + firstWeight +
                ", secondWeight=" + secondWeight +
                ", firstDepth=" + firstDepth +
                ", secondDepth=" + secondDepth +
                ", sumDepth=" + sumDepth +
                ", collectData='" + collectData + '\'' +
                ", gatherTime=" + gatherTime +
                ", str_gatherTime='" + str_gatherTime + '\'' +
                ", beginTime=" + beginTime +
                ", str_beginTime='" + str_beginTime + '\'' +
                ", endTime=" + endTime +
                ", str_endTime='" + str_endTime + '\'' +
                ", weightRecord='" + weightRecord + '\'' +
                '}';
    }
}