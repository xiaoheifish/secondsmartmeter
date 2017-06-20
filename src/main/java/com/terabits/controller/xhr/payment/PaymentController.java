package com.terabits.controller.xhr.payment;

import com.terabits.meta.vo.ClientInfoVO;
import com.terabits.meta.vo.PaymentVO;
import com.terabits.service.PaymentQueryService;
import com.terabits.service.PaymentService;
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
 * Created by Administrator on 2017/6/18.
 */
@Controller
public class PaymentController {
    @Autowired
    private PaymentQueryService paymentQueryService;
    @RequestMapping(value = {"/xhr/remain"}, method = { RequestMethod.POST})
    public void queryRemainInfo(HttpServletRequest request,
                                      HttpServletResponse response) throws IOException {
        ClientInfoVO clientInfoVO = paymentQueryService.queryRemain(request.getParameter("building"), request.getParameter("room"));
        JSONObject jsonObject = JSONObject.fromObject(clientInfoVO);
        response.getWriter().print(jsonObject);
    }

    @RequestMapping(value = {"/xhr/payment"}, method = { RequestMethod.POST})
    public void queryPaymentInfo(HttpServletRequest request,
                                HttpServletResponse response) throws IOException {
        List<PaymentVO> paymentVOS = paymentQueryService.queryPayment(request.getParameter("building"), request.getParameter("room"),
                request.getParameter("begin"),request.getParameter("end"));
        JSONArray jsonArray = JSONArray.fromObject(paymentVOS);
        response.getWriter().print(jsonArray);
    }
    @RequestMapping(value={"/deposit"}, method = {RequestMethod.POST})
    public void munualDeposit(HttpServletRequest request, HttpServletResponse response) throws IOException{
        int result = paymentQueryService.munualDeposit(request.getParameter("building"), request.getParameter("room"),
                request.getParameter("money"));
        JSONObject jsonObject = new JSONObject();
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
    @RequestMapping(value={"/reminder"}, method = {RequestMethod.POST})
    public void reminder(HttpServletRequest request, HttpServletResponse response) throws IOException{
        paymentQueryService.feeReminder(request.getParameter("building"), request.getParameter("room"));
        JSONObject jsonObject = new JSONObject();
            jsonObject.put("errno", 0);
            jsonObject.put("error", "succ");
            response.getWriter().print(jsonObject);
    }
}
