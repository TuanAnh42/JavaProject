/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import common.ICommon;
import dao.JDBCConnect;
import entity.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author teacher
 */
public class GroupModel implements ICommon<Group> {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    @Override
    public ArrayList<Group> getAll() {
        ArrayList<Group> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM FriendGroup";
        try {
            // kết nối được với db
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Group group = new Group();
                group.setId(rs.getInt("ID"));
                group.setName(rs.getString("Name"));
                group.setDescription(rs.getString("Description"));

                arrayList.add(group);
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

    @Override
    public Group getOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(Group group) {
        int flag = 0;
        String insertTableSQL = "INSERT INTO FriendGroup"
                + "(name, description) VALUES"
                + "(?,?)";
        try ( Connection con = JDBCConnect.getJDBCConnection();  PreparedStatement ps = con.prepareStatement(insertTableSQL)) {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, group.getName());
            preparedStatement.setString(2, group.getDescription());
            // execute insert SQL stetement
            flag = preparedStatement.executeUpdate();
            System.out.println("Record is inserted into DBUSER table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag > 0;
    }

    @Override
    public boolean update(Group obj, int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
