/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import common.IContact;
import dao.JDBCConnect;
import java.util.ArrayList;
import entity.Contactad;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


/**
 *
 * @author Tuấn Anh
 */
public class AddContact implements IContact<Contactad> {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    @Override
    public ArrayList<Contactad> getAll() {
        ArrayList<Contactad> contactList = new ArrayList<>();
        String sql = "SELECT * FROM Contact";
        try {
            // kết nối được với db
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Contactad contact = new Contactad();
                contact.setId(rs.getInt("ID"));
                contact.setFirstname(rs.getString("FirstName"));
                contact.setLastname(rs.getString("LastName"));

                contact.setCreatedDate(rs.getDate("CreatedDate"));
                contact.setPhoneNumber(rs.getString("PhoneNumber"));
                contact.setId(rs.getInt("GroupID"));
                contactList.add(contact);
            }
            return contactList;

        } catch (SQLException e) {
        } finally {
            JDBCConnect.closeResultSet(rs);
            JDBCConnect.closePreparedStatement(preparedStatement);
            JDBCConnect.closeConnection(connection);
        }
        return null;
    }

    @Override
    public boolean add(Contactad contact) {
        int flag = 0;
        String insertTableSQL = "INSERT INTO Contact"
                + "(firstname, lastname,createddate ,phonenumber) VALUES"
                + "(?,?,?,?)";
        try (Connection con = JDBCConnect.getJDBCConnection(); PreparedStatement ps = con.prepareStatement(insertTableSQL)) {

            ps.setString(1, contact.getFirstname());
            ps.setString(2, contact.getLastname());
            ps.setDate(3, Date.valueOf( LocalDate.now()));
            ps.setString(4, contact.getPhoneNumber());
            // execute insert SQL stetement
            flag = ps.executeUpdate();
            System.out.println("Record is inserted into DBUSER table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag > 0;
    }

}
