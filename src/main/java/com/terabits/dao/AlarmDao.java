package com.terabits.dao;

import com.terabits.dao.mapper.AlarmMapper;

import com.terabits.dao.mapper.MeterMapper;
import com.terabits.meta.bo.TimeSpanBO;
import com.terabits.meta.po.AlarmPO;
import com.terabits.meta.po.MeterPO;
import com.terabits.utils.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 */
@Repository("alarmDao")
public class AlarmDao {
   /* public static void main(String args[]){
        TimeSpanBO timeSpanBO = new TimeSpanBO();
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1 = "2017-05-26 16:40:44";
        String time2 = "2017-05-26 16:41:50";
        Date time11 = new Date();
        Date time21 = new Date();
        try {
            time11 = dfs.parse(time1);
            time21 = dfs.parse(time2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        timeSpanBO.setBeginTime(
        AlarmPO alarmPO = new AlarmPO();time11.getTime()/1000);
        timeSpanBO.setEndTime(time21.getTime()/1000);
        System.out.println(selectAlarmByTime(timeSpanBO));
        alarmPO.setTerminalImei("863703030057025");
        alarmPO.setAlarmInfo("终端异常");
        alarmPO.setAlarmType("terminal");
        alarmPO.setBuilding("01");
        alarmPO.setRoom("203");
        insertAlarm(alarmPO);
    }
*/
    //新增告警数据
    public int insertAlarm(AlarmPO alarmPO) {
        SqlSession session = DBTools.getSession();
        AlarmMapper mapper = session.getMapper(AlarmMapper.class);
        try {
            mapper.insertAlarm(alarmPO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        }
        return 200;
    }

    //根据楼号和室号删除告警数据
    public int deleteAlarmByRoom(String building, String room){
        SqlSession session = DBTools.getSession();
        AlarmMapper mapper = session.getMapper(AlarmMapper.class);
        try {
            mapper.deleteAlarmByRoom(building,room);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        }
        return 200;
    }

    // 根据时间段删除告警数据
    public int deleteAlarmByTime(TimeSpanBO timeSpanBO){
        SqlSession session = DBTools.getSession();
        AlarmMapper mapper = session.getMapper(AlarmMapper.class);
        try {
            mapper.deleteAlarmByTime(timeSpanBO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        }
        return 200;
    }

    //根据时间段查询告警数据
    public List<AlarmPO> selectAlarmByTime(TimeSpanBO timeSpanBO){
        SqlSession session = DBTools.getSession();
        AlarmMapper mapper = session.getMapper(AlarmMapper.class);
        List<AlarmPO> alarmPOS = new ArrayList<AlarmPO>();
        try {
            alarmPOS = mapper.selectAlarmByTime(timeSpanBO);

        } catch (Exception e) {
            e.printStackTrace();

        }
        return alarmPOS;
    }

    //查询所有的告警数据
    public List<AlarmPO> selectAllAlarm(){
        SqlSession session = DBTools.getSession();
        AlarmMapper mapper = session.getMapper(AlarmMapper.class);
        List<AlarmPO> alarmPOS = new ArrayList<AlarmPO>();
        try {
            alarmPOS = mapper.selectAllAlarm();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return alarmPOS;
    }

    //查询当日告警数据和
    public int getSumAlarm(String time){
        SqlSession session = DBTools.getSession();
        AlarmMapper mapper = session.getMapper(AlarmMapper.class);
        int sumAlarm = 0;
        try{
            sumAlarm = mapper.selectSumAlarm(time);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return sumAlarm;
    }
}
