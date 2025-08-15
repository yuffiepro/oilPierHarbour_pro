package com.oilpierharbour.platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oilpierharbour.platform.entity.WaterQualityMonitor;
import org.apache.ibatis.annotations.Mapper;

/**
 * 水质监测Mapper接口
 */
@Mapper
public interface WaterQualityMonitorMapper extends BaseMapper<WaterQualityMonitor> {
}

