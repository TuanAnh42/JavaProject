/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Tuấn Anh
 */
public class User {
    private int UserId ;
    private String Username ;
    private String Password ;
    private String Email ;
    private String Address ;

    public User() {
    }

    public User(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }

    public User(String Username, String Password, String Email, String Address) {
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
        this.Address = Address;
    }
    

    public User(int UserId, String Username, String Password, String Email, String Address) {
        this.UserId = UserId;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
        this.Address = Address;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    @Override
    public String toString() {
        return "User{" + "UserId=" + UserId + ", Username=" + Username + ", Password=" + Password + ", Email=" + Email + ", Address=" + Address + '}';
    }
    
    
    
}
