package com.terabits.controller.command;

import com.terabits.service.MeterService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/6/7.
 */
@Controller
public class CommandController {

    @Autowired
    MeterService meterService;

    @RequestMapping(value = "/command/start_stop", method = RequestMethod.POST)
    public void startStop(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String building = request.getParameter("building");
        String room = request.getParameter("room");
        int command = Integer.valueOf(request.getParameter("command"));
        JSONObject jsonObject = new JSONObject();
        try {
            meterService.sendStartOrStopCommand(building, room, command);
            jsonObject.put("errno", 0);
            jsonObject.put("error", "succ");
            response.getWriter().print(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("errno", 1);
            jsonObject.put("error", e.getMessage());
            response.getWriter().print(jsonObject);
        }
    }
}
