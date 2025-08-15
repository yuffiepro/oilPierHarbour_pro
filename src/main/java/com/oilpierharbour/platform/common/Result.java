package com.oilpierharbour.platform.common;

import lombok.Data;

/**
 * 统一响应结果类
 * 
 * @author 油墩港平台团队
 * @since 1.0.0
 */
@Data
public class Result<T> {
    
    private Integer code;
    private String message;
    private T data;
    private Long timestamp;
    
    public Result() {
        this.timestamp = System.currentTimeMillis();
    }
    
    public Result(Integer code, String message) {
        this();
        this.code = code;
        this.message = message;
    }
    
    public Result(Integer code, String message, T data) {
        this(code, message);
        this.data = data;
    }
    
    public static <T> Result<T> success() {
        return new Result<>(200, "操作成功");
    }
    
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "操作成功", data);
    }
    
    public static <T> Result<T> success(String message, T data) {
        return new Result<>(200, message, data);
    }
    
    public static <T> Result<T> error() {
        return new Result<>(500, "操作失败");
    }
    
    public static <T> Result<T> error(String message) {
        return new Result<>(500, message);
    }
    
    public static <T> Result<T> error(Integer code, String message) {
        return new Result<>(code, message);
    }
    
    public static <T> Result<T> unauthorized() {
        return new Result<>(401, "未授权访问");
    }
    
    public static <T> Result<T> forbidden() {
        return new Result<>(403, "禁止访问");
    }
    
    public static <T> Result<T> notFound() {
        return new Result<>(404, "资源不存在");
    }
}
