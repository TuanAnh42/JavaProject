/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Tuấn Anh
 */
public class Validate {
        public static boolean isValidPhoneNumber(String phoneNumber) {
        // Biểu thức chính quy chỉ cho phép chứa các chữ số từ 0 đến 9 và không có khoảng trắng
        String regex = "^[0-9]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();

}
}
