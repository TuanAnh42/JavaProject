/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.Close;
import config.Config;
import entity.Bill;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class BillManagement {

    public static void add(Bill billMn) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        boolean flag = false;
        

        String sql = "INSERT INTO bill(id, book_id,user_id,price,check_in,check_out) VALUES(?,?,?,?,?,?)";
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, billMn.getId());
            preparedStatement.setInt(2, billMn.getBook_id());
            preparedStatement.setInt(3, billMn.getUser_id());
            preparedStatement.setFloat(4, billMn.getPrice());
            preparedStatement.setString(5, billMn.getCheck_in());
            preparedStatement.setDate(6, null);

            if (preparedStatement.executeUpdate() > 0) {

                System.out.println("aaaa");
                flag = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.closeConnection(conn);
            Close.closePreparedStatement(preparedStatement);

        }

    }

    public static List<Bill> getBillList() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Bill> BillList = new ArrayList<>();

        String sql = "select bill.id as bill_id, book.id as book_id, customer.name as customerName, user.id as user_id,user.name as userName, bill.check_in,bill.check_out, bill.price  from bill "
                + "inner join book on bill.book_id = book.id "
                + " inner join customer on customer.id = book.customer_id"
                + " inner join user on bill.user_id = user.id ";

        try {
;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
//            System.out.println("vvvvvvvvvv");
//            System.out.println(rs);
//            int i = 1;
            while (rs.next()) {
//                System.out.println(rs);
                Bill billMn = new Bill(
                        rs.getInt("bill_id"),
                        rs.getInt("book_id"),
                        rs.getInt("user_id"),
                        rs.getFloat("price"),
                        rs.getString("check_in"),
                        rs.getDate("check_out")
                        
                );
//                System.out.println("cccc");
                billMn.setCustomerName(rs.getString("customerName"));
//                System.out.println(billMn.getCustomerName());
//                BillList.add(billMn);
                billMn.setUserName(rs.getString("userName"));
                BillList.add(billMn);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            Close.closeConnection(conn);
            Close.closeResultSet(rs);
            Close.closePreparedStatement(preparedStatement);
        }
        return BillList;
    }

    

}
/**
select bill.*,
customer.name,
user.name,
book.*
from bill 
inner join book
on bill.book_id = book.id
inner join customer
on customer.id = book.customer_id
inner join user
on book.user_id = user.id;


 */
