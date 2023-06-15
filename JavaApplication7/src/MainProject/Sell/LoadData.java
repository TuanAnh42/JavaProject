/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.Sell;

/**
 *
 * @author ASUS
 */
public class LoadData {
    int table;
    String food;
    int total;
    int price;

    public LoadData() {
    }

    public LoadData(int table, String food, int total, int price) {
        this.table = table;
        this.food = food;
        this.total = total;
        this.price = price;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    
}
