package com.terabits.controller.device;

import com.terabits.meta.po.LogPO;
import com.terabits.meta.po.MeterPO;
import com.terabits.service.impl.TerminalServiceImpl;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.terabits.service.TerminalService;
import com.terabits.service.MeterService;

/**
 * Created by Administrator on 2017/5/31.
 */
@Controller
public class DeviceController {
    @Autowired
    private TerminalService terminalService;
    @Autowired
    private MeterService meterService;

    public static void main(String[] args) throws Exception{
        String imei = "test";
        LogPO logPO = new LogPO();
        logPO.setLogInfo("添加终端：" + imei);
        TerminalService terminalService = new TerminalServiceImpl();
        try {
            terminalService.add(imei, logPO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/terminal/query", method = RequestMethod.GET)
    public void queryTerminal(HttpServletResponse response) throws Exception {
        List<String> imeiS = terminalService.getAllTerminal();
        JSONArray jsonArray = new JSONArray();
        for (String imei : imeiS) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("imei", imei);
            jsonArray.add(jsonObject);
        }
        System.out.println(jsonArray);
        response.getWriter().print(jsonArray);
    }

    @RequestMapping(value = "/terminal/add", method = RequestMethod.POST)
    public void addTerminal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String imei = request.getParameter("imei");
        JSONObject jsonObject = new JSONObject();
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        //String user = session.getAttribute("currentUser").toString();
        String user = "003";
        try {
            LogPO logPO = new LogPO();
            logPO.setLogInfo("添加终端：" + imei);
            logPO.setOperator(user);
            terminalService.add(imei, logPO);
            jsonObject.put("errno", 0);
            jsonObject.put("error", "succ");
            response.getWriter().print(jsonObject);
        }
        catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("errno", 1);
            jsonObject.put("error", e.getMessage());
            response.getWriter().print(jsonObject);
        }
    }

    @RequestMapping(value = "/terminal/remove", method = RequestMethod.POST)
    public void removeTerminal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String imei = request.getParameter("imei");
        JSONObject jsonObject = new JSONObject();
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        String user = session.getAttribute("currentUser").toString();
        try {
            LogPO logPO = new LogPO();
            logPO.setLogInfo("删除终端：" + imei);
            logPO.setOperator(user);
            terminalService.remove(imei, logPO);
            jsonObject.put("errno", 0);
            jsonObject.put("error", "succ");
            response.getWriter().print(jsonObject);
        }
        catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("errno", 1);
            jsonObject.put("error", e.getMessage());
            response.getWriter().print(jsonObject);
        }
    }

    @RequestMapping(value = "/terminal/change", method = RequestMethod.POST)
    public void changeTerminal(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String oldImei = request.getParameter("oldImei");
        String newImei = request.getParameter("newImei");
        JSONObject jsonObject = new JSONObject();
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        String user = session.getAttribute("currentUser").toString();
        try {
            LogPO logPO = new LogPO();
            logPO.setLogInfo("更换终端：原终端" + oldImei + "，新终端" + newImei);
            logPO.setOperator(user);
            terminalService.change(oldImei, newImei, logPO);
            jsonObject.put("errno", 0);
            jsonObject.put("error", "succ");
            response.getWriter().print(jsonObject);
        }
        catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("errno", 1);
            jsonObject.put("error", e.getMessage());
            response.getWriter().print(jsonObject);
        }
    }
    @RequestMapping(value = "/meter/query", method = RequestMethod.GET)
    public void queryMeter(HttpServletResponse response) throws Exception{
        JSONArray jsonArray = new JSONArray();
        List<String> buildingS = meterService.queryBuilding();
        for (String building : buildingS) {
            List<String> roomS = meterService.queryRoom(building);
            String roomR = "";
            for (String room : roomS) {
                roomR += room + ";";
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("building", building);
            jsonObject.put("room", roomR);
            jsonArray.add(jsonObject);
        }
        response.getWriter().print(jsonArray);
    }
    @RequestMapping(value = "/meter/add", method = RequestMethod.POST)
    public void addMeter(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String imei = request.getParameter("imei");
        String meterId = request.getParameter("meterId");
        String building = request.getParameter("building");
        String room = request.getParameter("room");
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        String user = session.getAttribute("currentUser").toString();
        JSONObject jsonObject = new JSONObject();
        try {
            MeterPO meterPO = new MeterPO();
            meterPO.setMeterId(meterId);
            meterPO.setBuilding(building);
            meterPO.setRoom(room);
            meterPO.setTerminalImei(imei);
            meterPO.setMeterRemain(0);
            meterPO.setMeterState(0);
            LogPO logPO = new LogPO();
            logPO.setLogInfo("添加电表：" + "building" + "-" + room);
            logPO.setOperator(user);
            meterService.add(meterPO, logPO);
            jsonObject.put("errno", 0);
            jsonObject.put("error", "succ");
            response.getWriter().print(jsonObject);
        }
        catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("errno", 1);
            jsonObject.put("error", e.getMessage());
            response.getWriter().print(jsonObject);
        }
    }
    @RequestMapping(value = "/meter/remove", method = RequestMethod.POST)
    public void removeMeter(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String building = request.getParameter("building");
        String room = request.getParameter("room");
        JSONObject jsonObject = new JSONObject();
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        String user = session.getAttribute("currentUser").toString();
        try {
            MeterPO meterPO = new MeterPO();
            meterPO.setBuilding(building);
            meterPO.setRoom(room);
            LogPO logPO = new LogPO();
            logPO.setLogInfo("删除电表：" + "building" + "-" + room);
            logPO.setOperator(user);
            meterService.remove(meterPO, logPO);
            jsonObject.put("errno", 0);
            jsonObject.put("error", "succ");
            response.getWriter().print(jsonObject);
        }
        catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("errno", 1);
            jsonObject.put("error", e.getMessage());
            response.getWriter().print(jsonObject);
        }
    }
}
