package com.terabits.service;

import com.terabits.meta.vo.ClientInfoVO;
import com.terabits.meta.vo.PaymentVO;

import java.util.List;

/**
 * Created by Administrator on 2017/6/18.
 */
public interface PaymentQueryService {
    public ClientInfoVO queryRemain(String building, String room);
    public List<PaymentVO> queryPayment(String building, String room, String begin, String end);
    public int munualDeposit(String building, String room, String money);
    public void feeReminder(String building, String room);
}
