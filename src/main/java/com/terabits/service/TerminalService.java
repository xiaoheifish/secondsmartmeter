package com.terabits.service;

import com.terabits.meta.po.LogPO;

import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */
public interface TerminalService {
    public void add(String imei, LogPO logPO) throws Exception;
    public void remove(String imei, LogPO logPO) throws Exception;
    public void change(String oldImei, String newImei, LogPO logPO) throws Exception;
    public List<String> getAllTerminal();
}
