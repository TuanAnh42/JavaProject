/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regexandcollection;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class CharacterCount {
    public static void main(String[] args) {
//        int count = 0;
        Scanner s= new Scanner(System.in);
        String content = s.nextLine();
        HashMap<Character,Integer> eachCharCount = new HashMap<Character,Integer>();
        char[] tochar = content.toCharArray();
        for(char c: tochar){
            if(eachCharCount.containsKey(c)){
                eachCharCount.put(c, eachCharCount.get(c)+1);
            }else{
                eachCharCount.put(c, 1);
            }
        }
        
        HashMap<String,Integer> eachStringCount = new HashMap<String,Integer>();
        String[] tostring = content.split(" ");
        for(String str : tostring){
            if(eachStringCount.containsKey(str)){
                eachStringCount.put(str, eachStringCount.get(str)+1);
            }else{
                eachStringCount.put(str, 1);
            }
        }
        System.out.println(eachCharCount);
        System.out.println(eachStringCount);
        
//////        String[] arr= content.split(" ");
////        char[] c = content.toCharArray();
////        for(int i=0;i<c.length;i++ ){
////            for(int j=0;j<=i;j++){
////                if(content.charAt(i) == c[j]){
////                
////                count++;
////            }
////            
////                
////            }
//////            System.out.println(c[i]);
////        }
//        System.out.println(count);
        
        
    }
}
