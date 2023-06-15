/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lesson5;

import java.util.Scanner;

/**
 *
 * @author std
 */
public class UpperCase {
    public static void main(String[] args) {
        String name;
        System.out.println("Nhập Tên:");
        Scanner scanner= new Scanner(System.in);
        name= scanner.nextLine();
        String[] strings=name.split(" ");
        String rs="";
        for(String s1:strings){
            rs+= (s1.charAt(0)+ "").toUpperCase()+s1.substring(1)+" ";
            
        }
        System.out.println(rs.trim());
    }
}