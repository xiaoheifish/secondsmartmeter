package com.terabits.service;

import com.terabits.meta.bo.LocationBO;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.po.LogPO;
import com.terabits.meta.po.MeterClientPO;
import com.terabits.meta.po.MeterPO;
import com.terabits.meta.vo.MeterStatusVO;

import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */
public interface MeterService {
    public void add(MeterPO meterPO, LogPO logPO) throws Exception;
    public void remove(MeterPO meterPO, LogPO logPO) throws Exception;
    public List<String> queryBuilding();
    public List<String> queryRoom(String building);
    public void setMeterAddress(String terminalId) throws Exception;
    public void setMeterState(String terminalId, int relativeLocation, int state);
    public void sendStartOrStopCommand(String building, String room, int command) throws Exception;
    public List<MeterPO> selectMeterInfo(SelectDataBO selectDataBO);
    public MeterClientPO quertMeterClient(LocationBO locationBO);
    public List<MeterStatusVO> selectListMeter(List<LocationBO> locationBOS);
    public List<LocationBO> getAllMeter();
}
