/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clients;

import database.database;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author muhammad
 */
public class  Client extends javax.swing.JFrame {

    Toolkit toolkit;
    private ButtonGroup group;

    boolean using_current_date = true;
    boolean using_other_date = false;

    Integer day_form_combo;
    Integer month_form_combo;
    Integer year_form_combo;

    DefaultTableModel dtm;

    String date_from_table;

    public Client() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

        initComponents();
        pay.setEnabled(false);

        jTable1.setRowHeight(25);
        jTable1.setFont(new Font("Arial", Font.PLAIN, 16));

        jTable1.setModel(new database().retrieve_all());

        add.setEnabled(false);

        client_name_t.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        cardboard_sort_t.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        amount_t.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        price_t.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        payed_t.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        searchTXT.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        amount_t.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || e.getKeyChar() == '.') {
                } else {
                    e.consume();
                }
            }
        });

        price_t.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || e.getKeyChar() == '.') {
                } else {
                    e.consume();
                }
            }
        });

        payed_t.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || e.getKeyChar() == '.') {
                } else {
                    e.consume();
                }
            }
        });
        payed_money.addKeyListener(new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9' || e.getKeyChar() == '.') {
                } else {
                    e.consume();
                }
            }
        });

//        try {
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        } catch (UnsupportedLookAndFeelException e) {
//            System.out.println(e.getMessage());
//        }
        current_date_RADIO.setSelected(true);

        group = new ButtonGroup();
        group.add(current_date_RADIO);
        group.add(custom_date_RADIO);

//        toolkit = Toolkit.getDefaultToolkit();
//        Dimension screenSize = toolkit.getScreenSize();
//        int screenWidth = screenSize.width;
//        int screenHeight = screenSize.height;
//        super.setSize(screenWidth, screenHeight);

        super.setLocationRelativeTo(null);
//        setLayout(null);
        super.setResizable(false);

    }

    // FILTER method
    public void filter(String query) throws ClassNotFoundException, SQLException {
        dtm = new database().retrieve_all();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtm);
        jTable1.setRowSorter(tr);

        tr.sort();
        tr.setRowFilter(RowFilter.regexFilter("^" + query));

