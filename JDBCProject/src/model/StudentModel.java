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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author std
 */
public class StudentModel implements ICommon<Student> {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    @Override
    public ArrayList<Student> getAll() {
        ArrayList<Student> arrayList = new ArrayList<>();
        String sql = "SELECT*FROM new_table";
        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setRollNumber(rs.getInt("roll_number"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getInt("gender"));
                student.setDob(rs.getString("dob"));
                student.setEmail(rs.getString("email"));
                student.setMobile(rs.getString("mobile"));
                student.setAddress(rs.getString("address"));

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
        String sql = "SELECT*FROM new_table where roll_number = ?";
        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setRollNumber(rs.getInt("roll_number"));
                student.setName(rs.getString("name"));
                student.setGender(rs.getInt("gender"));
                student.setDob(rs.getString("dob"));
                student.setEmail(rs.getString("email"));
                student.setMobile(rs.getString("mobile"));
                student.setAddress(rs.getString("Address"));

                return student;
            } else {
                System.out.println("No Student found with id= " + id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    public boolean add(Student obj) {
        boolean flag = false;
        String sql = "INSERT INTO student(Rollnumber, name, dob, email, mobile, address)VALUES(?,?,?,?,?,?)";
        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, obj.getRollNumber());
            preparedStatement.setString(2, obj.getName());
            preparedStatement.setString(3, obj.getDob());
            preparedStatement.setString(4, obj.getEmail());
            preparedStatement.setString(5, obj.getMobile());
            preparedStatement.setString(6, obj.getAddress());
            
           
            if(preparedStatement.executeUpdate()>0){
                System.out.println("aaaa");
                flag= true;
            }            
        } catch (SQLException ex) {
          
        } finally {
            
            JDBCConnect.closePreparedStatement(preparedStatement);
            JDBCConnect.closeConnection(connection);

        }
        return false;

    }
    @Override
    public boolean update(Student obj) {
        String query = "update new_table set name=? , dob=? ,email=?, mobile= ?, address=? ";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(query);

            int rs = preparedStatement.executeUpdate();
            Student s = new Student();
            ps.setString(1, s.getName());
            ps.setString(2, s.getDob());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getMobile());
            ps.setString(5, s.getAddress());

//                if (rs != 0) {
//                    System.out.println("Employee updated with roll_number=" + s.getRollNumber());
//                } else {
//                    System.out.println("No Employee found with roll_number=" + s.getRollNumber());
//                }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;

    }

    @Override
    public boolean delete(int id) {
        String query = "delete from new_table where roll_number=?";
        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            Student s = new Student();
            if (rs != 0) {
                System.out.println("Student delete with roll_number= " + id);
            } else {
                System.out.println("Not Student found with roll_number=" + id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public static void main(String[] args) {
        StudentModel std = new StudentModel();
        List<Student> aList = std.getAll();

        for (Student student : aList) {
            System.out.println(student);
        }
        System.out.println(std.getOne(1));

        Student s = new Student();
        s.setAddress("Thanh Ha");
        std.update(s);
        for (Student std1 : aList) {
            System.out.println(std1);
        }

        std.delete(2);
        for (Student sd : aList) {
            System.out.println(sd);
        }
    }

    

}
