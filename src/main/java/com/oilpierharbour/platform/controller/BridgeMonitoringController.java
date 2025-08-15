package com.oilpierharbour.platform.controller;

import com.oilpierharbour.platform.common.Result;
import com.oilpierharbour.platform.entity.BridgeMonitoring;
import com.oilpierharbour.platform.service.BridgeMonitoringService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 桥梁监测控制器
 * 
 * @author 油墩港平台团队
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequestMapping("/bridge/monitoring")
@RequiredArgsConstructor

public class BridgeMonitoringController {

    private final BridgeMonitoringService bridgeMonitoringService;

    @GetMapping("/{pointId}")
    public Result<BridgeMonitoring> getLatestMonitoringData(
            @PathVariable String pointId) {
        try {
            BridgeMonitoring data = bridgeMonitoringService.getLatestMonitoringData(pointId);
            if (data != null) {
                return Result.success(data);
            } else {
                return Result.notFound();
            }
        } catch (Exception e) {
            log.error("获取桥梁监测数据失败: {}", e.getMessage(), e);
            return Result.error("获取监测数据失败");
        }
    }

    @GetMapping("/{pointId}/history")
    public Result<List<BridgeMonitoring>> getHistoryMonitoringData(
            @PathVariable String pointId,
            @RequestParam(defaultValue = "100") Integer limit) {
        try {
            List<BridgeMonitoring> dataList = bridgeMonitoringService.getHistoryMonitoringData(pointId, limit);
            return Result.success(dataList);
        } catch (Exception e) {
            log.error("获取桥梁历史监测数据失败: {}", e.getMessage(), e);
            return Result.error("获取历史监测数据失败");
        }
    }

    @GetMapping("/warning")
    public Result<List<BridgeMonitoring>> getWarningPoints() {
        try {
            List<BridgeMonitoring> warningPoints = bridgeMonitoringService.getWarningPoints();
            return Result.success(warningPoints);
        } catch (Exception e) {
            log.error("获取预警监测点失败: {}", e.getMessage(), e);
            return Result.error("获取预警监测点失败");
        }
    }

    @GetMapping("/{pointId}/range")
    public Result<List<BridgeMonitoring>> getMonitoringDataByTimeRange(
            @PathVariable String pointId,
            @RequestParam String startTime,
            @RequestParam String endTime) {
        try {
            List<BridgeMonitoring> dataList = bridgeMonitoringService.getMonitoringDataByTimeRange(pointId, startTime, endTime);
            return Result.success(dataList);
        } catch (Exception e) {
            log.error("根据时间范围查询监测数据失败: {}", e.getMessage(), e);
            return Result.error("查询监测数据失败");
        }
    }

    @PostMapping
    public Result<Boolean> saveMonitoringData(@RequestBody BridgeMonitoring monitoring) {
        try {
            boolean result = bridgeMonitoringService.saveMonitoringData(monitoring);
            if (result) {
                return Result.success(true);
            } else {
                return Result.error("保存监测数据失败");
            }
        } catch (Exception e) {
            log.error("保存桥梁监测数据失败: {}", e.getMessage(), e);
            return Result.error("保存监测数据失败");
        }
    }

    @PostMapping("/batch")
    public Result<Boolean> batchSaveMonitoringData(@RequestBody List<BridgeMonitoring> monitoringList) {
        try {
            boolean result = bridgeMonitoringService.batchSaveMonitoringData(monitoringList);
            if (result) {
                return Result.success(true);
            } else {
                return Result.error("批量保存监测数据失败");
            }
        } catch (Exception e) {
            log.error("批量保存桥梁监测数据失败: {}", e.getMessage(), e);
            return Result.error("批量保存监测数据失败");
        }
    }

    @PutMapping("/{id}")
    public Result<Boolean> updateMonitoringData(
            @PathVariable Long id,
            @RequestBody BridgeMonitoring monitoring) {
        try {
            monitoring.setId(id);
            boolean result = bridgeMonitoringService.updateById(monitoring);
            if (result) {
                return Result.success(true);
            } else {
                return Result.error("更新监测数据失败");
            }
        } catch (Exception e) {
            log.error("更新桥梁监测数据失败: {}", e.getMessage(), e);
            return Result.error("更新监测数据失败");
        }
    }

    @DeleteMapping("/{id}")
    public Result<Boolean> deleteMonitoringData(@PathVariable Long id) {
        try {
            boolean result = bridgeMonitoringService.removeById(id);
            if (result) {
                return Result.success(true);
            } else {
                return Result.error("删除监测数据失败");
            }
        } catch (Exception e) {
            log.error("删除桥梁监测数据失败: {}", e.getMessage(), e);
            return Result.error("删除监测数据失败");
        }
    }
}
