/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.DAO;


import MainProject.RegisterAndLogin.Infor;
import MainProject.Utility.Patternform;
//import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class RegisterModify {
    public static void Register(Infor infor) {
        Connection conn = null;
        PreparedStatement statement = null;
        String mahoa = Patternform.mahoa(infor.getPassword());
        int code = (int) Math.ceil(Math.random() * 1000000);
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "insert into account_client(accounts, passwords, nick_name, phone, address, age, gender, created_at, updated_at, status, codes) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
            
            statement.setString(1, infor.getEmail());
            statement.setString(2, mahoa);
            statement.setString(3, infor.getFullname());
            statement.setString(4, infor.getPhone());
            statement.setString(5, infor.getAddress());
            statement.setString(6, infor.getAge());
            statement.setString(7, infor.getGender());
            statement.setString(8, strDate);
            statement.setString(9, strDate);
            statement.setString(10, "Offline");
            statement.setInt(11, code);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RegisterModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static boolean Login(String username, String pass) {
        Connection conn = null;
        PreparedStatement statement = null;
        String mahoa = Patternform.mahoa(pass);
        var result = false;
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select * from account_client where accounts = ? and passwords = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, mahoa);
            ResultSet resultset = statement.executeQuery();
            if(resultset.next()) {
                result = true;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(RegisterModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return result;
    }
    
    public static boolean getCode(String username, String code) {
        Connection conn = null;
        PreparedStatement statement = null;
        var result = false;
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select * from account_client where accounts = ? and codes = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, code);
            ResultSet resultset = statement.executeQuery();
            if(resultset.next()) {
                result = true;
            } 
        } catch (SQLException ex) {
            Logger.getLogger(RegisterModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return result;
    }

    public static Infor getByEmail(String username) {
        Infor data = null;
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select * from account_client where accounts = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultset = statement.executeQuery();
            if(resultset.next()) {
                data = new Infor(
                        resultset.getInt("id"),
                        resultset.getString("nick_name")
                );
            };
        } catch (SQLException ex) {
            Logger.getLogger(RegisterModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return data;
    }
    
    public static Infor getData(String username) {
        Infor data = null;
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select * from account_client where accounts = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet resultset = statement.executeQuery();
            if(resultset.next()) {
                data = new Infor(
                        resultset.getString("nick_name"),
                        resultset.getString("age"),
                        resultset.getString("accounts"),
                        resultset.getString("passwords"),
                        resultset.getString("phone"),
                        resultset.getString("address"),
                        resultset.getString("gender")
                );
            };
        } catch (SQLException ex) {
            Logger.getLogger(RegisterModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegisterModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return data;
    }
}
