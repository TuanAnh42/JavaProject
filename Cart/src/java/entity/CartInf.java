/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Tuấn Anh
 */
public class CartInf {
    private int Masp;
    private String Tensp;
    private double Dongia;

    public CartInf() {
    }

    public CartInf(int Masp, String Tensp, double Dongia) {
        this.Masp = Masp;
        this.Tensp = Tensp;
        this.Dongia = Dongia;
    }

    public int getMasp() {
        return Masp;
    }

    public void setMasp(int Masp) {
        this.Masp = Masp;
    }

    public String getTensp() {
        return Tensp;
    }

    public void setTensp(String Tensp) {
        this.Tensp = Tensp;
    }

    public double getDongia() {
        return Dongia;
    }

    public void setDongia(double Dongia) {
        this.Dongia = Dongia;
    }

    @Override
    public String toString() {
        return "CartInf{" + "Masp=" + Masp + ", Tensp=" + Tensp + ", Dongia=" + Dongia + '}';
    }
    
    
}
