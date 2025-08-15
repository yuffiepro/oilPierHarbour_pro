package com.oilpierharbour.platform.mqtt.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oilpierharbour.platform.entity.BridgeMonitoring;
import com.oilpierharbour.platform.entity.TowerCraneMonitor;
import com.oilpierharbour.platform.entity.WaterQualityMonitor;
import com.oilpierharbour.platform.service.BridgeMonitoringService;
import com.oilpierharbour.platform.service.TowerCraneMonitorService;
import com.oilpierharbour.platform.service.WaterQualityMonitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MqttMessageHandler {

    private static final Logger logger = LoggerFactory.getLogger(MqttMessageHandler.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BridgeMonitoringService bridgeMonitoringService;

    @Autowired
    private TowerCraneMonitorService towerCraneMonitorService;

    @Autowired
    private WaterQualityMonitorService waterQualityMonitorService;

    @ServiceActivator(inputChannel = "mqttInputChannel")
    public void handleMessage(Message<?> message) {
        try {
            String topic = message.getHeaders().get("mqtt_topic").toString();
            String payload = message.getPayload().toString();
            
            logger.info("收到MQTT消息，主题: {}, 内容: {}", topic, payload);

            if (topic.startsWith("oilpier/bridge/")) {
                handleBridgeMonitoringMessage(payload);
            } else if (topic.startsWith("oilpier/tower-crane/")) {
                handleTowerCraneMessage(payload);
            } else if (topic.startsWith("oilpier/water-quality/")) {
                handleWaterQualityMessage(payload);
            } else {
                logger.warn("未知的MQTT主题: {}", topic);
            }

        } catch (Exception e) {
            logger.error("处理MQTT消息时发生错误", e);
        }
    }

    private void handleBridgeMonitoringMessage(String payload) {
        try {
            Map<String, Object> data = objectMapper.readValue(payload, Map.class);
            BridgeMonitoring monitoring = new BridgeMonitoring();
            
            monitoring.setPointId((String) data.get("pointId"));
            monitoring.setVerticalDispl(parseDecimal(data.get("verticalDispl")));
            monitoring.setLateralDispl(parseDecimal(data.get("lateralDispl")));
            monitoring.setTemperature(parseDecimal(data.get("temperature")));
            monitoring.setWindSpeed(parseDecimal(data.get("windSpeed")));
            monitoring.setCableForce(parseDecimal(data.get("cableForce")));
            monitoring.setStressValue(parseDecimal(data.get("stressValue")));
            monitoring.setDeviation(parseDecimal(data.get("deviation")));
            
            // 根据监测数据判断状态
            monitoring.setStatus(determineBridgeStatus(monitoring));
            
            bridgeMonitoringService.save(monitoring);
            logger.info("桥梁监测数据保存成功: {}", monitoring.getPointId());
            
        } catch (Exception e) {
            logger.error("处理桥梁监测消息失败", e);
        }
    }

    private void handleTowerCraneMessage(String payload) {
        try {
            Map<String, Object> data = objectMapper.readValue(payload, Map.class);
            TowerCraneMonitor monitor = new TowerCraneMonitor();
            
            monitor.setCraneId((String) data.get("craneId"));
            monitor.setTiltAngle(parseDecimal(data.get("tiltAngle")));
            monitor.setStress(parseDecimal(data.get("stress")));
            monitor.setLoadWeight(parseDecimal(data.get("loadWeight")));
            monitor.setWorkRadius(parseDecimal(data.get("workRadius")));
            monitor.setWindSpeed(parseDecimal(data.get("windSpeed")));
            monitor.setCraneHeight(parseDecimal(data.get("craneHeight")));
            monitor.setArmAngle(parseDecimal(data.get("armAngle")));
            monitor.setHookHeight(parseDecimal(data.get("hookHeight")));
            
            // 根据监测数据判断报警状态
            monitor.setAlarmStatus(determineTowerCraneAlarmStatus(monitor));
            
            towerCraneMonitorService.save(monitor);
            logger.info("塔吊监测数据保存成功: {}", monitor.getCraneId());
            
        } catch (Exception e) {
            logger.error("处理塔吊监测消息失败", e);
        }
    }

    private void handleWaterQualityMessage(String payload) {
        try {
            Map<String, Object> data = objectMapper.readValue(payload, Map.class);
            WaterQualityMonitor monitor = new WaterQualityMonitor();
            
            monitor.setMonitorPointId((String) data.get("monitorPointId"));
            monitor.setWaterLevel(parseDecimal(data.get("waterLevel")));
            monitor.setFlowVelocity(parseDecimal(data.get("flowVelocity")));
            monitor.setFlowRate(parseDecimal(data.get("flowRate")));
            monitor.setPhValue(parseDecimal(data.get("phValue")));
            monitor.setTurbidity(parseDecimal(data.get("turbidity")));
            monitor.setDissolvedOxygen(parseDecimal(data.get("dissolvedOxygen")));
            
            // 根据监测数据判断状态
            monitor.setStatus(determineWaterQualityStatus(monitor));
            
            waterQualityMonitorService.save(monitor);
            logger.info("水质监测数据保存成功: {}", monitor.getMonitorPointId());
            
        } catch (Exception e) {
            logger.error("处理水质监测消息失败", e);
        }
    }

    private java.math.BigDecimal parseDecimal(Object value) {
        if (value == null) return null;
        try {
            return new java.math.BigDecimal(value.toString());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Integer determineBridgeStatus(BridgeMonitoring monitoring) {
        // 简单的预警逻辑，实际项目中需要更复杂的算法
        if (monitoring.getVerticalDispl() != null && monitoring.getVerticalDispl().compareTo(new java.math.BigDecimal("5.0")) > 0) {
            return 1; // 预警
        }
        if (monitoring.getLateralDispl() != null && monitoring.getLateralDispl().compareTo(new java.math.BigDecimal("2.0")) > 0) {
            return 1; // 预警
        }
        return 0; // 正常
    }

    private Integer determineTowerCraneAlarmStatus(TowerCraneMonitor monitor) {
        // 简单的报警逻辑，实际项目中需要更复杂的算法
        if (monitor.getTiltAngle() != null && monitor.getTiltAngle().compareTo(new java.math.BigDecimal("2.0")) > 0) {
            return 2; // 报警
        }
        if (monitor.getWindSpeed() != null && monitor.getWindSpeed().compareTo(new java.math.BigDecimal("10.0")) > 0) {
            return 1; // 预警
        }
        return 0; // 正常
    }

    private Integer determineWaterQualityStatus(WaterQualityMonitor monitor) {
        // 简单的水质状态判断，实际项目中需要更复杂的算法
        if (monitor.getPhValue() != null && 
            (monitor.getPhValue().compareTo(new java.math.BigDecimal("6.5")) < 0 || 
             monitor.getPhValue().compareTo(new java.math.BigDecimal("8.5")) > 0)) {
            return 1; // 预警
        }
        return 0; // 正常
    }
}

