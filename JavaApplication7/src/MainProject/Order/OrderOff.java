/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.Order;

import MainProject.RegisterAndLogin.Infor;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class OrderOff {
    int id;
    int table;
    int staffid;
    float totalPrice;
    String created_at;
    String times;
    String name;
    String phone;
    String note;
    Infor staff;
    public Infor getStaff() {
        return staff;
    }

    public void setStaff(Infor staff) {
        this.staff = staff;
    }
    

    
    
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public OrderOff(int id, int table, int staffid, float totalPrice, String created_at, String name, String phone, String note) {
        this.id = id;
        this.table = table;
        this.staffid = staffid;
        this.totalPrice = totalPrice;
        this.created_at = created_at;
        this.name = name;
        this.phone = phone;
        this.note = note;
    }

    
    
    public OrderOff(int table, String created_at, String times, String name, String phone, String note) {
        this.table = table;
        this.created_at = created_at;
        this.times = times;
        this.name = name;
        this.phone = phone;
        this.note = note;
    }

    public OrderOff(int id, int table, String created_at, String times, String name, String phone, String note) {
        this.id = id;
        this.table = table;
        this.created_at = created_at;
        this.times = times;
        this.name = name;
        this.phone = phone;
        this.note = note;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    public OrderOff(int table, int staffid, float totalPrice) {
        this.table = table;
        this.staffid = staffid;
        this.totalPrice = totalPrice;
    }

    
    public OrderOff(int table, int staffid, float totalPrice, String times) {
        this.table = table;
        this.staffid = staffid;
        this.totalPrice = totalPrice;
        this.times = times;
    }

    public OrderOff(int table, int staffid, float totalPrice, String created_at, String times) {
        this.table = table;
        this.staffid = staffid;
        this.totalPrice = totalPrice;
        this.created_at = created_at;
        this.times = times;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public int getStaffid() {
        return staffid;
    }

    public void setStaffid(int staffid) {
        this.staffid = staffid;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }
    
    
}
