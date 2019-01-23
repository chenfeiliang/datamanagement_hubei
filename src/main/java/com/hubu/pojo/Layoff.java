package com.hubu.pojo;

public class Layoff {
    private String machineNo;

    private String pileNo;

    private Float firstWeight;

    private Float secondWeight;

    private Float firstDepth;

    private Float secondDepth;

    private Float sumDepth;

    private String beginTime;

    private String endTime;

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

    public Float getFirstWeight() {
        return firstWeight;
    }

    public void setFirstWeight(Float firstWeight) {
        this.firstWeight = firstWeight;
    }

    public Float getSecondWeight() {
        return secondWeight;
    }

    public void setSecondWeight(Float secondWeight) {
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

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime == null ? null : beginTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    @Override
    public String toString() {
        return "Layoff{" +
                "machineNo='" + machineNo + '\'' +
                ", pileNo='" + pileNo + '\'' +
                ", firstWeight=" + firstWeight +
                ", secondWeight=" + secondWeight +
                ", firstDepth=" + firstDepth +
                ", secondDepth=" + secondDepth +
                ", sumDepth=" + sumDepth +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}