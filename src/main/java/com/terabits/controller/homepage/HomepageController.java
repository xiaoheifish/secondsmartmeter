package com.terabits.controller.homepage;

import com.terabits.service.AlarmService;
import com.terabits.service.BusinessService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/18.
 */
@Controller
public class HomepageController {
    @Autowired
    private BusinessService businessService;
    @Autowired
    private AlarmService alarmService;
    @RequestMapping(value = {"/display/day"}, method = { RequestMethod.GET })
    public void queryListMember(HttpServletRequest request,
                                HttpServletResponse response) throws IOException {
        SimpleDateFormat dfs = new SimpleDateFormat( "yyyy-MM-dd" );
        Date date = new Date();
        String currentTime = dfs.format(date);
        Map<String, String> dataMap = new HashMap<String, String>();
        double power = businessService.selectBusinessMeterData(currentTime).getPower();
        dataMap.put("power", Double.toString(power));
        int payment = businessService.selectBusinessPaymentData(currentTime).getPayment();
        dataMap.put("payment", Integer.toString(payment));
        int alarmCount = alarmService.getSumAlarm(currentTime);
        dataMap.put("alarm", Integer.toString(alarmCount));
        JSONObject jsonObject = JSONObject.fromObject(dataMap);
        System.out.println(jsonObject);
        response.getWriter().print(jsonObject);
    }

}
