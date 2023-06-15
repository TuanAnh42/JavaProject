/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Scanner;

/**
 *
 * @author AnhTH19
 */
public class Student extends Person {

    private double mark;

    public Student() {
    }

    public Student(String rollNumber, String name, boolean gender, String dob, String email, String mobile, String address, double mark) {
        super(rollNumber, name, gender, dob, email, mobile, address);
        this.mark = mark;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public void display() {
        super.display();
        System.out.printf("%6s |\n", mark);
    }

    @Override
    public void input() {
        Scanner scanner = new Scanner(System.in);

        super.input();
        System.out.print("Enter mark: ");
        try {
            this.mark = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("ReEnter mark");
        }
    }

}
