/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex;

import java.util.Scanner;

/**
 *
 * @author std
 */
public class ExRegex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arr = sc.nextLine();
        int j = arr.length();
            if (10 == j) {
                for (int i = 0; i < j; i++) {
                    if (Character.isDigit(arr.charAt(i))) {                       
                        System.out.println("This is a phone number");
                        break;
                    }
                }

            }else {          
                System.out.println("This is not phone number");
            }
             System.out.println("SDT:" + arr.matches("^\\d[10]$"));
        } 
}
       
