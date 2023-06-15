/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import config.Config;
import config.Close;
import entity.Customer;

/**
 *
 * @author DELL
 */
public class BillManagement {
    private Connection conn = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    
    
    public List<Customer> getCustomerList(){
        
        List<Customer> customerList = new ArrayList<>();
        
        String sql = "SELECT*FROM new_table";
        try {
            conn = DriverManager.getConnection(Config.DB_URL,Config.USERNAME,Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            rs =preparedStatement.executeQuery();
            while (rs.next()) {
                Customer customerMn = new entity.Customer();
                customerMn.setName(sql);

                customerList.add(customerMn);
            }
            return customerList;
        } catch (SQLException e) {
        } finally {
            Close.closeResultSet(rs);
            Close.closePreparedStatement(preparedStatement);
            
        }
        return null;
        
    } 
    public boolean add(Customer obj){
        boolean flag= false;
        String sql = "INSERT INTO student(Rollnumber, name, dob, email, mobile, address)VALUES(?,?,?,?,?,?)";
        try{
            
            conn = DriverManager.getConnection(Config.DB_URL,Config.USERNAME,Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            
            if(preparedStatement.executeUpdate()>0){
                System.out.println("aaaa");
                flag= true;
            }  
            
           
        } catch (SQLException e) {
        } finally {
            Close.closeConnection(conn);
            Close.closePreparedStatement(preparedStatement);
            
        }    
        return false;
        
    }
    public boolean update(Customer obj){
        String query = "UPDATE ";
        
        try{
            conn = DriverManager.getConnection(Config.DB_URL,Config.USERNAME,Config.PASSWORD);
            preparedStatement = conn.prepareStatement(query);
            Customer c = new Customer();
            
            
        } catch (SQLException e) {
        } finally {
            Close.closeConnection(conn);
            Close.closePreparedStatement(preparedStatement);
            
        }  
        return false;
        
    }
    public boolean delete(int id){
        String query = "DELETE";
        
        try{
            conn = DriverManager.getConnection(Config.DB_URL,Config.USERNAME,Config.PASSWORD);
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            Customer s = new Customer();
            if (rs != 0) {
                System.out.println("Student delete with roll_number= " + id);
            } else {
                System.out.println("Not Student found with roll_number=" + id);
            }
            
            
        } catch (SQLException e) {
        } finally {
            Close.closeConnection(conn);
            Close.closePreparedStatement(preparedStatement);
            Close.closeResultSet(rs);
        }  
        return false;
        
    }
    
}
