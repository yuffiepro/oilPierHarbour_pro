package com.oilpierharbour.platform.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 桥梁监测实体类
 * 
 * @author 油墩港平台团队
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("bridge_monitoring")
public class BridgeMonitoring {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 监测点ID
     */
    @TableField("point_id")
    private String pointId;

    /**
     * 竖向位移(mm)
     */
    @TableField("vertical_displ")
    private BigDecimal verticalDispl;

    /**
     * 横向位移(mm)
     */
    @TableField("lateral_displ")
    private BigDecimal lateralDispl;

    /**
     * 环境温度(℃)
     */
    @TableField("temperature")
    private BigDecimal temperature;

    /**
     * 风速(m/s)
     */
    @TableField("wind_speed")
    private BigDecimal windSpeed;

    /**
     * 状态(0正常,1预警)
     */
    @TableField("status")
    private Integer status;

    /**
     * 索力值(kN)
     */
    @TableField("cable_force")
    private BigDecimal cableForce;

    /**
     * 应力值(MPa)
     */
    @TableField("stress_value")
    private BigDecimal stressValue;

    /**
     * 偏位值(mm)
     */
    @TableField("deviation")
    private BigDecimal deviation;

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
