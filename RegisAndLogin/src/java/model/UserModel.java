/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import common.ICommon;
import config.IDBConfig;
import dao.JDBCConnect;
import entity.User;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tuấn Anh
 */
public class UserModel implements ICommon<User> {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    @Override
    public ArrayList<User> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User getOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(User obj) {
        int flag = 0;
        String insertTableSQL = "INSERT INTO User"
                + "(Username, Password,Email,Address) VALUES"
                + "(?,?,?,?)";
        try (Connection con = JDBCConnect.getJDBCConnection(); PreparedStatement ps = con.prepareStatement(insertTableSQL)) {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, obj.getUsername());
            preparedStatement.setString(2, obj.getPassword());
            preparedStatement.setString(3, obj.getEmail());
            preparedStatement.setString(4, obj.getAddress());
            // execute insert SQL stetement
            flag = preparedStatement.executeUpdate();
            System.out.println("Record is inserted into DBUSER table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag > 0;
    }

    @Override
    public boolean update(User obj, int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User login(String username, String password) {
        User users = null;
        String sql = "SELECT Username,Password FROM User where Username = ? and Password =?";
        try (Connection con = JDBCConnect.getJDBCConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {

                users = new User(
                        rs.getString("Username"),
                        rs.getString("Password")
                );
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCConnect.closeConnection(connection);
            JDBCConnect.closePreparedStatement(preparedStatement);

        }
        return null;
    }

}
