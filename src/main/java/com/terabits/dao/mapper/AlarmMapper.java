package com.terabits.dao.mapper;

import com.terabits.meta.bo.MeterBO;
import com.terabits.meta.bo.TimeSpanBO;
import com.terabits.meta.po.AlarmPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/5/26.
 */
public interface AlarmMapper {
    /**
     * 新增告警数据
     * @param alarmPO
     * @return
     * @throws Exception
     */
    public int insertAlarm(AlarmPO alarmPO) throws Exception;

    /**
     * 根据楼号和室号删除告警数据
     * @param building
     * @param room
     * @return
     * @throws Exception
     */
    public int deleteAlarmByRoom(@Param("building") String building, @Param("room") String room) throws Exception;

    /**
     * 根据时间段删除告警数据
     * @param timeSpanBO
     * @return
     * @throws Exception
     */
    public int deleteAlarmByTime(TimeSpanBO timeSpanBO) throws Exception;

    /**
     * 根据时间段查询告警数据
     * @param timeSpanBO
     * @return
     * @throws Exception
     */
    public List<AlarmPO> selectAlarmByTime(TimeSpanBO timeSpanBO) throws Exception;

    /**
     * 查询所有的告警数据
     * @return
     * @throws Exception
     */
    public List<AlarmPO> selectAllAlarm() throws Exception;

    /**
     * 查询当日告警数据总和
     * @return
     * @throws Exception
     */
    public int selectSumAlarm(String time) throws Exception;
}
