/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.DAO;

import MainProject.Sell.LoadData;
import MainProject.Order.OrderOff;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class loadDataModify {
    public static List<LoadData> getDataList(int table) {
        List<LoadData>  dataList = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select * from loaddata where ban = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, table);
            ResultSet resultset = statement.executeQuery();
            while(resultset.next()) {
                LoadData dt = new LoadData(
                        resultset.getInt("ban"),
                        resultset.getString("food"),
                        resultset.getInt("total"),
                        resultset.getInt("price")
                );
                dataList.add(dt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return dataList;
    }
    
    public static boolean  checkTable(int table) {
        boolean check = false;
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select * from loaddata where ban = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, table);
            ResultSet resultset = statement.executeQuery();
            while(resultset.next()) {
                check = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return check;
    }
    
    public static void InsertData(LoadData data) {
       
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "insert into loaddata(ban, food, total, price) values (?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, data.getTable());
            statement.setString(2, data.getFood());
            statement.setInt(3, data.getTotal());
            statement.setInt(4, data.getPrice());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void deleteData(int table) {
       
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "delete from loaddata where ban = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, table);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void InsertOrder(GetAccount ac,OrderOff data, String dates) {
       
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);   
            String sql = "insert into orders(Client_ID, tab, total_price, dates, name, phone, address) values (?, ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, data.getStaffid());
            statement.setInt(2, data.getTable());
            statement.setFloat(3, data.getTotalPrice());
            statement.setString(4, dates);
            statement.setString(5, ac.getName_client());
            statement.setString(6, ac.getTelephone());
            statement.setString(7, ac.getAddress());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void InsertOrderDetail(int orderid, int pid, LoadData data) {
       
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);   
            String sql = "insert into order_detail(OrderID, ProductID, Price, Total) values (?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, orderid);
            statement.setInt(2, pid);
            statement.setInt(3, data.getPrice());
            statement.setInt(4, data.getTotal());
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static int selectID(String dates) {
       int id = 0;
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);   
            String sql = "select OrderID from orders where dates = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, dates);
            ResultSet resultsest = statement.executeQuery();
            while(resultsest.next()) {
                id = resultsest.getInt("OrderID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return id;
    }
    
    public static int idProduct(String name) {
       int id = 0;
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);   
            String sql = "select ProductID from products where Name = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultsest = statement.executeQuery();
            while(resultsest.next()) {
                id = resultsest.getInt("ProductID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(loadDataModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return id;
    }
    
    public static void UpdateStatus(String email,  String status) {
        Connection conn = null;
        PreparedStatement statement = null;
      
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "update account_client set status = ? where accounts = ?";
            statement = conn.prepareStatement(sql);
            
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
            
            statement.setString(1, status);
            statement.setString(2, email);
            
            
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
