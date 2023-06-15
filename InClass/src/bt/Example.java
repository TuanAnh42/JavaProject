/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt;

/**
 *
 * @author std
 */
public class Example {
//    public static void isPrimeNumber(){
//        if(){
//            
//        }
//    }
    public static void main(String[] args) {
        String string = "Cl89s J235 1 hh";
       int sum=0;
       for(int i =0; i<string.length();i++){
           char c= string.charAt(i);
           if(Character.isDigit(c)){
               sum+= Integer.parseInt(c+ "");
           }      
       }
        System.out.println(sum);
    }     
}

