package com.terabits.service;

import com.terabits.meta.bo.TempBusinessDataBO;

import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 */
public interface BuildingService {
    public void insertBuildingData();
    public List<TempBusinessDataBO> selectMaxMeterData(String tableName, String time);
    public List<TempBusinessDataBO> selectMinMeterData(String tableName, String time);
}
