/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Bo.Controller;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Nhập hệ số a:");
        int a = s.nextInt();
        System.out.println("Nhập hệ số b:");
        int b = s.nextInt();
        System.out.println("Nhập hệ số c:");
        int c = s.nextInt();
        Controller controller = new Controller();
        controller.quadraticEquation2(a, b, c);

    }

}
