/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainProject.Sell;

import MainProject.Order.OrderOff;
import MainProject.ManagerSP.Category;
import MainProject.DAO.CategoryModify;
import MainProject.DAO.Constant;
import MainProject.DAO.DataController;
import MainProject.DAO.GetAccount;
import MainProject.DAO.ProductModify;
import MainProject.DAO.RegisterModify;
import MainProject.DAO.bookModify;
import MainProject.DAO.loadDataModify;
import MainProject.MainFrame;
import static MainProject.MainFrame.checkStatus;
import MainProject.ManagerSP.Product;
import MainProject.RegisterAndLogin.Infor;
import MainProject.Statiscial.ModelStaticalFrame;
import MainProject.Utility.Patternform;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TrangAnh Lptop
 */
public class SetPruductJFrame extends javax.swing.JFrame implements Runnable {
    private Thread thread;
    DataController dataMgr;
    JButton[] ban = new JButton[Constant.soNgang * Constant.soDoc];
    private ImageIcon icon1 = new ImageIcon(getClass().getResource("../Icon/icons8_table_40px.png"));
    private ImageIcon icon2 = new ImageIcon(getClass().getResource("../Icon/coffee-table.png"));
    private ImageIcon icon3 = new ImageIcon(getClass().getResource("../Icon/icons8_table.png"));
    private ImageIcon icon4 = new ImageIcon(getClass().getResource("../Icon/menu.jpg"));
    DefaultTableModel tableModel;
    private List<LoadData> dataList;
    Infor staff = RegisterModify.getByEmail(GetAccount.getAccount());
    public static boolean checkEnd = false;
    public static List<OrderOff> bookList;
    int statusTable = 0;
    /**
     * Creates new form SetPruductJFrame
     */
    public SetPruductJFrame() {
        initComponents();
//        setTitle("Bán hàng");
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                loadDataModify.UpdateStatus(GetAccount.getAccount(), "Offline");
            }
        });
        dataMgr = new DataController();
        dataMgr.getDataFormDB();
        String loadtime = String.valueOf(new SimpleDateFormat("YYYY-MM-dd").format(new java.util.Date()));
        bookList = bookModify.getbookList(loadtime);
        tableModel = (DefaultTableModel) foodtable.getModel();
        setResizable(false);//Ko định lại kích thước giao diện
        setLocationRelativeTo(null);//Ra giũa màn hình
        TaoBan();
        veBan();
        ShowCategory();
        eventComboxParent();
        TinhTrangBan();
        NameAndDate();
        Start();
    }
    
    void Display(List<LoadData> datalist) {
        tableModel.setRowCount(0);
        for (LoadData data : datalist) {
            var price = Patternform.transformPrice(data.getPrice());
            tableModel.addRow(new Object[]{
                tableModel.getRowCount() + 1,
                data.getFood(),
                data.getTotal(),
                price
            });
        }
    }

    void ShowCategory() {
        for (Category ct : dataMgr.getCategoryList()) {
            categoryCombox.addItem(ct.getName());
        }
    }

    void eventComboxParent() {
        categoryCombox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                productCombox.removeAllItems();
                var name = categoryCombox.getSelectedItem().toString();
                var idCombox = CategoryModify.getCategory(name).getId();
                List<Product> data = ProductModify.SearchName(Integer.parseInt(idCombox));
                for (Product pd : data) {
                    productCombox.addItem(pd.getName());
                }
                eventComboxChild();
            }
        });
    }

    void eventComboxChild() {
        productCombox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (productCombox.getSelectedItem() == null) {

                } else {
                    var name = productCombox.getSelectedItem().toString();
                    var img = ProductModify.SearchImg(name, "imgLink");
                    var price = ProductModify.SearchImg(name, "Price");
                    priceLabel.setText(Patternform.transformPrice(Integer.parseInt(price)).replace(".", ","));
                    SetImg(img);
                }

            }
        });
    }


    void Start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
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
                Logger.getLogger(SetPruductJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    private void TaoBan() {
        int count = 1;
        JButton oldbButton = new JButton();
        oldbButton.setBounds(0, 0, 0, 0);
        for (int i = 0; i < Constant.soDoc; i++) {
            for (int j = 0; j < Constant.soNgang; j++) {
                JButton button = new JButton("" + count, icon3);
                button.setHorizontalTextPosition(JButton.CENTER);
                button.setVerticalTextPosition(JButton.BOTTOM);

//                button.addActionListener((ActionListener) this);
                button.setBounds(oldbButton.getX() + oldbButton.getWidth(), oldbButton.getY(), Constant.Button_width, Constant.Button_height);
                oldbButton.setBounds(button.getX(), button.getY(), button.getWidth() + Constant.distance, button.getHeight() + Constant.distance);
                ban[count - 1] = button;
                count++;
            }
            oldbButton.setBounds(0, oldbButton.getY() + oldbButton.getHeight(), 0, 0);
        }
    }

    private void veBan() {
        for (JButton jButton : ban) {
            var name = jButton.getText();
            tableMain.add(jButton);
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    tableNumber.setText(name);
                    dataList = loadDataModify.getDataList(Integer.parseInt(tableNumber.getText().toString()));
                    int totalFood = 0;
                    for (LoadData data1 : dataList) {
                        totalFood += data1.getPrice();
                    }
                    totalP.setText(Patternform.transformPrice(totalFood));
                    Display(dataList);
                    if (dataList.size() == 0 || dataList == null) {
                        billBtn.setEnabled(false);
                    } else {
                        billBtn.setEnabled(true);
                    }
                }
            });
        }
    }
    
    private int getHour(String s) {
        String []array = s.replace(":", " ").split("\\s");
        return Integer.parseInt(array[0]);
    }
    
    private int getMinute(String s) {
        String []array = s.replace(":", " ").split("\\s");
        return Integer.parseInt(array[1]);
    }
    
    private void checkStatus() {
        for(OrderOff od : bookList) {
            if(getHour(Timelabel.getText()) - getHour(od.getTimes()) == -1) {
                if((60 - getMinute(Timelabel.getText())) + getMinute(od.getTimes()) <= 30) {
                    for(JButton bt : ban) {
                        if(bt.getText().equals(String.valueOf(od.getTable()))) {
                            bt.setEnabled(false);
                        }
                    }
                }
            }
            else if(getHour(Timelabel.getText()) - getHour(od.getTimes()) == 0) {
                if(getMinute(od.getTimes()) >= getMinute(Timelabel.getText()) && getMinute(od.getTimes()) - getMinute(Timelabel.getText()) <= 30) {
                    for(JButton bt : ban) {
                        if(bt.getText().equals(String.valueOf(od.getTable()))) {
                            bt.setEnabled(false);
                        }
                    }
                }
                else if(getMinute(Timelabel.getText()) >= getMinute(od.getTimes()) && getMinute(Timelabel.getText()) - getMinute(od.getTimes()) <= 30) {
                    for(JButton bt : ban) {
                        if(bt.getText().equals(String.valueOf(od.getTable()))) {
                            bt.setEnabled(false);
                        }
                    }
                }
            }
            else if(getHour(Timelabel.getText()) - getHour(od.getTimes()) == 1) {
                if((60 - getMinute(od.getTimes())) + getMinute(Timelabel.getText()) <= 30) {
                    for(JButton bt : ban) {
                        if(bt.getText().equals(String.valueOf(od.getTable()))) {
                            bt.setEnabled(false);
                        }
                    }
                }
            }
        }
    }
    
    void NameAndDate() {
        staffName.setText(staff.getFullname());
        dateLabel.setText(String.valueOf(new SimpleDateFormat("EEEE dd/MM/YYYY").format(new java.util.Date())));
        Timelabel.setText(String.valueOf(new SimpleDateFormat("HH:mm:ss").format(new java.util.Date())));
        billBtn.setEnabled(false);
    }
    
     private void update() {
        Timelabel.setText(String.valueOf(new SimpleDateFormat("HH:mm:ss").format(new java.util.Date())));
        if (tableNumber.getText().equals("0")) {
            Disabled(false);
        } else {
            Disabled(true);
        }
        checkStatus();
    }
    
    private void TinhTrangBan() {
        for (JButton btn : ban) {
            boolean check = loadDataModify.checkTable(Integer.parseInt(btn.getText().toString()));
            if (check) {
                btn.setIcon(icon1);
            } else {
                btn.setIcon(icon3);
            }
        }
    }

    private void Disabled(boolean pay) {
        if (pay == false) {
            categoryCombox.setEnabled(false);
            productCombox.setEnabled(false);
            addBtn.setEnabled(false);
//            billBtn.setEnabled(false);
        } else {
            categoryCombox.setEnabled(true);
            productCombox.setEnabled(true);
            addBtn.setEnabled(true);
//            billBtn.setEnabled(true);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        categoryCombox = new javax.swing.JComboBox<>();
        quantityText = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        ad = new javax.swing.JPanel();
        imgLabel = new javax.swing.JLabel();
        productCombox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        tableMain = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        foodtable = new javax.swing.JTable();
        timeLable = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        staffName = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Timelabel = new javax.swing.JLabel();
        tableNumber = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        ádf = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        totalP = new javax.swing.JLabel();
        billBtn = new javax.swing.JButton();
        homeBtn = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        jLabel4.setText("jLabel4");

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(186, 79, 84));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cangtin Aptech", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N

        addBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addBtn.setForeground(new java.awt.Color(186, 79, 84));
        addBtn.setText("Buy");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        ad.setBackground(new java.awt.Color(255, 255, 255));

        imgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/menu.jpg"))); // NOI18N

        javax.swing.GroupLayout adLayout = new javax.swing.GroupLayout(ad);
        ad.setLayout(adLayout);
        adLayout.setHorizontalGroup(
            adLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        adLayout.setVerticalGroup(
            adLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgLabel)
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Price: ");

        priceLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(255, 255, 255));
        priceLabel.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(categoryCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(productCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(priceLabel)))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(quantityText)
                    .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(ad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(categoryCombox, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(quantityText)
                            .addComponent(productCombox, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(priceLabel))
                        .addGap(70, 70, 70))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel3.setBackground(new java.awt.Color(74, 31, 61));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Desk Manager");

        javax.swing.GroupLayout tableMainLayout = new javax.swing.GroupLayout(tableMain);
        tableMain.setLayout(tableMainLayout);
        tableMainLayout.setHorizontalGroup(
            tableMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
        );
        tableMainLayout.setVerticalGroup(
            tableMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(85, 85, 85)
                .addComponent(tableMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 832, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        foodtable.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        foodtable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        foodtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NO", "Food", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        foodtable.setFocusable(false);
        foodtable.setGridColor(new java.awt.Color(51, 51, 51));
        foodtable.setRowHeight(25);
        foodtable.setRowMargin(0);
        foodtable.setSelectionBackground(new java.awt.Color(232, 57, 95));
        foodtable.setShowHorizontalLines(false);
        foodtable.setShowVerticalLines(false);
        foodtable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(foodtable);
        if (foodtable.getColumnModel().getColumnCount() > 0) {
            foodtable.getColumnModel().getColumn(0).setResizable(false);
            foodtable.getColumnModel().getColumn(1).setResizable(false);
            foodtable.getColumnModel().getColumn(2).setResizable(false);
            foodtable.getColumnModel().getColumn(3).setResizable(false);
        }

        timeLable.setBackground(new java.awt.Color(186, 79, 84));
        timeLable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Table: ");

        staffName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        staffName.setForeground(new java.awt.Color(255, 255, 255));
        staffName.setText("Name");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Day: ");

        Timelabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Timelabel.setForeground(new java.awt.Color(255, 255, 255));
        Timelabel.setText("Time: ");

        tableNumber.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tableNumber.setForeground(new java.awt.Color(255, 255, 255));
        tableNumber.setText("0");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Fullname: ");

        dateLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateLabel.setText("Day: ");

        ádf.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ádf.setForeground(new java.awt.Color(255, 255, 255));
        ádf.setText("Time: ");

        javax.swing.GroupLayout timeLableLayout = new javax.swing.GroupLayout(timeLable);
        timeLable.setLayout(timeLableLayout);
        timeLableLayout.setHorizontalGroup(
            timeLableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timeLableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(timeLableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(timeLableLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tableNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Timelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ádf, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(timeLableLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(staffName)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        timeLableLayout.setVerticalGroup(
            timeLableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timeLableLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(timeLableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tableNumber))
                .addGap(30, 30, 30)
                .addGroup(timeLableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(staffName))
                .addGap(29, 29, 29)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(dateLabel)
                .addGap(32, 32, 32)
                .addComponent(ádf)
                .addGap(18, 18, 18)
                .addComponent(Timelabel)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Total:");

        totalP.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalP.setText("0");

        billBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainProject/Icon/icons8_check_dollar_24px.png"))); // NOI18N
        billBtn.setText("Check Out");
        billBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billBtnActionPerformed(evt);
            }
        });

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
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalP, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(billBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeBtn)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(billBtn)
                            .addComponent(homeBtn)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalP, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timeLable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeLable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeBtnActionPerformed
        // TODO add your handling code here:
        MainFrame.checkStatus = true;
        setVisible(false);
    }//GEN-LAST:event_homeBtnActionPerformed

    private void billBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_billBtnActionPerformed
        // TODO add your handling code here:
        int id = staff.getId();
        int total = 0;
        for (LoadData data : dataList) {
            total += data.getPrice();
        }
        var table = Integer.parseInt(tableNumber.getText());
        var created_at = dateLabel.getText();
        String times = String.valueOf(new SimpleDateFormat("HH:mm:ss").format(new java.util.Date()));
        GetAccount.setOrder(new OrderOff(table, id, total, times));
        GetAccount.setDatalist(dataList);
        Refresh();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MaseJFrom().setVisible(true);
            }
        });
    }//GEN-LAST:event_billBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        if (productCombox.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn sản phẩm để thêm");
        } else {
            var x = quantityText.getText();
            var price = priceLabel.getText().toString().replace(",", "");
           
            int totalProduct = Integer.parseInt(ProductModify.SearchImg(productCombox.getSelectedItem().toString(), "quantity"));
            int table = Integer.parseInt(tableNumber.getText().toString());
            if (Patternform.IsInterger(x.toString())) {
                if (Integer.parseInt(x) > totalProduct) {
                    JOptionPane.showMessageDialog(rootPane, productCombox.getSelectedItem() + " chỉ còn " + totalProduct + "sản phầm.");
                } else {
                    var food = productCombox.getSelectedItem().toString();
                    var total = Integer.parseInt(x);
                    var totalPrice = Integer.parseInt(price) * total;
                    LoadData data = new LoadData(table, food, total, totalPrice);
                    loadDataModify.InsertData(data);
                    dataList = loadDataModify.getDataList(table);
                    int totalFood = 0;
                    for (LoadData data1 : dataList) {
                        totalFood += data1.getPrice();
                    }
                    quantityText.setText("");
                    totalP.setText(Patternform.transformPrice(totalFood).replace(".", ","));
                    Display(dataList);
                    TinhTrangBan();
                    ProductModify.UpdateProduct(productCombox.getSelectedItem().toString(), totalProduct - Integer.parseInt(x));
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Trường này phải là lớn hơn 0");
            }
        }
    }//GEN-LAST:event_addBtnActionPerformed
    private void Refresh() {
        tableNumber.setText("0");
        priceLabel.setText("0");
        totalP.setText("0");
        imgLabel.setIcon(icon4);
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
            java.util.logging.Logger.getLogger(SetPruductJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SetPruductJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SetPruductJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SetPruductJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SetPruductJFrame().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Timelabel;
    private javax.swing.JPanel ad;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton billBtn;
    private javax.swing.JComboBox<String> categoryCombox;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTable foodtable;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JComboBox<String> productCombox;
    private javax.swing.JTextField quantityText;
    private javax.swing.JLabel staffName;
    private javax.swing.JPanel tableMain;
    private javax.swing.JLabel tableNumber;
    private javax.swing.JPanel timeLable;
    private javax.swing.JLabel totalP;
    private javax.swing.JLabel ádf;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void run() {
        while (true) {
            update();
            if (checkEnd == true) {
                TinhTrangBan();
                statusTable++;
                if(statusTable == 3) {
                    statusTable=0;
                    checkEnd = false;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
