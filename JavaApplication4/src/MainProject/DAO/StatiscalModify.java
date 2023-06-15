/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.DAO;

import MainProject.Order.OrderOff;
import MainProject.Order.Orderdetail;
import MainProject.ManagerSP.Product;
import MainProject.RegisterAndLogin.Infor;
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
public class StatiscalModify {
    public static List<OrderOff> getOrderList() {
        List<OrderOff> datalist = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select orders.*, account_client.nick_name as account_name from orders left join account_client on orders.Client_ID = account_client.ID";
            statement = conn.prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();
            
            while(resultset.next()) {
                OrderOff od = new OrderOff(
                        resultset.getInt("OrderID"),
                        resultset.getInt("tab"),
                        resultset.getInt("Client_ID"),
                        resultset.getFloat("total_price"),
                        resultset.getString("dates"),
                        resultset.getString("name"),
                        resultset.getString("phone"),
                        resultset.getString("address")
                );
                Infor staff = new Infor(
                        resultset.getInt("Client_ID"),
                        resultset.getString("account_name")
                );
                od.setStaff(staff);
                datalist.add(od);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatiscalModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StatiscalModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StatiscalModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return datalist;
    }
    
    public static List<OrderOff> Search(String date) {
        List<OrderOff> dataList = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select orders.*, account_client.nick_name as account_name from orders inner join account_client on orders.Client_ID = account_client.ID and dates like '"+date+"%'";
            statement = conn.prepareStatement(sql);
//            String s = date + "%";
//            statement.setString(1, s);
            ResultSet resultset = statement.executeQuery();
            
            while(resultset.next()) {
                OrderOff od = new OrderOff(
                        resultset.getInt("OrderID"),
                        resultset.getInt("tab"),
                        resultset.getInt("Client_ID"),
                        resultset.getFloat("total_price"),
                        resultset.getString("dates"),
                        resultset.getString("name"),
                        resultset.getString("phone"),
                        resultset.getString("address")
                );
                Infor staff = new Infor(
                        resultset.getInt("Client_ID"),
                        resultset.getString("account_name")
                );
                od.setStaff(staff);
                dataList.add(od);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatiscalModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StatiscalModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StatiscalModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return dataList;
    }
    
    public static List<Orderdetail> getListDetail(int id) {
        List<Orderdetail> dataList = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select order_detail.*, products.Name as pd_name from order_detail inner join products on order_detail.ProductID = products.ProductID and OrderID = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();
            
            while(resultset.next()) {
                Orderdetail od = new Orderdetail(
                        resultset.getInt("id"),
                        resultset.getInt("OrderID"),
                        resultset.getInt("ProductID"),
                        resultset.getInt("Price"),
                        resultset.getInt("Total")
                );
                Product p = new Product(
                        resultset.getString("ProductID"),
                        resultset.getString("pd_name")
                );
                od.setProduct(p);
                dataList.add(od);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatiscalModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StatiscalModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StatiscalModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return dataList;
    }
    
    public static List<Orderdetail> getListODD() {
        List<Orderdetail> dataList = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select Price, ProductID from order_detail";
            statement = conn.prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();
            
            while(resultset.next()) {
                Orderdetail od = new Orderdetail(
                        resultset.getInt("ProductID"),
                        resultset.getInt("Price")
                );
                dataList.add(od);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatiscalModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StatiscalModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StatiscalModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return dataList;
    }
    
    public static int getCount(String date) {
        int x = 0;
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "SELECT SUM(total_price) FROM orders where dates like '"+date+"%'";
            statement = conn.prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();
            while(resultset.next()) {
                      x = resultset.getInt("SUM(total_price)");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatiscalModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StatiscalModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StatiscalModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return x;
    }
}
