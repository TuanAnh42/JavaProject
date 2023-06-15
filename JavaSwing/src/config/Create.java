/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author DELL
 */
public class Create {
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USERNAME = "root";
    static final String PASSWORD = "12345678a";
    public static void main(String[] agrs)  {     
        try (Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD )) {
            System.out.println("Connecting to database...");
            System.out.println("Creating database...");
            
            PreparedStatement stmt = conn.prepareStatement(DB_URL);

            String sql = "CREATE DATABASE IF NOT EXISTS STUDENTS";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

