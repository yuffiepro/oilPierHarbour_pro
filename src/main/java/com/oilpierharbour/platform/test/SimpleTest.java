package com.oilpierharbour.platform.test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SimpleTest {
    
    private static final int PORT = 8080;
    
    public static void main(String[] args) {
        System.out.println("Starting Oil Pier Harbour Test Service...");
        System.out.println("Port: " + PORT);
        
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Test service started successfully!");
            
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     OutputStream out = clientSocket.getOutputStream();
                     PrintWriter writer = new PrintWriter(out, true)) {
                    
                    String response = "HTTP/1.1 200 OK\r\n" +
                                   "Content-Type: application/json\r\n" +
                                   "\r\n" +
                                   "{\"status\":\"running\",\"port\":" + PORT + "}";
                    
                    writer.print(response);
                    writer.flush();
                    
                } catch (Exception e) {
                    System.err.println("Error handling client: " + e.getMessage());
                }
            }
            
        } catch (IOException e) {
            System.err.println("Failed to start test service: " + e.getMessage());
        }
    }
}

