package com.terabits.dao.mapper;

import com.terabits.meta.bo.BuildingDataBO;
import com.terabits.meta.bo.SelectDataBO;
import com.terabits.meta.bo.TempBusinessDataBO;
import com.terabits.meta.po.BuildingPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/26.
 */
public interface BuildingMapper {
    /**
     * 新增list形式电表数据
     * @param buildingPO
     * @return
     * @throws Exception
     */
    public int insertData(List<BuildingPO> buildingPO) throws Exception;

    /**
     * 新增map形式电表数据
     * @param params
     * @return
     * @throws Exception
     */
    public int insertDataNew(Map<String,Object> params);

    /**
     * 根据条件删除电表数据
     * @param selectDataBO
     * @return
     * @throws Exception
     */
    public int deleteData(SelectDataBO selectDataBO) throws Exception;

    /**
     * 根据条件查询电表数据
     * @param selectDataBO
     * @return
     * @throws Exception
     */
    public List<BuildingPO> selectData(SelectDataBO selectDataBO) throws Exception;

    /**
     * 查询全部电表数据
     * @return
     * @throws Exception
     */
    public List<BuildingPO> selectAllData(@Param("buildingNum")String buildingNum) throws Exception;

    /**
     * 新建数据表
     * @return
     * @throws Exception
     */
    int createNewTable(@Param("tableName") String tableName) throws Exception;


    /**
     * 查询当前最后一条数据
     * @param tableName
     * @param time
     * @return
     * @throws Exception
     */
    public List<TempBusinessDataBO> selectMaxMeterData(@Param("tableName") String tableName, @Param("time") String time);

    /**
     * 查询当前第一条数据
     * @param tableName
     * @param time
     * @return
     * @throws Exception
     */
    public List<TempBusinessDataBO> selectMinMeterData(@Param("tableName") String tableName, @Param("time") String time);

}
