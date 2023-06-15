
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author pc
 */
public class Studentmain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        boolean flag = true;
        do {
        System.out.println("\n--------STUDENT MANAGE------");
        System.out.println("1. Hien thi danh sach");
        System.out.println("2. Them hoc sinh moi");
        System.out.println("3. Cap nhat sinh vien");
        
        System.out.print("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println("------------------------------");

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Only choose 1 - 3.");
            }
        } while (flag);
    }
}