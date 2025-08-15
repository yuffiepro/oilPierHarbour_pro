package com.oilpierharbour.platform.controller;

import com.oilpierharbour.platform.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试控制器
 */
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 健康检查接口
     */
    @GetMapping("/health")
    public Result<Map<String, Object>> health() {
        Map<String, Object> data = new HashMap<>();
        data.put("status", "UP");
        data.put("timestamp", System.currentTimeMillis());
        data.put("service", "油墩港数字管理平台");
        data.put("version", "1.0.0");
        
        return Result.success(data);
    }

    /**
     * 公开接口测试
     */
    @GetMapping("/public")
    public Result<String> publicTest() {
        return Result.success("这是一个公开接口，无需认证");
    }

    /**
     * 需要认证的接口测试
     */
    @GetMapping("/auth")
    public Result<String> authTest() {
        return Result.success("这是一个需要认证的接口，认证成功！");
    }
}

