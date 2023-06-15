/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import common.ICommon;
import dao.JDBCConnect;
import entity.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author teacher
 */
public class ContactModel implements ICommon<Contact> {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    @Override
    public ArrayList<Contact> getAll() {
        ArrayList<Contact> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM Contact";
        try {
            // kết nối được với db
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Contact contact = new Contact();
                contact.setId(rs.getInt("ID"));
                contact.setFirstName(rs.getString("FirstName"));
                contact.setLastName(rs.getString("LastName"));
                contact.setPhoneNumber(rs.getString("PhoneNumber"));
                contact.setGroupId(rs.getInt("GroupID"));
                arrayList.add(contact);
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
    public Contact getOne(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(Contact contact) {
        int flag = 0;
        String insertTableSQL = "INSERT INTO Contact"
                + "(FirstName, LastName,PhoneNumber,GroupID) VALUES"
                + "(?,?,?,?)";
        try ( Connection con = JDBCConnect.getJDBCConnection();  PreparedStatement ps = con.prepareStatement(insertTableSQL)) {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, contact.getFirstName());
            preparedStatement.setString(2, contact.getLastName());
            preparedStatement.setString(3, contact.getPhoneNumber());
            preparedStatement.setInt(4, contact.getGroupId());
            // execute insert SQL stetement
            flag = preparedStatement.executeUpdate();
            System.out.println("Record is inserted into DBUSER table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag > 0;
    }

   @Override
    public boolean update(Contact obj,int id) {
            int flag = 0;
        String updateTableSQL = "UPDATE contact set "
                + "FirstName =?, LastName =?,PhoneNumber =?"
                + "WHERE ID =?";
        try (Connection con = JDBCConnect.getJDBCConnection();
                PreparedStatement ps = con.prepareStatement(updateTableSQL)) {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(updateTableSQL);
            preparedStatement.setString(1, obj.getFirstName());
           
            preparedStatement.setString(2, obj.getLastName());
            preparedStatement.setString(3, obj.getPhoneNumber());
            // execute insert SQL stetement
            flag = preparedStatement.executeUpdate();
            System.out.println("Record is updated into DBUSER table!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag > 0;
    }
    

    @Override
    public boolean delete(int id) {
    int flag = 0;
        String deleteTableSQL = "DELETE FROM Contact WHERE ID =? ";
        try (Connection con = JDBCConnect.getJDBCConnection();
            PreparedStatement ps = con.prepareStatement(deleteTableSQL)) {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(deleteTableSQL);
            ps.setInt(1, id);  
            flag = preparedStatement.executeUpdate();
            System.out.println("Record is updated into DBUSER table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag > 0;    }

}
