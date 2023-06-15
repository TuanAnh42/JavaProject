/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author std
 */
public class Student {

    /**
     * @param args the command line arguments
     */
    private int rollNumber;
    private String name;
    private int gender;
    private String dob;
    private String email;
    private String mobile;
    private String address;

    public Student(int rollNumber, String name, int gender, String dob, String email, String mobile, String address) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    public Student() {
        
        
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int isGender() {
        return gender;
    }

    public void setGender(int gender) {
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

    @Override
    public String toString() {
        return "Student{" + "rollNumber=" + rollNumber + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", email=" + email + ", mobile=" + mobile + ", address=" + address + '}';
    }
    
}
