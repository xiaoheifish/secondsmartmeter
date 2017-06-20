package com.terabits.meta.po;

/**
 * Created by Administrator on 2017/5/23.
 */
public class SharePO {
    int id;
    String building;
    double powerTotal;
    double feeTotal;
    String month;
    String gmtCreate;
    String gmtModified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public double getPowerTotal() {
        return powerTotal;
    }

    public void setPowerTotal(double powerTotal) {
        this.powerTotal = powerTotal;
    }

    public double getFeeTotal() {
        return feeTotal;
    }

    public void setFeeTotal(double feeTotal) {
        this.feeTotal = feeTotal;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(String gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "SharePO[" +
                "id=" + id +
                ", building='" + building + '\'' +
                ", powerTotal=" + powerTotal +
                ", feeTotal=" + feeTotal +
                ", month='" + month + '\'' +
                ", gmtCreate='" + gmtCreate + '\'' +
                ", gmtModified='" + gmtModified + '\'' +
                ']';
    }
}
