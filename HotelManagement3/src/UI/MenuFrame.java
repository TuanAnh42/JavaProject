/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import dao.UserManagement;
import entity.User;
import unti.Clock;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class MenuFrame extends javax.swing.JFrame {

    /**
     * Creates new form MenuFrame
     */
    Color DefaultColor, ClickedColor;

    public MenuFrame() {
        initComponents();
        initCLock();
        chuchay();
        check();
        List<User> userList = new ArrayList<>();
        userList = UserManagement.getUserList();
        for (User user : userList) {

            txtName.setText(user.getName());

        }

        DefaultColor = new Color(133, 176, 240);
        ClickedColor = new Color(169, 198, 239);
        DashboardManagementJFrame menu1 = new DashboardManagementJFrame();

        jDesktopPanel.removeAll();
        jDesktopPanel.add(menu1).setVisible(true);

        Menu2.setBackground(DefaultColor);
        Menu3.setBackground(DefaultColor);
        Menu6.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu7.setBackground(DefaultColor);
        Menu9.setBackground(DefaultColor);
        Menu1.setBackground(DefaultColor);
        Menu10.setBackground(DefaultColor);
    }

    public void check() {
        User user = new User();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        File file = new File("data.txt");
        try {
            fis = new FileInputStream(file);
            while (fis.available() > 0) {
                ois = new ObjectInputStream(fis);

                try {
                    user = (User) ois.readObject();
                } catch (EOFException eofe) {
                    eofe.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                    break;
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoginJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(LoginJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(LoginJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        if (user.getRole_id() == 2) {
            jLabel17.setEnabled(false);
            Menu6.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
            StaffManagementJFrame staff = new StaffManagementJFrame();
            jDesktopPanel.removeAll();
            jDesktopPanel.add(staff).setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(MenuFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }

         
            });
        }else{
            jLabel17.setEnabled(true);
        }
    }

    public void chuchay() {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                String txt = lbl_chuchay.getText() + "  ";
                while (true) {
//                    txt = txt.substring(1,txt.length()) + txt.charAt(0);
                    txt = txt.charAt(txt.length() - 1) + txt.substring(0, txt.length() - 1);
                    try {
                        sleep(800);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MenuFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    lbl_chuchay.setText(txt);
                }
            }

        };
        thread1.start();
    }

    private void setUser() {

    }

    private void initCLock() {
        Clock clock = new Clock(timeLbl);
        clock.start();
    }

    /**
     *
     * /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPanel = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_chuchay = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        Menu6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        Menu7 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtName = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Menu9 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        Menu2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        Menu5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        Menu3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        timeLbl = new javax.swing.JLabel();
        Menu1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        Menu10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDesktopPanel.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPanel.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jDesktopPanelLayout = new javax.swing.GroupLayout(jDesktopPanel);
        jDesktopPanel.setLayout(jDesktopPanelLayout);
        jDesktopPanelLayout.setHorizontalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1440, Short.MAX_VALUE)
        );
        jDesktopPanelLayout.setVerticalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );

        getContentPane().add(jDesktopPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 1440, 890));

        jPanel1.setBackground(new java.awt.Color(169, 198, 239));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-x-25.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 0, 22, -1));

        lbl_chuchay.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_chuchay.setText("                                WELLCOME HOTEL NOVOTEL MANAGEMENT ");
        jPanel1.add(lbl_chuchay, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 970, 20));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-189, -2, 1640, -1));

        jSeparator3.setBackground(new java.awt.Color(0, 51, 204));
        jSeparator3.setForeground(new java.awt.Color(0, 51, 204));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1460, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 1460, 30));

        jPanel3.setBackground(new java.awt.Color(133, 176, 240));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu6.setBackground(new java.awt.Color(133, 176, 240));
        Menu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Menu6MousePressed(evt);
            }
        });
        Menu6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setBackground(new java.awt.Color(164, 211, 238));
        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-admin-settings-male-24.png"))); // NOI18N
        jLabel17.setText("  Manage Staff");
        Menu6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, 40));

        jPanel3.add(Menu6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 190, 60));

        Menu7.setBackground(new java.awt.Color(133, 176, 240));
        Menu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu7MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Menu7MousePressed(evt);
            }
        });
        Menu7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-contact-24.png"))); // NOI18N
        jLabel20.setText("   Contact");
        Menu7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 120, 40));

        jPanel3.add(Menu7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 190, 50));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logout-24.png"))); // NOI18N
        jLabel14.setText("Log out");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel14MousePressed(evt);
            }
        });
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 900, 120, 30));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 140, 10));

        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/admin-32.png"))); // NOI18N
        txtName.setText("Hello ADMIN");
        jPanel3.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 180, 40));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-hotel-30.png"))); // NOI18N
        jLabel2.setText("Novotel Hotel ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 40));

        Menu9.setBackground(new java.awt.Color(133, 176, 240));
        Menu9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu9MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Menu9MousePressed(evt);
            }
        });
        Menu9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setBackground(new java.awt.Color(164, 211, 238));
        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-customer-32.png"))); // NOI18N
        jLabel18.setText("Manage Customer");
        Menu9.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, 40));

        jPanel3.add(Menu9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 190, 60));

        Menu2.setBackground(new java.awt.Color(133, 176, 240));
        Menu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Menu2MousePressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/BillManage.png"))); // NOI18N
        jLabel13.setText("  Manage Bill");

        javax.swing.GroupLayout Menu2Layout = new javax.swing.GroupLayout(Menu2);
        Menu2.setLayout(Menu2Layout);
        Menu2Layout.setHorizontalGroup(
            Menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        Menu2Layout.setVerticalGroup(
            Menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(Menu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 190, 60));

        Menu5.setBackground(new java.awt.Color(133, 176, 240));
        Menu5.setPreferredSize(new java.awt.Dimension(190, 50));
        Menu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu5MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Menu5MousePressed(evt);
            }
        });
        Menu5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-event-accepted-24.png"))); // NOI18N
        jLabel19.setText("  Booking Room");
        Menu5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, 40));

        jPanel3.add(Menu5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 190, 60));

        Menu3.setBackground(new java.awt.Color(133, 176, 240));
        Menu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Menu3MousePressed(evt);
            }
        });
        Menu3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-room-24.png"))); // NOI18N
        jLabel12.setText("  Manage Room");
        Menu3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 170, 40));

        jPanel3.add(Menu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 190, 70));

        timeLbl.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        timeLbl.setForeground(new java.awt.Color(255, 255, 255));
        timeLbl.setText("Time :");
        jPanel3.add(timeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 180, 30));

        Menu1.setBackground(new java.awt.Color(133, 176, 240));
        Menu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Menu1MousePressed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(164, 211, 238));
        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-combo-chart-26.png"))); // NOI18N
        jLabel11.setText(" Dashboard");

        javax.swing.GroupLayout Menu1Layout = new javax.swing.GroupLayout(Menu1);
        Menu1.setLayout(Menu1Layout);
        Menu1Layout.setHorizontalGroup(
            Menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        Menu1Layout.setVerticalGroup(
            Menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(Menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 190, 60));

        Menu10.setBackground(new java.awt.Color(133, 176, 240));
        Menu10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu10MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Menu10MousePressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-forgot-password-26.png"))); // NOI18N
        jLabel15.setText("   Change Password");

        javax.swing.GroupLayout Menu10Layout = new javax.swing.GroupLayout(Menu10);
        Menu10.setLayout(Menu10Layout);
        Menu10Layout.setHorizontalGroup(
            Menu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );
        Menu10Layout.setVerticalGroup(
            Menu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(Menu10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 190, 60));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 940));

        jPanel4.setBackground(new java.awt.Color(169, 198, 239));

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 1649, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 9, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 920, 1460, 20));

        jPanel5.setBackground(new java.awt.Color(169, 198, 239));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1630, 20, 20, 910));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Menu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu2MouseClicked
        BillManagementJFrame menu1 = new BillManagementJFrame();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(menu1).setVisible(true);
    }//GEN-LAST:event_Menu2MouseClicked

    private void Menu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu2MousePressed
        Menu2.setBackground(ClickedColor);
        Menu3.setBackground(DefaultColor);
        Menu6.setBackground(DefaultColor);
        Menu7.setBackground(DefaultColor);
        Menu9.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu1.setBackground(DefaultColor);
        Menu10.setBackground(DefaultColor);
    }//GEN-LAST:event_Menu2MousePressed

    private void Menu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu3MousePressed
        Menu2.setBackground(DefaultColor);
        Menu3.setBackground(ClickedColor);
        Menu6.setBackground(DefaultColor);
        Menu7.setBackground(DefaultColor);
        Menu9.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu1.setBackground(DefaultColor);
        Menu10.setBackground(DefaultColor);
    }//GEN-LAST:event_Menu3MousePressed

    private void Menu6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu6MousePressed
        Menu2.setBackground(DefaultColor);
        Menu3.setBackground(DefaultColor);
        Menu6.setBackground(ClickedColor);
        Menu7.setBackground(DefaultColor);
        Menu9.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu1.setBackground(DefaultColor);
        Menu10.setBackground(DefaultColor);

    }//GEN-LAST:event_Menu6MousePressed

    private void Menu7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu7MousePressed
        Menu2.setBackground(DefaultColor);
        Menu3.setBackground(DefaultColor);
        Menu6.setBackground(DefaultColor);
        Menu7.setBackground(ClickedColor);
        Menu9.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu1.setBackground(DefaultColor);
        Menu10.setBackground(DefaultColor);

    }//GEN-LAST:event_Menu7MousePressed

    private void Menu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu3MouseClicked
        try {
            RoomManagementJFrame roomJFrame = new RoomManagementJFrame();
            jDesktopPanel.removeAll();
            jDesktopPanel.add(roomJFrame).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MenuFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_Menu3MouseClicked

    private void Menu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu6MouseClicked
        try {
            StaffManagementJFrame staff = new StaffManagementJFrame();
            jDesktopPanel.removeAll();
            jDesktopPanel.add(staff).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MenuFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_Menu6MouseClicked

    private void Menu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu7MouseClicked
        ContactJFrame contact = new ContactJFrame();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(contact).setVisible(true);
    }//GEN-LAST:event_Menu7MouseClicked

    private void Menu9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu9MousePressed
        Menu2.setBackground(DefaultColor);
        Menu3.setBackground(DefaultColor);
        Menu6.setBackground(DefaultColor);
        Menu7.setBackground(DefaultColor);
        Menu9.setBackground(ClickedColor);
        Menu5.setBackground(DefaultColor);
        Menu1.setBackground(DefaultColor);
        Menu10.setBackground(DefaultColor);

    }//GEN-LAST:event_Menu9MousePressed

    private void Menu9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu9MouseClicked
        try {
            // TODO add your handling code here:
            CustomerManagementJFrame cus = new CustomerManagementJFrame();
            jDesktopPanel.removeAll();
            jDesktopPanel.add(cus).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(MenuFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Menu9MouseClicked

    private void Menu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu5MouseClicked
        // TODO add your handling code here:
        BookingJFrame bk = new BookingJFrame();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(bk).setVisible(true);
    }//GEN-LAST:event_Menu5MouseClicked

    private void Menu5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu5MousePressed
        Menu2.setBackground(DefaultColor);
        Menu3.setBackground(DefaultColor);
        Menu6.setBackground(DefaultColor);
        Menu7.setBackground(DefaultColor);
        Menu9.setBackground(DefaultColor);
        Menu5.setBackground(ClickedColor);
        Menu1.setBackground(DefaultColor);
        Menu10.setBackground(DefaultColor);

    }//GEN-LAST:event_Menu5MousePressed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();

    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MousePressed
        LoginJFrame frame = new LoginJFrame();
//        frame.setdata(UserManagement.getEmail(email));
        frame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel14MousePressed

    private void Menu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu1MousePressed
        Menu2.setBackground(DefaultColor);
        Menu3.setBackground(DefaultColor);
        Menu6.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu7.setBackground(DefaultColor);
        Menu9.setBackground(DefaultColor);
        Menu1.setBackground(ClickedColor);
        Menu10.setBackground(DefaultColor);
    }//GEN-LAST:event_Menu1MousePressed

    private void Menu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu1MouseClicked
        DashboardManagementJFrame menu1 = new DashboardManagementJFrame();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(menu1).setVisible(true);
    }//GEN-LAST:event_Menu1MouseClicked

    private void Menu10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu10MousePressed
        Menu2.setBackground(DefaultColor);
        Menu3.setBackground(DefaultColor);
        Menu6.setBackground(DefaultColor);
        Menu5.setBackground(DefaultColor);
        Menu7.setBackground(DefaultColor);
        Menu9.setBackground(DefaultColor);
        Menu1.setBackground(DefaultColor);
        Menu10.setBackground(ClickedColor);
    }//GEN-LAST:event_Menu10MousePressed

    private void Menu10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu10MouseClicked
        ChangePassword menu10 = new ChangePassword();
        jDesktopPanel.removeAll();
        jDesktopPanel.add(menu10).setVisible(true);
    }//GEN-LAST:event_Menu10MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MenuFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Menu1;
    private javax.swing.JPanel Menu10;
    private javax.swing.JPanel Menu2;
    private javax.swing.JPanel Menu3;
    private javax.swing.JPanel Menu5;
    private javax.swing.JPanel Menu6;
    private javax.swing.JPanel Menu7;
    private javax.swing.JPanel Menu9;
    private javax.swing.JDesktopPane jDesktopPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_chuchay;
    private javax.swing.JLabel timeLbl;
    private javax.swing.JLabel txtName;
    // End of variables declaration//GEN-END:variables
}
