/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.Order;

import MainProject.DAO.Constant;
import MainProject.DAO.GetAccount;
import MainProject.DAO.bookModify;
import MainProject.DAO.loadDataModify;
import MainProject.Sell.LoadData;
import MainProject.MainFrame;
import MainProject.Sell.SetPruductJFrame;
import static MainProject.Sell.SetPruductJFrame.bookList;
import MainProject.Utility.Patternform;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TrangAnh Lptop
 */
public class OderJFrame extends javax.swing.JFrame {

    private List<OrderOff> datalist;
    DefaultTableModel tableModel;
    int currentPost = -1;
    JButton[] ban = new JButton[Constant.soNgang * Constant.soDoc];
    private ImageIcon icon1 = new ImageIcon(getClass().getResource("../Icon/icons8-table-60.png"));
    private ImageIcon icon2 = new ImageIcon(getClass().getResource("../Icon/icons8-table-1.png"));
    private ImageIcon icon3 = new ImageIcon(getClass().getResource("../Icon/icons8-table-2.png"));
    public static List<OrderOff> bookList;

    /**
     * Creates new form OderJFrame
     */
    public OderJFrame() {
        initComponents();
        setTitle("Đặt bàn");
        setResizable(false);//Ko định lại kích thước giao diện
        setLocationRelativeTo(null);//Ra giũa màn hình
        checkStatus(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                loadDataModify.UpdateStatus(GetAccount.getAccount(), "Offline");
            }
        });
        loadTime();
        TaoBan();
        veBan();

        tableModel = (DefaultTableModel) bookTable.getModel();
        datalist = bookModify.getbookList(null);
        Display();
        bookTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentPost = bookTable.getSelectedRow();
                nameText.setText(datalist.get(currentPost).getName());
                phoneText.setText(datalist.get(currentPost).getPhone());
                noteText.setText(datalist.get(currentPost).getNote());
                var table = datalist.get(currentPost).getTable();
                tableCombox.setSelectedIndex(table - 1);
                var times = datalist.get(currentPost).getTimes().toString();
                int indextime = indextime = Integer.parseInt(times.charAt(0) + "" + times.charAt(1));
                int indexminute = Integer.parseInt(times.charAt(3) + "" + times.charAt(4));
                timeCombox.setSelectedIndex(indextime);
                minuteCombox.setSelectedIndex(indexminute);
                String date = datalist.get(currentPost).getCreated_at();

                Date date1 = null;
                try {
                    date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                } catch (ParseException ex) {
                    Logger.getLogger(OderJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                chooseDate.setDate(date1);
                checkStatus(true);
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

    private void Display() {
        tableModel.setRowCount(0);

        for (OrderOff od : datalist) {
            tableModel.addRow(new Object[]{
                tableModel.getRowCount() + 1,
                od.getName(),
                od.getPhone(),
                od.getTable(),
                od.getTimes(),
                od.getCreated_at(),
                od.getNote()
            });
        }
    }

    private void checkStatus(boolean check) {
        addBtn.setEnabled(!check);
        EditBtn.setEnabled(check);
        DeleteBtn.setEnabled(check);
    }

    private void TaoBan() {
        int count = 1;
        JButton oldbButton = new JButton();
        oldbButton.setBounds(0, 0, 0, 0);
        for (int i = 0; i < Constant.soDoc; i++) {
            for (int j = 0; j < Constant.soNgang; j++) {
                JButton button = new JButton("" + count, icon1);
                button.setHorizontalTextPosition(JButton.CENTER);
                button.setVerticalTextPosition(JButton.BOTTOM);

//                button.addActionListener((ActionListener) this);
                button.setBounds(oldbButton.getX() + oldbButton.getWidth(), oldbButton.getY(), Constant.Button_width_1, Constant.Button_height_1);
                oldbButton.setBounds(button.getX(), button.getY(), button.getWidth() + Constant.distance_1, button.getHeight() + Constant.distance);
                ban[count - 1] = button;
                count++;
            }
            oldbButton.setBounds(0, oldbButton.getY() + oldbButton.getHeight(), 0, 0);
        }
    }

    private void veBan() {
        for (JButton jButton : ban) {
            var name = jButton.getText();
            MainTable.add(jButton);
        }
    }

    private void loadDate() {
        chooseDate.setDateFormatString("dd/MM/yyyy");
        chooseDate.setFont(new Font("Dialog", Font.PLAIN, 11));
        chooseDate.setSize(new Dimension(105, 0));
    }

    private void loadTable() {
        tableCombox.removeAllItems();
        for (int i = 1; i <= 25; i++) {
            tableCombox.addItem(String.valueOf(i));
        }
    }

    private void loadHour() {
        timeCombox.removeAllItems();
        for (int i = 0; i <= 23; i++) {
            timeCombox.addItem(String.valueOf(i));
        }
    }

    private void loadMinutes() {
        minuteCombox.removeAllItems();
        for (int i = 0; i <= 59; i++) {
            if (i < 10) {
                minuteCombox.addItem("0" + i);
            } else {
                minuteCombox.addItem(String.valueOf(i));
            }

        }
    }

    private void loadTime() {
        loadTable();
        loadHour();
        loadMinutes();
        loadDate();
    }

    private void Reset() {
        nameText.setText("");
        phoneText.setText("");
        tableCombox.setSelectedIndex(0);
        timeCombox.setSelectedIndex(0);
        minuteCombox.setSelectedIndex(0);
        noteText.setText("");
        chooseDate.setDateFormatString("");
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
        jScrollPane2 = new javax.swing.JScrollPane();
        noteText = new javax.swing.JEditorPane();
        tableCombox = new javax.swing.JComboBox<>();
        timeCombox = new javax.swing.JComboBox<>();
        minuteCombox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        phoneText = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        EditBtn = new javax.swing.JButton();
        DeleteBtn = new javax.swing.JButton();
        HomeBtn = new javax.swing.JButton();
        FilterBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        MainTable = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(186, 79, 84));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        noteText.setBackground(new java.awt.Color(186, 79, 84));
        noteText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        noteText.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(noteText);

        tableCombox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableComboxActionPerformed(evt);
            }
        });

        timeCombox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeComboxActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Name");

        phoneText.setBackground(new java.awt.Color(186, 79, 84));
        phoneText.setForeground(new java.awt.Color(204, 204, 204));
        phoneText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        phoneText.setCaretColor(new java.awt.Color(255, 255, 255));
        phoneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTextActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Phone");

        nameText.setBackground(new java.awt.Color(186, 79, 84));
        nameText.setForeground(new java.awt.Color(204, 204, 204));
        nameText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        nameText.setCaretColor(new java.awt.Color(255, 255, 255));
        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Date");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Table");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Time");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Note");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(":");

        addBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/icons8_add_24px.png"))); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        EditBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/icons8_update_24px.png"))); // NOI18N
        EditBtn.setText("Edit");
        EditBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditBtnActionPerformed(evt);
            }
        });

        DeleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/icons8_delete_24px_1.png"))); // NOI18N
        DeleteBtn.setText("Delete");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });

        HomeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/icons8_home_24px.png"))); // NOI18N
        HomeBtn.setText("Home");
        HomeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeBtnActionPerformed(evt);
            }
        });

        FilterBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        FilterBtn.setForeground(new java.awt.Color(186, 79, 84));
        FilterBtn.setText("Filter");
        FilterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addBtn)
                        .addGap(61, 61, 61)
                        .addComponent(EditBtn)
                        .addGap(60, 60, 60)
                        .addComponent(DeleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(HomeBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)))
                            .addComponent(jLabel12)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(phoneText)
                            .addComponent(nameText)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(158, 158, 158)
                                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tableCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(timeCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(minuteCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 168, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(FilterBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tableCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minuteCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel9)
                        .addGap(93, 93, 93)
                        .addComponent(jLabel12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(FilterBtn)
                        .addGap(53, 53, 53)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addBtn)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EditBtn)
                        .addComponent(DeleteBtn)
                        .addComponent(HomeBtn)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        bookTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bookTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NO", "Name", "Phone", "Table", "Time", "Date", "Note"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookTable.setFocusable(false);
        bookTable.setGridColor(new java.awt.Color(51, 51, 51));
        bookTable.setRowHeight(25);
        bookTable.setRowMargin(0);
        bookTable.setSelectionBackground(new java.awt.Color(232, 57, 95));
        bookTable.setShowHorizontalLines(false);
        bookTable.setShowVerticalLines(false);
        bookTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(bookTable);
        if (bookTable.getColumnModel().getColumnCount() > 0) {
            bookTable.getColumnModel().getColumn(0).setResizable(false);
            bookTable.getColumnModel().getColumn(1).setResizable(false);
            bookTable.getColumnModel().getColumn(2).setResizable(false);
            bookTable.getColumnModel().getColumn(3).setResizable(false);
            bookTable.getColumnModel().getColumn(4).setResizable(false);
            bookTable.getColumnModel().getColumn(5).setResizable(false);
            bookTable.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Oders");

        javax.swing.GroupLayout MainTableLayout = new javax.swing.GroupLayout(MainTable);
        MainTable.setLayout(MainTableLayout);
        MainTableLayout.setHorizontalGroup(
            MainTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );
        MainTableLayout.setVerticalGroup(
            MainTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 412, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MainTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MainTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void phoneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneTextActionPerformed

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
//          Date load = chooseDate.getDate();
//            Date loading = new Date();
//            int s = Integer.parseInt(df.format(load).substring(8, 10));
//            int y = Integer.parseInt(df.format(loading).substring(8, 10));
//            JOptionPane.showMessageDialog(rootPane, loading.getHours() + ", " +loading.getMinutes());
        if (chooseDate.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn ngày");
        } else {
            Date load = chooseDate.getDate();
            Date loading = new Date();
            int s = Integer.parseInt(df.format(load).substring(8, 10));
            int y = Integer.parseInt(df.format(loading).substring(8, 10));
            if (load.getYear() > loading.getYear() || load.getYear() == loading.getYear() && load.getMonth() > loading.getMonth() || load.getYear() == loading.getYear() && load.getMonth() == loading.getMonth() && s >= y) {
                var name = nameText.getText();
                var phone = phoneText.getText();
                var table = Integer.parseInt(tableCombox.getSelectedItem().toString());
                var time = timeCombox.getSelectedItem() + ":" + minuteCombox.getSelectedItem();
                var times = Integer.parseInt(timeCombox.getSelectedItem().toString());
                var minutes = Integer.parseInt(minuteCombox.getSelectedItem().toString());
                int indextime = 0;
                int indexminute = 0;
                var date = df.format(chooseDate.getDate());
                var note = noteText.getText();
                boolean checknull = !(name.equals("") && phone.equals("") && note.equals(""));
                boolean check = false;
                boolean checkday = true;
                for (OrderOff od : datalist) {
                    indextime = Integer.parseInt(od.getTimes().charAt(0) + "" + od.getTimes().charAt(1));
                    indexminute = Integer.parseInt(od.getTimes().charAt(3) + "" + od.getTimes().charAt(4));
                    if (od.getCreated_at().equals(date) && od.getTable() == table) {
                        checkday = false;
                        int minutestart = 0;
                        int minuteend = 0;

                        if (times == indextime) {
                            if (indexminute > minutes) {
                                minutestart = indexminute - minutes;
                            } else {
                                minutestart = minutes - indexminute;
                            }
                            if (minutestart <= 30) {
                                check = false;
                            } else {
                                check = true;
                            }

                        } else {
                            if (times < indextime) {
                                minuteend = (60 - minutes) + indexminute;
                            } else if (times > indextime) {
                                minuteend = (60 - indexminute) + minutes;
                            }
                            if (minuteend <= 30) {

                                check = false;
                            } else {
                                check = true;
                            }

                        }

                        if (!check) {
                            JOptionPane.showMessageDialog(rootPane, "Thoi gian giua các ban phai lon hon 30 phut");
                            return;
                        }
                    }
                }
                if (check || checkday) {
                    if (checknull) {
                        OrderOff oda = new OrderOff(table, date, time, name, phone, note);
                        bookModify.InsertBook(oda);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin khách hàng.");
                    }
                    datalist = bookModify.getbookList(null);
                    Display();

                    Reset();
                    loadDate();
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn ngày lớn hơn");
            }
        }
        String loadtime = String.valueOf(new SimpleDateFormat("YYYY-MM-dd").format(new java.util.Date()));

        SetPruductJFrame.bookList = bookModify.getbookList(loadtime);


    }//GEN-LAST:event_addBtnActionPerformed

    private void EditBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditBtnActionPerformed
        // TODO add your handling code here:
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        var name = nameText.getText();
        var phone = phoneText.getText();
        var table = Integer.parseInt(tableCombox.getSelectedItem().toString());
        var time = timeCombox.getSelectedItem() + ":" + minuteCombox.getSelectedItem();
        var date = df.format(chooseDate.getDate());
        var note = noteText.getText();
        var id = datalist.get(currentPost).getId();
        boolean checknull = !(name.equals("") && phone.equals("") && note.equals(""));
        if (checknull) {
            OrderOff od = new OrderOff(id, table, date, time, name, phone, note);
            bookModify.Update(od);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin khách hàng.");
        }
        datalist = bookModify.getbookList(null);
        Display();

        Reset();
        loadDate();
        String loadtime = String.valueOf(new SimpleDateFormat("YYYY-MM-dd").format(new java.util.Date()));
        SetPruductJFrame.bookList = bookModify.getbookList(loadtime);
        checkStatus(false);
    }//GEN-LAST:event_EditBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        // TODO add your handling code here:
        var id = datalist.get(currentPost).getId();
        bookModify.Delete(id);
        datalist = bookModify.getbookList(null);
        Display();

        Reset();
        loadDate();
        String loadtime = String.valueOf(new SimpleDateFormat("YYYY-MM-dd").format(new java.util.Date()));
        SetPruductJFrame.bookList = bookModify.getbookList(loadtime);
        checkStatus(false);
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void HomeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeBtnActionPerformed
        // TODO add your handling code here:
        MainFrame.checkStatus = true;
        setVisible(false);
    }//GEN-LAST:event_HomeBtnActionPerformed

    private int getHour(String s) {
        String[] array = s.replace(":", " ").split("\\s");
        return Integer.parseInt(array[0]);
    }

    private int getMinute(String s) {
        String[] array = s.replace(":", " ").split("\\s");
        return Integer.parseInt(array[1]);
    }

    private void checkStatus() {
        var hour = Integer.parseInt(timeCombox.getSelectedItem().toString());
        var minute = Integer.parseInt(minuteCombox.getSelectedItem().toString());
        for (OrderOff od : bookList) {
            if (hour - getHour(od.getTimes()) == -1) {

                if ((60 - minute) + getMinute(od.getTimes()) <= 60 && (60 - minute) + getMinute(od.getTimes()) >= 30) {
                    for (JButton bt : ban) {
                        if (bt.getText().equals(String.valueOf(od.getTable()))) {
                            bt.setIcon(icon2);
                        }
                    }
                }
                if ((60 - minute) + getMinute(od.getTimes()) <= 30) {
                    for (JButton bt : ban) {
                        if (bt.getText().equals(String.valueOf(od.getTable()))) {
                            bt.setIcon(icon3);
                        }
                    }
                }
            } else if (hour - getHour(od.getTimes()) == 0) {
                if (getMinute(od.getTimes()) >= minute && getMinute(od.getTimes()) - minute <= 30) {
                    for (JButton bt : ban) {
                        if (bt.getText().equals(String.valueOf(od.getTable()))) {
                            bt.setIcon(icon3);
                        }
                    }
                } else if (minute >= getMinute(od.getTimes()) && minute - getMinute(od.getTimes()) <= 30) {
                    for (JButton bt : ban) {
                        if (bt.getText().equals(String.valueOf(od.getTable()))) {
                            bt.setIcon(icon3);
                        }
                    }
                }

            } else if (hour - getHour(od.getTimes()) == 1) {
                if ((60 - getMinute(od.getTimes())) + minute <= 30) {
                    for (JButton bt : ban) {
                        if (bt.getText().equals(String.valueOf(od.getTable()))) {
                            bt.setIcon(icon3);
                        }
                    }
                }
                if ((60 - getMinute(od.getTimes())) + minute <= 60 && (60 - getMinute(od.getTimes())) + minute >= 30) {
                    for (JButton bt : ban) {
                        if (bt.getText().equals(String.valueOf(od.getTable()))) {
                            bt.setIcon(icon2);
                        }
                    }
                }
            }
        }
    }

    private void FilterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterBtnActionPerformed
        // TODO add your handling code here:
        if (chooseDate.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn ngày để check");
        } else {
            for (JButton bt : ban) {
                bt.setIcon(icon1);
            }
            String loadtime = String.valueOf(new SimpleDateFormat("YYYY-MM-dd").format(chooseDate.getDate()));

            bookList = bookModify.getbookList(loadtime);
            checkStatus();
        }

    }//GEN-LAST:event_FilterBtnActionPerformed

    private void tableComboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableComboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tableComboxActionPerformed

    private void timeComboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeComboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeComboxActionPerformed

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
            java.util.logging.Logger.getLogger(OderJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OderJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OderJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OderJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OderJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteBtn;
    private javax.swing.JButton EditBtn;
    private javax.swing.JButton FilterBtn;
    private javax.swing.JButton HomeBtn;
    private javax.swing.JPanel MainTable;
    private javax.swing.JButton addBtn;
    private javax.swing.JTable bookTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JComboBox<String> minuteCombox;
    private javax.swing.JTextField nameText;
    private javax.swing.JEditorPane noteText;
    private javax.swing.JTextField phoneText;
    private javax.swing.JComboBox<String> tableCombox;
    private javax.swing.JComboBox<String> timeCombox;
    // End of variables declaration//GEN-END:variables
}
