package com.oilpierharbour.platform.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 简单的HTTP测试服务器
 * 用于验证基础功能是否正常
 */
public class SimpleTestApp {
    
    private static final int PORT = 8080;
    private static final String RESPONSE = 
        "HTTP/1.1 200 OK\r\n" +
        "Content-Type: application/json\r\n" +
        "Access-Control-Allow-Origin: *\r\n" +
        "\r\n" +
        "{\n" +
        "  \"code\": 200,\n" +
        "  \"message\": \"油墩港数字管理平台测试服务运行正常\",\n" +
        "  \"data\": {\n" +
        "    \"timestamp\": \"" + System.currentTimeMillis() + "\",\n" +
        "    \"status\": \"running\",\n" +
        "    \"version\": \"1.0.0\"\n" +
        "  }\n" +
        "}";
    
    public static void main(String[] args) {
        System.out.println("启动油墩港数字管理平台测试服务...");
        System.out.println("服务端口: " + PORT);
        System.out.println("访问地址: http://localhost:" + PORT + "/test/health");
        
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("测试服务启动成功！");
            
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     OutputStream out = clientSocket.getOutputStream();
                     PrintWriter writer = new PrintWriter(out, true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    
                    // 读取HTTP请求
                    String requestLine = in.readLine();
                    System.out.println("收到请求: " + requestLine);
                    
                    // 发送响应
                    writer.print(RESPONSE);
                    writer.flush();
                    
                } catch (Exception e) {
                    System.err.println("处理客户端请求时发生错误: " + e.getMessage());
                }
            }
            
        } catch (IOException e) {
            System.err.println("启动测试服务失败: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

