package com.hubu.pojo;

import java.util.Date;

public class ProjectTeamFinishedCompletion {
    private Integer projectNo;
    private Integer teamNo;
    private String projectName;
    private String teamName;
    private Float teamPlanStakes;
    private Float teamPlanMeters;
    private Integer finishedStakes;
    private Float finishedMeters;
    private Integer totalWeight;
    private Float averWeight;
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

    public Integer getTeamNo() {
        return teamNo;
    }

    public void setTeamNo(Integer teamNo) {
        this.teamNo = teamNo;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Float getTeamPlanStakes() {
        return teamPlanStakes;
    }

    public void setTeamPlanStakes(Float teamPlanStakes) {
        this.teamPlanStakes = teamPlanStakes;
    }

    public Float getTeamPlanMeters() {
        return teamPlanMeters;
    }

    public void setTeamPlanMeters(Float teamPlanMeters) {
        this.teamPlanMeters = teamPlanMeters;
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

    public Integer getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Integer totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Float getAverWeight() {
        return averWeight;
    }

    public void setAverWeight(Float averWeight) {
        this.averWeight = averWeight;
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
