package com.terabits.redis;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * Created by Administrator on 2017/6/15.
 */
@Controller
@RequestMapping(value = "/member")
public class MemberController extends BaseMultiController {

    @Autowired
    private MemberService memberService;

    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(value = { "/add", "/add.html" }, method = { RequestMethod.GET })
    public ModelAndView add(HttpServletRequest request,
                            HttpServletResponse response) {
        Map<String, Object> map = new HashMap<String, Object>();
        Member member = new Member();
        member.setId("1");
        member.setElectricity("1284.34");
        boolean re= this.memberService.add(member);
        System.out.println(re);
        return toView("add", map);
    }

    @RequestMapping(value = {"/add", "/add.html" }, method = { RequestMethod.POST })
    public void addMember(HttpServletRequest request,
                                  HttpServletResponse response,
                                  @ModelAttribute("member") Member member) throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println(member);
        map.put("message", "成功添加数据到库," + member);
        boolean result = this.memberService.add(member);
        System.out.println("插入成功");
        response.getWriter().print(result);
    }

    @RequestMapping(value = {"/update", "/update.html" }, method = { RequestMethod.POST })
    public void updateMember(HttpServletRequest request,
                                  HttpServletResponse response,
                                  @ModelAttribute("member") Member member) throws IOException{
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println(member);
        map.put("message", "成功添加数据到库," + member);
        boolean result = this.memberService.update(member);
        System.out.println("更新成功");
        response.getWriter().print(result);
    }


    @RequestMapping(value = { "/{id:\\d+}/query", "/{id:\\d+}/query.html" }, method = {
            RequestMethod.GET, RequestMethod.POST })
    public void queryMember(HttpServletRequest request,
                                    HttpServletResponse response,@PathVariable("id") String id)throws IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println(id);
        Member member = this.memberService.get(id);
        if (null != member) {
            map.put("message", "查询Id=" + id + "的用电量为:" + member.getElectricity());
            System.out.println(member.getElectricity());
        } else {
            map.put("message", "没有查询到与Id=" + id + "相关的数据");
            System.out.println("meichadao");
        }
        JSONObject jsonObject = JSONObject.fromObject(member);
        response.getWriter().print(jsonObject);
    }

    @RequestMapping(value = { "/{id:\\d+}/delete", "/{id:\\d+}/delete.html" }, method = {
            RequestMethod.GET, RequestMethod.POST })
    public ModelAndView deleteMember(HttpServletRequest request,
                                     HttpServletResponse response, @PathVariable("id") String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            this.memberService.delete(id);
            map.put("message", "删除Id为" + id + "的用户成功.");
            System.out.println("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", "删除Id为" + id + "的用户失败, " + e.getMessage());
            System.out.println("删除失败");
        }
        return toView("message", map);
    }

    @RequestMapping(value = {"/query", "/query.html" }, method = { RequestMethod.GET })
    public void queryListMember(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        Calendar cal = Calendar.getInstance();
        int hour  = cal.get(Calendar.HOUR_OF_DAY);
        String stringHour = Integer.toString(hour);
        List<Member> memberList = memberService.getMemberList(stringHour);
        JSONArray jsonArray = JSONArray.fromObject(memberList);
        System.out.println("取回成功");
        response.getWriter().print(jsonArray);
    }

}