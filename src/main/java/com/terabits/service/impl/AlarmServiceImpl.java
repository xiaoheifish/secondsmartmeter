package com.terabits.service.impl;

import com.terabits.dao.AlarmDao;
import com.terabits.meta.bo.TimeSpanBO;
import com.terabits.meta.po.AlarmPO;
import com.terabits.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
@Service("alarmService")
public class AlarmServiceImpl implements AlarmService{
    @Autowired
    private AlarmDao alarmDao;
    @Override
    public List<AlarmPO> alarmQuery(String begin, String end) {
        TimeSpanBO timeSpanBO = new TimeSpanBO();
        timeSpanBO.setBeginTime(begin);
        timeSpanBO.setEndTime(end);
        return alarmDao.selectAlarmByTime(timeSpanBO);
    }
    public int getSumAlarm(String time){
        return alarmDao.getSumAlarm(time);
    }
}
