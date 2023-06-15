/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.DAO;

import MainProject.Sell.LoadData;
import MainProject.Order.OrderOff;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class GetAccount {
    static String account;
    String name_client;
    String telephone;
    String address;
    static List<OrderOff> data;
    static List<LoadData> datalist;

    public static List<LoadData> getDatalist() {
        return datalist;
    }

    public static void setDatalist(List<LoadData> datalist) {
        GetAccount.datalist = datalist;
    }
    static OrderOff order;

    public GetAccount() {
    }

    public GetAccount(String name_client, String telephone, String address) {
        this.name_client = name_client;
        this.telephone = telephone;
        this.address = address;
    }
    
    

    public static OrderOff getOrder() {
        return order;
    }

    public static void setOrder(OrderOff order) {
        GetAccount.order = order;
    }
    
    public static List<OrderOff> getData() {
        return data;
    }

    public static void setData(List<OrderOff> data) {
        GetAccount.data = data;
    }

    public String getName_client() {
        return name_client;
    }

    public void setName_client(String name_client) {
        this.name_client = name_client;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   

    public static String getAccount() {
        return account;
    }

    public static void setAccount(String account) {
        GetAccount.account = account;
    }
    
    
}
