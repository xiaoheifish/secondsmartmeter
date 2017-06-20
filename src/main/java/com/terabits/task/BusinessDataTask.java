package com.terabits.task;

import java.text.SimpleDateFormat;
import com.terabits.meta.bo.TempBusinessDataBO;
import com.terabits.meta.bo.TempBusinessPaymentBO;
import com.terabits.meta.po.BusinessMeterDataPO;
import com.terabits.meta.po.BusinessPaymentPO;
import com.terabits.service.AdminUserService;
import com.terabits.service.BuildingService;
import com.terabits.service.BusinessService;
import com.terabits.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class BusinessDataTask {
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private BusinessService businessService;
    @Autowired
    private PaymentService paymentService;
    @Scheduled(cron = "0 0/15 * * * *")
    //每隔15分钟计算一次当日使用总电量和当日缴费总和，存入businessmeterdata和businesspayment表中
    void calculateSum(){
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dfsCurrent = new SimpleDateFormat("yyyy-MM-dd");
        Date time1 = new Date();
        Date currentTime = new Date();
        String time11 = dfs.format(time1);
        String currentQueryTime = dfs.format(currentTime);
        List<TempBusinessDataBO> MaxDataBOList = buildingService.selectMaxMeterData("building01_data",currentQueryTime);
        List<TempBusinessDataBO> MinDataBOList = buildingService.selectMinMeterData("building01_data",currentQueryTime);
        Double sum1 = 0.0;
        Double sum2 = 0.0;
        for(int i = 0; i< MaxDataBOList.size();i++){
            sum1 += MaxDataBOList.get(i).getTempPower();
            sum2 += MinDataBOList.get(i).getTempPower();
        }
        Double power = sum1 - sum2;
        BusinessMeterDataPO businessMeterDataPO = new BusinessMeterDataPO();
        businessMeterDataPO.setPower(power);
        businessService.insertBusinessMeterData(businessMeterDataPO);
        int payment = paymentService.selectSumPayment(currentQueryTime);
        BusinessPaymentPO businessPaymentPO = new BusinessPaymentPO();
        businessPaymentPO.setPayment(payment);
        businessService.insertBusinessPaymentData(businessPaymentPO);
        System.out.println(power);
        System.out.println("I'm doing with cron now!" + time11);
    }

}

