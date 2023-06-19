/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import common.IGroup;
import dao.JDBCConnect;
import entity.FriendGroup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Tuấn Anh
 */
public class AddGroup implements IGroup<FriendGroup>{
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    @Override
    public ArrayList<FriendGroup> getAll() {
    

        ArrayList<FriendGroup> groupList = new ArrayList<>();
        String sql = "SELECT * FROM FriendGroup";
        try {
            // kết nối được với db
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                FriendGroup group = new FriendGroup(
                        rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("Description")
                );
                

                groupList.add(group);
            }
            return groupList;
            
        } catch (SQLException e) {
        } finally {
            JDBCConnect.closeResultSet(rs);
            JDBCConnect.closePreparedStatement(preparedStatement);
            JDBCConnect.closeConnection(connection);
        }
        return null;
    }
    

    @Override
    public boolean add(FriendGroup group) {
        int flag = 0;
        String insertTableSQL = "INSERT INTO FriendGroup (name, description) VALUES(?,?) ";
        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, group.getName());
            preparedStatement.setString(2, group.getDescription());
            
            // execute insert SQL stetement
            flag = preparedStatement.executeUpdate();
            System.out.println("Record is inserted into DBUSER table!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag > 0;    }

    
}
