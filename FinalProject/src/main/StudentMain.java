/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bo.StudentBo;
import entity.Student;
import java.util.Scanner;

/**
 *
 * @author AnhTH19
 */
public class StudentMain {

    public static void main(String[] args) {
        StudentBo studentBo = new StudentBo();
        Scanner scanner = new Scanner(System.in);
        String rollNumber = scanner.nextLine().trim();

        boolean flag = true;
        do {
            System.out.println("\n------- STUDENT MANAGE -------");
            System.out.println("1. Display list student");
            System.out.println("2. Add new student");
            System.out.println("3. Update student");
            System.out.println("4. Delete student");
            System.out.println("5. Search");
            System.out.println("6. Sort");
            System.out.println("7. Find name startwith a");
            System.out.println("8. Max mark");
            System.out.println("9. Save data");
            System.out.println("10. Load data");
            System.out.println("11. Exit");

            System.out.print("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            System.out.println("------------------------------");

            switch (choice) {
                case 1:
                    studentBo.display();
                    break;
                case 2:
                    studentBo.add();
                    System.out.println("Student list after adding");
                    studentBo.display();
                    break;
                case 3:
                    
                    studentBo.update(rollNumber);
                    break;
                case 4:
                System.out.println("Enter the rollnumber: ");
                scanner.nextLine();
                
                    studentBo.remove(rollNumber);
                
                    break;
                case 5:
                    scanner.nextLine();
                    String text = scanner.nextLine();
                    for(Student std : studentBo.search(text)){
                        std.display();
                    }
                    
                    break;
                case 6:
                    studentBo.sort();
                    break;
                case 7:
                    studentBo.find();
                    break;
                case 8:
                    studentBo.maxmark();
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    flag = false;
                    break;
                default:
                    System.out.println("Only choose 1 - 11.");
            }
        } while (flag);
    }
}
