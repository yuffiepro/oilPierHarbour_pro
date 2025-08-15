package com.oilpierharbour.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oilpierharbour.platform.entity.WaterQualityMonitor;

/**
 * 水质监测服务接口
 */
public interface WaterQualityMonitorService extends IService<WaterQualityMonitor> {

    /**
     * 根据监测点ID获取最新数据
     */
    WaterQualityMonitor getLatestByPointId(String pointId);

    /**
     * 检查水质状态
     */
    boolean checkWaterQuality(String pointId);

    /**
     * 获取预警监测点列表
     */
    java.util.List<WaterQualityMonitor> getWarningPoints();
}

