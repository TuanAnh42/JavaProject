/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.sql.Date;

/**
 *
 * @author Tuấn Anh
 */
public class Contactad {
    
    private int id;
    private String firstname;
    private String lastname;
    private Date createdDate;
    private String phoneNumber;
    private int groupId;
    

    public Contactad() {
    }
    

    public Contactad(int id, String firstname, String lastname, Date createdDate, String phoneNumber, int groupId) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.createdDate = createdDate;
        this.phoneNumber = phoneNumber;
        this.groupId = groupId;
    }

    public Contactad(String firstname, String lastname, Date createdDate, String phoneNumber, int groupId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.createdDate = createdDate;
        this.phoneNumber = phoneNumber;
        this.groupId = groupId;
    }

    public Contactad(String firstname, String lastname, Date createdDate, String phoneNumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.createdDate = createdDate;
        this.phoneNumber = phoneNumber;
    }
    

    public Contactad(int id, String firstname, String lastname, Date createdDate, String phoneNumber) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.createdDate = createdDate;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Contactad{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", createdDate=" + createdDate + ", phoneNumber=" + phoneNumber + ", groupId=" + groupId + '}';
    }
    
}
