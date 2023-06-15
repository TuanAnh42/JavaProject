/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.Order;

import MainProject.ManagerSP.Product;

/**
 *
 * @author ASUS
 */
public class Orderdetail {
    int id, OrderID, ProductID;
    int Price;
    int total;
    Product product;

    public Orderdetail(int ProductID, int Price) {
        this.ProductID = ProductID;
        this.Price = Price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public Orderdetail(int id, int OrderID,int ProductID, int Price, int total) {
        this.id = id;
        this.OrderID = OrderID;
        this.ProductID = ProductID;
        this.Price = Price;
        this.total = total;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public Orderdetail(int OrderID, int Price, int total) {
        this.OrderID = OrderID;
        this.Price = Price;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
}
