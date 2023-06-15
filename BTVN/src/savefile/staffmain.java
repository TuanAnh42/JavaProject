/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package savefile;

import java.io.*;

/**
 *
 * @author DELL
 */
public class staffmain {
    public static void main(String[] args) {
        Staff s = new Staff("1N","Tang Ba Anh",20,223535345,"Hai Duong",20.4,"Giam Doc");
        try{
            FileOutputStream fos = new FileOutputStream("Staff.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s);
            oos.close();
            fos.close();
            
            FileInputStream fis = new FileInputStream("Staff.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s = (Staff) ois.readObject();
            System.out.println(s.toString());
            ois.close();
            fis.close();          
        }catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
        
    }
}
