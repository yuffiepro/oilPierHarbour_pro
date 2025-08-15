package com.oilpierharbour.platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oilpierharbour.platform.entity.BridgeMonitoring;
import com.oilpierharbour.platform.mapper.BridgeMonitoringMapper;
import com.oilpierharbour.platform.service.BridgeMonitoringService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * 桥梁监测服务实现类
 * 
 * @author 油墩港平台团队
 * @since 1.0.0
 */
@Slf4j
@Service
public class BridgeMonitoringServiceImpl extends ServiceImpl<BridgeMonitoringMapper, BridgeMonitoring> 
        implements BridgeMonitoringService {

    @Override
    public BridgeMonitoring getLatestMonitoringData(String pointId) {
        return baseMapper.selectLatestByPointId(pointId);
    }

    @Override
    public List<BridgeMonitoring> getHistoryMonitoringData(String pointId, Integer limit) {
        return baseMapper.selectHistoryByPointId(pointId, limit);
    }

    @Override
    public List<BridgeMonitoring> getWarningPoints() {
        return baseMapper.selectWarningPoints();
    }

    @Override
    public List<BridgeMonitoring> getMonitoringDataByTimeRange(String pointId, String startTime, String endTime) {
        return baseMapper.selectByTimeRange(pointId, startTime, endTime);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveMonitoringData(BridgeMonitoring monitoring) {
        try {
            // 检查数据是否异常
            if (checkMonitoringDataAbnormal(monitoring)) {
                monitoring.setStatus(1); // 设置为预警状态
                // 发送预警通知
                sendWarningNotification(monitoring);
            } else {
                monitoring.setStatus(0); // 设置为正常状态
            }
            
            return save(monitoring);
        } catch (Exception e) {
            log.error("保存桥梁监测数据失败: {}", e.getMessage(), e);
            return false;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean batchSaveMonitoringData(List<BridgeMonitoring> monitoringList) {
        try {
            for (BridgeMonitoring monitoring : monitoringList) {
                if (checkMonitoringDataAbnormal(monitoring)) {
                    monitoring.setStatus(1);
                    sendWarningNotification(monitoring);
                } else {
                    monitoring.setStatus(0);
                }
            }
            return saveBatch(monitoringList);
        } catch (Exception e) {
            log.error("批量保存桥梁监测数据失败: {}", e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean checkMonitoringDataAbnormal(BridgeMonitoring monitoring) {
        // 检查竖向位移是否超限 (假设预警阈值为10mm)
        if (monitoring.getVerticalDispl() != null && 
            monitoring.getVerticalDispl().compareTo(new BigDecimal("10")) > 0) {
            return true;
        }
        
        // 检查横向位移是否超限 (假设预警阈值为5mm)
        if (monitoring.getLateralDispl() != null && 
            monitoring.getLateralDispl().compareTo(new BigDecimal("5")) > 0) {
            return true;
        }
        
        // 检查应力值是否超限 (假设预警阈值为200MPa)
        if (monitoring.getStressValue() != null && 
            monitoring.getStressValue().compareTo(new BigDecimal("200")) > 0) {
            return true;
        }
        
        // 检查索力值是否超限 (假设预警阈值为1000kN)
        if (monitoring.getCableForce() != null && 
            monitoring.getCableForce().compareTo(new BigDecimal("1000")) > 0) {
            return true;
        }
        
        return false;
    }

    @Override
    public void sendWarningNotification(BridgeMonitoring monitoring) {
        try {
            log.warn("桥梁监测预警通知 - 监测点: {}, 竖向位移: {}mm, 横向位移: {}mm, 应力值: {}MPa, 索力值: {}kN", 
                    monitoring.getPointId(),
                    monitoring.getVerticalDispl(),
                    monitoring.getLateralDispl(),
                    monitoring.getStressValue(),
                    monitoring.getCableForce());
            
            // TODO: 实现具体的预警通知逻辑
            // 1. 发送短信通知
            // 2. 发送邮件通知
            // 3. 推送WebSocket消息
            // 4. 记录预警日志
            
        } catch (Exception e) {
            log.error("发送桥梁监测预警通知失败: {}", e.getMessage(), e);
        }
    }
}
