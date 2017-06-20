package com.terabits.controller.query;

import com.terabits.meta.po.AlarmPO;
import com.terabits.meta.po.BuildingPO;
import com.terabits.meta.po.LogPO;
import com.terabits.service.AlarmService;
import com.terabits.service.DataService;
import com.terabits.service.LogService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/6/1.
 */
@Controller
public class QueryController {
    @Autowired
    private AlarmService alarmService;
    @Autowired
    private DataService dataService;
    @Autowired
    private LogService logService;

    @RequestMapping(value = "/alarm/query", method = RequestMethod.GET)
    public void queryAlarm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String begin = request.getParameter("begin");
        String end = request.getParameter("end");
        JSONArray jsonArray = new JSONArray();
        List<AlarmPO> alarmPOS = alarmService.alarmQuery(begin, end);
        for (AlarmPO alarmPO : alarmPOS) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("imei", alarmPO.getTerminalImei());
            jsonObject.put("type", alarmPO.getAlarmType());
            jsonObject.put("info", alarmPO.getAlarmInfo());
            jsonObject.put("buidling", alarmPO.getBuilding());
            jsonObject.put("room", alarmPO.getRoom());
            jsonObject.put("time", alarmPO.getGmtCreate());
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray);
        response.getWriter().print(jsonArray);
    }

    @RequestMapping(value = "/data/query", method = RequestMethod.GET)
    public void dataAlarm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String begin = request.getParameter("begin");
        String end = request.getParameter("end");
        String building = "0" + request.getParameter("building");
        String room = "10" + request.getParameter("room");
        JSONArray jsonArray = new JSONArray();
        List<BuildingPO> buildingPOS = dataService.dataQuery(begin, end, building, room);
        for (BuildingPO buildingPO : buildingPOS) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("buidling", buildingPO.getBuilding());
            jsonObject.put("room", buildingPO.getRoom());
            jsonObject.put("voltage", buildingPO.getVoltage());
            jsonObject.put("current", buildingPO.getCurrent());
            jsonObject.put("power", buildingPO.getPower());
            jsonObject.put("time", buildingPO.getGmtCreate());
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray);
        response.getWriter().print(jsonArray);
    }

    @RequestMapping(value = "/log/query", method = RequestMethod.GET)
    public void logAlarm(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String begin = request.getParameter("begin");
        String end = request.getParameter("end");
        JSONArray jsonArray = new JSONArray();
        List<LogPO> logPOS = logService.logQuery(begin, end);
        for (LogPO logPO : logPOS) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("info", logPO.getLogInfo());
            jsonObject.put("operation", logPO.getOperator());
            jsonObject.put("time", logPO.getGmtCreate());
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray);
        response.getWriter().print(jsonArray);
    }
}
