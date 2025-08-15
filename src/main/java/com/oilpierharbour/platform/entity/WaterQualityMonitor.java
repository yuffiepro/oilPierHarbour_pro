package com.oilpierharbour.platform.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 水质监测实体类
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("water_quality_monitor")
public class WaterQualityMonitor {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 监测点ID
     */
    @TableField("monitor_point_id")
    private String monitorPointId;

    /**
     * 水位(m)
     */
    @TableField("water_level")
    private BigDecimal waterLevel;

    /**
     * 流速(m/s)
     */
    @TableField("flow_velocity")
    private BigDecimal flowVelocity;

    /**
     * 流量(m³/s)
     */
    @TableField("flow_rate")
    private BigDecimal flowRate;

    /**
     * pH值
     */
    @TableField("ph_value")
    private BigDecimal phValue;

    /**
     * 浊度(NTU)
     */
    @TableField("turbidity")
    private BigDecimal turbidity;

    /**
     * 溶解氧(mg/L)
     */
    @TableField("dissolved_oxygen")
    private BigDecimal dissolvedOxygen;

    /**
     * 状态(0正常,1预警)
     */
    @TableField("status")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /**
     * 逻辑删除标识
     */
    @TableLogic
    @TableField("deleted")
    private Integer deleted;
}

