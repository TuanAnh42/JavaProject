/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.ManagerSP;

/**
 *
 * @author ASUS
 */
public class Product {
    String id;
    String name;
    String price;
    String Properties;
    String categoryid;
    String quantity;
    String imgLink, created_at, updated_at;
    Category ct;
    int idp;

    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public Category getCt() {
        return ct;
    }

    public void setCt(Category ct) {
        this.ct = ct;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Product(String id, String name, String price, String Properties, String categoryid, String quantity, String imgLink, String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.Properties = Properties;
        this.categoryid = categoryid;
        this.quantity = quantity;
        this.imgLink = imgLink;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    public Product() {
    }

    public Product(String id, String name, String price, String Properties, String quantity, String imgLink, String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.Properties = Properties;
        this.quantity = quantity;
        this.imgLink = imgLink;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Product(int id, String name, String price, String Properties, String quantity, String imgLink) {
        this.idp = id;
        this.name = name;
        this.price = price;
        this.Properties = Properties;
        this.quantity = quantity;
        this.imgLink = imgLink;
    }

    public Product(String name, String price, String Properties, String quantity, String imgLink) {
        this.name = name;
        this.price = price;
        this.Properties = Properties;
        this.quantity = quantity;
        this.imgLink = imgLink;
    }

    
    
    public Product(String id, String name, String price, String Properties, String categoryid, String quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.Properties = Properties;
        this.categoryid = categoryid;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProperties() {
        return Properties;
    }

    public void setProperties(String Properties) {
        this.Properties = Properties;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    
}
