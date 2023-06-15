/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.DAO;

import MainProject.Order.OrderOff;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class bookModify {
    public static void InsertBook(OrderOff od) {
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "insert into book(tab, note, created_at, times, name, phone) values (?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, od.getTable());
            statement.setString(2, od.getNote());
            statement.setString(3, od.getCreated_at());
            statement.setString(4, od.getTimes());
            statement.setString(5, od.getName());
            statement.setString(6, od.getPhone());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(bookModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(bookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(bookModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static List<OrderOff> getbookList(String s) {
        List<OrderOff> dataList = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select * from book";
            if(s != null && !s.isEmpty()) {
                sql += " where created_at = ?";
            }
            statement = conn.prepareStatement(sql);
            if(s != null && !s.isEmpty()) {
                statement.setString(1, s);
            }
            ResultSet resultset = statement.executeQuery();
            
            while(resultset.next()) {
                OrderOff staff = new OrderOff(
                        resultset.getInt("id"),
                        resultset.getInt("tab"),
                        resultset.getString("created_at"),
                        resultset.getString("times"),
                        resultset.getString("name"),
                        resultset.getString("phone"),
                        resultset.getString("note")
                );
                dataList.add(staff);
            };
            
        } catch (SQLException ex) {
            Logger.getLogger(ManageStaffModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManageStaffModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManageStaffModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
        return dataList;
    }
    
    
    
    public static void Update(OrderOff od) {
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "update book set tab = ?, note = ?, created_at = ?, times = ?, name = ?, phone = ? where id = ?";
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, od.getTable());
            statement.setString(2, od.getNote());
            statement.setString(3, od.getCreated_at());
            statement.setString(4, od.getTimes());
            statement.setString(5, od.getName());
            statement.setString(6, od.getPhone());
            statement.setInt(7, od.getId());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ManageStaffModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManageStaffModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManageStaffModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void Delete(int id) {
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "delete from book where id = ?";
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, id);    
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ManageStaffModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManageStaffModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ManageStaffModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
