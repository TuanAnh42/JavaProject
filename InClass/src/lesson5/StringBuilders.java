/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson5;

/**
 *
 * @author std
 */
public class StringBuilders {
    StringBuilder str= new StringBuilder("JAVA ");
    public void displayStrings(){
        System.out.println("Appended String is "+ str.append("7"));
        System.out.println("Inserted String is "+ str.insert(5, "SE"));
        System.out.println("Deleted String is "+ str.delete(4, 7));
        System.out.println("Reverse String is "+ str.reverse());
    }
    public static void main(String[] args) {
        StringBuilders objStrBuild = new StringBuilders();
        objStrBuild.displayStrings();
    }
}
