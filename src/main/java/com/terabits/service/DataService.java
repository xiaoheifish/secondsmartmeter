package com.terabits.service;

import com.terabits.meta.bo.ReciveDataBO;
import com.terabits.meta.po.BuildingPO;

import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
public interface DataService {
    public List<BuildingPO> dataQuery(String begin, String end, String building, String room);
    public void dataInsert(ReciveDataBO receiveDataBO);
}
