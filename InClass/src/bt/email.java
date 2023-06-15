/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt;

import java.util.Scanner;

/**
 *
 * @author std
 */
public class email {
    
    public static void main(String[] args) {
        String name;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập Họ Và Tên:");
        name = scanner.nextLine();
        System.out.println("Họ và tên:"+ name );
        String[] strings=name.split(" ");
        String mail= strings[strings.length-1];        
            for(int i=0;i<strings.length-1;i++){
                mail+=strings[i].charAt(0);
            }
            System.out.println("Email:"+mail+"@aptechlearning.edu.vn");
        
        
        
        
    }
}
