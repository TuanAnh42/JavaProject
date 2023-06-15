/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bo;

import static java.lang.Math.sqrt;

/**
 *
 * @author DELL
 */
public class Controller {

    public void quadraticEquation2(int a, int b, int c) {
        if (a != 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Phương trình vô nghiệm");
                }
            }
        }
        
        double delta = (b * b) - (4 * a * c);
        double x1, x2;
        if (delta > 0) {
            x1 = ((-b - Math.sqrt(delta)) / (2*a));
            x2 = ((-b + Math.sqrt(delta)) / (2*a));
            System.out.println("Phương trình có 2 nghiệm:");
            System.out.println("x1:" + x1);
            System.out.println("x2:" + x2);
        } else if (delta == 0) {
            System.out.println("Phương trình có nghiệm kép:");
            System.out.println("x=" + ((-b) / (2 * a)));
        } else {
            System.out.println("Phương trình vô nghiệm");
        }
    }
}
