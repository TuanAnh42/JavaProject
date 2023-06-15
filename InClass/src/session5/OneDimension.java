/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session5;

/**
 *
 * @author std
 */
public class OneDimension {
    int marks[];
    public void storeMarks(){
        marks = new int[4];
        System.out.println("Storing Marks. Please wait...");
        marks[0]=65;
        marks[1]=47;
        marks[2]=75;
        marks[3]=50;
    }
    public void displayMarks(){
        System.out.println("Marks are:");
        System.out.println(marks[0]);
        System.out.println(marks[1]);
        System.out.println(marks[2]);
        System.out.println(marks[3]);
    }
    public static void main(String[] args) {
        OneDimension oneDimenObj = new OneDimension();
        oneDimenObj.storeMarks();
        oneDimenObj.displayMarks();
    }
}
