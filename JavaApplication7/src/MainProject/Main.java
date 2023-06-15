/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject;

import MainProject.DAO.CategoryModify;
import MainProject.DAO.ProductModify;
import MainProject.DAO.RegisterModify;
import MainProject.DAO.StatiscalModify;
import MainProject.DAO.bookModify;
import MainProject.DAO.loadDataModify;
import MainProject.RegisterAndLogin.Infor;
import MainProject.Utility.Patternform;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.Timer;


/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        int x = StatiscalModify.getCount("2021-11");
        System.out.println(x);
    }
    
   
}
