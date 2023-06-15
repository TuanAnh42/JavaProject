/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regexandcollection;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class RegexEmail {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        String email= s.nextLine();
        System.out.println("This is a email:"+ email.matches("^[A-Za-z0-9+_.-]+@(.+)$"));
        
    }
}
