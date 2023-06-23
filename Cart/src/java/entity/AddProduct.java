/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Tuấn Anh
 */
public class AddProduct {

    private String Maproduct;
    private int soluong;
    private double Dongia;

    public double getDongia() {
        return Dongia;
    }

    public AddProduct(String Maproduct, int soluong, double Dongia) {
        super();
        this.Maproduct = Maproduct;
        this.soluong = soluong;
        this.Dongia = Dongia;
    }

    public void setDongia() {
    }

    public String getMaproduct() {
        return Maproduct;
    }

    public void setMaproduct(String Maproduct) {
        this.Maproduct = Maproduct;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return "AddProduct{" + "Masp=" + Maproduct + ", soluong=" + soluong + ", Dongia=" + Dongia + '}';
    }
    
    
}
