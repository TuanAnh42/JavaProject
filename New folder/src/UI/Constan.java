/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.JPanel;

/**
 * 
 * @author admin
 */
public class Constan extends JPanel{
//    JPanel panel = new JPanel();
//    public  Test() {
//        setSize(66,78); // Kích thước khung
//    }
    public static final int Button_width = 70;
    public static final int Button_height = 60;
    public static final int distance = 50;
    
}
// JFileChooser chooser = new JFileChooser();
//       chooser.setFileFilter(new FileFilter() {
//           @Override
//           public boolean accept(File f) {
//               if(f.isDirectory()){
//                   return true;
//               }else{
//                   return f.getName().toLowerCase().endsWith(".jpg");
//               }
//               
//               
//           
//           }
//       
//
//           @Override
//           public String getDescription() {
//              return "Image File (*.jpg)";
//           }
//       });
//       
//       if(chooser.showOpenDialog(jPanel1)==JFileChooser.CANCEL_OPTION){
//           return;
//       }
//       File file = chooser.getSelectedFile();
//        try {
//            ImageIcon icon = new ImageIcon(file.getPath());
//            Image image = ImgHelper.resize(icon.getImage(),140, 160);
//            ImageIcon imageIcon = new ImageIcon(image);
//            imgroom.setIcon(imageIcon);
//            roomImage = ImgHelper.toByteArray(image, "jpg");
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(jPanel1,"loi");
//            
//        }
//
//
//
//
// System.out.println("Click save button ");    
//        room_num = room_number.getText();
//        type_room = cbtype.getSelectedItem().toString();
//        floor = cbfloor.getSelectedItem().toString();
//        status = cbstatus.getSelectedItem().toString();
//        price_room = price.getText();    
//        roomImage = null;
//        System.out.println("room_num=" + room_num + ", type_room=" + type_room + ", floor=" + floor + ", status=" + status + ", price_room=" + price_room + ", img=" + img + ", roomImage=" + roomImage);
//
//        ImageIcon icon = new ImageIcon(getClass().getResource("/Icon/Hotel-icon.png"));
//        imgroom.setIcon(icon);
//        
//        if(room_num.equals("")|| price_room.equals("")){
//            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ");
//        }else{
//            Room r = new Room(room_num,type_room, floor, status, price_room, roomImage);
//            try {
//                RoomManagement.add(r);
//            } catch (IOException ex) {
//                Logger.getLogger(AddRoomForm.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            dispose();
//        }
