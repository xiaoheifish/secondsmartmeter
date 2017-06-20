package com.terabits.service.impl;

import com.terabits.dao.LogDao;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.po.LogPO;
import com.terabits.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
@Service("logService")
public class LogServiceImpl implements LogService{
    @Autowired
    private LogDao logDao;
    @Override
    public List<LogPO> logQuery(String begin, String end) {
        SelectDataBO selectDataBO = new SelectDataBO();
        selectDataBO.setBeginTime(begin);
        selectDataBO.setEndTime(end);
        return logDao.selectLog(selectDataBO);
    }

    public void logInsert(List<LogPO> logPOS) {
        for (LogPO logPO : logPOS) {
            logDao.insertLog(logPO);
        }
    }
}
