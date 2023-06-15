/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Person {
    private String rollNumber;
    private String name;
    private boolean gender;
    private String dob;
    private String email;
    private String mobile;
    private String address;
    
    public void display() {
        System.out.printf("|%10s|%16s|%5s|%12s|%28s|%12s|%12s|",
                rollNumber,
                name, 
                gender ? "Nam" : "Nữ", 
                dob, 
                email, 
                mobile, 
                address);
    }
    public void input() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\nEnter MaHS: ");
        this.rollNumber = scanner.nextLine().trim(); 
        
        System.out.println("\nEnter Ten: ");
        this.name = scanner.nextLine().trim();
        
        System.out.println("\nEnter Gioitinh: ");
        this.gender = Boolean.parseBoolean(scanner.nextLine().trim());
        
        System.out.println("\nEnter Ngaysinh(DD/MM/YYYY): ");
        this.dob = scanner.nextLine().trim();
        
        System.out.println("\nEnter Email: ");
        this.email = scanner.nextLine().trim();
        
        System.out.println("\nEnter Sdt: ");
        this.mobile = scanner.nextLine().trim();
        
        System.out.println("\nEnter Diachi: ");
        this.address = scanner.nextLine().trim();
    }
}