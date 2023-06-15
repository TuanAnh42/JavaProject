/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homels5;

/**
 *
 * @author DELL
 */
public class string1 {

    public static void main(String[] args) {
        String string = "Ja8va Cl239ass Apt58ech";
        String string1 = "";
        System.out.println("Ban đầu:"+string);
        System.out.println("Sau đó:");
        for (int i = 0; i < string.length(); i++) {
            char c1 = string.charAt(i);
            if (Character.isDigit(c1)) {
            } else {
                string1 += c1;
            }

        }
        System.out.println(string1);
        for (int j = 0; j < string.length(); j++) {
            if (Character.isDigit(string.charAt(j))) {
                string = string.replace(string.charAt(j), '*');

            }
        }
        System.out.println(string);

    }
}
