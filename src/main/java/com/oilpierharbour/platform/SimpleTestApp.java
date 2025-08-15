package com.oilpierharbour.platform;

/**
 * Simple test application to verify basic functionality
 */
public class SimpleTestApp {
    
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("Oil Pier Harbour Platform Test");
        System.out.println("=================================");
        System.out.println("Java version: " + System.getProperty("java.version"));
        System.out.println("OS: " + System.getProperty("os.name"));
        System.out.println("User: " + System.getProperty("user.name"));
        System.out.println("=================================");
        
        // Test database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL driver loaded successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL driver not found: " + e.getMessage());
        }
        
        System.out.println("=================================");
        System.out.println("Test completed!");
    }
}
