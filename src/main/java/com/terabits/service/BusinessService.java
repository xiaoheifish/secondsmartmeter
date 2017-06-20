package com.terabits.service;

import com.terabits.meta.bo.TimeSpanBO;
import com.terabits.meta.po.BusinessMeterDataPO;
import com.terabits.meta.po.BusinessPaymentPO;

/**
 * Created by Administrator on 2017/6/15.
 */
public interface BusinessService {

    //新增24小时电表数据
    public int insertBusinessMeterData(BusinessMeterDataPO businessMeterDataPO);


    //新增24小时缴费数据
    public int insertBusinessPaymentData(BusinessPaymentPO businessPaymentPO);


    // 查询24小时电表数据
    public BusinessMeterDataPO selectBusinessMeterData(String time);

    //查询24小时缴费数据
    public BusinessPaymentPO selectBusinessPaymentData(String time);

    //查询1小时用电量之和
    public double selectSumMeterData(TimeSpanBO timeSpanBO);

}
