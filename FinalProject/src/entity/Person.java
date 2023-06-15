/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Scanner;
import util.Validate;

/**
 *
 * @author AnhTH19
 */
public class Person {

    private String rollNumber;
    private String name;
    private boolean gender;
    private String dob;
    private String email;
    private String mobile;
    private String address;

    public Person() {
    }

    public Person(String rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    public Person(String rollNumber, String name, boolean gender, String dob, String email, String mobile, String address) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }
    
    

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void display() {
        System.out.printf(
                "%s | %10s | %10s | %10s | %10s | %10s | %12s |",
                rollNumber,
                name,
                gender ? "Nam" : "Nữ",
                dob,
                email,
                mobile,
                address
        );
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        this.rollNumber = Validate.getString("Enter rollNumber: ", "Please re enter roll number", "[A-Za-z0-9]+");
        this.name = Validate.getString("Enter name: ", "Please re enter namne", "^[A-Za-z\\s]+$");
        System.out.print("Enter gender (Male or Female):");
        this.gender = convertGender(scanner.nextLine().trim());
        System.out.print("Enter dob (DD/MM/YYYY): ");
        this.dob = scanner.nextLine().trim();
        this.email = Validate.getString("Enter email: ", "Please re enter email", "^[A-Za-z0-9+_.-]+@(.+)$");
        this.mobile = Validate.getString("Enter phone: ", "Please re enter phone", "^\\d{10}$");
        this.address = Validate.getString("Enter address: ", "Please re enter address", "[A-Za-z]+");
    }
    
    private boolean convertGender(String input){
        return input.equalsIgnoreCase("male");
    }
}
