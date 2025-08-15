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

-- ==========================================
-- 系统与基础维表（用户、角色、权限、配置、设备、标段等）
-- ==========================================

-- 系统用户表
CREATE TABLE IF NOT EXISTS `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码(BCrypt)',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像URL',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态(1:启用,0:禁用)',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`),
  KEY `idx_status` (`status`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统用户表';

-- 角色表
CREATE TABLE IF NOT EXISTS `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code` varchar(50) NOT NULL COMMENT '角色编码',
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态(1:启用,0:禁用)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_role_code` (`code`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- 权限表(接口/菜单/按钮)
CREATE TABLE IF NOT EXISTS `sys_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code` varchar(100) NOT NULL COMMENT '权限编码',
  `name` varchar(100) NOT NULL COMMENT '权限名称',
  `type` tinyint(1) NOT NULL DEFAULT '1' COMMENT '类型(1:接口,2:菜单,3:按钮)',
  `method` varchar(10) DEFAULT NULL COMMENT 'HTTP方法(GET/POST/...)',
  `path` varchar(200) DEFAULT NULL COMMENT '接口路径或前端路由',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父权限ID',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态(1:启用,0:禁用)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_perm_code` (`code`),
  KEY `idx_parent_id` (`parent_id`),
  KEY `idx_type_status` (`type`, `status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='权限表';

-- 用户-角色 关系表
CREATE TABLE IF NOT EXISTS `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_role` (`user_id`, `role_id`),
  KEY `idx_role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户-角色 关系表';

-- 角色-权限 关系表
CREATE TABLE IF NOT EXISTS `sys_role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` bigint(20) NOT NULL COMMENT '角色ID',
  `permission_id` bigint(20) NOT NULL COMMENT '权限ID',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_role_perm` (`role_id`, `permission_id`),
  KEY `idx_permission_id` (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色-权限 关系表';

-- 系统配置表(系统设置)
CREATE TABLE IF NOT EXISTS `sys_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `config_key` varchar(100) NOT NULL COMMENT '配置键',
  `config_value` text COMMENT '配置值',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态(1:启用,0:禁用)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_config_key` (`config_key`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统配置表';

-- 设备维表：桥梁监测点
CREATE TABLE IF NOT EXISTS `bridge_monitor_point` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `point_id` varchar(50) NOT NULL COMMENT '监测点ID(与业务表关联)',
  `name` varchar(100) DEFAULT NULL COMMENT '监测点名称',
  `location` varchar(200) DEFAULT NULL COMMENT '位置描述/坐标',
  `elevation` decimal(8,2) DEFAULT NULL COMMENT '高程(m)',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态(1:启用,0:停用)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_point_id` (`point_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='桥梁监测点维表';

-- 设备维表：塔吊设备
CREATE TABLE IF NOT EXISTS `tower_crane_device` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `crane_id` varchar(50) NOT NULL COMMENT '塔吊ID(与业务表关联)',
  `name` varchar(100) DEFAULT NULL COMMENT '塔吊名称',
  `model` varchar(100) DEFAULT NULL COMMENT '设备型号',
  `installation_height` decimal(8,2) DEFAULT NULL COMMENT '安装高度(m)',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态(1:启用,0:停用)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_crane_id` (`crane_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='塔吊设备维表';

-- 设备维表：水质监测点
CREATE TABLE IF NOT EXISTS `water_quality_point` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `monitor_point_id` varchar(50) NOT NULL COMMENT '监测点ID(与业务表关联)',
  `name` varchar(100) DEFAULT NULL COMMENT '监测点名称',
  `location` varchar(200) DEFAULT NULL COMMENT '位置描述/坐标',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态(1:启用,0:停用)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_monitor_point_id` (`monitor_point_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='水质监测点维表';

-- 能耗：表计维表
CREATE TABLE IF NOT EXISTS `energy_meter` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `meter_id` varchar(50) NOT NULL COMMENT '表计ID(与业务表关联)',
  `meter_type` tinyint(1) NOT NULL COMMENT '表计类型(1:电表,2:水表)',
  `name` varchar(100) DEFAULT NULL COMMENT '表计名称',
  `location` varchar(200) DEFAULT NULL COMMENT '安装位置',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态(1:启用,0:停用)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_meter_id` (`meter_id`),
  KEY `idx_type_status` (`meter_type`, `status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='能耗表计维表';

-- 无人机设备维表
CREATE TABLE IF NOT EXISTS `drone_device` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `drone_id` varchar(50) NOT NULL COMMENT '无人机ID(与业务表关联)',
  `name` varchar(100) DEFAULT NULL COMMENT '设备名称',
  `model` varchar(100) DEFAULT NULL COMMENT '设备型号',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态(1:启用,0:停用)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_drone_id` (`drone_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='无人机设备维表';

-- 无人机巡检路线维表
CREATE TABLE IF NOT EXISTS `drone_route` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `route_code` varchar(50) NOT NULL COMMENT '路线编码',
  `name` varchar(100) DEFAULT NULL COMMENT '路线名称',
  `waypoints` text COMMENT '航点(JSON)',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态(1:启用,0:停用)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_route_code` (`route_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='无人机巡检路线维表';

-- 土方：标段维表
CREATE TABLE IF NOT EXISTS `project_section` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `section_id` varchar(50) NOT NULL COMMENT '标段ID(与业务表关联)',
  `name` varchar(100) DEFAULT NULL COMMENT '标段名称',
  `contractor` varchar(100) DEFAULT NULL COMMENT '承包单位',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态(1:在建,0:停工/完工)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `deleted` tinyint(1) DEFAULT '0' COMMENT '逻辑删除标识',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_section_id` (`section_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='项目标段维表';

-- ==========================================
-- 初始化基础数据
-- ==========================================

-- 初始化系统角色
INSERT INTO `sys_role` (`code`, `name`, `description`) VALUES
('ROLE_ADMIN', '管理员', '系统管理员'),
('ROLE_USER', '普通用户', '普通使用者')
ON DUPLICATE KEY UPDATE `name`=VALUES(`name`);

-- 初始化系统用户(密码为123456, 与内存用户保持一致便于切换)
INSERT INTO `sys_user` (`username`, `password`, `nickname`, `status`) VALUES
('admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVEFDa', '管理员', 1),
('user', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVEFDa', '普通用户', 1)
ON DUPLICATE KEY UPDATE `nickname`=VALUES(`nickname`);

-- 绑定用户角色
INSERT INTO `sys_user_role` (`user_id`, `role_id`)
SELECT u.id, r.id FROM sys_user u, sys_role r 
WHERE u.username='admin' AND r.code='ROLE_ADMIN'
ON DUPLICATE KEY UPDATE `role_id`=VALUES(`role_id`);

INSERT INTO `sys_user_role` (`user_id`, `role_id`)
SELECT u.id, r.id FROM sys_user u, sys_role r 
WHERE u.username='user' AND r.code='ROLE_USER'
ON DUPLICATE KEY UPDATE `role_id`=VALUES(`role_id`);

-- 示例系统配置
INSERT INTO `sys_config` (`config_key`, `config_value`, `description`) VALUES
('site.title', '油墩港数字管理平台', '系统站点标题'),
('mqtt.enabled', 'false', '是否启用MQTT采集'),
('alarm.bridge.threshold.verticalDispl', '10', '桥梁竖向位移预警阈值(mm)')
ON DUPLICATE KEY UPDATE `config_value`=VALUES(`config_value`);
