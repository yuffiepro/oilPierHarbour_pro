-- 油墩港数字管理平台数据库初始化脚本
-- 创建数据库
CREATE DATABASE IF NOT EXISTS `oil_pier_harbour` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE `oil_pier_harbour`;

-- 桥梁监测表
CREATE TABLE IF NOT EXISTS `bridge_monitoring` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `point_id` varchar(50) NOT NULL COMMENT '监测点ID',
  `vertical_displ` decimal(10,4) DEFAULT NULL COMMENT '竖向位移(mm)',
  `lateral_displ` decimal(10,4) DEFAULT NULL COMMENT '横向位移(mm)',
  `temperature` decimal(5,2) DEFAULT NULL COMMENT '环境温度(℃)',
  `wind_speed` decimal(5,2) DEFAULT NULL COMMENT '风速(m/s)',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态(0正常,1预警)',
  `cable_force` decimal(10,2) DEFAULT NULL COMMENT '索力值(kN)',
  `stress_value` decimal(10,2) DEFAULT NULL COMMENT '应力值(MPa)',
  `deviation` decimal(10,4) DEFAULT NULL COMMENT '偏位值(mm)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`),
  KEY `idx_point_id` (`point_id`),
  KEY `idx_status` (`status`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='桥梁监测表';

-- 土方流转表
CREATE TABLE IF NOT EXISTS `earthwork_flow` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `section_id` varchar(50) NOT NULL COMMENT '标段ID',
  `excavation` decimal(15,3) DEFAULT NULL COMMENT '开挖量(m³)',
  `backfill` decimal(15,3) DEFAULT NULL COMMENT '回填量(m³)',
  `transport_out` decimal(15,3) DEFAULT NULL COMMENT '外运量(m³)',
  `transport_in` decimal(15,3) DEFAULT NULL COMMENT '内运量(m³)',
  `carbon_value` decimal(15,3) DEFAULT NULL COMMENT '碳转换值(tCO2e)',
  `record_date` date DEFAULT NULL COMMENT '记录日期',
  `earthwork_type` tinyint(1) DEFAULT '1' COMMENT '土方类型(1:普通土,2:淤泥,3:石方)',
  `disposal_method` tinyint(1) DEFAULT '1' COMMENT '处理方式(1:回填,2:外运,3:资源化利用)',
  `transport_distance` decimal(10,2) DEFAULT NULL COMMENT '运输距离(km)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`),
  KEY `idx_section_id` (`section_id`),
  KEY `idx_record_date` (`record_date`),
  KEY `idx_earthwork_type` (`earthwork_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='土方流转表';

-- 塔吊监测表
CREATE TABLE IF NOT EXISTS `tower_crane_monitor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `crane_id` varchar(50) NOT NULL COMMENT '塔吊ID',
  `tilt_angle` decimal(5,2) DEFAULT NULL COMMENT '倾斜角度(度)',
  `stress` decimal(10,2) DEFAULT NULL COMMENT '应力值(MPa)',
  `load_weight` decimal(8,2) DEFAULT NULL COMMENT '载重(吨)',
  `work_radius` decimal(8,2) DEFAULT NULL COMMENT '工作半径(m)',
  `wind_speed` decimal(5,2) DEFAULT NULL COMMENT '风速(m/s)',
  `alarm_status` tinyint(1) DEFAULT '0' COMMENT '报警状态(0:正常,1:预警,2:报警)',
  `crane_height` decimal(8,2) DEFAULT NULL COMMENT '塔吊高度(m)',
  `arm_angle` decimal(5,2) DEFAULT NULL COMMENT '大臂角度(度)',
  `hook_height` decimal(8,2) DEFAULT NULL COMMENT '钩头高度(m)',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`),
  KEY `idx_crane_id` (`crane_id`),
  KEY `idx_alarm_status` (`alarm_status`),
  KEY `idx_update_time` (`update_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='塔吊监测表';

-- 水质监测表
CREATE TABLE IF NOT EXISTS `water_quality_monitor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `monitor_point_id` varchar(50) NOT NULL COMMENT '监测点ID',
  `water_level` decimal(8,2) DEFAULT NULL COMMENT '水位(m)',
  `flow_velocity` decimal(6,2) DEFAULT NULL COMMENT '流速(m/s)',
  `flow_rate` decimal(10,2) DEFAULT NULL COMMENT '流量(m³/s)',
  `ph_value` decimal(4,2) DEFAULT NULL COMMENT 'pH值',
  `turbidity` decimal(6,2) DEFAULT NULL COMMENT '浊度(NTU)',
  `dissolved_oxygen` decimal(5,2) DEFAULT NULL COMMENT '溶解氧(mg/L)',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态(0正常,1预警)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`),
  KEY `idx_monitor_point_id` (`monitor_point_id`),
  KEY `idx_status` (`status`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='水质监测表';

-- 能耗监测表
CREATE TABLE IF NOT EXISTS `energy_consumption_monitor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `meter_id` varchar(50) NOT NULL COMMENT '表计ID',
  `meter_type` tinyint(1) NOT NULL COMMENT '表计类型(1:电表,2:水表)',
  `reading_value` decimal(15,3) DEFAULT NULL COMMENT '读数',
  `consumption` decimal(15,3) DEFAULT NULL COMMENT '消耗量',
  `carbon_emission` decimal(10,3) DEFAULT NULL COMMENT '碳排放量(kgCO2e)',
  `record_time` datetime DEFAULT NULL COMMENT '记录时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`),
  KEY `idx_meter_id` (`meter_id`),
  KEY `idx_meter_type` (`meter_type`),
  KEY `idx_record_time` (`record_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='能耗监测表';

-- 无人机巡检表
CREATE TABLE IF NOT EXISTS `drone_inspection` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `drone_id` varchar(50) NOT NULL COMMENT '无人机ID',
  `inspection_route` varchar(200) DEFAULT NULL COMMENT '巡检路线',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态(0:待执行,1:执行中,2:已完成,3:异常)',
  `video_url` varchar(500) DEFAULT NULL COMMENT '视频文件地址',
  `image_urls` text DEFAULT NULL COMMENT '图片文件地址(JSON格式)',
  `violation_count` int(11) DEFAULT '0' COMMENT '违规行为数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`),
  KEY `idx_drone_id` (`drone_id`),
  KEY `idx_status` (`status`),
  KEY `idx_start_time` (`start_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='无人机巡检表';

-- 插入测试数据
INSERT INTO `bridge_monitoring` (`point_id`, `vertical_displ`, `lateral_displ`, `temperature`, `wind_speed`, `status`, `cable_force`, `stress_value`, `deviation`) VALUES
('B-P001', 2.1500, 0.8500, 25.50, 2.80, 0, 850.00, 150.00, 0.5000),
('B-P002', 3.2500, 1.0800, 28.50, 3.20, 1, 920.00, 180.00, 0.7500),
('B-P003', 1.8500, 0.6500, 24.80, 2.50, 0, 780.00, 120.00, 0.4000);

INSERT INTO `earthwork_flow` (`section_id`, `excavation`, `backfill`, `transport_out`, `transport_in`, `carbon_value`, `record_date`, `earthwork_type`, `disposal_method`, `transport_distance`) VALUES
('SEC-001', 1250.750, 850.250, 400.500, 320.250, 15.500, '2023-08-15', 1, 1, 5.20),
('SEC-002', 980.500, 650.300, 330.200, 280.100, 12.800, '2023-08-15', 1, 2, 8.50),
('SEC-003', 1560.800, 1100.400, 460.400, 380.200, 18.900, '2023-08-15', 2, 3, 3.80);

INSERT INTO `tower_crane_monitor` (`crane_id`, `tilt_angle`, `stress`, `load_weight`, `work_radius`, `wind_speed`, `alarm_status`, `crane_height`, `arm_angle`, `hook_height`) VALUES
('TC-001', 0.85, 120.50, 8.50, 45.20, 3.20, 0, 85.50, 45.80, 65.30),
('TC-002', 1.20, 150.80, 12.30, 52.10, 4.50, 1, 92.30, 38.90, 78.40),
('TC-003', 0.65, 95.20, 6.80, 38.70, 2.80, 0, 78.90, 52.10, 58.20);

-- 创建索引
CREATE INDEX idx_bridge_monitoring_composite ON bridge_monitoring(point_id, status, create_time);
CREATE INDEX idx_earthwork_flow_composite ON earthwork_flow(section_id, record_date, earthwork_type);
CREATE INDEX idx_tower_crane_composite ON tower_crane_monitor(crane_id, alarm_status, update_time);
