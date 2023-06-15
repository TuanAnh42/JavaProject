/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Popup;

import UI.RegisterJFrame;
import UI.StaffForm;
import dao.UserManagement;
import entity.User;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class PopupEdit {

    User userDao = new User();
    JFrame previousview;

    public void useredit(StaffForm view, User std) {
        if (previousview != null && previousview.isDisplayable()) {
            previousview.requestFocus();
            return;
        }
        previousview = view;
        view.setVisible(true);
        view.getBtnOK().addActionListener(evt -> {
            view.getUserName().setText(std.getName());
            view.getEmail().setText(std.getEmail());
            view.getDob().setText(std.getDob());
            view.getPhone().setText(std.getPhone());
            view.getGender().setSelectedItem(std.getGender().toString());
            view.getPosition().setText(std.getPosition());
            view.getSalary().setText(std.getSalary());
             try {
                editUser(view, std);
                view.dispose();
                 JOptionPane.showMessageDialog(previousview, "Cập nhật thông tin thành công");
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }

    public boolean editUser(StaffForm view, User std) throws Exception {
        String username = view.getUserName().getText();
        String temail = view.getEmail().getText();
        String birthday = view.getDob().getText();
        String mobile = view.getPhone().getText();
        String gender = view.getGender().getSelectedItem().toString();
        String pos = view.getPosition().getText();
        String sal = view.getSalary().getText();
        
        std.setName(username);
        std.setEmail(temail);
        std.setDob(birthday);
        std.setPhone(mobile);
        std.setPhone(mobile);
        std.setGender(gender);
        std.setPosition(pos);
        std.setSalary(sal);
        UserManagement.update(std);

        return true;
    }
}
