/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.DAO;

import MainProject.ManagerSP.Category;
import MainProject.ManagerSP.Product;
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
public class ProductModify {

    public static List<Product> SearchName(int id) {
        List<Product> dataList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "Select * from products where CategoryID = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                Product pd = new Product(
                        resultset.getString("ProductID"),
                        resultset.getString("Name"),
                        resultset.getString("Price"),
                        resultset.getString("Properties"),
                        resultset.getString("CategoryID"),
                        resultset.getString("quantity")
                );
                dataList.add(pd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return dataList;
    }
    
    
    
    public static List<Product> ListProduct() {
        List<Product> dataList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "Select * from products";
            statement = conn.prepareStatement(sql);
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                Product pd = new Product(
                        resultset.getString("ProductID"),
                        resultset.getString("Name"),
                        resultset.getString("Price"),
                        resultset.getString("Properties"),
                        resultset.getString("CategoryID"),
                        resultset.getString("quantity")
                );
                dataList.add(pd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return dataList;
    }
    
    
    

    public static String SearchImg(String name, String getdata) {
        String img = null;

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "Select * from products where Name = ?";
            statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                img = resultset.getString(getdata);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return img;
    }

    public static void UpdateProduct(String name, int total) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "update products set quantity = ? where Name = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, total);
            statement.setString(2, name);
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static List<Product> getDataProduct() {
        List<Product> dataList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "select products.*, category.NameC as category_name from products left join category on products.CategoryID = category.CategoryID";
            statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Product p = new Product(
                        resultSet.getString("ProductID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Price"),
                        resultSet.getString("Properties"),
                        resultSet.getString("quantity"),
                        resultSet.getString("ImgLink"),
                        resultSet.getString("created_at"),
                        resultSet.getString("update_at")
                );
                Category c = new Category(
                        resultSet.getString("CategoryID"),
                        resultSet.getString("category_name")
                );
                p.setCt(c);
                dataList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return dataList;
    }

    public static void InsertData(Product p, int id) {

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "insert into products(Name, Price, Properties, ImgLink, quantity, CategoryID, created_at, update_at) values(?, ?, ?, ?, ?, ?, ?, ?)";
            statement = conn.prepareStatement(sql);
            
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
            
            statement.setString(1, p.getName());
            statement.setString(2, p.getPrice());
            statement.setString(3, p.getProperties());
            statement.setString(4, p.getImgLink());
            statement.setString(5, p.getQuantity());
            statement.setInt(6, id);
            statement.setString(7, strDate);
            statement.setString(8, strDate);
           statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
    public static void Update(Product p, int id) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "update products set Name = ?, Price = ?, Properties = ?, ImgLink = ?, quantity = ?, CategoryID = ?, update_at = ? where ProductID = ?";
            statement = conn.prepareStatement(sql);
            
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strDate = dateFormat.format(date);
            
            statement.setString(1, p.getName());
            statement.setString(2, p.getPrice());
            statement.setString(3, p.getProperties());
            statement.setString(4, p.getImgLink());
            statement.setString(5, p.getQuantity());
            statement.setInt(6, id);
            statement.setString(7, strDate);
            statement.setInt(8, p.getIdp());
           statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void Delete(int id) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "delete from products where ProductID = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
           statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static List<Product> Search(String name) {
        List<Product> dataList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement statement = null;
        
        
        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
//            String sql = "select * from products where Name like  '%"+name+"%'";
String sql = "select products.*, category.NameC as category_name from products inner join category on products.CategoryID = category.CategoryID and Name like '%"+name+"%'";
            statement = conn.prepareStatement(sql);
            
            ResultSet resultset = statement.executeQuery();
            while(resultset.next()) {
                Product p = new Product(
                        resultset.getString("ProductID"),
                        resultset.getString("Name"),
                        resultset.getString("Price"),
                        resultset.getString("Properties"),
                        resultset.getString("quantity"),
                        resultset.getString("ImgLink"),
                        resultset.getString("created_at"),
                        resultset.getString("update_at")
                );
                Category c = new Category(
                        resultset.getString("CategoryID"),
                        resultset.getString("category_name")
                );
                p.setCt(c);
                dataList.add(p);
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
    
    public static List<Product> getNameList() {
        List<Product> datalist = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = DriverManager.getConnection(Config.DB_URL, Config.USERNAME, Config.PASSWORD);
            String sql = "Select * from products";
            statement = conn.prepareStatement(sql); 
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()) {
                Product p = new Product(
                        resultset.getString("ProductID"),
                        resultset.getString("Name")
                );
                  
                datalist.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (conn == null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (statement == null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductModify.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return datalist;
    }
}
