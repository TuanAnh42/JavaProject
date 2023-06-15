/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import common.ICommon;
import dao.JDBCConnect;
import entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author To Hoang Anh
 */
public class StudentDao implements ICommon<Student> {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    @Override
    public ArrayList<Student> getAll() {
        ArrayList<Student> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM new_table";
        try {
            // kết nối được với db
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setGender(rs.getBoolean("gender"));
                student.setPhone(rs.getString("phone"));
                student.setEmail(rs.getString("email"));
                student.setAddress(rs.getString("address"));
                student.setMarkAvg(rs.getDouble("markAvg"));
                arrayList.add(student);
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
    public Student getOne(int id) {
        
        String sql = "SELECT * FROM new_table where id = ?";
        try {
            // kết nối được với db
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
               Student std = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getBoolean("gender"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getDouble("markAvg")
                        
                );
            return std;
               
            }
            
        } catch (SQLException e) {
        } finally {
            JDBCConnect.closeResultSet(rs);
            JDBCConnect.closePreparedStatement(preparedStatement);
            JDBCConnect.closeConnection(connection);
        }
        return null;    }

    @Override
    public boolean add(Student student) {
        int flag = 0;
        String insertTableSQL = "INSERT INTO new_table"
                + "(name, age,gender,phone"
                + ",email,address,markAvg) VALUES"
                + "(?,?,?,?,?,?,?)";
        try (Connection con = JDBCConnect.getJDBCConnection();
                PreparedStatement ps = con.prepareStatement(insertTableSQL)) {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setBoolean(3, student.isGender());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setString(6, student.getAddress());
            preparedStatement.setDouble(7, student.getMarkAvg());
            // execute insert SQL stetement
            flag = preparedStatement.executeUpdate();
            System.out.println("Record is inserted into DBUSER table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag > 0;
    }

    @Override
    public boolean update(Student obj,int id) {
            int flag = 0;
        String updateTableSQL = "UPDATE new_table set "
                + "name =?, age =?,gender =?,phone =?"
                + ",email =?,address =?,markAvg =? "
                + "WHERE id =?";
        try (Connection con = JDBCConnect.getJDBCConnection();
                PreparedStatement ps = con.prepareStatement(updateTableSQL)) {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(updateTableSQL);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setInt(2, obj.getAge());
            preparedStatement.setBoolean(3, obj.isGender());
            preparedStatement.setString(4, obj.getPhone());
            preparedStatement.setString(5, obj.getEmail());
            preparedStatement.setString(6, obj.getAddress());
            preparedStatement.setDouble(7, obj.getMarkAvg());
            // execute insert SQL stetement
            flag = preparedStatement.executeUpdate();
            System.out.println("Record is updated into DBUSER table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag > 0;
    }
    

    @Override
    public boolean delete(int id) {
    int flag = 0;
        String deleteTableSQL = "DELETE FROM new_table WHERE id =? ";
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
     @Override
    public boolean deletelogic(Student std ) {
    int flag = 0;
        String deleteTableSQL = "UPDATE new_table set status =? WHERE id =? ";
        try (Connection con = JDBCConnect.getJDBCConnection();
            PreparedStatement ps = con.prepareStatement(deleteTableSQL)) {
//            connection = JDBCConnect.getJDBCConnection();
//            preparedStatement = connection.prepareStatement(deleteTableSQL);
            ps.setBoolean(1, std.getStatus());
            ps.setInt(1, std.getId());  
            flag = preparedStatement.executeUpdate();
            System.out.println("Record is updated into DBUSER table!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return flag > 0;    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students = new StudentDao().getAll();
        for (Student student : students) {
            System.out.println(student);
        }
        Student student = new Student("Duc", 20, true, "0123456789", "duc@gmail.com", "hn", 2);
        new StudentDao().add(student);
        
        System.out.println(new StudentDao().getOne(1));
        
        
       

        
    }

}
