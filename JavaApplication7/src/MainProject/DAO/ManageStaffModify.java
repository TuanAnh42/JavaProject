/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.DAO;

import MainProject.RegisterAndLogin.Infor;
import MainProject.RegisterAndLogin.admin;
import MainProject.Utility.Patternform;
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
public class ManageStaffModify {
    public static List<Infor> getStaffList() {
        List<Infor> dataList = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select * from account_client";
            statement = conn.prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();
            
            while(resultset.next()) {
                Infor staff = new Infor(
                        resultset.getString("nick_name"),
                        resultset.getString("age"),
                        resultset.getString("accounts"),
                        resultset.getString("passwords"),
                        resultset.getString("phone"),
                        resultset.getString("address"),
                        resultset.getString("gender"),
                        resultset.getString("created_at"),
                        resultset.getString("updated_at"),
                        resultset.getString("status")
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
    
     public static boolean checkEmail(String username, String table, String account) {
        Connection conn = null;
        PreparedStatement statement = null;
        boolean result = false;
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select * from "+ table + " where " + account + " = ?";
            
            statement = conn.prepareStatement(sql);
            statement.setString(1, username);
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
     
    public static void Update(Infor staff) {
        Connection conn = null;
        PreparedStatement statement = null;
        String mahoa = Patternform.mahoa(staff.getPassword());
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "update account_client set passwords = ?, nick_name = ?, phone = ?, address = ?, age = ?, gender = ?, updated_at = ? where accounts = ?";
            statement = conn.prepareStatement(sql);
            
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
            
            statement.setString(1, mahoa);
            statement.setString(2, staff.getFullname());
            statement.setString(3, staff.getPhone());
            statement.setString(4, staff.getAddress());
            statement.setString(5, staff.getAge());
            statement.setString(6, staff.getGender());
            statement.setString(7, strDate);
            statement.setString(8, staff.getEmail());
            
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
    
    public static void Delete(String account, String table, String email) {
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "delete from " + table + " where " + email +" = ?";
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, account);
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
    
    public static List<Infor> Search(String name) {
        List<Infor> dataList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select * from account_client where nick_name like  '%"+name+"%'";
            statement = conn.prepareStatement(sql);
            
            ResultSet resultset = statement.executeQuery();
            while(resultset.next()) {
                Infor staff = new Infor(
                        resultset.getString("nick_name"),
                        resultset.getString("age"),
                        resultset.getString("accounts"),
                        resultset.getString("passwords"),
                        resultset.getString("phone"),
                        resultset.getString("address"),
                        resultset.getString("gender"),
                        resultset.getString("created_at"),
                        resultset.getString("updated_at"),
                        resultset.getString("status")
                );
                dataList.add(staff);
            }
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
    
    public static void addAdmin(admin ad) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "insert into account_admin(accountadmin, passwordadmin, nameadmin, id) values (?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, ad.getAccount());
            statement.setString(2, ad.getPassword());
            statement.setString(3, ad.getName());
            statement.setInt(4, ad.getId());
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
    
    
    
    
    
    public static void UpdateAd(admin ad) {
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "update account_admin set passwordadmin = ?, nameadmin = ? where accountadmin = ?";
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, ad.getPassword());
            statement.setString(2, ad.getName()); 
            statement.setString(3, ad.getAccount());
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
    
    public static void UpdatePass(String account, String pass, String table, String name, String confirmp) {
        Connection conn = null;
        PreparedStatement statement = null;
        String mahoa = Patternform.mahoa(pass);
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "update " + table +" set " + confirmp + " = ? where "+ name + "= ?";
            statement = conn.prepareStatement(sql);
            
            statement.setString(1, mahoa);
            statement.setString(2, account); 
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
    
    public static void SetCode(String account, int code) {
        Connection conn = null;
        PreparedStatement statement = null;
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "update account_client set codes = ? where accounts = ?";
            statement = conn.prepareStatement(sql);
            
            statement.setInt(1, code);
            statement.setString(2, account); 
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
