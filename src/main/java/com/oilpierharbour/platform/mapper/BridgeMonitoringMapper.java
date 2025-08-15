package com.oilpierharbour.platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oilpierharbour.platform.entity.BridgeMonitoring;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 桥梁监测Mapper接口
 * 
 * @author 油墩港平台团队
 * @since 1.0.0
 */
@Mapper
public interface BridgeMonitoringMapper extends BaseMapper<BridgeMonitoring> {

    /**
     * 根据监测点ID查询最新监测数据
     * 
     * @param pointId 监测点ID
     * @return 监测数据
     */
    BridgeMonitoring selectLatestByPointId(@Param("pointId") String pointId);

    /**
     * 根据监测点ID查询历史监测数据
     * 
     * @param pointId 监测点ID
     * @param limit 限制条数
     * @return 监测数据列表
     */
    List<BridgeMonitoring> selectHistoryByPointId(@Param("pointId") String pointId, @Param("limit") Integer limit);

    /**
     * 查询预警状态的监测点
     * 
     * @return 预警监测数据列表
     */
    List<BridgeMonitoring> selectWarningPoints();

    /**
     * 根据时间范围查询监测数据
     * 
     * @param pointId 监测点ID
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 监测数据列表
     */
    List<BridgeMonitoring> selectByTimeRange(@Param("pointId") String pointId, 
                                           @Param("startTime") String startTime, 
                                           @Param("endTime") String endTime);
}
