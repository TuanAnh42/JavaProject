/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author std
 */
public class Person {
    int rollNumber;
    String name;
    String dateOfBirth;

    public Person(int rollNumber, String name, String dateOfBirth) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" + "rollNumber=" + rollNumber + ", name=" + name + ", dateOfBirth=" + dateOfBirth + '}';
    }
    
}
