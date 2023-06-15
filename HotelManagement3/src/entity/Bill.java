/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author admin
 */
public class Bill {

    private int id;
    private int book_id;
    private int user_id;
    private float price;
    private String check_in;
    private Date check_out;
    private Book book;
    private String customerName;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

     public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
     
     public String getCustomerName() {
        return customerName;
    }
     
    public Bill() {
    }

    public Bill(String check_in) {
        this.check_in = check_in;
    }

    

    public Bill(int id, Date check_out) {
        this.id = id;
        this.check_out = check_out;
    }
    
    
    

    public Bill(int id, int book_id, int user_id, float price, String check_in, Date check_out) {
        this.id = id;
        this.book_id = book_id;
        this.user_id = user_id;
        this.price = price;
        this.check_in = check_in;
        this.check_out = check_out;
    }
    
    
    public Book getBook() {
        return book;
    }
    public Bill(int book_id) {
        this.book_id = book_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public Date getCheck_out() {
        return check_out;
    }

    public void setCheck_out(Date check_out) {
        this.check_out = check_out;
    }

    @Override
    public String toString() {
        return "Bill{" + "id=" + id + ", book_id=" + book_id + ", user_id=" + user_id + ", Customer name" + customerName +  ", price=" + price + ", check_in=" + check_in + ", check_out=" + check_out + '}';
    }

    

    
    

    
    
}
