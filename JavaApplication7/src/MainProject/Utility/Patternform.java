/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.Utility;

import java.text.NumberFormat;
import java.util.Base64;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author ASUS
 */
public class Patternform {

    public static boolean GetUserName(String str) {
        Pattern pt = Pattern.compile("[A-Za-z0-9_-]{6,12}$");
        boolean matcher = pt.matcher(str).matches();
        return matcher;
    }

    public static boolean GetEmail(String str) {
        Pattern pt = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
        boolean matcher = pt.matcher(str).matches();
        return matcher;
    }

    public static boolean GetPass(String str) {
        Pattern pt = Pattern.compile("^.*(?=.{6,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z]).*$");
        boolean matcher = pt.matcher(str).matches();
        return matcher;
    }

    public static String transformPrice(double x) {
        Locale loacleVN = new Locale("vi", "VN");
        NumberFormat vn = NumberFormat.getInstance(loacleVN);
        String str = vn.format(x);
        return str;
    }

    public static boolean IsInterger(String number) {
        try {
            var x = Integer.parseInt(number);
            if (x > 0) {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }

    public static String mahoa(String original) {
        try {
            String SECRET_KEY = "thanhliem261202.";
            SecretKeySpec skeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] byteEncrypted = cipher.doFinal(original.getBytes());
            String encrypted = Base64.getEncoder().encodeToString(byteEncrypted);

            return encrypted;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String giaima(String str) {
        try {
            String SECRET_KEY = "thanhliem261202.";
            SecretKeySpec skeyKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeyKeySpec);

            byte[] byteEncrypted = Base64.getDecoder().decode(str);
            byte[] byteDecryted = cipher.doFinal(byteEncrypted);
            String decryted = new String(byteDecryted);

            return decryted;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
