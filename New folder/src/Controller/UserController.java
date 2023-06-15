/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ManagerController.Manager;
import Popup.PopupEdit;
import UI.StaffForm;
import entity.User;

/**
 *
 * @author DELL
 */
public class UserController extends Manager{
    User std = new User();
    PopupEdit popup = new PopupEdit();
    

    public UserController() {
        super();
    }
    

    

    

    @Override
    public void actionEdit() {
        try {
            popup.editUser(new StaffForm(), std);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionSearch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
