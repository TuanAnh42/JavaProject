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
public class Convert {
    public static void main(String[] args) {
        String string ="AXTYTZUIKEJT";
        String[] strings=string.split("");
        String rs="";
        for( int i=0;i<strings.length; i++){
        if(i!=0){
            if(i%3==0){
                rs+="-";
            }
        }
            rs+= strings[i];
    }
        
        System.out.println(rs);
    }
}

