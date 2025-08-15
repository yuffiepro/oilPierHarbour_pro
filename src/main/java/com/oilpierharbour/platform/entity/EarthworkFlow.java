package com.oilpierharbour.platform.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 土方流转实体类
 * 
 * @author 油墩港平台团队
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("earthwork_flow")
public class EarthworkFlow {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 标段ID
     */
    @TableField("section_id")
    private String sectionId;

    /**
     * 开挖量(m³)
     */
    @TableField("excavation")
    private BigDecimal excavation;

    /**
     * 回填量(m³)
     */
    @TableField("backfill")
    private BigDecimal backfill;

    /**
     * 外运量(m³)
     */
    @TableField("transport_out")
    private BigDecimal transportOut;

    /**
     * 内运量(m³)
     */
    @TableField("transport_in")
    private BigDecimal transportIn;

    /**
     * 碳转换值(tCO2e)
     */
    @TableField("carbon_value")
    private BigDecimal carbonValue;

    /**
     * 记录日期
     */
    @TableField("record_date")
    private LocalDate recordDate;

    /**
     * 土方类型(1:普通土,2:淤泥,3:石方)
     */
    @TableField("earthwork_type")
    private Integer earthworkType;

    /**
     * 处理方式(1:回填,2:外运,3:资源化利用)
     */
    @TableField("disposal_method")
    private Integer disposalMethod;

    /**
     * 运输距离(km)
     */
    @TableField("transport_distance")
    private BigDecimal transportDistance;

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
