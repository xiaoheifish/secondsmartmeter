package com.terabits.service.impl;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.terabits.dao.LogDao;
import com.terabits.dao.MeterDao;
import com.terabits.dao.TerminalDao;
import com.terabits.iotconnetion.CodecComponent;
import com.terabits.iotconnetion.JsonUtil;
import com.terabits.iotconnetion.PlatformGlobal;
import com.terabits.meta.bo.LocationBO;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.po.LogPO;
import com.terabits.meta.po.MeterClientPO;
import com.terabits.meta.po.MeterPO;
import com.terabits.meta.po.TerminalPO;
import com.terabits.meta.vo.MeterStatusVO;
import com.terabits.service.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */
@Service("meterService")
public class MeterServiceImpl implements MeterService {
    @Autowired
    private MeterDao meterDao;
    @Autowired
    private TerminalDao terminalDao;
    @Autowired
    private LogDao logDao;

    public void add(MeterPO meterPO, LogPO logPO) throws Exception{
        //查看并分配相对位置
        List<Integer> relativeLocationS = meterDao.selectAllRelctiveLocationByImei(meterPO.getTerminalImei());
        if (relativeLocationS.size() == PlatformGlobal.limitDevicesByOneTerminal) {
            throw new Exception("终端电表数已达到最大");
        }
        int [] array = new int[PlatformGlobal.limitDevicesByOneTerminal];
        for (int i = 0; i < PlatformGlobal.limitDevicesByOneTerminal; i++) array[i] = 0;
        for (Integer relativeLocation : relativeLocationS) {
            array[relativeLocation] = 1;
        }
        for (int i = 0; i < PlatformGlobal.limitDevicesByOneTerminal; i++) {
            if (array[i] == 0) {
                meterPO.setRelativeLocation(i);
                break;
            }
        }
        meterDao.insertMeter(meterPO);
        //添加日志
        logDao.insertLog(logPO);
    }
    public void remove(MeterPO meterPO, LogPO logPO) throws Exception {
        meterDao.deleteMeter(meterPO.getBuilding(), meterPO.getRoom());
        //通知终端删除电表
        MeterPO meterPo = meterDao.selectOneMeter(meterPO.getBuilding(), meterPO.getRoom());
        String terminalImei = meterPo.getTerminalImei();
        String meterId = meterPo.getMeterId();
        TerminalPO terminalPO = terminalDao.selectOneTerminal(terminalImei);
        String terminalId = terminalPO.getTerminalId();
        byte[] command = {0};
        PlatformGlobal.command(command, terminalId);
        //添加日志
        logDao.insertLog(logPO);
    }

    public List<String> queryBuilding() {
        return meterDao.selectAllBuilding();
    }

    public List<String> queryRoom(String building) {
        return meterDao.selectAllRoomByBuilding(building);
    }

    public void setMeterAddress(String terminalId) throws Exception{
        TerminalPO terminalPO = terminalDao.selectOneTerminalById(terminalId);
        List<MeterPO> meterPOS = meterDao.selectMeterByImei(terminalPO.getTerminalImei());
        int meterNumber = 0;
        String meterAddress = "";
        String meterRelativeLocation = "";
        for (MeterPO meterPO : meterPOS) {
            if (meterPO.getMeterState() == 0) {
                meterNumber++;
                meterAddress += meterPO.getMeterId();
                meterRelativeLocation += meterPO.getRelativeLocation();
            }
        }
        if (meterNumber == 0) {
            return;
        }
        String paraStr = "{";
        paraStr += "\"meterNumber\":" + meterNumber;
        paraStr += "\"meterAddress\":\"" + meterAddress + "\"";
        paraStr += "\"meterId\":\"" + meterRelativeLocation + "\"";
        paraStr += "}";
        ObjectNode node = JsonUtil.convertObject2ObjectNode(paraStr);
        PlatformGlobal.command(terminalId, "METER_ID", node);
    }

    public void setMeterState(String terminalId, int relativeLocation, int state) {
        TerminalPO terminalPO = terminalDao.selectOneTerminalById(terminalId);
        MeterPO meterPO = meterDao.selectMeterByRelativeLocation(terminalPO.getTerminalImei(), relativeLocation);
        meterDao.updateMeterState(state, meterPO.getBuilding(), meterPO.getRoom());
    }

    public void sendStartOrStopCommand(String building, String room, int command) throws Exception{
        MeterPO meterPO = meterDao.selectOneMeter(building, room);
        TerminalPO terminalPO = terminalDao.selectOneTerminal(meterPO.getTerminalImei());
        String terminalId = terminalPO.getTerminalId();
        int state = CodecComponent.METER_COMMAND_OFF;
        if (command == 1) {
            state = CodecComponent.METER_COMMAND_ON;
        }
        int relativeLocation = meterPO.getRelativeLocation();
        String paraStr = "{";
        paraStr += "\"meterId\":" + relativeLocation;
        paraStr += "\"state\":" + state;
        paraStr += "}";
        ObjectNode node = JsonUtil.convertObject2ObjectNode(paraStr);
        PlatformGlobal.command(terminalId, "START_STOP", node);
    }

    public List<MeterPO> selectMeterInfo(SelectDataBO selectDataBO){
        return meterDao.selectMeterInfo(selectDataBO);
    }

    public MeterClientPO quertMeterClient(LocationBO locationBO){
        return meterDao.queryMeterClient(locationBO);
    }

    public List<MeterStatusVO> selectListMeter(List<LocationBO> locationBOS){
        return meterDao.selectListMeter(locationBOS);
    }

    public List<LocationBO> getAllMeter(){
        return meterDao.getAllMeter();
    }
}
