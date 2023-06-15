/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.ManagerSP;

import MainProject.DAO.DataController;
import MainProject.DAO.GetAccount;
import MainProject.DAO.ManageStaffModify;
import MainProject.DAO.RegisterModify;
import MainProject.DAO.loadDataModify;
import MainProject.MainFrame;
import static MainProject.MainFrame.checkStatus;
import MainProject.RegisterAndLogin.Infor;
import MainProject.RegisterAndLogin.admin;
import MainProject.Utility.Patternform;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TrangAnh Lptop
 */
public class managestaffJFrom extends javax.swing.JFrame {
    DataController dataMgr;
    DefaultTableModel tableModel;
    int currenPost = -1;
    /**
     * Creates new form managestaffJFrom
     */
    public managestaffJFrom() {
        initComponents();
        setTitle("Quản lí nhân viên");
        CheckStatus(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                loadDataModify.UpdateStatus(GetAccount.getAccount(), "Offline");
            }
        });
        chooseDate.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                SimpleDateFormat formatdate = new SimpleDateFormat("dd-MM-yyyy");
                String date = formatdate.format(chooseDate.getDate());
                ageText.setText(date);
            }
        });
        setBackground(new Color(0,0,0));
        setResizable(false);//Ko định lại kích thước giao diện
        setLocationRelativeTo(null);//Ra giũa màn hình
        TableManager.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        TableManager.getTableHeader().setOpaque(false);
        TableManager.getTableHeader().setBackground(new Color(32, 136, 203));
        TableManager.getTableHeader().setBackground(new Color(255, 255, 255));
        TableManager.getRowHeight(25);
        tableModel = (DefaultTableModel) TableManager.getModel();

        dataMgr = new DataController();
        dataMgr.getDataFormDB();
        Display();

        TableManager.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currenPost = TableManager.getSelectedRow();

                nameText.setText(dataMgr.getStaffList().get(currenPost).getFullname());
                telephoneText.setText(dataMgr.getStaffList().get(currenPost).getPhone());
                ageText.setText(dataMgr.getStaffList().get(currenPost).getAge());
                addressText.setText(dataMgr.getStaffList().get(currenPost).getAddress());
                accountText.setText(dataMgr.getStaffList().get(currenPost).getEmail());
                passText.setText(Patternform.giaima(dataMgr.getStaffList().get(currenPost).getPassword()));

                var gender = dataMgr.getStaffList().get(currenPost).getGender();
                int index;
                if (gender.equals("Male")) {
                    index = 0;
                } else if (gender.equals("Female")) {
                    index = 1;
                } else {
                    index = 2;
                }
                genderText.setSelectedIndex(index);
                AddBtn.setEnabled(false);
                CheckStatus(true);

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
        
    }
    
    void Display() {
        tableModel.setRowCount(0);

        for (Infor staff : dataMgr.getStaffList()) {
            tableModel.addRow(new Object[]{
                tableModel.getRowCount() + 1,
                staff.getFullname(),
                staff.getAge(),
                staff.getPhone(),
                staff.getAddress(),
                staff.getGender(),
                staff.getCreated_at(),
                staff.getUpdate_at()
            });
        }
    }
    
    private void CheckStatus(boolean check) {
        updateBtn.setEnabled(check);
        deleteBtn.setEnabled(check);
        adminBtn.setEnabled(check);
    }
    
    private void ClearText() {
        nameText.setText("");
        genderText.setSelectedIndex(0);
        telephoneText.setText("");
        addressText.setText("");
        accountText.setText("");
        passText.setText("");
        ageText.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        telephoneText = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        addressText = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        accountText = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        genderText = new javax.swing.JComboBox<>();
        passText = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        ageText = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableManager = new javax.swing.JTable();
        searchText = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        AddBtn = new javax.swing.JButton();
        adminBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        homeBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(186, 79, 84));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, " Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("FullName");

        nameText.setBackground(new java.awt.Color(186, 79, 84));
        nameText.setForeground(new java.awt.Color(204, 204, 204));
        nameText.setText("Name");
        nameText.setBorder(null);
        nameText.setCaretColor(new java.awt.Color(255, 255, 255));
        nameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameTextFocusGained(evt);
            }
        });
        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Gender");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Phone");

        telephoneText.setBackground(new java.awt.Color(186, 79, 84));
        telephoneText.setForeground(new java.awt.Color(204, 204, 204));
        telephoneText.setText("Phone");
        telephoneText.setBorder(null);
        telephoneText.setCaretColor(new java.awt.Color(255, 255, 255));
        telephoneText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                telephoneTextFocusGained(evt);
            }
        });
        telephoneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telephoneTextActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Address");

        addressText.setBackground(new java.awt.Color(186, 79, 84));
        addressText.setForeground(new java.awt.Color(204, 204, 204));
        addressText.setText("Address");
        addressText.setBorder(null);
        addressText.setCaretColor(new java.awt.Color(255, 255, 255));
        addressText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                addressTextFocusGained(evt);
            }
        });
        addressText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTextActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Account");

        accountText.setBackground(new java.awt.Color(186, 79, 84));
        accountText.setForeground(new java.awt.Color(204, 204, 204));
        accountText.setText("Account");
        accountText.setBorder(null);
        accountText.setCaretColor(new java.awt.Color(255, 255, 255));
        accountText.setEnabled(false);
        accountText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                accountTextFocusGained(evt);
            }
        });
        accountText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountTextActionPerformed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Password");

        genderText.setBackground(new java.awt.Color(186, 79, 84));
        genderText.setEditable(true);
        genderText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        genderText.setForeground(new java.awt.Color(186, 79, 84));
        genderText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));
        genderText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderTextActionPerformed(evt);
            }
        });

        passText.setBackground(new java.awt.Color(186, 79, 84));
        passText.setForeground(new java.awt.Color(204, 204, 204));
        passText.setText("PassWord");
        passText.setBorder(null);
        passText.setCaretColor(new java.awt.Color(255, 255, 255));
        passText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passTextFocusGained(evt);
            }
        });
        passText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passTextActionPerformed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Birthday");

        ageText.setBackground(new java.awt.Color(186, 79, 84));
        ageText.setForeground(new java.awt.Color(204, 204, 204));
        ageText.setText("Age");
        ageText.setBorder(null);
        ageText.setCaretColor(new java.awt.Color(255, 255, 255));
        ageText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ageTextFocusGained(evt);
            }
        });
        ageText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12)
                            .addComponent(telephoneText)
                            .addComponent(jSeparator3)
                            .addComponent(jLabel11)
                            .addComponent(jSeparator2)
                            .addComponent(jLabel13)
                            .addComponent(addressText)
                            .addComponent(jSeparator4)
                            .addComponent(genderText, 0, 176, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14)
                                .addComponent(accountText, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(141, 141, 141))
                        .addComponent(jLabel15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(passText, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(ageText, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(373, 373, 373)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(105, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(13, 13, 13)
                        .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(accountText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(genderText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel16))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telephoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ageText, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addressText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(315, Short.MAX_VALUE)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(122, 122, 122)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        TableManager.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        TableManager.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        TableManager.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Rollno", "UserName", "Age", "Phone", "Address", "Gender", "Create_at", "Update_at"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableManager.setFocusable(false);
        TableManager.setGridColor(new java.awt.Color(51, 51, 51));
        TableManager.setRowHeight(25);
        TableManager.setRowMargin(0);
        TableManager.setSelectionBackground(new java.awt.Color(232, 57, 95));
        TableManager.setShowVerticalLines(false);
        TableManager.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TableManager);
        if (TableManager.getColumnModel().getColumnCount() > 0) {
            TableManager.getColumnModel().getColumn(0).setResizable(false);
            TableManager.getColumnModel().getColumn(1).setResizable(false);
            TableManager.getColumnModel().getColumn(2).setResizable(false);
            TableManager.getColumnModel().getColumn(3).setResizable(false);
            TableManager.getColumnModel().getColumn(4).setResizable(false);
            TableManager.getColumnModel().getColumn(5).setResizable(false);
            TableManager.getColumnModel().getColumn(6).setResizable(false);
            TableManager.getColumnModel().getColumn(7).setResizable(false);
        }

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/icons8_search_26px.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/icons8_update_24px.png"))); // NOI18N
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        AddBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/icons8_add_24px.png"))); // NOI18N
        AddBtn.setText("Add");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });

        adminBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/icons8_verified_account_32px_2.png"))); // NOI18N
        adminBtn.setText("LicensingAD");
        adminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminBtnActionPerformed(evt);
            }
        });

        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/icons8_delete_24px_1.png"))); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(74, 31, 61));

        homeBtn.setBackground(new java.awt.Color(255, 255, 255));
        homeBtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/icons8_back_24px.png"))); // NOI18N
        homeBtn.setText("BACK");
        homeBtn.setBorder(null);
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Employee Manager");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(353, 353, 353)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(homeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(btnSearch)
                        .addGap(235, 235, 235)
                        .addComponent(AddBtn)
                        .addGap(91, 91, 91)
                        .addComponent(updateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(adminBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(deleteBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(updateBtn)
                    .addComponent(adminBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn)
                    .addComponent(AddBtn))
                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ageTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ageTextActionPerformed

    private void ageTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ageTextFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_ageTextFocusGained

    private void passTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passTextActionPerformed

    private void passTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passTextFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_passTextFocusGained

    private void genderTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderTextActionPerformed

    private void accountTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accountTextActionPerformed

    private void accountTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_accountTextFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_accountTextFocusGained

    private void addressTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTextActionPerformed

    private void addressTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_addressTextFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTextFocusGained

    private void telephoneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telephoneTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telephoneTextActionPerformed

    private void telephoneTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telephoneTextFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_telephoneTextFocusGained

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextActionPerformed

    private void nameTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameTextFocusGained
        nameText.setText("");
    }//GEN-LAST:event_nameTextFocusGained

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        // TODO add your handling code here:
        var username = nameText.getText();
        var email = accountText.getText();
        var age = ageText.getText();
        var phone = telephoneText.getText();
        var address = addressText.getText();
        var pass = passText.getText();
        var gender = genderText.getSelectedItem().toString();
        var checkUser = !(Patternform.GetUserName(username));
        var checkEmail = !(Patternform.GetEmail(email));
        var checkPass = !(Patternform.GetPass(pass));
        var checkExitsEmail = ManageStaffModify.checkEmail(email, "account_client", "accounts");

        var isNull = (username.equals("") || email.equals("") || age.equals("") || phone.equals("") || address.equals("") || pass.equals(""));
        if (isNull) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ các trường." + username);
        } else if (checkUser) {
            JOptionPane.showMessageDialog(rootPane, "Username từ 6 - 12 kí tự và không có khoảng trắng.");
        } else if (checkEmail) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đúng định dạng email!");
        } else if (checkPass) {
            JOptionPane.showMessageDialog(rootPane, "Mật khẩu ít nhất 6 kí tự, có 1 chữ viết hoa và số.");
        } else if (checkExitsEmail) {
            JOptionPane.showMessageDialog(rootPane, "Tài khoản trên đã tồn tại vui lòng đổi tên tài khoản.");
        } else {
            int dk = JOptionPane.showConfirmDialog(rootPane, "ADMIN có chắc muốn thêm tài khoản");
            if (dk == 0) {
                Infor infor = new Infor(username, age, email, pass, phone, address, gender);
                RegisterModify.Register(infor);
                dataMgr.getDataFormDB();
                Display();
            }
        }
        ClearText();
    }//GEN-LAST:event_AddBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        var username = nameText.getText();
        var email = accountText.getText();
        var age = ageText.getText();
        var phone = telephoneText.getText();
        var address = addressText.getText();
        var pass = passText.getText();
        var gender = genderText.getSelectedItem().toString();
        var checkUser = !(Patternform.GetUserName(username));
        var checkEmail = !(Patternform.GetEmail(email));
        var checkPass = !(Patternform.GetPass(pass));
        var checkExitsEmail = ManageStaffModify.checkEmail(email, "account_client", "accounts");
        var checkExits = ManageStaffModify.checkEmail(email, "account_admin", "accountadmin");
        var isNull = (username.equals("") || email.equals("") || age.equals("") || phone.equals("") || address.equals("") || pass.equals(""));
        if (isNull) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ các trường." + username);
        } else if (checkUser) {
            JOptionPane.showMessageDialog(rootPane, "Username từ 6 - 12 kí tự và không có khoảng trắng.");
        } else if (checkEmail) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đúng định dạng email!");
        } else if (checkPass) {
            JOptionPane.showMessageDialog(rootPane, "Mật khẩu ít nhất 6 kí tự, có 1 chữ viết hoa và số.");
        } else {
            if (!checkExitsEmail) {
                int choose = JOptionPane.showConfirmDialog(rootPane, "Tài khoản trên chưa tồn tại ADMIN có muốn thêm tài khoản trên không?");
                if (choose == 0) {
                    Infor infor = new Infor(username, age, email, pass, phone, address, gender);
                    RegisterModify.Register(infor);
                    dataMgr.getDataFormDB();
                    Display();
                    
                }
            } else {
                int dk = JOptionPane.showConfirmDialog(rootPane, "ADMIN có chắc muốn thay đổi thông tin không?");
                if (dk == 0) {
                    Infor infor = new Infor(username, age, email, pass, phone, address, gender);
                    ManageStaffModify.Update(infor);
                    dataMgr.getDataFormDB();
                    Display();
                    if(checkExits) {
                        admin ad = new admin(email, pass, username);
                        ManageStaffModify.UpdateAd(ad);
                    }
                }
            }   
        }
        AddBtn.setEnabled(true);
         CheckStatus(false);
        ClearText();
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        var email = accountText.getText();
        var checkExitsEmail = ManageStaffModify.checkEmail(email, "account_client", "accounts");
        var checkExits = ManageStaffModify.checkEmail(email, "account_admin", "accountadmin");
        if(checkExitsEmail) {
            ManageStaffModify.Delete(email, "account_client", "accounts");
            dataMgr.getDataFormDB();
            Display();
            if(checkExits) {
                ManageStaffModify.Delete(email, "account_admin", "accountadmin");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Tài khoản trên không tồn tại");
        }
        AddBtn.setEnabled(true);
         CheckStatus(false);
        ClearText();
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void adminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminBtnActionPerformed
        // TODO add your handling code here:
        var pass = passText.getText();
        var name = nameText.getText();
        var account = accountText.getText();
        
        var checkExits = ManageStaffModify.checkEmail(account, "account_admin", "accountadmin");
        
        if(checkExits) {
            JOptionPane.showMessageDialog(rootPane, "Tài khoản này đã là admin trc đấy.");
        } else {
            admin ad = new admin(account, pass, name);
            ManageStaffModify.addAdmin(ad);
            JOptionPane.showMessageDialog(rootPane, "Thêm tài khoản admin thành công");
        }
        AddBtn.setEnabled(true);
        CheckStatus(false);
        ClearText();
    }//GEN-LAST:event_adminBtnActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        var search = searchText.getText();
        if(search.equals("")) {
            dataMgr.setStaffList(ManageStaffModify.getStaffList());
            Display();
        } else {
        dataMgr.setStaffList(ManageStaffModify.Search(search));
        Display();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        // TODO add your handling code here:
        MainFrame.checkStatus = true;
        setVisible(false);
    }//GEN-LAST:event_homeBtnActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(managestaffJFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managestaffJFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managestaffJFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managestaffJFrom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new managestaffJFrom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBtn;
    private javax.swing.JTable TableManager;
    private javax.swing.JTextField accountText;
    private javax.swing.JTextField addressText;
    private javax.swing.JButton adminBtn;
    private javax.swing.JTextField ageText;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JComboBox<String> genderText;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField passText;
    private javax.swing.JTextField searchText;
    private javax.swing.JTextField telephoneText;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
