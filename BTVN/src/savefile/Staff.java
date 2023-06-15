/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savefile;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class Staff implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private int age;
    private int phone;
    private String address;
    private double salary;
    private String role;

    public Staff(String id, String name, int age, int phone, String address, double salary, String role) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.salary = salary;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Staff{" + "id=" + id + ", name=" + name + ", age=" + age + ", phone=" + phone + ", address=" + address + ", salary=" + salary + ", role=" + role + '}';
    }
    
          
}
