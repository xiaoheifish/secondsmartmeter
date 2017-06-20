package com.terabits.controller.admin;

import com.terabits.meta.po.AdminUserPO;
import com.terabits.meta.vo.AdminUserVO;
import com.terabits.service.AdminUserService;
import com.terabits.utils.PasswordUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/5/18.
 */
@Controller

public class AdminController {
    @Autowired
    private AdminUserService adminUserService;
    @RequestMapping(value = "/user/get", method = RequestMethod.GET)
    //@RequiresPermissions("")
    public void getAdminUser(HttpServletRequest request,
                                 HttpServletResponse response) throws IOException {
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        if(!account.equals("all")){
            AdminUserVO adminUserVO = adminUserService.selectAdminUserVOByAccount(account);
            JSONObject jsonObject = JSONObject.fromObject(adminUserVO);
            response.getWriter().print(jsonObject);
            return;
        }
        else if(!name.equals("all")){
            AdminUserVO adminUserVO = adminUserService.getAdminUserByName(name);
            JSONObject jsonObject = JSONObject.fromObject(adminUserVO);
            response.getWriter().print(jsonObject);
        }
        else{
            List<AdminUserVO> adminUserVOList = adminUserService.getAllAdminUser();
            JSONArray jsonArray = JSONArray.fromObject(adminUserVOList);
            response.getWriter().print(jsonArray);
        }
    }

    @RequestMapping(value = "/user/modify", method = RequestMethod.POST)
    //@RequiresPermissions("")
    public void insertAdminUser(HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("name");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String authority = request.getParameter("authority");
        String role = "admin";
        String newpassword = new String();
        try{
            newpassword = PasswordUtil.EncoderByMd5(account +"terabits"+password);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        AdminUserPO adminUserPO = new AdminUserPO();
        adminUserPO.setAccount(account);
        adminUserPO.setPassword(newpassword);
        adminUserPO.setName(name);
        adminUserPO.setPhone(phone);
        adminUserPO.setEmail(email);
        adminUserPO.setAuthority(authority);
        adminUserPO.setRole(role);
        JSONObject jsonObject = new JSONObject();
        if(request.getParameter("type").equals("0")){
            int result = adminUserService.updateAdminUser(adminUserPO);
            if(result == 200){
                jsonObject.put("errno", 0);
                jsonObject.put("error", "succ");
                response.getWriter().print(jsonObject);
            }
            else{
                jsonObject.put("errno", 1);
                jsonObject.put("error", "fail");
                response.getWriter().print(jsonObject);
            }
        }
        else if(request.getParameter("type").equals("1")){
            int result = adminUserService.insertAdminUser(adminUserPO);
            if(result == 200){
                jsonObject.put("errno", 0);
                jsonObject.put("error", "succ");
                response.getWriter().print(jsonObject);
            }
            else{
                jsonObject.put("errno", 1);
                jsonObject.put("error", "fail");
                response.getWriter().print(jsonObject);
            }
        }

    }
}

