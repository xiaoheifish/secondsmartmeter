package com.terabits.controller.display;

/**
 * Created by Administrator on 2017/5/9.
 */

import com.terabits.meta.bo.TempBusinessDataBO;
import com.terabits.service.*;
import com.terabits.meta.po.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DisplayController {

    @Autowired
    //private UserService userService;
    //private MeterService meterService;
    private BuildingService buildingService;
    private ClientBalanceService clientBalanceService;
    @Autowired
    private AccessTokenService accessTokenService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {

        return "pages/index.jsp";
    }

    @RequestMapping(value = "/admin/listUser", method = RequestMethod.GET)
    public String listUser() {
        //userService.selectUserById();
        //clientBalanceService.queryClientBalance();
       /* List<TempBusinessDataBO> maxBusinessDataBOList = buildingService.selectMaxMeterData("building01_data","2017-06-14");
        System.out.println("max:"+maxBusinessDataBOList);
        List<TempBusinessDataBO> minBusinessDataBOList = buildingService.selectMinMeterData("building01_data","2017-06-14");
        System.out.println("min:"+minBusinessDataBOList);*/
       System.out.println(accessTokenService.getLatestToken());

        return "pages/listUser.jsp";
    }
    @RequestMapping(value = "/refuse", method = RequestMethod.GET)
    public String refuse() {

        return "pages/refuse.jsp";
    }

    @RequestMapping(value = "/user/info", method = RequestMethod.GET)
    public String info() {

        return "user/info.jsp";
    }

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public String display() {
        return "pages/display.jsp";
    }

}
