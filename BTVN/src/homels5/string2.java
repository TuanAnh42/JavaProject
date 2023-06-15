/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homels5;

/**
 *
 * @author DELL
 */
public class string2 {
    public static void main(String[] args) {
        String string= "Java is a high-level,class-based,object-oriented "
                + "programming language this is designed to have as few "
                + "implementation dependencies as possible.it is a "
                + "general-purpose programming language intended to let "
                + "programmers write once,run anywhere(WORA)";
           String s1=String.valueOf(string).replaceAll(",", "$0 ");
            String[] s2=s1.split("\\.");
            String string1="";
            for(String str: s2){
                string1+=(str.charAt(0)+ "").toUpperCase() +str.substring(1) +".";
            }
            System.out.println("Chuỗi trước khi thay dổi:"+string);
            System.out.println("Chuỗi sau khi thay dổi:"+string1);
    }
    
    
}

