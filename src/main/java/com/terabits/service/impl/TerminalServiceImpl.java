package com.terabits.service.impl;

import com.terabits.dao.LogDao;
import com.terabits.dao.TerminalDao;
import com.terabits.dao.MeterDao;
import com.terabits.meta.po.LogPO;
import com.terabits.meta.po.TerminalPO;
import com.terabits.service.TerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.terabits.iotconnetion.HttpsUtil;
import com.terabits.iotconnetion.PlatformGlobal;
import com.terabits.iotconnetion.JsonUtil;

/**
 * Created by Administrator on 2017/5/27.
 */
@Service("terminalService")
public class TerminalServiceImpl implements TerminalService {
    @Autowired
    private TerminalDao terminalDao;
    @Autowired
    private MeterDao meterDao;
    @Autowired
    private LogDao logDao;

    public void add(String imei, LogPO logPO) throws Exception{
        //注册设备
        System.out.println("aaa");
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();

        String accessToken = PlatformGlobal.login(httpsUtil);
        String EndUserId = "currentuser";

        Map<String, Object> paramReg = new HashMap<String, Object>();
        paramReg.put("verifyCode", imei);
        paramReg.put("nodeId", imei);
        paramReg.put("endUserId", EndUserId);
        paramReg.put("timeout", 0);

        String jsonRequest = JsonUtil.jsonObj2Sting(paramReg);

        Map<String, String> header = new HashMap<String, String>();
        header.put("app_key", PlatformGlobal.appId);
        header.put("Authorization", "Bearer " + accessToken);

        String bodyReg = httpsUtil.doPostJsonForString(PlatformGlobal.urlReg, header,
                jsonRequest);

        Map<String, String> data = new HashMap<String, String>();
        data = JsonUtil.jsonString2SimpleObj(bodyReg, data.getClass());
        String deviceId = data.get("deviceId");

        System.out.println(bodyReg);

        //设置设备信息
        String urlSetDeviceInfo = PlatformGlobal.urlSetDeviceInfo + deviceId;

        Map<String, Object> paramSetDeviceInfo = new HashMap<String, Object>();
        paramSetDeviceInfo.put("manufacturerId", PlatformGlobal.manufacturerId);
        paramSetDeviceInfo.put("manufacturerName", PlatformGlobal.manufacturerName);
        paramSetDeviceInfo.put("deviceType", PlatformGlobal.deviceType);
        paramSetDeviceInfo.put("protocolType", PlatformGlobal.protocolType);
        paramSetDeviceInfo.put("model", PlatformGlobal.model);

        jsonRequest = JsonUtil.jsonObj2Sting(paramSetDeviceInfo);
        String bodyModifyDeviceInfo = httpsUtil.doPutJsonForString(urlSetDeviceInfo, header, jsonRequest);

        //数据库操作
        TerminalPO terminalPO = new TerminalPO();
        terminalPO.setTerminalImei(imei);
        terminalPO.setTerminalId(deviceId);
        terminalPO.setTerminalState(1);
        terminalDao.insertTerminal(terminalPO);

        //添加日志
        if (logPO != null)
            logDao.insertLog(logPO);
    }
    public void remove(String imei, LogPO logPO) throws Exception{
        //删除设备
        HttpsUtil httpsUtil = new HttpsUtil();
        httpsUtil.initSSLConfigForTwoWay();

        String accessToken = PlatformGlobal.login(httpsUtil);
        TerminalPO ternimalPO = terminalDao.selectOneTerminal(imei);
        String deviceId = ternimalPO.getTerminalId();
        String urlDelete = PlatformGlobal.urlDelete + deviceId;

        Map<String, String> header = new HashMap<String, String>();
        header.put("app_key", PlatformGlobal.appId);
        header.put("Authorization", "Bearer " + accessToken);

        String bodyDelete = httpsUtil.doDeleteForString(urlDelete, header);

        //数据库操作
        terminalDao.deleteTerminal(imei);
        meterDao.deleteGroupMeter(imei);

        //添加日志
        if (logPO != null)
            logDao.insertLog(logPO);
    }
    public void change(String oldImei, String newImei, LogPO logPO) throws Exception{
        //考虑外键约束，先注册新终端
        add(newImei, null);
        TerminalPO ternimalNew = terminalDao.selectOneTerminal(newImei);
        TerminalPO ternimalOld = terminalDao.selectOneTerminal(oldImei);
        //更新电表关联终端IMEI号
        meterDao.updateGroupImei(ternimalNew.getTerminalImei(), ternimalOld.getTerminalImei());
        //删除原终端
        remove(oldImei, null);
        //将原终端创建时间写入新终端
        terminalDao.updateTerminalCreateTime(ternimalOld.getGmtCreate(), newImei);

        //添加日志
        logDao.insertLog(logPO);
    }

    public List<String> getAllTerminal() {
        List<TerminalPO> terminalPOS = terminalDao.selectAllTerminal();
        List<String> imeiS = new ArrayList<String>();
        for (TerminalPO terminalPO : terminalPOS) {
            imeiS.add(terminalPO.getTerminalImei());
        }
        return imeiS;
    }

}
