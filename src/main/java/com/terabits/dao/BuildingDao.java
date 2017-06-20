package com.terabits.dao;

import com.terabits.dao.mapper.BuildingMapper;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.bo.TempBusinessDataBO;
import com.terabits.meta.po.BuildingPO;
import com.terabits.utils.DBTools;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/26.
 */
@Repository("buildingDao")
public class BuildingDao {

  /*public static void main(String args[]){
        SelectDataBO selectDataBO = new SelectDataBO();
        SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time1 = "2017-06-02 10:20:21";
        String time2 = "2017-06-02 14:40:14";
        Date time11 = new Date();
        Date time21 = new Date();
        try {
            time11 = dfs.parse(time1);
            time21 = dfs.parse(time2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        selectDataBO.setBeginTime(time1);
        selectDataBO.setEndTime(time2);
        selectDataBO.setRoom("103");
        selectDataBO.setBuilding("02");
        selectDataBO.setBuildingNum("building02_data");
        System.out.println(selectData(selectDataBO));
      BuildingPO buildingPO = new BuildingPO();
      buildingPO.setBuildingNum("building02_data");
      buildingPO.setPower(141.22);
      buildingPO.setVoltage(21.01);
      buildingPO.setCurrent(32.2);
      buildingPO.setRoom("103");
      buildingPO.setBuilding("01");
      insertData(buildingPO);
      createNewTable("building02_data");
    }*/

    //新增电表数据
    public int insertData(List<BuildingPO> buildingPO) {
        SqlSession session = DBTools.getSession();
        BuildingMapper mapper = session.getMapper(BuildingMapper.class);
        try {
            mapper.insertData(buildingPO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        }
        return 200;
    }

    public int insertDataNew(Map<String,Object> params) {
        SqlSession session = DBTools.getSession();
        BuildingMapper mapper = session.getMapper(BuildingMapper.class);
        try {
            mapper.insertDataNew(params);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        }
        return 200;
    }


    //根据条件删除电表数据
    public int deleteData(SelectDataBO selectDataBO) {
        SqlSession session = DBTools.getSession();
        BuildingMapper mapper = session.getMapper(BuildingMapper.class);
        try {
            mapper.deleteData(selectDataBO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        }
        return 200;
    }

    //根据条件查询电表数据
    public List<BuildingPO> selectData(SelectDataBO selectDataBO) {
        SqlSession session = DBTools.getSession();
        BuildingMapper mapper = session.getMapper(BuildingMapper.class);
        List<BuildingPO> buildingPOS = new ArrayList<BuildingPO>();
        try {
            buildingPOS = mapper.selectData(selectDataBO);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return buildingPOS;
    }

    //查询全部电表数据
    public List<BuildingPO> selectAllData(String buildingNum) {
        SqlSession session = DBTools.getSession();
        BuildingMapper mapper = session.getMapper(BuildingMapper.class);
        List<BuildingPO> buildingPOS = new ArrayList<BuildingPO>();
        try {
            buildingPOS = mapper.selectAllData(buildingNum);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return buildingPOS;
    }

    //根据需求新建数据表
    public int createNewTable(String tableName){
        SqlSession session = DBTools.getSession();
        BuildingMapper mapper = session.getMapper(BuildingMapper.class);
        try {
            mapper.createNewTable(tableName);
            session.commit();
            return 200;
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            return 400;
        }
    }

     //查询当前所有电表最后一条数据
    public List<TempBusinessDataBO> selectMaxMeterData(String tableName, String time){
        SqlSession session = DBTools.getSession();
        BuildingMapper mapper = session.getMapper(BuildingMapper.class);
        List<TempBusinessDataBO> tempBusinessDataBOS = new ArrayList<TempBusinessDataBO>();
        try {
            tempBusinessDataBOS = mapper.selectMaxMeterData(tableName, time);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return tempBusinessDataBOS;
    }

    //查询当前所有电表第一条数据

    public List<TempBusinessDataBO> selectMinMeterData(String tableName, String time){
        SqlSession session = DBTools.getSession();
        BuildingMapper mapper = session.getMapper(BuildingMapper.class);
        List<TempBusinessDataBO> tempBusinessDataBOS = new ArrayList<TempBusinessDataBO>();
        try {
            tempBusinessDataBOS = mapper.selectMinMeterData(tableName, time);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        return tempBusinessDataBOS;
    }

}
