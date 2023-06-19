
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.text.DateFormatter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AnhTH
 */
public class InternaltionalApplication {

    static public void printValue(Locale currentLocale) {
        Integer value = Integer.valueOf(123456);
        Double amt = new Double(345987.246);
        NumberFormat numberFormat;
        String valueDisplay;
        String amtDisplay;
        numberFormat = NumberFormat.getNumberInstance(currentLocale);
        valueDisplay = numberFormat.format(value);
        amtDisplay = numberFormat.format(amt);
        System.out.println(valueDisplay + " " + currentLocale.toString());
        System.out.println(amtDisplay + " " + currentLocale.toString());

    }
    
    public static void main(String[] args) {
        Date today;
        String strDate;
        DateFormat dateFormatter;
        Locale locale = new Locale("vi", "VN");
        dateFormatter = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        today = new Date();
        strDate = dateFormatter.format(today);
        System.out.println(strDate);
    }
}
