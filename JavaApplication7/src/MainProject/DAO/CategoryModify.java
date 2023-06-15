/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.DAO;

import MainProject.ManagerSP.Category;
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
public class CategoryModify {
    
    public static List<Category> GetCategoryList() {
        List<Category> dataList = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select * from category";
            statement = conn.prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();
            
            while(resultset.next()) {
                Category ct = new Category(
                        resultset.getString("CategoryID"),
                        resultset.getString("NameC")
                );
                dataList.add(ct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
        return dataList;
    }
    
    public static Category getCategory(String name) {
        Category ct = null;
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select * from category where NameC = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultset = statement.executeQuery();
            
            while(resultset.next()) {
                ct = new Category(
                        resultset.getString("CategoryID"),
                        resultset.getString("NameC")
                );
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CategoryModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        
        return ct;
    }
}
