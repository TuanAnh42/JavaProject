/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TotalIngredients;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Total {

    boolean isPrimeNumber(int a) {
        if (a < 2) {
            return false;
        }
        for (int i = 2; i <= a / 2; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int a, surPlus;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Number:");
        a = s.nextInt();

        int total = 0;

        while (a != 0) {
            surPlus = a % 10;
            if (new Total().isPrimeNumber(surPlus)) {
                total += surPlus;
            }
            a = a / 10;
            while (a < 0) {
                System.out.println("ReEnter Number:");
                a = s.nextInt();
                surPlus = a % 10;
                if (new Total().isPrimeNumber(surPlus)) {
                    total += surPlus;
                }
                a = a / 10;
            }
        }
        System.out.println("Total Ingredients:" + total);
    }

}
