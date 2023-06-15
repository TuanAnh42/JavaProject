/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import dao.JDBCConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.User;

/**
 *
 * @author DELL
 */
public class model  {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

   
    public ArrayList<User> getAll() {
        ArrayList<User> arrayList = new ArrayList<>();
        String sql = "SELECT*FROM user";
        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = new User();
                
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("Password"));
                arrayList.add(user);
            }
            return arrayList;
        } catch (SQLException e) {
        } finally {
            JDBCConnect.closeResultSet(rs);
            JDBCConnect.closePreparedStatement(preparedStatement);
            JDBCConnect.closeConnection(connection);
        }
        return null;

    }
}
