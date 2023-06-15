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
import entity.Book;
import java.sql.Statement;


/**
 *
 * @author DELL
 */
public class BookManagement {

    public static List<Book> getBookList() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Book> bookList = new ArrayList<>();

        String sql = "SELECT*FROM book";
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {

                Book bookMn = new Book(
                        rs.getInt("id"),
                        rs.getInt("user_id"),                 
                        rs.getInt("customer_id"),
                        rs.getBoolean("status")
                      
                );
                bookList.add(bookMn);
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            Close.closeConnection(conn);
            Close.closeResultSet(rs);
            Close.closePreparedStatement(preparedStatement);

        }
        return bookList;

    }

    public static void add(Book bookMn) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        boolean flag = false;

        String sql = "INSERT INTO book(id, user_id,customer_id,status )VALUES(?,?,?,?)";
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, bookMn.getId());
            preparedStatement.setInt(2, bookMn.getUser_id());
            preparedStatement.setInt(3, bookMn.getCustomer_id());
            preparedStatement.setBoolean(4, true);
            if (preparedStatement.executeUpdate() > 0) {
                ResultSet rsGetId = preparedStatement.getGeneratedKeys();
                    int generatedKey = 0;
                    if (rsGetId.next()) {
                        generatedKey = rsGetId.getInt(1);
                        bookMn.setId(generatedKey);
                    }
//                System.out.println("aaaa");
                flag = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.closeConnection(conn);
            Close.closePreparedStatement(preparedStatement);

        }

    }

}
