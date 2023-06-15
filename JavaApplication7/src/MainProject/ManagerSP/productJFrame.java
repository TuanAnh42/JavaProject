/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.ManagerSP;

import MainProject.DAO.CategoryModify;
import MainProject.DAO.DataController;
import MainProject.DAO.GetAccount;
import MainProject.DAO.ProductModify;
import MainProject.DAO.loadDataModify;
import MainProject.MainFrame;
import static MainProject.MainFrame.checkStatus;
import MainProject.Utility.Patternform;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TrangAnh Lptop
 */
public class productJFrame extends javax.swing.JFrame {
    DataController dataMgr;
    DefaultTableModel tableModel;
    int currentPost = -1;
     private ImageIcon icon1 = new ImageIcon(getClass().getResource("../Icon/menu.jpg"));
    /**
     * Creates new form productJFrame
     */
    public productJFrame() {
        initComponents();
        setTitle("Quản lí sản phẩm");
        setResizable(false);//Ko định lại kích thước giao diện
        setLocationRelativeTo(null);//Ra giũa màn hình
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                loadDataModify.UpdateStatus(GetAccount.getAccount(), "Offline");
            }
        });
        tableModel = (DefaultTableModel) ProductTable.getModel();
        ProductTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                currentPost = ProductTable.getSelectedRow();

                nameText.setText(dataMgr.getProductList().get(currentPost).getName());
                priceText.setText(dataMgr.getProductList().get(currentPost).getPrice());
                quantityText.setText(dataMgr.getProductList().get(currentPost).getQuantity());
                propertyText.setText(dataMgr.getProductList().get(currentPost).getProperties());
                imgText.setText(dataMgr.getProductList().get(currentPost).getImgLink());
                String name = dataMgr.getProductList().get(currentPost).getCt().getName();
                int index = 0;
                for(int i = 0; i < dataMgr.getCategoryList().size(); i++) {
                    if(dataMgr.getCategoryList().get(i).getName().equals(dataMgr.getProductList().get(currentPost).getCt().getName().toString())) {
                        index = i;
                    }
                }
                categoryCombox.setSelectedIndex(index);
                addBtn.setEnabled(false);
                checkStatus(true);
                SetImg(imgText.getText());
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
        dataMgr = new DataController();
        dataMgr.getDataFormDB();
        Display();
        showCategory();
        checkStatus(false);
    }
    
     void SetImg(String img) {
        try {
              
               BufferedImage image = ImageIO.read(new File(img));
               int x = imgLabel.getSize().width;
               int y = imgLabel.getSize().height;
               int ix = image.getWidth();
               int iy = image.getHeight();
               int dx = 0;
               int dy = 0;
               if(x / y > ix / iy) {
                   dy = y;
                   dx = dy * ix / iy;
               } else {
                   dx = x;
                   dy = dx * iy/ ix;
               }
                ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
                imgLabel.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(productJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    private void checkStatus(boolean check) {
        UpdateBtn.setEnabled(check);
        deleteBtn.setEnabled(check);
    }
    
    private void showCategory() {
        for (Category ct : dataMgr.getCategoryList()) {
            categoryCombox.addItem(ct);
        }
    }

    private void Display() {
        tableModel.setRowCount(0);
        for (Product p : dataMgr.getProductList()) {
            String price = Patternform.transformPrice(Double.parseDouble(p.getPrice()));
            tableModel.addRow(new Object[]{
                tableModel.getRowCount() + 1,
                p.getCt().getName(),
                p.getName(),
                price,
                p.getQuantity(),
                p.getImgLink(),
                p.getProperties()
            });
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
        categoryCombox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        propertyText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        quantityText = new javax.swing.JTextField();
        imgText = new javax.swing.JTextField();
        priceText = new javax.swing.JTextField();
        imgBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        UpdateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        imgLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProductTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        SearchBtn = new javax.swing.JButton();
        searchText = new javax.swing.JTextField();
        homeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(186, 79, 84));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        categoryCombox.setBackground(new java.awt.Color(186, 79, 84));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Name");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Category");

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
        jLabel9.setText("Quantity");

        propertyText.setBackground(new java.awt.Color(186, 79, 84));
        propertyText.setForeground(new java.awt.Color(204, 204, 204));
        propertyText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        propertyText.setCaretColor(new java.awt.Color(255, 255, 255));
        propertyText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertyTextActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Price");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Introduce");

        quantityText.setBackground(new java.awt.Color(186, 79, 84));
        quantityText.setForeground(new java.awt.Color(204, 204, 204));
        quantityText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        quantityText.setCaretColor(new java.awt.Color(255, 255, 255));
        quantityText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTextActionPerformed(evt);
            }
        });

        imgText.setBackground(new java.awt.Color(186, 79, 84));
        imgText.setForeground(new java.awt.Color(204, 204, 204));
        imgText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        imgText.setCaretColor(new java.awt.Color(255, 255, 255));
        imgText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imgTextActionPerformed(evt);
            }
        });

        priceText.setBackground(new java.awt.Color(186, 79, 84));
        priceText.setForeground(new java.awt.Color(204, 204, 204));
        priceText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        priceText.setCaretColor(new java.awt.Color(255, 255, 255));
        priceText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceTextActionPerformed(evt);
            }
        });

        imgBtn.setBackground(new java.awt.Color(255, 255, 255));
        imgBtn.setForeground(new java.awt.Color(186, 79, 84));
        imgBtn.setText("IMG LINK");
        imgBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imgBtnActionPerformed(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(255, 255, 255));
        addBtn.setForeground(new java.awt.Color(186, 79, 84));
        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/icons8_add_24px.png"))); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        UpdateBtn.setBackground(new java.awt.Color(255, 255, 255));
        UpdateBtn.setForeground(new java.awt.Color(186, 79, 84));
        UpdateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/icons8_update_24px.png"))); // NOI18N
        UpdateBtn.setText("Update");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteBtn.setForeground(new java.awt.Color(186, 79, 84));
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/icons8_delete_16px.png"))); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        imgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/menu.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)))
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(imgBtn))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(categoryCombox, javax.swing.GroupLayout.Alignment.LEADING, 0, 326, Short.MAX_VALUE)
                            .addComponent(priceText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(propertyText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quantityText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(imgText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameText)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addBtn)
                        .addGap(61, 61, 61)
                        .addComponent(UpdateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(categoryCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(propertyText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(quantityText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(imgText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imgBtn)))
                    .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(UpdateBtn)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        ProductTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        ProductTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NO", "Name", "Category", "Price", "Quantity", "ING LINK", "Introduce"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ProductTable.setFocusable(false);
        ProductTable.setGridColor(new java.awt.Color(51, 51, 51));
        ProductTable.setRowHeight(25);
        ProductTable.setRowMargin(0);
        ProductTable.setSelectionBackground(new java.awt.Color(232, 57, 95));
        ProductTable.setShowHorizontalLines(false);
        ProductTable.setShowVerticalLines(false);
        ProductTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(ProductTable);
        if (ProductTable.getColumnModel().getColumnCount() > 0) {
            ProductTable.getColumnModel().getColumn(0).setResizable(false);
            ProductTable.getColumnModel().getColumn(1).setResizable(false);
            ProductTable.getColumnModel().getColumn(2).setResizable(false);
            ProductTable.getColumnModel().getColumn(3).setResizable(false);
            ProductTable.getColumnModel().getColumn(4).setResizable(false);
            ProductTable.getColumnModel().getColumn(5).setResizable(false);
            ProductTable.getColumnModel().getColumn(6).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Product Management ");

        SearchBtn.setBackground(new java.awt.Color(255, 255, 255));
        SearchBtn.setForeground(new java.awt.Color(186, 79, 84));
        SearchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/icons8_search_26px.png"))); // NOI18N
        SearchBtn.setText("Search");
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });

        homeBtn.setForeground(new java.awt.Color(186, 79, 84));
        homeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/icons8_home_24px.png"))); // NOI18N
        homeBtn.setText("Home");
        homeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(SearchBtn)
                .addGap(66, 66, 66)
                .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(homeBtn)
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchText, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(SearchBtn)
                    .addComponent(homeBtn))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextActionPerformed

    private void propertyTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertyTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_propertyTextActionPerformed

    private void quantityTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityTextActionPerformed

    private void imgTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imgTextActionPerformed

    private void priceTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTextActionPerformed

    private void ClearText() {
        nameText.setText("");
        categoryCombox.setSelectedIndex(0);
        priceText.setText("");
        propertyText.setText("");
        quantityText.setText("");
        imgText.setText("");
        imgLabel.setIcon(icon1);
    }
    
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        String name = nameText.getText();
        String price = priceText.getText();
        String introduce = propertyText.getText();
        String img = imgText.getText();
        String quantity = quantityText.getText();
        String namec = categoryCombox.getSelectedItem().toString();
        Product p = new Product(name, price, introduce, quantity, img);
        Category ct = CategoryModify.getCategory(namec);
        ProductModify.InsertData(p, Integer.parseInt(ct.getId()));
        dataMgr.setProductList(ProductModify.getDataProduct());
        Display();
        currentPost = -1;
        ClearText();
    }//GEN-LAST:event_addBtnActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        // TODO add your handling code here:
        String name = nameText.getText();
        String price = priceText.getText();
        String introduce = propertyText.getText();
        String img = imgText.getText();
        String quantity = quantityText.getText();
        String namec = categoryCombox.getSelectedItem().toString();
        String id = dataMgr.getProductList().get(currentPost).getId();
        Product p = new Product(Integer.parseInt(id), name, price, introduce, quantity, img);
        Category ct = CategoryModify.getCategory(namec);
        ProductModify.Update(p, Integer.parseInt(ct.getId()));
        dataMgr.setProductList(ProductModify.getDataProduct());
        Display();
        currentPost = -1;
         addBtn.setEnabled(true);
         ClearText();
         checkStatus(false);
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(dataMgr.getProductList().get(currentPost).getId());
        ProductModify.Delete(id);
        dataMgr.setProductList(ProductModify.getDataProduct());
        Display();
        currentPost = -1;
         addBtn.setEnabled(true);
         ClearText();
         checkStatus(false);
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed
        // TODO add your handling code here:
         String name = searchText.getText();
        if (name.equals("")) {
            dataMgr.setProductList(ProductModify.getDataProduct());
        } else {
            dataMgr.setProductList(ProductModify.Search(name));
        }

        Display();
    }//GEN-LAST:event_SearchBtnActionPerformed

    private void imgBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgBtnActionPerformed
        // TODO add your handling code here:
        JFileChooser filechooser = new JFileChooser();
        FileNameExtensionFilter imagefilter = new FileNameExtensionFilter("hình ảnh", "jpg","png");
        filechooser.setFileFilter(imagefilter);
        filechooser.setMultiSelectionEnabled(false);
        
        int g = filechooser.showDialog(this, "Chọn ảnh");
        if(g == JFileChooser.APPROVE_OPTION) {
             File f = filechooser.getSelectedFile();
              imgText.setText(f.getAbsolutePath());
              SetImg(f.getAbsolutePath());
        }
    }//GEN-LAST:event_imgBtnActionPerformed

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
            java.util.logging.Logger.getLogger(productJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(productJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(productJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(productJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new productJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ProductTable;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JButton addBtn;
    private javax.swing.JComboBox<Category> categoryCombox;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton homeBtn;
    private javax.swing.JButton imgBtn;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JTextField imgText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField priceText;
    private javax.swing.JTextField propertyText;
    private javax.swing.JTextField quantityText;
    private javax.swing.JTextField searchText;
    // End of variables declaration//GEN-END:variables
}
