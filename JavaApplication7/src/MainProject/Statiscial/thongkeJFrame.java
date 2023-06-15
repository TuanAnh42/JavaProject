/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.Statiscial;

import MainProject.Order.OrderOff;
import MainProject.DAO.GetAccount;
import MainProject.DAO.StatiscalModify;
import MainProject.DAO.loadDataModify;
import MainProject.MainFrame;
import MainProject.Utility.Patternform;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TrangAnh Lptop
 */
public class thongkeJFrame extends javax.swing.JFrame {
    DefaultTableModel tableModel;
    List<OrderOff> datalist;
    boolean lapYear = false, day, month, year = false;
    int currentPost = -1;
    int OrderID;
    String name;
    String address;
    String telephone;
    int multi = 0;
    int pages = 0;
    int pg = 0;
    int multiPage = 10;
    int present = 1;
    JButton[] page;
    JButton next;
    JButton prev;
    /**
     * Creates new form thongkeJFrame
     */
    public thongkeJFrame() {
        initComponents();
        setTitle("Thống kê");
        setResizable(false);//Ko định lại kích thước giao diện
        setLocationRelativeTo(null);//Ra giũa màn hình
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                loadDataModify.UpdateStatus(GetAccount.getAccount(), "Offline");
            }
        });
        tableModel = (DefaultTableModel) statisticalTable.getModel();
        datalist = StatiscalModify.getOrderList();
        Combox();

        pages = (int) Paging(multiPage);
        if (pages > 5) {
            pg = 5;
        } else {
            pg = pages;
        }
        page = new JButton[pages];
        Display(1, pages);
        TaoBan();
        veBan();
        statisticalTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                currentPost = statisticalTable.getSelectedRow() + ((present-1) * multiPage);
                OrderID = datalist.get(currentPost).getId();
                name = datalist.get(currentPost).getName();
                telephone = datalist.get(currentPost).getPhone();
                address = datalist.get(currentPost).getNote();
                
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
    
    private void Display(int get, int compare) {
        if (datalist.size() == 0 || datalist == null) {
            datalist = new ArrayList<>();
            tableModel.setRowCount(0);
            for (OrderOff od : datalist) {
                var total = Patternform.transformPrice(od.getTotalPrice());
                tableModel.addRow(new Object[]{
                    tableModel.getRowCount() + 1,
                    od.getStaff().getFullname(),
                    od.getTable(),
                    total,
                    od.getCreated_at(),
                    od.getName(),
                    od.getPhone(),
                    od.getNote()
                });
            }
        } else {
            int start = 0;
            int end = 0;
            int totalPrice = 0;
            tableModel.setRowCount(0);
            if (get == compare) {
                start = (get - 1) * multiPage;
                end = datalist.size();
            } else {
                end = get * multiPage;
                start = end - multiPage;
            }

            for (int i = start; i < end; i++) {
                totalPrice += datalist.get(i).getTotalPrice();
                var total = Patternform.transformPrice(datalist.get(i).getTotalPrice());
                tableModel.addRow(new Object[]{
                    i + 1,
                    datalist.get(i).getStaff().getFullname(),
                    datalist.get(i).getTable(),
                    total,
                    datalist.get(i).getCreated_at(),
                    datalist.get(i).getName(),
                    datalist.get(i).getPhone(),
                    datalist.get(i).getNote()
                });
            }
            totalBill.setText(datalist.size() + "");
            totalPrices.setText(Patternform.transformPrice(totalPrice).replace(".", ","));
        }

    }


    private double Paging(double x) {
        return Math.ceil(datalist.size() / x);
    }

    private void TaoBan() {
        int count = 1;
        int width = 40;
        int height = 30;
        int distance = 15;
        int map = tableMain.getWidth() / 3;
        JButton oldbButton = new JButton();
        oldbButton.setBounds(map, 0, 0, 0);
        for (int j = 0; j < pages; j++) {
            JButton button = new JButton("" + count);
            button.setHorizontalTextPosition(JButton.CENTER);
            button.setVerticalTextPosition(JButton.BOTTOM);
            button.setBounds(oldbButton.getX() + oldbButton.getWidth(), oldbButton.getY(), width, height);
            oldbButton.setBounds(button.getX(), button.getY(), button.getWidth() + distance, button.getHeight() + distance);
            page[count - 1] = button;
            count++;
        }
        if (pages > 5) {
            next = new JButton(">>");
            prev = new JButton("<<");
            next.setHorizontalTextPosition(JButton.CENTER);
            next.setVerticalTextPosition(JButton.BOTTOM);
            next.setBounds(oldbButton.getX(), oldbButton.getY(), 50, height);

            prev.setHorizontalTextPosition(JButton.CENTER);
            prev.setVerticalTextPosition(JButton.BOTTOM);
            prev.setBounds(map - 70, oldbButton.getY(), 50, height);
        }
    }

    private void veBan() {

        for (int i = 0; i < pg; i++) {
            var name = page[i].getText();
            tableMain.add(page[i]);
            page[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    present = Integer.parseInt(name);
                    if (multi == 0) {
                        Display(Integer.parseInt(name), pages);
                    } else {
                        Display(Integer.parseInt(name), multi);
                    }

                    if (pages > 5) {
                        if (present == 1) {
                            prev.setEnabled(false);
                        } else {
                            prev.setEnabled(true);
                        }
                    }

                }
            });
        }

        if (pages > 5) {
            tableMain.add(next);
            tableMain.add(prev);
            prev.setEnabled(false);

            next.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (present < pages) {
                        present++;
                    }
                    if (present > 1) {
                        prev.setEnabled(true);
                    }
                    Display(present, pages);
                }
            });

            prev.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (present > 1) {
                        present--;
                    }
                    if (present == 1) {
                        prev.setEnabled(false);
                    }
                    Display(present, pages);
                }
            });
        }

    }

    private void checkYear() {
        if (Double.parseDouble(String.valueOf(chooseYear.getValue())) % 4 == 0) {
            lapYear = true;
        } else {
            lapYear = false;
        }
    }

    private void addDay() {
        checkYear();
        String[] day = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "24", "25", "26", "27", "28", "29", "30", "31"};
        switch (Integer.parseInt(monthCombox.getSelectedItem().toString())) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dateCombox.removeAllItems();
                for (String i : day) {
                    dateCombox.addItem(i);
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dateCombox.removeAllItems();
                for (int i = 0; i < day.length - 1; i++) {
                    dateCombox.addItem(day[i]);
                }
                break;
            case 2:
                if (lapYear) {
                    for (int i = 0; i < day.length - 2; i++) {
                        dateCombox.addItem(day[i]);
                    }
                } else {
                    for (int i = 0; i < day.length - 3; i++) {
                        dateCombox.addItem(day[i]);
                    }
                }
                break;
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        statisticalTable = new javax.swing.JTable();
        tableMain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        totalBill = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totalPrices = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        radNgay = new javax.swing.JRadioButton();
        radMonth = new javax.swing.JRadioButton();
        radYear = new javax.swing.JRadioButton();
        dateCombox = new javax.swing.JComboBox<>();
        monthCombox = new javax.swing.JComboBox<>();
        returnBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        btnModel = new javax.swing.JButton();
        detailBtn = new javax.swing.JButton();
        modelCombox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        chooseYear = new com.toedter.calendar.JYearChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        statisticalTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        statisticalTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        statisticalTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "NO", "Staff", "Table", "Total", "Create_at", "Client", "Phone", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        statisticalTable.setFocusable(false);
        statisticalTable.setGridColor(new java.awt.Color(51, 51, 51));
        statisticalTable.setRowHeight(25);
        statisticalTable.setRowMargin(0);
        statisticalTable.setSelectionBackground(new java.awt.Color(232, 57, 95));
        statisticalTable.setShowHorizontalLines(false);
        statisticalTable.setShowVerticalLines(false);
        statisticalTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(statisticalTable);
        if (statisticalTable.getColumnModel().getColumnCount() > 0) {
            statisticalTable.getColumnModel().getColumn(0).setResizable(false);
            statisticalTable.getColumnModel().getColumn(1).setResizable(false);
            statisticalTable.getColumnModel().getColumn(2).setResizable(false);
            statisticalTable.getColumnModel().getColumn(3).setResizable(false);
            statisticalTable.getColumnModel().getColumn(4).setResizable(false);
            statisticalTable.getColumnModel().getColumn(5).setResizable(false);
            statisticalTable.getColumnModel().getColumn(6).setResizable(false);
            statisticalTable.getColumnModel().getColumn(7).setResizable(false);
        }

        tableMain.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout tableMainLayout = new javax.swing.GroupLayout(tableMain);
        tableMain.setLayout(tableMainLayout);
        tableMainLayout.setHorizontalGroup(
            tableMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tableMainLayout.setVerticalGroup(
            tableMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 93, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Tổng hóa đơn:");

        totalBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalBill.setText("0");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tổng tiền :");

        totalPrices.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totalPrices.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
            .addComponent(tableMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalBill)
                .addGap(76, 76, 76)
                .addComponent(jLabel3)
                .addGap(9, 9, 9)
                .addComponent(totalPrices)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                    .addComponent(totalBill)
                    .addComponent(jLabel3)
                    .addComponent(totalPrices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38)
                .addComponent(tableMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.setBackground(new java.awt.Color(116, 204, 204));

        radNgay.setBackground(new java.awt.Color(116, 204, 204));
        radNgay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        radNgay.setText("Date");
        radNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radNgayActionPerformed(evt);
            }
        });

        radMonth.setBackground(new java.awt.Color(116, 204, 204));
        radMonth.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        radMonth.setText("Month");
        radMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radMonthActionPerformed(evt);
            }
        });

        radYear.setBackground(new java.awt.Color(116, 204, 204));
        radYear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        radYear.setText("Year");
        radYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radYearActionPerformed(evt);
            }
        });

        monthCombox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        monthCombox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthComboxActionPerformed(evt);
            }
        });

        returnBtn.setBackground(new java.awt.Color(159, 217, 231));
        returnBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/icons8_back_50px.png"))); // NOI18N
        returnBtn.setBorderPainted(false);
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });

        searchBtn.setBackground(new java.awt.Color(159, 217, 231));
        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/icons8_search_48px.png"))); // NOI18N
        searchBtn.setBorderPainted(false);
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        btnModel.setBackground(new java.awt.Color(255, 255, 255));
        btnModel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnModel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/icons8_home_24px.png"))); // NOI18N
        btnModel.setText("Home");
        btnModel.setBorderPainted(false);
        btnModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModelActionPerformed(evt);
            }
        });

        detailBtn.setBackground(new java.awt.Color(255, 255, 255));
        detailBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        detailBtn.setText("Detail");
        detailBtn.setBorderPainted(false);
        detailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailBtnActionPerformed(evt);
            }
        });

        modelCombox.setEditable(true);
        modelCombox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modelCombox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TurnOver", "Product" }));
        modelCombox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("CharAt");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnModel, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                                .addComponent(detailBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(returnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modelCombox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(radNgay)
                                .addGap(49, 49, 49))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(dateCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(monthCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radMonth))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chooseYear, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radYear))))
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radNgay)
                    .addComponent(radMonth)
                    .addComponent(radYear))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseYear, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(returnBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModel)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModelActionPerformed
        // TODO add your handling code here:
        MainFrame.checkStatus = true;
        setVisible(false);
    }//GEN-LAST:event_btnModelActionPerformed

    private void monthComboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthComboxActionPerformed
        // TODO add your handling code here:
        addDay();
    }//GEN-LAST:event_monthComboxActionPerformed

    private void radNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radNgayActionPerformed
        // TODO add your handling code here:
        radMonth.setSelected(false);
        radYear.setSelected(false);
        dateCombox.setEnabled(true);
        monthCombox.setEnabled(true);
        day = true;
        month = false;
        year = false;
    }//GEN-LAST:event_radNgayActionPerformed

    private void radMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radMonthActionPerformed
        // TODO add your handling code here:
        radNgay.setSelected(false);
        radYear.setSelected(false);
        monthCombox.setEnabled(true);
        dateCombox.setEnabled(false);
        day = false;
        month = true;
        year = false;
    }//GEN-LAST:event_radMonthActionPerformed

    private void radYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radYearActionPerformed
        // TODO add your handling code here:
        radNgay.setSelected(false);
        radMonth.setSelected(false);
        dateCombox.setEnabled(false);
        monthCombox.setEnabled(false);
        day = false;
        month = false;
        year = true;
    }//GEN-LAST:event_radYearActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        String date = "";

        if (year) {
            date = chooseYear.getValue() + "";
        } else if (month) {
            String s = monthCombox.getSelectedItem().toString();
            if (s.length() == 1) {
                s = "0" + s;
            }
            date = chooseYear.getValue() + "-" + s;
        } else if (day) {
            String s = monthCombox.getSelectedItem().toString();
            String y = dateCombox.getSelectedItem().toString();
            if (s.length() == 1) {
                s = "0" + s;
            }
            if (y.length() == 1) {
                y = "0" + y;
            }
            date = chooseYear.getValue() + "-" + s + "-" + y;
        }

        datalist = StatiscalModify.Search(date);

        multi = (int) Paging(multiPage);
        if (multi < pg) {

            for (int i = 0; i < pg; i++) {
                if (i > multi - 1) {

                    page[i].setEnabled(false);
                } else {
                    page[i].setEnabled(true);
                }
            }
        } else {
            for(int i = 0; i < pg; i++) {
                page[i].setEnabled(true);
            }
        }

        Display(1, multi);
    }//GEN-LAST:event_searchBtnActionPerformed

    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        // TODO add your handling code here:
         datalist = StatiscalModify.getOrderList();
        multi = 0;
        for (int i = 0; i < pg; i++) {
            page[i].setEnabled(true);
        }
        Display(1, pages);
    }//GEN-LAST:event_returnBtnActionPerformed

    private void detailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailBtnActionPerformed
        // TODO add your handling code here:
        OrderdetailFrame.id = OrderID;
        OrderdetailFrame.name = name;
        OrderdetailFrame.phone = telephone;
        OrderdetailFrame.address = address;
        OrderdetailFrame.check = true;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderdetailFrame().setVisible(true);
            }
        });
    }//GEN-LAST:event_detailBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         if (modelCombox.getSelectedIndex() == 1) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ModelProducd().setVisible(true);
                }
            });
        } else {
            if (month) {
                String s = monthCombox.getSelectedItem().toString();
                if (s.length() == 1) {
                    s = "0" + s;
                }
                s = chooseYear.getValue() + "-" + s;
                ModelStaticalFrame.check = true;
                ModelStaticalFrame.setDate = s;
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new ModelStaticalFrame().setVisible(true);
                    }
                });
            } else {
                JOptionPane.showMessageDialog(dateCombox, "Vui lòng chọn tháng để thống kê");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void Combox() {
        radYear.setSelected(true);
        radNgay.setSelected(false);
        radMonth.setSelected(false);
        dateCombox.setEnabled(false);
        monthCombox.setEnabled(false);
    }
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
            java.util.logging.Logger.getLogger(thongkeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(thongkeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(thongkeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(thongkeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new thongkeJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModel;
    private com.toedter.calendar.JYearChooser chooseYear;
    private javax.swing.JComboBox<String> dateCombox;
    private javax.swing.JButton detailBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> modelCombox;
    private javax.swing.JComboBox<String> monthCombox;
    private javax.swing.JRadioButton radMonth;
    private javax.swing.JRadioButton radNgay;
    private javax.swing.JRadioButton radYear;
    private javax.swing.JButton returnBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTable statisticalTable;
    private javax.swing.JPanel tableMain;
    private javax.swing.JLabel totalBill;
    private javax.swing.JLabel totalPrices;
    // End of variables declaration//GEN-END:variables
}
