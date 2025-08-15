package com.oilpierharbour.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oilpierharbour.platform.entity.WaterQualityMonitor;
import com.oilpierharbour.platform.mapper.WaterQualityMonitorMapper;
import com.oilpierharbour.platform.service.WaterQualityMonitorService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 水质监测服务实现类
 */
@Service
public class WaterQualityMonitorServiceImpl extends ServiceImpl<WaterQualityMonitorMapper, WaterQualityMonitor> implements WaterQualityMonitorService {

    @Override
    public WaterQualityMonitor getLatestByPointId(String pointId) {
        QueryWrapper<WaterQualityMonitor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("monitor_point_id", pointId)
                   .orderByDesc("update_time")
                   .last("LIMIT 1");
        return this.getOne(queryWrapper);
    }

    @Override
    public boolean checkWaterQuality(String pointId) {
        WaterQualityMonitor latest = getLatestByPointId(pointId);
        if (latest == null) {
            return false;
        }
        
        // 检查pH值是否在正常范围内
        if (latest.getPhValue() != null && 
            (latest.getPhValue().compareTo(new java.math.BigDecimal("6.5")) < 0 || 
             latest.getPhValue().compareTo(new java.math.BigDecimal("8.5")) > 0)) {
            return false;
        }
        
        // 检查溶解氧是否充足
        if (latest.getDissolvedOxygen() != null && 
            latest.getDissolvedOxygen().compareTo(new java.math.BigDecimal("5.0")) < 0) {
            return false;
        }
        
        return true;
    }

    @Override
    public List<WaterQualityMonitor> getWarningPoints() {
        QueryWrapper<WaterQualityMonitor> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 1)
                   .orderByDesc("update_time");
        return this.list(queryWrapper);
    }
}

