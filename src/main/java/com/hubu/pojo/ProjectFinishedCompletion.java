package com.hubu.pojo;

import java.util.Date;

public class ProjectFinishedCompletion {
    private Integer projectNo;
    private String projectName;
    private Float planStakes;
    private Float planMeters;
    private Float price;
    private Integer finishedStakes;
    private Float finishedMeters;
    private String finishedValue;
    private Float totalValue;
    private String completionRate;
    private Date beginTime;
    private Date endTime;
    private String str_beginTime;
    private String str_endTime;

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

    public Integer getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(Integer projectNo) {
        this.projectNo = projectNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Float getPlanStakes() {
        return planStakes;
    }

    public void setPlanStakes(Float planStakes) {
        this.planStakes = planStakes;
    }

    public Float getPlanMeters() {
        return planMeters;
    }

    public void setPlanMeters(Float planMeters) {
        this.planMeters = planMeters;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getFinishedStakes() {
        return finishedStakes;
    }

    public void setFinishedStakes(Integer finishedStakes) {
        this.finishedStakes = finishedStakes;
    }

    public Float getFinishedMeters() {
        return finishedMeters;
    }

    public void setFinishedMeters(Float finishedMeters) {
        this.finishedMeters = finishedMeters;
    }

    public String getFinishedValue() {
        return finishedValue;
    }

    public void setFinishedValue(String finishedValue) {
        this.finishedValue = finishedValue;
    }

    public Float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Float totalValue) {
        this.totalValue = totalValue;
    }

    public String getCompletionRate() {
        return completionRate;
    }

    public void setCompletionRate(String completionRate) {
        this.completionRate = completionRate;
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
}
