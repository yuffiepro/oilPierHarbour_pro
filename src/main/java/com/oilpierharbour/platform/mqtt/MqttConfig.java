package com.oilpierharbour.platform.mqtt;

import org.springframework.context.annotation.Configuration;

/**
 * MQTT配置类 - 暂时简化配置
 * 
 * @author 油墩港平台团队
 * @since 1.0.0
 */
@Configuration
public class MqttConfig {
    // TODO: 完善MQTT配置
    // 暂时注释掉MQTT相关配置，避免启动错误
    
    /*
    @Value("${oilpier.mqtt.broker}")
    private String broker;

    @Value("${oilpier.mqtt.client-id}")
    private String clientId;

    @Value("${oilpier.mqtt.username}")
    private String username;

    @Value("${oilpier.mqtt.password}")
    private String password;

    @Bean
    public MqttConnectOptions mqttConnectOptions() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[]{broker});
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        options.setConnectionTimeout(30);
        options.setKeepAliveInterval(60);
        options.setAutomaticReconnect(true);
        options.setCleanSession(false);
        return options;
    }

    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler mqttOutbound() {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler(clientId + "_out");
        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic("oilpier/response");
        return messageHandler;
    }

    @Bean
    public MqttPahoMessageDrivenChannelAdapter mqttInbound() {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter(
                clientId + "_in", "oilpier/bridge/#", "oilpier/tower-crane/#", "oilpier/water-quality/#");

        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler mqttMessageHandler() {
        return new MqttMessageHandler();
    }
    */
}
