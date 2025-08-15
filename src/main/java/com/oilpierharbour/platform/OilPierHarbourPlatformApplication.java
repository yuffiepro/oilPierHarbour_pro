package com.oilpierharbour.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 油墩港数字管理平台启动类
 * 
 * @author 油墩港平台团队
 * @since 1.0.0
 */
@SpringBootApplication
@MapperScan("com.oilpierharbour.platform.mapper")
@EnableAsync
@EnableScheduling
public class OilPierHarbourPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(OilPierHarbourPlatformApplication.class, args);
        System.out.println("=================================");
        System.out.println("油墩港数字管理平台启动成功！");
        System.out.println("=================================");
    }
}
