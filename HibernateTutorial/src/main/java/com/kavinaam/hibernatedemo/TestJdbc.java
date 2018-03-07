package com.kavinaam.hibernatedemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/spring_db?useSSL=false";
        String jdbcUser = "rudraautomation";
        String jdbcPassword = "rudraautomation";
        try {
            System.out.println("Connecting to datavase: "+jdbcUrl);
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl,jdbcUser,jdbcPassword);
            System.out.println("Connection successful!!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
