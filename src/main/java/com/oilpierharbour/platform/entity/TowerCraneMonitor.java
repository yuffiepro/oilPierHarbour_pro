package com.oilpierharbour.platform.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 塔吊监测实体类
 * 
 * @author 油墩港平台团队
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("tower_crane_monitor")
public class TowerCraneMonitor {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 塔吊ID
     */
    @TableField("crane_id")
    private String craneId;

    /**
     * 倾斜角度(度)
     */
    @TableField("tilt_angle")
    private BigDecimal tiltAngle;

    /**
     * 应力值(MPa)
     */
    @TableField("stress")
    private BigDecimal stress;

    /**
     * 载重(吨)
     */
    @TableField("load_weight")
    private BigDecimal loadWeight;

    /**
     * 工作半径(m)
     */
    @TableField("work_radius")
    private BigDecimal workRadius;

    /**
     * 风速(m/s)
     */
    @TableField("wind_speed")
    private BigDecimal windSpeed;

    /**
     * 报警状态(0:正常,1:预警,2:报警)
     */
    @TableField("alarm_status")
    private Integer alarmStatus;

    /**
     * 塔吊高度(m)
     */
    @TableField("crane_height")
    private BigDecimal craneHeight;

    /**
     * 大臂角度(度)
     */
    @TableField("arm_angle")
    private BigDecimal armAngle;

    /**
     * 钩头高度(m)
     */
    @TableField("hook_height")
    private BigDecimal hookHeight;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 逻辑删除标识
     */
    @TableLogic
    @TableField("deleted")
    private Integer deleted;
}
