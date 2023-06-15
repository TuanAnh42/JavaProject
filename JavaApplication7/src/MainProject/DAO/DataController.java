/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.DAO;

import MainProject.ManagerSP.Category;
import MainProject.ManagerSP.Product;
import MainProject.RegisterAndLogin.Infor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class DataController {
    List<Infor> staffList;
    List<Category> categoryList;
    List<Product> productList;
   

    public DataController() {
        staffList = new ArrayList<>();
        categoryList = new ArrayList<>();
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
    
    
    public void getDataFormDB() {
        staffList = ManageStaffModify.getStaffList();
        categoryList = CategoryModify.GetCategoryList();
        productList = ProductModify.getDataProduct();
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
    
    public List<Infor> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Infor> staffList) {
        this.staffList = staffList;
    }

    
    
    
}
