/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.IDBConfig;
import entity.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.StudentModel;


/**
 *
 * @author std
 */
public class JDBCConnect extends StudentModel{

    public static Connection getJDBCConnection() {
        Connection conn = null;
        String connectionUrl = "jdbc:mysql://" + IDBConfig.HOSTNAME
                + ":" + IDBConfig.PORT + "/"
                + IDBConfig.DBNAME;
        System.out.println(connectionUrl);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Where is your MySQL JDBC Driver");
            return conn;
        }
        System.out.println("MySQL JDBC Driver Registered!");
        try {         
            conn = DriverManager.getConnection(connectionUrl,IDBConfig.USERNAME,IDBConfig.PASSWORD);
            System.out.println(conn);
        } catch (SQLException ex) {
            System.out.println("Connection Failed! Check output console");
            return conn;
        }
        return conn;
    }
    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("Close Connection fails");
        }
    }

    public static void closeResultSet(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("Close ResultSet fails");
        }
    }

    public static void closePreparedStatement(PreparedStatement prepare) {
        try {
            if (prepare != null) {
                prepare.close();
            }
        } catch (SQLException e) {
            System.out.println("Close PreparedStatement fails");
        }
    }
    

    
}
