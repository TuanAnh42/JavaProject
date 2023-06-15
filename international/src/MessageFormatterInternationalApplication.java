
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AnhTH
 */
public class MessageFormatterInternationalApplication {

    public static void main(String[] args) {
        // en_US
        System.out.println("Current Locale: " + Locale.getDefault());
        ResourceBundle mybundle = ResourceBundle.getBundle("MyLabels");

        // read MyLabels_en_US.properties
        System.out.println("Say how are you in US English: " + mybundle.getString("how_are_you"));

        Locale.setDefault(new Locale("ms", "MY"));

        // read MyLabels_ms_MY.properties
        System.out.println("Current Locale: " + Locale.getDefault());
        mybundle = ResourceBundle.getBundle("MyLabels");
        System.out.println("Say how are you in Malaysian Malaya language: " + mybundle.getString("how_are_you"));

        //read MyLabels_vi_VN
        Locale.setDefault(new Locale("vi", "VN"));
        System.out.println("Current Locale: " + Locale.getDefault());
        mybundle = ResourceBundle.getBundle("MyLabels");
        System.out.println("Say how are you in Viet Nam language: " + mybundle.getString("how_are_you"));
        String value = mybundle.getString("how_are_you");
        try {
            System.out.println(new String(value.getBytes("ISO-8859-1"), "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MessageFormatterInternationalApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
}
