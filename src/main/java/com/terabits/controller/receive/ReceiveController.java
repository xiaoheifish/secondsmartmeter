package com.terabits.controller.receive;

import com.terabits.iotconnetion.CodecComponent;
import com.terabits.meta.bo.ReciveDataBO;
import com.terabits.meta.po.LogPO;
import com.terabits.service.DataService;
import com.terabits.service.LogService;
import com.terabits.service.MeterService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/5.
 */
@Controller
public class ReceiveController {
    @Autowired
    private DataService dataService;
    @Autowired
    private MeterService meterService;
    @Autowired
    private LogService logService;

    @RequestMapping(value = "/receive/data", method = RequestMethod.POST)
    public void data(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BufferedReader br = request.getReader();
        String str, wholeStr = "";
        while((str = br.readLine()) != null){
            wholeStr += str;
        }
        System.out.println(wholeStr);
        JSONObject json = JSONObject.fromObject(wholeStr);
        Map<String, Object> map = (Map<String, Object>)json;
        String terminalId = (String) map.get("deviceId");
        Map<String, Object> service = (Map<String, Object>)map.get("service");
        Map<String, Object> data = (Map<String, Object>)service.get("data");

        int type = Integer.valueOf((String)data.get("type"));
        if (type == CodecComponent.RECEIVE_DATA) {
            int meterRelativeLocation = Integer.valueOf((String)data.get("meterId"));
            double power = Double.valueOf((String)data.get("power"));
            double voltage = Double.valueOf((String)data.get("voltage"));
            double current = Double.valueOf((String)data.get("current"));
            ReciveDataBO reciveDataBO = new ReciveDataBO();
            reciveDataBO.setTerminalId(terminalId);
            reciveDataBO.setMeterRelativeLocation(meterRelativeLocation);
            reciveDataBO.setCurrent(current);
            reciveDataBO.setPower(power);
            reciveDataBO.setVoltage(voltage);
            dataService.dataInsert(reciveDataBO);
        } else if (type == CodecComponent.SEND_ADDRESS) {
            meterService.setMeterAddress(terminalId);
        } else if (type == CodecComponent.TERMINAL_INFORMATION) {
            String info = (String)data.get("terminalState");
        }
    }

    @RequestMapping(value = "/receive/reply", method = RequestMethod.POST)
    public void reply(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BufferedReader br = request.getReader();
        String str, wholeStr = "";
        while((str = br.readLine()) != null){
            wholeStr += str;
        }
        System.out.println(wholeStr);
        JSONObject json = JSONObject.fromObject(wholeStr);
        Map<String, Object> map = (Map<String, Object>)json;
        String terminalId = (String) map.get("deviceId");
        Map<String, Object> service = (Map<String, Object>)map.get("service");
        Map<String, Object> data = (Map<String, Object>)service.get("data");
        int type = Integer.valueOf((String)data.get("type"));
        if (type == CodecComponent.REPLY_COMMAND) {
            int meterId = Integer.valueOf((String)data.get("meterId"));
            int meterState = Integer.valueOf((String)data.get("meterState"));
            if (meterState == CodecComponent.METER_STATE_OFF) {
                meterService.setMeterState(terminalId, meterId, 2);
            } else if (meterState == CodecComponent.METER_STATE_ON) {
                meterService.setMeterState(terminalId, meterId, 1);
            } else if (meterState == CodecComponent.METER_STATE_ERROR) {

            } else if (meterState == CodecComponent.METER_ADRRESS_RECEIVED) {
                meterService.setMeterState(terminalId, meterId, 1);
            }
        }
    }
}
