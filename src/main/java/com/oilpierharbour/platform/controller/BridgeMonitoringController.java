package com.oilpierharbour.platform.controller;

import com.oilpierharbour.platform.common.Result;
import com.oilpierharbour.platform.entity.BridgeMonitoring;
import com.oilpierharbour.platform.service.BridgeMonitoringService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(tags = "桥梁监测管理")
public class BridgeMonitoringController {

    private final BridgeMonitoringService bridgeMonitoringService;

    @GetMapping("/{pointId}")
    @ApiOperation("根据监测点ID获取最新监测数据")
    public Result<BridgeMonitoring> getLatestMonitoringData(
            @ApiParam("监测点ID") @PathVariable String pointId) {
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
    @ApiOperation("根据监测点ID获取历史监测数据")
    public Result<List<BridgeMonitoring>> getHistoryMonitoringData(
            @ApiParam("监测点ID") @PathVariable String pointId,
            @ApiParam("限制条数") @RequestParam(defaultValue = "100") Integer limit) {
        try {
            List<BridgeMonitoring> dataList = bridgeMonitoringService.getHistoryMonitoringData(pointId, limit);
            return Result.success(dataList);
        } catch (Exception e) {
            log.error("获取桥梁历史监测数据失败: {}", e.getMessage(), e);
            return Result.error("获取历史监测数据失败");
        }
    }

    @GetMapping("/warning")
    @ApiOperation("获取所有预警监测点")
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
    @ApiOperation("根据时间范围查询监测数据")
    public Result<List<BridgeMonitoring>> getMonitoringDataByTimeRange(
            @ApiParam("监测点ID") @PathVariable String pointId,
            @ApiParam("开始时间") @RequestParam String startTime,
            @ApiParam("结束时间") @RequestParam String endTime) {
        try {
            List<BridgeMonitoring> dataList = bridgeMonitoringService.getMonitoringDataByTimeRange(pointId, startTime, endTime);
            return Result.success(dataList);
        } catch (Exception e) {
            log.error("根据时间范围查询监测数据失败: {}", e.getMessage(), e);
            return Result.error("查询监测数据失败");
        }
    }

    @PostMapping
    @ApiOperation("保存监测数据")
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
    @ApiOperation("批量保存监测数据")
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
    @ApiOperation("更新监测数据")
    public Result<Boolean> updateMonitoringData(
            @ApiParam("监测数据ID") @PathVariable Long id,
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
    @ApiOperation("删除监测数据")
    public Result<Boolean> deleteMonitoringData(@ApiParam("监测数据ID") @PathVariable Long id) {
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
