/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.RegisterAndLogin;

/**
 *
 * @author ASUS
 */
public class Infor {
    int id;
    String fullname;
    String  age;
    String email;
    String password;
    String phone;
    String address;
    String gender;
    String created_at;
    String update_at;
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Infor(int id, String fullname) {
        this.id = id;
        this.fullname = fullname;
    }

//    public Infor(String fullname, String email, String created_at, String status) {
//        this.fullname = fullname;
//        this.email = email;
//        this.created_at = created_at;
//        this.status = status;
//    }



    
    
    
    

    public Infor(String fullname, String age, String email, String password, String phone, String address, String gender, String created_at, String update_at, String status) {
        this.fullname = fullname;
        this.age = age;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.created_at = created_at;
        this.update_at = update_at;
       this.status = status;
    }
    public Infor() {
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public Infor(String fullname, String age, String email, String password, String phone, String address, String gender) {
        
        this.fullname = fullname;
        this.age = age;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
    }


    public String getFullname() {
        return fullname;
    }

    public String getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    
}
