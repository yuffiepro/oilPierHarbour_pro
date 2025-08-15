package com.oilpierharbour.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oilpierharbour.platform.entity.TowerCraneMonitor;

/**
 * 塔吊监测服务接口
 */
public interface TowerCraneMonitorService extends IService<TowerCraneMonitor> {

    /**
     * 根据塔吊ID获取最新监测数据
     */
    TowerCraneMonitor getLatestByCraneId(String craneId);

    /**
     * 检查塔吊安全状态
     */
    boolean checkSafetyStatus(String craneId);

    /**
     * 获取预警塔吊列表
     */
    java.util.List<TowerCraneMonitor> getWarningCranes();
}

