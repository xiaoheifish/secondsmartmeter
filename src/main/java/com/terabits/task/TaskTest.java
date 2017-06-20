package com.terabits.task;

import com.terabits.meta.bo.TimeSpanBO;
import com.terabits.service.BusinessService;
import com.terabits.utils.TimeUtil;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by Administrator on 2017/6/1.
 */
@Component
@Transactional
public class TaskTest {
    @Autowired
    private BusinessService businessService;
    @Scheduled(cron = "0 0 0/1 * * *")
    //每隔1个小时，计算这个小时的总用电量，并存入redis；redis中不存在的时候是add，redis中存在的时候是update
    void calculateHourlyPower(){
        TimeSpanBO timeSpanBO = TimeUtil.getTimeSpan();
        double power = businessService.selectSumMeterData(timeSpanBO);
        if(power == 0.0){
            power = 8888;
        }
        String timeId = timeSpanBO.getEndTime().substring(11,13);
        String url = "http://localhost:8080/SmartMeter/member/" + timeId + "/query";
        HttpClient httpClient = new DefaultHttpClient();
        // get method
        HttpPost httpPost = new HttpPost(url);
        //response
        HttpResponse response = null;
        try{
            response = httpClient.execute(httpPost);
        }catch (Exception e) {
        }
        String temp="";
        try{
            HttpEntity entity = response.getEntity();
            temp=EntityUtils.toString(entity,"UTF-8");
        }catch (Exception e) {}
        System.out.println(temp);
        if(temp == null){
            String urlAdd = "http://localhost:8080/SmartMeter/member/add";
            httpPost = new HttpPost(urlAdd);
            // set header
            httpPost.setHeader("Content-Type","application/x-www-form-urlencoded");
            //set params
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("id",timeId));
            params.add(new BasicNameValuePair("electricity", Double.toString(power)));
            try{
                httpPost.setEntity(new UrlEncodedFormEntity(params));
            }catch (Exception e) {}
            try{
                response = httpClient.execute(httpPost);
            }catch (Exception e) {
            }
            String result = "";
            try{
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity,"UTF-8");
            }catch (Exception e) {}
            System.out.println(result);
        }
        else{
            String urlUpdate = "http://localhost:8080/SmartMeter/member/update";
            httpPost = new HttpPost(urlUpdate);
            // set header
            httpPost.setHeader("Content-Type","application/x-www-form-urlencoded");
            //set params
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("id",timeId));
            params.add(new BasicNameValuePair("electricity", Double.toString(power)));
            try{
                httpPost.setEntity(new UrlEncodedFormEntity(params));
            }catch (Exception e) {}
            try{
                response = httpClient.execute(httpPost);
            }catch (Exception e) {
            }
            String result = "";
            try{
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity,"UTF-8");
            }catch (Exception e) {}

            System.out.println(result);
        }
    }

}
