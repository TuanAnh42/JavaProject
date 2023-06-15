/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.ManagerSP;

/**
 *
 * @author ASUS
 */
public class Category {
    String id;
    String name;

    @Override
    public String toString() {
        return name;
    }
    
  
    
    public Category(String id, String category) {
        this.id = id;
        this.name = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String category) {
        this.name = category;
    }
    
    
}
