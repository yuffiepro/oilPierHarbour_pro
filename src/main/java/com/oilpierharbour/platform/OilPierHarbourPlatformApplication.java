package com.oilpierharbour.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Oil Pier Harbour Digital Management Platform Main Class
 * 
 * @author Platform Team
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
        System.out.println("Oil Pier Harbour Platform Started Successfully!");
        System.out.println("=================================");
    }
}