//        tr.setRowFilter(RowFilter.regexFilter("^"+query+"$"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        client_name = new javax.swing.JLabel();
        cardboard_sort_t = new javax.swing.JTextField();
        amount = new javax.swing.JLabel();
        client_name_t = new javax.swing.JTextField();
        cardboard_sort = new javax.swing.JLabel();
        amount_t = new javax.swing.JTextField();
        price = new javax.swing.JLabel();
        payed = new javax.swing.JLabel();
        price_t = new javax.swing.JTextField();
        payed_t = new javax.swing.JTextField();
        calculate = new javax.swing.JButton();
        net_price = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        net_price_money = new javax.swing.JLabel();
        remaining = new javax.swing.JLabel();
        panel2 = new java.awt.Panel();
        remaining_money = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        custom_date_RADIO = new javax.swing.JRadioButton();
        current_date_RADIO = new javax.swing.JRadioButton();
        dayLBL = new javax.swing.JLabel();
        dayCOMBO = new javax.swing.JComboBox();
        yearLBL = new javax.swing.JLabel();
        monthLBL = new javax.swing.JLabel();
        monthCOMBO = new javax.swing.JComboBox();
        yearCOMBO = new javax.swing.JComboBox();
        searchLBL = new javax.swing.JLabel();
        searchTXT = new javax.swing.JTextField();
        delete = new javax.swing.JButton();
        dateLBL = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pay = new javax.swing.JButton();
        payed_money = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("العميل");
        setSize(new java.awt.Dimension(800, 500));

        client_name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        client_name.setText("اسم العميل :");

        cardboard_sort_t.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        cardboard_sort_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardboard_sort_tActionPerformed(evt);
            }
        });

        amount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        amount.setText("الكميه         :");

        client_name_t.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        client_name_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                client_name_tActionPerformed(evt);
            }
        });

        cardboard_sort.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cardboard_sort.setText("نوع الكرتونه   :");

        amount_t.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        amount_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amount_tActionPerformed(evt);
            }
        });

        price.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        price.setText("سعر الكرتونه :");

        payed.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        payed.setText("تحصيل        :");

        price_t.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        price_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                price_tActionPerformed(evt);
            }
        });

        payed_t.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        payed_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payed_tActionPerformed(evt);
            }
        });

        calculate.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        calculate.setText("حساب");
        calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateActionPerformed(evt);
            }
        });

        net_price.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        net_price.setText("السعر الكلى :");

        panel1.setBackground(new java.awt.Color(0, 0, 102));
        panel1.setForeground(new java.awt.Color(255, 255, 255));

        net_price_money.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        net_price_money.setForeground(new java.awt.Color(255, 255, 255));
        net_price_money.setText("0000.00");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(net_price_money, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(net_price_money, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        remaining.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        remaining.setText("الباقى         :");

        panel2.setBackground(new java.awt.Color(0, 0, 102));
        panel2.setForeground(new java.awt.Color(255, 255, 255));

        remaining_money.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        remaining_money.setForeground(new java.awt.Color(255, 255, 255));
        remaining_money.setText("0000.00");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(remaining_money, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(remaining_money, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add.setText("اضافه");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        custom_date_RADIO.setText("تاريخ اخر");
        custom_date_RADIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custom_date_RADIOActionPerformed(evt);
            }
        });

        current_date_RADIO.setText("التاريخ الحالى ");
        current_date_RADIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                current_date_RADIOActionPerformed(evt);
            }
        });

        dayLBL.setText("اليوم :");

        dayCOMBO.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1\t", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        dayCOMBO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayCOMBOActionPerformed(evt);
            }
        });

        yearLBL.setText("السنه :");

        monthLBL.setText("الشهر :");

        monthCOMBO.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1\t", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        monthCOMBO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthCOMBOActionPerformed(evt);
            }
        });

        yearCOMBO.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2030", "2031", "2032", "2034", "2035", "2036", "2037", "2038", "2039", "2040", " " }));
        yearCOMBO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearCOMBOActionPerformed(evt);
            }
        });

        searchLBL.setText("البحث عن عميل :");

        searchTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTXTActionPerformed(evt);
            }
        });
        searchTXT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTXTKeyTyped(evt);
            }
        });

        delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 0, 51));
        delete.setText("مسح");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setToolTipText("");
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        pay.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pay.setText("سداد");
        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });

        payed_money.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(yearCOMBO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(yearLBL)
                                .addGap(18, 18, 18)
                                .addComponent(monthCOMBO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(monthLBL)
                                .addGap(14, 14, 14)
                                .addComponent(dayCOMBO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dayLBL)
                                .addGap(18, 18, 18)
                                .addComponent(custom_date_RADIO, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(current_date_RADIO, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(net_price, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(remaining, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cardboard_sort_t, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(client_name_t, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(amount_t, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(price_t, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(payed_t, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(delete)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(payed_money)
                                    .addComponent(pay, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                                .addGap(106, 106, 106)
                                .addComponent(calculate, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(payed, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(client_name)
                            .addComponent(cardboard_sort))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(searchTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchLBL))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(879, 879, 879)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(client_name)
                            .addComponent(client_name_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(net_price)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(price)
                                            .addComponent(price_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(amount_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(amount)))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(payed)
                                    .addComponent(payed_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(remaining)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cardboard_sort_t, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cardboard_sort)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(calculate, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(payed_money, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pay)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(custom_date_RADIO)
                    .addComponent(current_date_RADIO)
                    .addComponent(dayLBL)
                    .addComponent(dayCOMBO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthLBL)
                    .addComponent(monthCOMBO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearLBL)
                    .addComponent(yearCOMBO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchLBL)
                    .addComponent(searchTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cardboard_sort_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardboard_sort_tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cardboard_sort_tActionPerformed

    private void client_name_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_client_name_tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_client_name_tActionPerformed

    private void amount_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amount_tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amount_tActionPerformed

    private void price_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_price_tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_price_tActionPerformed

    private void payed_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payed_tActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payed_tActionPerformed

    private void calculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateActionPerformed

        if (amount_t.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "حقل العدد فارغ", "خطأ", JOptionPane.ERROR_MESSAGE);

        } else if (price_t.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "حقل سعر الكرتونه فارغ", "خطأ", JOptionPane.ERROR_MESSAGE);

        } else {
            Double net_price = Double.parseDouble(amount_t.getText()) * Double.parseDouble(price_t.getText());

            if (payed_t.getText().length() == 0) {
                DecimalFormat myFormatter = new DecimalFormat("000000.00");
                String output = myFormatter.format(net_price);
                net_price_money.setText(output);

                String[] options = {"سداد", "اضافه"};

                int ans = JOptionPane.showOptionDialog(null, "العمليه القادمة تعديل أم اضافه ؟ ", "delete confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                if (ans == 0) {
                    pay.setEnabled(true);
                    add.setEnabled(false);
                    client_name_t.setEditable(false);
                    cardboard_sort_t.setEditable(false);
                } else {
                    add.setEnabled(true);
                    pay.setEnabled(false);
                }

            } else {
                DecimalFormat myFormatter = new DecimalFormat("000000.00");
                String output = myFormatter.format(net_price);
                net_price_money.setText(output);

                Double remaining = (net_price - Double.parseDouble(payed_t.getText()));
                String output2 = myFormatter.format(remaining);
                remaining_money.setText(output2);

                String[] options = {"سداد", "اضافه"};

                int ans = JOptionPane.showOptionDialog(null, "العمليه القادمة تعديل أم اضافه ؟ ", "delete confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                if (ans == 0) {
                    pay.setEnabled(true);
                    add.setEnabled(false);

                    client_name_t.setEditable(false);
                    cardboard_sort_t.setEditable(false);
                } else {
                    add.setEnabled(true);
                    pay.setEnabled(false);
                }
            }
        }

    }//GEN-LAST:event_calculateActionPerformed

    private void custom_date_RADIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custom_date_RADIOActionPerformed
        if (custom_date_RADIO.isSelected()) {
            using_current_date = false;
            using_other_date = true;
        }
    }//GEN-LAST:event_custom_date_RADIOActionPerformed

    private void current_date_RADIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_current_date_RADIOActionPerformed
        if (current_date_RADIO.isSelected()) {
            using_current_date = true;
            using_other_date = false;

        }

    }//GEN-LAST:event_current_date_RADIOActionPerformed

    private void dayCOMBOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayCOMBOActionPerformed
        Integer[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
        day_form_combo = days[dayCOMBO.getSelectedIndex()];
    }//GEN-LAST:event_dayCOMBOActionPerformed

    private void monthCOMBOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthCOMBOActionPerformed
        Integer[] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        month_form_combo = months[monthCOMBO.getSelectedIndex()];
    }//GEN-LAST:event_monthCOMBOActionPerformed

    private void yearCOMBOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearCOMBOActionPerformed
        Integer[] years = {2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023, 2024, 2025, 2026, 2027,
            2028, 2029, 2030, 2031, 2032, 2033, 2034, 2035, 2036, 2037, 2038, 2039, 2040};
        year_form_combo = years[yearCOMBO.getSelectedIndex()];
    }//GEN-LAST:event_yearCOMBOActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        try {
            database db = new database();
            ResultSet re = db.check();

            int dd;
            int mm;
            int yy;
            String d;
            String m;
            String y;
            String date;

            String name_db;
            String sort_db;
            int day_db;
            int month_db;
            int year_db;
            int amount_db = 0;
            float price_db;
            double net_price_db = 0;
            double payed_db = 0;
            double remain_db = 0;

            boolean bool = false;

            if (client_name_t.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "حقل الاسم فارغ", "خطأ", JOptionPane.ERROR_MESSAGE);
            } else if (cardboard_sort_t.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "حقل نوع الكرتونه فارغ", "خطأ", JOptionPane.ERROR_MESSAGE);
            } else {
                if (using_current_date) {
//                    dd = Calendar.DAY_OF_WEEK_IN_MONTH;
                    Calendar cal = Calendar.getInstance();
                    dd = cal.get(Calendar.DAY_OF_MONTH);
//                    System.out.println(dd);
                    mm = (new Date().getMonth() + 1);
                    yy = (new Date().getYear() + 1900);

                } else {
                    dd = day_form_combo;
                    mm = month_form_combo;
                    yy = year_form_combo;

                }

                String name = client_name_t.getText();
                String sort = cardboard_sort_t.getText();
                int day = dd;
                int month = mm;
                int year = yy;

                int amount = Integer.parseInt(amount_t.getText());
                float price = Float.parseFloat(price_t.getText());
                double net_price = Double.parseDouble(net_price_money.getText());
                double payed = Double.parseDouble(payed_t.getText());
                double remain = Double.parseDouble(remaining_money.getText());

                while (re.next()) {
                    name_db = re.getString("client_name");
                    sort_db = re.getString("cardboard_sort");
                    day_db = re.getInt("day");
                    month_db = re.getInt("month");
                    year_db = re.getInt("year");
                    amount_db = re.getInt("amount");
                    price_db = re.getFloat("cardboard_price");
                    net_price_db = re.getDouble("net_price");
                    payed_db = re.getDouble("payed");
                    remain_db = re.getDouble("remainning");

                    if (name_db.equals(name) && sort_db.equals(sort) && day_db == day && month_db == month && year_db == year) {
                        bool = true;
                        break;
                    }
                }

                if (bool) {
                    Integer new_amount;
                    Double new_net_price;
                    Double new_payed;
                    Double new_remainning;

                    new_amount = amount_db + amount;
                    new_net_price = net_price_db + net_price;
                    new_payed = payed_db + payed;
                    new_remainning = remain_db + remain;

                    db.insert_when_the_record_is_found_in_the_table(name, sort, day, month, year, new_amount, price, new_net_price, new_payed, new_remainning);

                    JOptionPane.showMessageDialog(null, "تمت الإضافة بنجاح");

                    client_name_t.setText("");
                    cardboard_sort_t.setText("");
                    amount_t.setText("");
                    price_t.setText("");
                    payed_t.setText("");
                    net_price_money.setText("");
                    remaining_money.setText("");
                    dateLBL.setText("");

                    jTable1.setModel(new database().retrieve_all());
                    add.setEnabled(false);
                } else {
                    db.insert_when_the_record_is_not_found_in_the_table(name, sort, day, month, year, amount, price, net_price, payed, remain);

                    client_name_t.setText("");
                    cardboard_sort_t.setText("");
                    amount_t.setText("");
                    price_t.setText("");
                    payed_t.setText("");
                    net_price_money.setText("");
                    remaining_money.setText("");
                    dateLBL.setText("");

                    JOptionPane.showMessageDialog(null, "تمت الإضافة بنجاح");
                    jTable1.setModel(db.retrieve_all());

                    add.setEnabled(false);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addActionPerformed

    private void searchTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTXTActionPerformed

    private void searchTXTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTXTKeyTyped
        try {
            String query = searchTXT.getText();
            filter(query);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchTXTKeyTyped

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        try {
            String[] options = {"تأكيد", "الغاء"};

            database db = new database();
            ResultSet re = db.check();
            boolean bool = false;

            int index = jTable1.getSelectedRow();
            System.out.println(index);
            if (!(index == -1)) {

                String name = jTable1.getValueAt(index, 0).toString();
                String sort = jTable1.getValueAt(index, 1).toString();
                String date = jTable1.getValueAt(index, 2).toString();

                String name_db;
                String sort_db;
                Integer day_db;
                Integer month_db;
                Integer year_db;
                String date_db;

                while (re.next()) {
                    name_db = re.getString("client_name");
                    sort_db = re.getString("cardboard_sort");

                    day_db = re.getInt("day");
                    month_db = re.getInt("month");
                    year_db = re.getInt("year");

                    date_db = day_db.toString() + "/" + month_db.toString() + "/" + year_db.toString();

                    if (name_db.equals(name) && sort_db.equals(sort) && date_db.equals(date_from_table)) {
                        bool = true;
                        break;
                    }
                }

                if (client_name_t.getText().equals("") || cardboard_sort_t.getText().equals("") || dateLBL.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "من فضلك قم بالاختيار من الجدول بالضغط على ذر الفأرة الأيسر", "خطأ", JOptionPane.ERROR_MESSAGE);
                } else {
                    int ans = JOptionPane.showOptionDialog(null, "هل انت متأكد من الحذف ؟", "تأكيد الجذف", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                    if (ans == 0) {
                        int index_index = jTable1.getSelectedRow();
//                    String id = jTable1.getValueAt(index, 0).toString();

                        try {

                            System.out.println(name + ", " + sort + ", " + date + " == " + date_from_table);

                            String dd = "";
                            String mm = "";
                            String yy = "";
                            int x = 0;

                            for (int i = 0; i < date_from_table.length(); i++) {
                                if (date_from_table.charAt(i) == '/') {
                                    x += 1;
                                    continue;
                                } else {
                                    if (x == 0) {
                                        dd += date_from_table.valueOf(date_from_table.charAt(i));
                                    } else if (x == 1) {
                                        mm += date_from_table.valueOf(date_from_table.charAt(i));
                                    } else {
                                        yy += date_from_table.valueOf(date_from_table.charAt(i));
                                    }
                                }

                            }

                            db.delete(name, sort, Integer.parseInt(dd), Integer.parseInt(mm), Integer.parseInt(yy));
                            System.out.println(dd + ", " + mm + ", " + yy);

                            JOptionPane.showMessageDialog(null, "تم الحذف بنجاح");

                            client_name_t.setText("");
                            cardboard_sort_t.setText("");
                            amount_t.setText("");
                            price_t.setText("");
                            payed_t.setText("");
                            net_price_money.setText("0000.00");
                            remaining_money.setText("0000.00");
                            dateLBL.setText("");

                            jTable1.setModel(db.retrieve_all());

                        } catch (SQLException ex) {
                            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "لم تتم عملية الحذف", "error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "من فضلك قم بالاختيار من الجدول بالضغط على ذر الفأرة الأيسر", "خطأ", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        if (evt.isMetaDown()) {

        } else if (evt.isAltDown()) {

        } else {
            String name = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            String sort = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
            date_from_table = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
            String amount = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
            String price = jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();
            String net_price = jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString();
            String payed = jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString();
            String remain = jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString();

            client_name_t.setText(name);
            cardboard_sort_t.setText(sort);
            amount_t.setText(amount);
            price_t.setText(price);
            payed_t.setText(payed);
            net_price_money.setText(net_price);
            remaining_money.setText(remain);
            dateLBL.setText(date_from_table);
        }


    }//GEN-LAST:event_jTable1MouseClicked

    database d = new database();
    private void payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payActionPerformed
        try {

            if (payed_money.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "من فضلك ادخل قيمة السداد", "خطأ", JOptionPane.ERROR_MESSAGE);
            } else {
                Double new_payed = Double.parseDouble(payed_money.getText());
                Double all_payed = new_payed + Double.parseDouble(payed_t.getText());
                Double all_remaining = Double.parseDouble(net_price_money.getText()) - all_payed;
                Double remain = Double.parseDouble(remaining_money.getText()) - new_payed;

                String dd = "";
                String mm = "";
                String yy = "";
                int x = 0;

                for (int i = 0; i < date_from_table.length(); i++) {
                    if (date_from_table.charAt(i) == '/') {
                        x += 1;
                        continue;
                    } else {
                        if (x == 0) {
                            dd += date_from_table.valueOf(date_from_table.charAt(i));
                        } else if (x == 1) {
                            mm += date_from_table.valueOf(date_from_table.charAt(i));
                        } else {
                            yy += date_from_table.valueOf(date_from_table.charAt(i));
                        }
                    }

                }

                d.update2(client_name_t.getText(), cardboard_sort_t.getText(), Integer.parseInt(dd),
                        Integer.parseInt(mm), Integer.parseInt(yy), Double.parseDouble(net_price_money.getText()), all_payed, all_remaining);
                jTable1.setModel(d.retrieve_all());
                
                JOptionPane.showMessageDialog(null, "تم السداد بنجاح والمتبقى اصبح " + all_remaining);
                client_name_t.setText("");
                cardboard_sort_t.setText("");
                amount_t.setText("");
                price_t.setText("");
                payed_t.setText("");
                net_price_money.setText("");
                remaining_money.setText("");
                dateLBL.setText("");
                payed_money.setText("");
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_payActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_UP || evt.getKeyCode()==KeyEvent.VK_DOWN){
              String name = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            String sort = jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString();
            date_from_table = jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString();
            String amount = jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString();
            String price = jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString();
            String net_price = jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString();
            String payed = jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString();
            String remain = jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString();

            client_name_t.setText(name);
            cardboard_sort_t.setText(sort);
            amount_t.setText(amount);
            price_t.setText(price);
            payed_t.setText(payed);
            net_price_money.setText(net_price);
            remaining_money.setText(remain);
            dateLBL.setText(date_from_table);
        
        
        }
        
        
    }//GEN-LAST:event_jTable1KeyPressed

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
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Client client = new Client();

                    client.setVisible(true);
                    client.setResizable(false);

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JLabel amount;
    private javax.swing.JTextField amount_t;
    private javax.swing.JButton calculate;
    private javax.swing.JLabel cardboard_sort;
    private javax.swing.JTextField cardboard_sort_t;
    private javax.swing.JLabel client_name;
    private javax.swing.JTextField client_name_t;
    private javax.swing.JRadioButton current_date_RADIO;
    private javax.swing.JRadioButton custom_date_RADIO;
    private javax.swing.JLabel dateLBL;
    private javax.swing.JComboBox dayCOMBO;
    private javax.swing.JLabel dayLBL;
    private javax.swing.JButton delete;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox monthCOMBO;
    private javax.swing.JLabel monthLBL;
    private javax.swing.JLabel net_price;
    private javax.swing.JLabel net_price_money;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private javax.swing.JButton pay;
    private javax.swing.JLabel payed;
    private javax.swing.JTextField payed_money;
    private javax.swing.JTextField payed_t;
    private javax.swing.JLabel price;
    private javax.swing.JTextField price_t;
    private javax.swing.JLabel remaining;
    private javax.swing.JLabel remaining_money;
    private javax.swing.JLabel searchLBL;
    private javax.swing.JTextField searchTXT;
    private javax.swing.JComboBox yearCOMBO;
    private javax.swing.JLabel yearLBL;
    // End of variables declaration//GEN-END:variables
}
