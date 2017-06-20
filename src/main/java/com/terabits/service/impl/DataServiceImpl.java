package com.terabits.service.impl;

import com.terabits.dao.BuildingDao;
import com.terabits.dao.MeterDao;
import com.terabits.dao.TerminalDao;
import com.terabits.meta.bo.ReciveDataBO;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.po.BuildingPO;
import com.terabits.meta.po.MeterPO;
import com.terabits.meta.po.TerminalPO;
import com.terabits.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/1.
 */
@Service("dataService")
public class DataServiceImpl implements DataService{
    @Autowired
    private BuildingDao buildingDao;
    @Autowired
    private TerminalDao terminalDao;
    @Autowired
    private MeterDao meterDao;

    @Override
    public List<BuildingPO> dataQuery(String begin, String end, String building, String room) {
        SelectDataBO selectDataBO = new SelectDataBO();
        selectDataBO.setBeginTime(begin);
        selectDataBO.setEndTime(end);
        selectDataBO.setBuilding(building);
        selectDataBO.setRoom(room);
        System.out.println("test");
        return buildingDao.selectData(selectDataBO);
    }

    @Override
    public void dataInsert(ReciveDataBO receiveDataBO) {
        //根据终端ID获得IMEI
        TerminalPO terminalPO = terminalDao.selectOneTerminalById(receiveDataBO.getTerminalId());
        //根据IMEI和电表相对位置获得电表
        MeterPO meterPO = meterDao.selectMeterByRelativeLocation(terminalPO.getTerminalImei(), receiveDataBO.getMeterRelativeLocation());
        String building = meterPO.getBuilding();
        String tableName = "building" + building + "_data";
        List<BuildingPO> buildingPOS = new ArrayList<BuildingPO>();
        BuildingPO buildingPO = new BuildingPO();
        buildingPO.setBuilding(meterPO.getBuilding());
        buildingPO.setRoom(meterPO.getRoom());
        buildingPO.setCurrent(receiveDataBO.getCurrent());
        buildingPO.setPower(receiveDataBO.getPower());
        buildingPO.setVoltage(receiveDataBO.getVoltage());
        buildingPOS.add(buildingPO);
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("tablename",building);
        params.put("buildingPOS",buildingPOS);
        buildingDao.insertDataNew(params);
    }


}
