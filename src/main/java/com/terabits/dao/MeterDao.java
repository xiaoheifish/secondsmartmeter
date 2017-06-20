package com.terabits.dao;

import com.sun.xml.internal.ws.api.model.MEP;
import com.terabits.dao.mapper.MeterMapper;
import com.terabits.meta.bo.LocationBO;
import com.terabits.meta.bo.MeterBO;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.po.MeterClientPO;
import com.terabits.meta.po.MeterPO;
import com.terabits.meta.vo.MeterStatusVO;
import com.terabits.utils.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/24.
 */
@Repository("meterDao")
public class MeterDao {
  /*  public static void main(String args[]){
        LocationBO locationBO = new LocationBO();
        locationBO.setBuilding("01");
        locationBO.setRoom("102");
        System.out.println(queryMeterClient(locationBO));
    }*/
    //新增电表数据
    public int insertMeter(MeterPO meterPO) {
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        try {
            mapper.insertMeter(meterPO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        }
        return 200;
    }
    //更新Imei号，余额以及状态
    public int updateMeter(MeterBO meterBO){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        try {
            mapper.updateMeter(meterBO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        }
        return 200;
    }
    //根据楼号和室号更新Imei号
    public int updateMeterImei(String terminalImei, String building, String room){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        try {
            mapper.updateMeterImei(terminalImei,building,room);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        }
        return 200;
    }
    //根据楼号和室号更新余额
    public int updateMeterRemain(double remain, String building, String room){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        try {
            mapper.updateMeterRemain(remain,building,room);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        }
        return 200;
    }
    //根据楼号和室号更新状态
    public int updateMeterState(int state, String building, String room){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        try {
            mapper.updateMeterState(state,building,room);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        }
        return 200;
    }
    //更换终端时使用
    public int updateGroupImei(String newImei, String oldImei){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        try {
            mapper.updateGroupImei(newImei,oldImei);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        }
        return 200;
    }
    //删除电表
    public int deleteMeter(String building, String room){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        try {
            mapper.deleteMeter(building,room);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        }
        return 200;
    }
    //批量删除电表
    public int deleteGroupMeter(String imei) {
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        try {
            mapper.deleteGroupMeter(imei);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        }
        return 200;
    }
    //根据楼号和室号选择一台电表
    public MeterPO selectOneMeter(String building, String room){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        MeterPO meterPO = new MeterPO();
        try {
            meterPO = mapper.selectOneMeter(building,room);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        }
        return meterPO;
    }
    //根据终端imei和电表相对位置选择一台电表
    public MeterPO selectMeterByRelativeLocation(String imei, int relativeLocation){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        MeterPO meterPO = new MeterPO();
        try {
            meterPO = mapper.selectMeterByRelativeLocation(imei,relativeLocation);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        }
        return meterPO;
    }
    //根据终端imei选择一台电表
    public List<MeterPO> selectMeterByImei(String imei){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        List<MeterPO> meterPOS = new ArrayList<MeterPO>();
        try {
            meterPOS = mapper.selectMeterByImei(imei);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        }
        return meterPOS;
    }
    //根据楼号选择多台电表
    public List<MeterPO> selectMeterByBuilding(String building){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        List<MeterPO> meterPO = new ArrayList<MeterPO>();
        try {
            meterPO = mapper.selectMeterByBuilding(building);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        }
        return meterPO;
    }
    //选择全部电表
    public List<MeterPO> selectAllMeter(){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        List<MeterPO> meterPO = new ArrayList<MeterPO>();
        try {
            meterPO = mapper.selectAllMeter();
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        }
        return meterPO;
    }
    //查询所有楼号
    public List<String> selectAllBuilding(){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        List<String> building = new ArrayList<String>();
        try {
            building = mapper.selectAllBuilding();
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        }
        return building;
    }
    //根据楼号查询所有房间
    public List<String> selectAllRoomByBuilding(String building){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        List<String> room = new ArrayList<String>();
        try {
            room = mapper.selectAllRoomByBuilding(building);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        }
        return room;
    }
    public LocationBO selectLocation(String meterId){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        LocationBO locationBO = new LocationBO();
        try {
            locationBO = mapper.selectLocation(meterId);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        }
        return locationBO;
    }

    public List<Integer> selectAllRelctiveLocationByImei(String imei) {
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        List<Integer> relativeLocationS = new ArrayList<Integer>();
        try {
            relativeLocationS = mapper.selectAllRelativeLocationByImei(imei);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        }
        return relativeLocationS;
    }

    public List<MeterPO> selectMeterInfo(SelectDataBO selectDataBO){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        List<MeterPO> meterPOS = new ArrayList<MeterPO>();
        try {
            meterPOS = mapper.selectMeterInfo(selectDataBO);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        }
        return meterPOS;
    }

    public MeterClientPO queryMeterClient(LocationBO locationBO){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        MeterClientPO meterPOS = new MeterClientPO();
        try {
            meterPOS = mapper.queryForList(locationBO);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        }
        return meterPOS;
    }

    public List<MeterStatusVO> selectListMeter(List<LocationBO> locationBOS){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        List<MeterStatusVO> meterStatusVOS = new ArrayList<MeterStatusVO>();
        try {
            meterStatusVOS = mapper.selectListMeter(locationBOS);
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        }
        return meterStatusVOS;
    }

    public List<LocationBO> getAllMeter(){
        SqlSession session = DBTools.getSession();
        MeterMapper mapper = session.getMapper(MeterMapper.class);
        List<LocationBO> locationBOS = new ArrayList<LocationBO>();
        try {
            locationBOS = mapper.getMeterLocation();
            //session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //session.rollback();
        }
        return locationBOS;
    }
}
