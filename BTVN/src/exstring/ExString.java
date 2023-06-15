/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exstring;

/**
 *
 * @author DELL
 */
public class ExString {

    public static void main(String[] args) {

        String string = "String Example In Java ";
        //1) length();
        
        int length = string.length();
        System.out.println(length);
        System.out.println("-----------------");
        //2) charAt();
        
        char charat = string.charAt(7);
        System.out.println(charat);
        System.out.println("-----------------");
        //3) concat();
        
        String string1 = "Today";
        System.out.println(string.concat(string1));
        System.out.println("-----------------");
        //4) substring(int i);
        
        System.out.println(string.substring(6));
        //5) substring(int i ,int j);
        
        System.out.println(string.substring(6, 14));
        System.out.println("-----------------");
        //6) indexOf(string s);
        
        int index = string.indexOf("Java");
        System.out.println(index);
        //7) indexOf(string s, int i);
        
        int index1 = string.indexOf("a", 3);
        System.out.println(index1);
        //8) lastindexof(string);
        
        int lastindex = string.lastIndexOf("Example");
        System.out.println(lastindex);
        System.out.println("-----------------");
        //9) equals;
        
        String str = "Hello";
        String str1 = "Hello";
        String str2 = "World";
        boolean b1 = str1.equals(str2);
        boolean b2 = str1.equals(str);
        System.out.println(b1);
        System.out.println(b2);
        //10) equalsIgnoreCase(String anotherString);
        
        String str3 = "Hello world";
        String str4 = "Hello wOrLD";
        String str5 = "World";
        boolean b3=str3.equalsIgnoreCase(str4);
        boolean b4=str3.equalsIgnoreCase(str5);
        System.out.println(b3);
        System.out.println(b4);
        System.out.println("-----------------");
        //11) compareTo();
        
        String comp="Java 1";
        String comp1="Java 1";
        String comp2="Ja";
        String comp3="Example Java";
        int compare= comp.compareTo(comp1);
        int compare1= comp2.compareTo(comp);
        int compare2= comp.compareTo(comp3);
        System.out.println(compare);
        System.out.println(compare1);
        System.out.println(compare2);
        System.out.println("-----------------");
        //12) compareToIgnoreCase( String anotherString);
        
        String com="JAvA 1";
        String com1="JaVa 1";
        String com2="JA";
        String com3="ExAmple JAva";
        int compareto=com.compareToIgnoreCase(com1);
        int compareto1=com2.compareToIgnoreCase(com);
        int compareto2=com.compareToIgnoreCase(com3);
        System.out.println(compareto1);
        System.out.println(compareto);   
        System.out.println(compareto2);
        System.out.println("-----------------");
        //13) lowercase();
        
        String word="clOtHes";
        System.out.println(word.toLowerCase());
        //14) uppercase();
        
        String word1="clothes";
        System.out.println(word1.toUpperCase());
        System.out.println("-----------------");
        //15) trim();
        
        String trim="          books";
        System.out.println("          books");
        System.out.println(trim.trim());
        System.out.println("-----------------");
        //16) replace();
        
        String s1="character";
        System.out.println("character");
        System.out.println(s1.replace("h", "p"));
        System.out.println("-----------------"); 
    }
}
