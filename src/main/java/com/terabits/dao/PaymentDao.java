package com.terabits.dao;

import com.terabits.dao.mapper.PaymentMapper;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.bo.TempBusinessPaymentBO;
import com.terabits.meta.po.PaymentPO;
import com.terabits.utils.DBTools;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */
@Repository("paymentDao")
public class PaymentDao {

  /*  public static void main(String[] args){
        PaymentPO paymentPO = new PaymentPO();
        paymentPO.setBuilding("01");
        paymentPO.setRoom("102");
        paymentPO.setOpenId("543214344ULL42434354");
        paymentPO.setOrderId("356464");
        paymentPO.setTradeNo("201705270005");
        paymentPO.setPayment(50);
        paymentPO.setRemaining(55.3);
        insertPayment(paymentPO);
        SelectDataBO selectDataBO = new SelectDataBO();
        selectDataBO.setBuilding("01");
        selectDataBO.setRoom("103");
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1 = "2017-05-27 16:49:45";
        String time2 = "2017-05-27 16:53:33";
        Date time11 = new Date();
        Date time21 = new Date();
        try {
            time11 = dfs.parse(time1);
            time21 = dfs.parse(time2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        selectDataBO.setBeginTime(time11.getTime()/1000);
        selectDataBO.setEndTime(time21.getTime()/1000);
        System.out.println(selectPayment(selectDataBO));
    }*/

    //新增缴费数据
    public int insertPayment(PaymentPO paymentPO) {
        SqlSession session = DBTools.getSession();
        PaymentMapper mapper = session.getMapper(PaymentMapper.class);
        try {
            mapper.insertPayment(paymentPO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        }
        return 200;
    }

    //删除缴费数据
    public int deletePayment(SelectDataBO selectDataBO){
        SqlSession session = DBTools.getSession();
        PaymentMapper mapper = session.getMapper(PaymentMapper.class);
        try {
            mapper.deletePayment(selectDataBO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        }
        return 200;
    }

    //根据条件查询缴费数据
    public List<PaymentPO> selectPayment(SelectDataBO selectDataBO){
        SqlSession session = DBTools.getSession();
        PaymentMapper mapper = session.getMapper(PaymentMapper.class);
        List<PaymentPO> paymentPOS = new ArrayList<PaymentPO>();
        try {
            paymentPOS = mapper.selectPayment(selectDataBO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return paymentPOS;
    }

    //根据openId查询缴费数据
    public List<PaymentPO> selectPaymentByOpenId(String openId){
        SqlSession session = DBTools.getSession();
        PaymentMapper mapper = session.getMapper(PaymentMapper.class);
        List<PaymentPO> paymentPOS = new ArrayList<PaymentPO>();
        try {
            paymentPOS = mapper.selectPaymentByOpenId(openId);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return paymentPOS;
    }

    //查询全部缴费数据

    public List<PaymentPO> selectAllPayment() {
        SqlSession session = DBTools.getSession();
        PaymentMapper mapper = session.getMapper(PaymentMapper.class);
        List<PaymentPO> paymentPOS = new ArrayList<PaymentPO>();
        try {
            paymentPOS = mapper.selectAllPayment();
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return paymentPOS;
    }

    public int selectSumPayment(String time){
        SqlSession session = DBTools.getSession();
        PaymentMapper mapper = session.getMapper(PaymentMapper.class);
        int sumPayment = 0;
        try {
            sumPayment = mapper.selectSumPayment(time);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return sumPayment;
    }

    //根据条件查询缴费数据量
    public int selectCountByTime(SelectDataBO selectDataBO){
        SqlSession session = DBTools.getSession();
        PaymentMapper mapper = session.getMapper(PaymentMapper.class);
        int count = 0;
        try {
            count = mapper.selectCountByTime(selectDataBO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

}
