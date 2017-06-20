package com.terabits.service.impl;

import com.terabits.dao.BuildingDao;
import com.terabits.dao.MeterDao;
import com.terabits.meta.bo.TempBusinessDataBO;
import com.terabits.meta.po.BuildingPO;
import com.terabits.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/26.
 */
@Service("buildingService")
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private MeterDao meterDao;
    @Autowired
    private BuildingDao buildingDao;

    public void insertBuildingData() {
        List buildingPOS = new ArrayList<BuildingPO>();
        //LocationBO locationBO= meterDao.selectLocation("312010");

        for (int i = 0; i < 3; i++) {
            BuildingPO buildingPO = new BuildingPO();
            buildingPO.setBuildingNum("building01_data");
            buildingPO.setBuilding("01");
            buildingPO.setCurrent(1);
            buildingPO.setVoltage(2);
            int room = 101 + i;
            buildingPO.setRoom(Integer.toString(room));
            buildingPO.setPower(20 + i);
            buildingPOS.add(buildingPO);
        }
        //BuildingDao buildingOneDao = new BuildingDao();
        //BuildingDao.insertData(buildingPOS);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("tablename", "building01_data");
        params.put("buildingPOS", buildingPOS);
        buildingDao.insertDataNew(params);

/*
        List buildingPOS1 = new ArrayList<BuildingPO>();
        //LocationBO locationBO= meterDao.selectLocation("312010");
        for (int i = 0; i < 3; i++)
        {
            BuildingPO buildingPO = new BuildingPO();
            buildingPO.setBuildingNum("building01_data");
            buildingPO.setBuilding("01");
            buildingPO.setCurrent(1);
            buildingPO.setVoltage(2);
            int room = 201 + i;
            buildingPO.setRoom(Integer.toString(room));
            buildingPO.setPower(25 + i);
            buildingPOS1.add(buildingPO);
        }
        //BuildingDao buildingOneDao = new BuildingDao();
        //BuildingDao.insertData(buildingPOS);
        Map<String, Object> params1 = new HashMap<String, Object>();
        params1.put("tablename", "building01_data");
        params1.put("buildingPOS", buildingPOS1);
        buildingDao.insertDataNew(params1);

        List buildingPOS2 = new ArrayList<BuildingPO>();
        //LocationBO locationBO= meterDao.selectLocation("312010");
        for (int i = 0; i < 3; i++)
        {
            BuildingPO buildingPO = new BuildingPO();
            buildingPO.setBuildingNum("building01_data");
            buildingPO.setBuilding("01");
            buildingPO.setCurrent(1);
            buildingPO.setVoltage(2);
            int room = 301 + i;
            buildingPO.setRoom(Integer.toString(room));
            buildingPO.setPower(28 + i);
            buildingPOS2.add(buildingPO);
        }
        //BuildingDao buildingOneDao = new BuildingDao();
        //BuildingDao.insertData(buildingPOS);
        Map<String, Object> params2 = new HashMap<String, Object>();
        params2.put("tablename", "building01_data");
        params2.put("buildingPOS", buildingPOS2);
        buildingDao.insertDataNew(params2);*/

    }

    public List<TempBusinessDataBO> selectMaxMeterData(String tableName, String time){
        List<TempBusinessDataBO> tempBusinessDataBOS = buildingDao.selectMaxMeterData(tableName, time);
        return tempBusinessDataBOS;
    }

    public List<TempBusinessDataBO> selectMinMeterData(String tableName, String time){
        List<TempBusinessDataBO> tempBusinessDataBOS = buildingDao.selectMinMeterData(tableName, time);
        return tempBusinessDataBOS;
    }
}
