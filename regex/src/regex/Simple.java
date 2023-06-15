/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex;

/**
 *
 * @author std
 */
public class Simple {
    public static void main(String[] args) {
        String str="He7ll8888209o 111123 Wor23ld!";
        String rs = "";
        
            for(int i=0 ;i<str.length();i++){
                if(Character.isDigit(str.charAt(i))){
                    rs += "";
                }else{
                    rs+= str.charAt(i);
                }
                
            }
            System.out.println(rs);
            //regex
            String result= str.replaceAll("\\d", "");
            System.out.println(result);
            }
    
    
}
