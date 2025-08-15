package com.oilpierharbour.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oilpierharbour.platform.entity.BridgeMonitoring;

import java.util.List;

/**
 * 桥梁监测服务接口
 * 
 * @author 油墩港平台团队
 * @since 1.0.0
 */
public interface BridgeMonitoringService extends IService<BridgeMonitoring> {

    /**
     * 根据监测点ID获取最新监测数据
     * 
     * @param pointId 监测点ID
     * @return 监测数据
     */
    BridgeMonitoring getLatestMonitoringData(String pointId);

    /**
     * 根据监测点ID获取历史监测数据
     * 
     * @param pointId 监测点ID
     * @param limit 限制条数
     * @return 监测数据列表
     */
    List<BridgeMonitoring> getHistoryMonitoringData(String pointId, Integer limit);

    /**
     * 获取所有预警监测点
     * 
     * @return 预警监测数据列表
     */
    List<BridgeMonitoring> getWarningPoints();

    /**
     * 根据时间范围查询监测数据
     * 
     * @param pointId 监测点ID
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 监测数据列表
     */
    List<BridgeMonitoring> getMonitoringDataByTimeRange(String pointId, String startTime, String endTime);

    /**
     * 保存监测数据
     * 
     * @param monitoring 监测数据
     * @return 是否保存成功
     */
    boolean saveMonitoringData(BridgeMonitoring monitoring);

    /**
     * 批量保存监测数据
     * 
     * @param monitoringList 监测数据列表
     * @return 是否保存成功
     */
    boolean batchSaveMonitoringData(List<BridgeMonitoring> monitoringList);

    /**
     * 检查监测数据是否异常
     * 
     * @param monitoring 监测数据
     * @return 是否异常
     */
    boolean checkMonitoringDataAbnormal(BridgeMonitoring monitoring);

    /**
     * 发送预警通知
     * 
     * @param monitoring 异常监测数据
     */
    void sendWarningNotification(BridgeMonitoring monitoring);
}
