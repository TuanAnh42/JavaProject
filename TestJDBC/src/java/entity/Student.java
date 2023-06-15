/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author To Hoang Anh
 */
public class Student {
    private int id;
    private String name;
    private int age;
    private boolean gender;
    private String phone;
    private String email;
    private String address;
    private double markAvg;
    private boolean status;


    public Student() {
    }
    

    public Student(int id, boolean status) {
        this.id = id;
        this.status = status;
    }
    

    public Student(int id, String name, int age, boolean gender, String phone, String email, String address, double markAvg) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.markAvg = markAvg;
    }

    public Student(int id, String name, int age, boolean gender, String phone, String email, String address, double markAvg, boolean status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.markAvg = markAvg;
        this.status = status;
    }
    
    

    public Student(String name, int age, boolean gender, String phone, String email, String address, double markAvg) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.markAvg = markAvg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMarkAvg() {
        return markAvg;
    }

    public void setMarkAvg(double markAvg) {
        this.markAvg = markAvg;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", address=" + address + ", markAvg=" + markAvg + ", status=" + status + '}';
    }
    

    
    
    
    
}