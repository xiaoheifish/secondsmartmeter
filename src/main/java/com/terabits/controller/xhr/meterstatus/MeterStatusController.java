package com.terabits.controller.xhr.meterstatus;

import com.terabits.meta.bo.LocationBO;
import com.terabits.meta.vo.MeterStatusVO;
import com.terabits.service.MeterService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/6/19.
 */
@Controller
public class MeterStatusController {
    @Autowired
    private MeterService meterService;
    @RequestMapping(value = {"/xhr/meter/data"}, method = { RequestMethod.POST})
    public void queryPaymentInfo(HttpServletRequest request,
                                 HttpServletResponse response) throws IOException {
        List<LocationBO> locationBOS = new ArrayList<LocationBO>();
        LocationBO locationBO = new LocationBO();
        String building = request.getParameter("building");
        String room = request.getParameter("room");
        if(!building.equals("all")){
            locationBO.setBuilding(building);
        }
        if(!room.equals("all")){
            locationBO.setRoom(room);
            locationBOS.add(locationBO);
        }
        else{
            locationBOS = meterService.getAllMeter();
        }
        List<MeterStatusVO> meterStatusVOList = meterService.selectListMeter(locationBOS);
        System.out.println(meterStatusVOList);
        JSONArray jsonArray = JSONArray.fromObject(meterStatusVOList);
        response.getWriter().print(jsonArray);
    }
}
