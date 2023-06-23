/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import common.ICart;
import dao.JDBCConnect;
import entity.CartInf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tuấn Anh
 */
public class CartModel implements ICart<CartInf> {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    
    @Override
    public ArrayList<CartInf> getAll() {
        ArrayList<CartInf> CartList = new ArrayList<>();
        String sql = "SELECT * FROM  cartInf ";
        try {
            // kết nối được với db
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                CartInf inf = new CartInf(
                        rs.getInt("Masp"),
                        rs.getString("Tensp"),
                        rs.getDouble("Dongia")
                );
                
                CartList.add(inf);
            }
            return CartList;
            
        } catch (SQLException e) {
        } finally {
            JDBCConnect.closeResultSet(rs);
            JDBCConnect.closePreparedStatement(preparedStatement);
            JDBCConnect.closeConnection(connection);
        }
        return null;
    }
    public static void main(String[] args) {
        List<CartInf> cart = new ArrayList<>();
        cart = new CartModel().getAll();
        for (CartInf cartInf : cart) {
            System.out.println(cartInf);
        }
    }
}
