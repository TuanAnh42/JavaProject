/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.Menu;

import MainProject.DAO.DataController;
import MainProject.DAO.ManageStaffModify;
import MainProject.Menu.Setting.Model_Card;
import MainProject.DAO.StatiscalModify;
import MainProject.Menu.Setting.ScrollBar;
import MainProject.Menu.Setting.StatusType;
import MainProject.Statiscial.ModelStaticalFrame;
import MainProject.RegisterAndLogin.Infor;
import Utility.Patternform;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class FormPanel extends javax.swing.JPanel implements Runnable{
    public static boolean  check = false;
    int year;
    int monthEnd = 0;
    int monthStart = 0;
    int monthMiddle = 0;
    int money1 = 0;
    int money2 = 0;
    int money3 = 0;
    DataController dataMgr;
    DefaultTableModel tableModel;
    private Thread thread;
    int x = 0;
    /**
     * Creates new form TablePanel
     */
    public FormPanel() {
        initComponents();
        GetMonthPresent();
        spTable.setVerticalScrollBar(new ScrollBar());
        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        dataMgr = new DataController();
        dataMgr.getDataFormDB();
        tableModel = (DefaultTableModel) table.getModel();
        Display();
        Start();
    }
    
    void Start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    private void Display() {
        tableModel.setRowCount(0);
        StatusType type;
        String ad;
        for (Infor staff : dataMgr.getStaffList()) {
            String created = staff.getCreated_at().substring(0, 10);
            var admin = ManageStaffModify.checkEmail(staff.getEmail(), "account_admin", "accountadmin");
            if (admin) {
                ad = "Admin";
            } else {
                ad = "Staff";
            }
            if (staff.getStatus().equals("Online")) {
                type = StatusType.ONLINE;
            } else {
                type = StatusType.OFFLINE;
            }
            tableModel.addRow(new Object[]{staff.getFullname(), staff.getEmail(), ad, created, type});
        }
    }

    private void GetMonthPresent() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(date);
        year = Integer.parseInt(s.substring(0, 4));
        monthEnd = Integer.parseInt(s.substring(5, 7));
        if (monthEnd == 1) {
            monthMiddle = 12;
            monthStart = 11;
            money1 = StatiscalModify.getCount( (year - 1) + "-" + monthMiddle);
            money2 = StatiscalModify.getCount( (year - 1) + "-" + monthStart);
            card1.setData(new Model_Card(new ImageIcon(getClass().getResource("../Icon/stock.png")), "Statistical", Patternform.transformPrice(money1)+ " VND", monthMiddle + "-" + (year - 1)));
            card2.setData(new Model_Card(new ImageIcon(getClass().getResource("../Icon/profit.png")), "Statistical", Patternform.transformPrice(money2)+ " VND", monthStart + "-" + (year - 1)));
        } else if (monthEnd == 2) {
            monthMiddle = 1;
            monthStart = 12;
            money1 = StatiscalModify.getCount( (year - 1) + "-"+ monthStart);
            money2 = StatiscalModify.getCount( year + "-" + monthMiddle);
            card1.setData(new Model_Card(new ImageIcon(getClass().getResource("../Icon/stock.png")), "Statistical", Patternform.transformPrice(money1)+ " VND", monthStart + "-"+ (year - 1)));
            card2.setData(new Model_Card(new ImageIcon(getClass().getResource("../Icon/profit.png")), "Statistical", Patternform.transformPrice(money2)+ " VND", monthMiddle + "-" + year));
        } else {
            monthMiddle = monthEnd - 1;
            monthStart = monthEnd - 2;
            money1 = StatiscalModify.getCount( year + "-" + monthStart);
            money2 = StatiscalModify.getCount( year + "-" + monthMiddle);
            card1.setData(new Model_Card(new ImageIcon(getClass().getResource("../Icon/stock.png")), "Statistical", Patternform.transformPrice(money1)+ " VND", monthStart + "-" + year));
            card2.setData(new Model_Card(new ImageIcon(getClass().getResource("../Icon/profit.png")), "Statistical", Patternform.transformPrice(money2) + " VND", monthMiddle + "-" + year));
        }
        money3 = StatiscalModify.getCount(year + "-" + monthEnd);
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("../Icon/flag.png")), "Statistical", Patternform.transformPrice(money3) + " VND", monthEnd + "-" + year));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        searchText = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/searchx.png"))); // NOI18N
        jLabel2.setOpaque(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        searchText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchText.setForeground(new java.awt.Color(117, 117, 117));
        searchText.setText("Search here ...");
        searchText.setBorder(null);
        searchText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTextFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
            .addComponent(searchText)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(374, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void card1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card1MouseClicked
        // TODO add your handling code here:
        String s = year + "-" + monthStart;
        if (monthStart < 10) {
            s = year + "-0" + monthStart;
        }
        ModelStaticalFrame.check = true;
        ModelStaticalFrame.setDate = s;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModelStaticalFrame().setVisible(true);
            }
        });
    }//GEN-LAST:event_card1MouseClicked

    private void card2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card2MouseClicked
        // TODO add your handling code here:
        String s = year + "-" + monthMiddle;
        if (monthMiddle < 10) {
            s = year + "-0" + monthMiddle;
        }
        ModelStaticalFrame.check = true;
        ModelStaticalFrame.setDate = s;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModelStaticalFrame().setVisible(true);
            }
        });
    }//GEN-LAST:event_card2MouseClicked

    private void card3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card3MouseClicked
        // TODO add your handling code here:
        String s = year + "-" + monthEnd;
        if (monthEnd < 10) {
            s = year + "-0" + monthEnd;
        }
        ModelStaticalFrame.check = true;
        ModelStaticalFrame.setDate = s;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModelStaticalFrame().setVisible(true);
            }
        });
    }//GEN-LAST:event_card3MouseClicked

    private void searchTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFocusGained
        // TODO add your handling code here:
        searchText.setText("");
    }//GEN-LAST:event_searchTextFocusGained

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        var search = searchText.getText();
        
        if(search.equals("")) {
            dataMgr.setStaffList(ManageStaffModify.getStaffList());
            Display();
        } else {
        dataMgr.setStaffList(ManageStaffModify.Search(search));
        Display();
        }
    }//GEN-LAST:event_jLabel2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField searchText;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while (true) {
            
            if (check == true) { 
                x++; 
                if(x >= 3) {
                    dataMgr.setStaffList(ManageStaffModify.getStaffList());
                    Display();
                    x = 0;
                    check = false;
                }
            }
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
