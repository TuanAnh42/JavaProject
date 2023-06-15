
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Student extends Person{
    private double mark;
    
    @Override
    public void display(){
        super.display();
        System.out.printf("%6s |\n", mark);
    }
    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);

        super.input();
        System.out.print("Enter mark: ");
        this.mark = Double.parseDouble(scanner.nextLine().trim());
    }
}