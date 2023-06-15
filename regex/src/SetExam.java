
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author std
 */
public class SetExam {
    public static void main(String[] args) {
        Set<String> s= new HashSet<String>();
        Set<String> s1= new HashSet<String>();
        s.add("JAVA");
        s.add("PHP");
        s.add("PYTHON");
        s.add("JAVA");
        s1.add("C++");
        s1.add("JAVA");
        s1.add("HTML");
        s1.add("C++");
        s.addAll(s1);
        
        System.out.println("Số phần tử của setA: " + s.size());
        System.out.println("Các phần tử của setA: " + s);
        System.out.println("setA có chứa Java không? " + s.contains("Java"));
        System.out.println("setA có chứa C++ không? " + s.contains("C++"));
        
    }
}
