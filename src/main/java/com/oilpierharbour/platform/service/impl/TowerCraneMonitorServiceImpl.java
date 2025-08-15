package com.oilpierharbour.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oilpierharbour.platform.entity.TowerCraneMonitor;
import com.oilpierharbour.platform.mapper.TowerCraneMonitorMapper;
import com.oilpierharbour.platform.service.TowerCraneMonitorService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 塔吊监测服务实现类
 */
@Service
public class TowerCraneMonitorServiceImpl extends ServiceImpl<TowerCraneMonitorMapper, TowerCraneMonitor> implements TowerCraneMonitorService {

    @Override
    public TowerCraneMonitor getLatestByCraneId(String craneId) {
        QueryWrapper<TowerCraneMonitor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("crane_id", craneId)
                   .orderByDesc("update_time")
                   .last("LIMIT 1");
        return this.getOne(queryWrapper);
    }

    @Override
    public boolean checkSafetyStatus(String craneId) {
        TowerCraneMonitor latest = getLatestByCraneId(craneId);
        if (latest == null) {
            return false;
        }
        
        // 检查倾斜角度是否超限
        if (latest.getTiltAngle() != null && latest.getTiltAngle().compareTo(new java.math.BigDecimal("2.0")) > 0) {
            return false;
        }
        
        // 检查风速是否超限
        if (latest.getWindSpeed() != null && latest.getWindSpeed().compareTo(new java.math.BigDecimal("10.0")) > 0) {
            return false;
        }
        
        return true;
    }

    @Override
    public List<TowerCraneMonitor> getWarningCranes() {
        QueryWrapper<TowerCraneMonitor> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("alarm_status", 0)
                   .orderByDesc("update_time");
        return this.list(queryWrapper);
    }
}

