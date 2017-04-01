/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package print;

import database.database;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author programmer
 */
public class view extends javax.swing.JFrame {

    /**
     * Creates new form view
     */
    DefaultTableModel model;
    database data;

    public view() {
        initComponents();
        init_tablemodel();
        try {
            data = new database();
            retrieve();
        } catch (SQLException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setLocationRelativeTo(null);
        this.setTitle("الطباعه");
        label1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        label2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        label3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        label4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        amount.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        color_number.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        payed.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        table.setSelectionBackground(Color.green);
        table.setSelectionForeground(Color.black);
        table.setRowHeight(30);
        table.setShowGrid(true);
        table.setGridColor(Color.blue);
        table.setBackground(Color.PINK);
        table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        day_comb.getModel().setSelectedItem("");
        month_comb.getModel().setSelectedItem("");
        year_comp.getModel().setSelectedItem("");

        current_date();
        this.setVisible(true);
    }

    public void current_date() {

        Thread t = new Thread() {

            @Override
            public void run() {

                for (;;) {
                    Calendar c = new GregorianCalendar();
                    int second = c.get(Calendar.SECOND);
                    int minute = c.get(Calendar.MINUTE);
                    int hour = c.get(Calendar.HOUR);
                    int day = c.get(Calendar.DAY_OF_MONTH);
                    int month = c.get(Calendar.MONTH);
                    int year = c.get(Calendar.YEAR);

                    clock.setText("Time    :" + hour + ":" + minute + ":" + second);
                    date.setText("Date    :" + year + "/" + (month + 1) + "/" + day);

                }

            }

        };
        t.start();

    }

    public void retrieve() {
        try {

            ResultSet res = data.retrieve_prints();

            while (res.next()) {

                add_row(res.getDouble("number"), res.getInt("day"), res.getInt("month"), res.getInt("year"), res.getInt("color_number"), res.getDouble("total_price"), res.getDouble("payed"), res.getDouble("charge"));

            }
        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    // create table inside any methode from here
    public void init_tablemodel() {

//        model = (DefaultTableModel) table.getModel();
        model = new DefaultTableModel() {

            boolean[] a = {false, false, false, false, false, false, true, false};

            @Override
            public boolean isCellEditable(int row, int column) {

                return a[column];

            }

        };
        table.setModel(model);
        model.addColumn("العدد/الكميه");
        model.addColumn("اليوم");
        model.addColumn("الشهر");
        model.addColumn("السنه");
        model.addColumn("عددالالوان");
        model.addColumn("السعر الكلي");
        model.addColumn("المدفوع");
        model.addColumn("المتبقى");

    }

    // return table object
    public JTable table() {

        return this.table;

    }

    public DefaultTableModel table_model() {

        return this.model;

    }
    // print button action

    public void action(ActionListener listener) {

        print.addActionListener(listener);

    }

    // delete button actiion
    public void delete_action(ActionListener listener) {

        delete.addActionListener(listener);

    }

// table mouselistener 
    public void table_listener(MouseListener listener) {
        table.addMouseListener(listener);

    }

    // methode validate all texts 
    public void validate_amount(KeyListener k) {

        amount.addKeyListener(k);

    }

    public void validate_number_color(KeyListener k) {

        color_number.addKeyListener(k);
    }

    public void validate_payed(KeyListener k) {

        payed.addKeyListener(k);
    }

    // get textfields 
    public String payedString() {

        return this.payed.getText();

    }

    public String amountString() {

        return this.amount.getText();

    }

    public String color_numberString() {

        return this.color_number.getText();

    }

    public String dayString() {

        return this.day_comb.getSelectedItem().toString();

    }

    public String monthString() {

        return this.month_comb.getSelectedItem().toString();

    }

    public String yearString() {

        return this.year_comp.getSelectedItem().toString();

    }

    // get the values ofStrings 
    public double amount() {

        return Double.parseDouble(this.amount.getText());

    }

    public double payed() {

        return Double.parseDouble(this.payed.getText());

    }

    public int number_color() {

        return Integer.parseInt(this.color_number.getText());

    }

    public int day_box() {

        return Integer.parseInt(this.day_comb.getSelectedItem().toString());

    }

    public int month_box() {

        return Integer.parseInt(this.month_comb.getSelectedItem().toString());

    }

    public int year_box() {

        return Integer.parseInt(this.year_comp.getSelectedItem().toString());

    }
    ///--------------------------------- add button --------------------------

    public void action_ad(ActionListener listener) {

        add.addActionListener(listener);
//        add.setActionCommand("add");
    }
// table keylistener 

    public void table_keylistener(KeyListener listener) {

        table.addKeyListener(listener);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        day_comb = new javax.swing.JComboBox();
        month_comb = new javax.swing.JComboBox();
        year_comp = new javax.swing.JComboBox();
        color_number = new javax.swing.JTextField();
        payed = new javax.swing.JTextField();
        print = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        delete = new javax.swing.JButton();
        clock = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        ll1 = new javax.swing.JLabel();
        ll2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 0));

        label1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label1.setText("العدد");

        label2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label2.setText("التاريخ");

        label3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label3.setText("عددالالوان");

        label4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label4.setText("مدفوع");

        jLabel1.setText("يوم");

        jLabel2.setText("شهر");

        jLabel3.setText("سنه");

        amount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountActionPerformed(evt);
            }
        });
        amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                amountKeyTyped(evt);
            }
        });

        day_comb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        day_comb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        month_comb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        month_comb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        year_comp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        year_comp.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2015", "2016", "2017", "2018", "2019", "2020", "2022", "2023", "2024", "2025" }));

        color_number.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        color_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                color_numberActionPerformed(evt);
            }
        });

        payed.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        payed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payedActionPerformed(evt);
            }
        });

        print.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/print/print.png"))); // NOI18N
        print.setText("طباعه");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });

        add.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/print/add3.png"))); // NOI18N
        add.setText("اضافه");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        table.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        delete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/print/delete.png"))); // NOI18N
        delete.setText("حذف");

        clock.setBackground(new java.awt.Color(0, 255, 255));
        clock.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        clock.setOpaque(true);

        date.setBackground(new java.awt.Color(0, 255, 255));
        date.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        date.setOpaque(true);

        ll1.setBackground(new java.awt.Color(102, 255, 0));
        ll1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ll1.setForeground(new java.awt.Color(0, 0, 153));
        ll1.setOpaque(true);

        ll2.setBackground(new java.awt.Color(51, 204, 0));
        ll2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ll2.setForeground(new java.awt.Color(0, 0, 153));
        ll2.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(clock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                        .addGap(150, 150, 150)
                        .addComponent(delete)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(color_number, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(label3))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(payed, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(26, 26, 26))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(26, 26, 26))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(year_comp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2)
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel1)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(month_comb, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(day_comb, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(34, 34, 34))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(print))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ll1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(ll2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label1)
                            .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel3)
                                .addGap(1, 1, 1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(clock, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label2)
                            .addComponent(year_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(day_comb, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(month_comb, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label3)
                            .addComponent(color_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label4)
                            .addComponent(payed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(ll1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ll2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add)
                            .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountActionPerformed

    private void color_numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_color_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_color_numberActionPerformed

    private void payedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payedActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_printActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void amountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_amountKeyTyped

//    public void 
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JTextField amount;
    private javax.swing.JLabel clock;
    private javax.swing.JTextField color_number;
    private javax.swing.JLabel date;
    private javax.swing.JComboBox day_comb;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel ll1;
    private javax.swing.JLabel ll2;
    private javax.swing.JComboBox month_comb;
    private javax.swing.JTextField payed;
    private javax.swing.JButton print;
    private javax.swing.JTable table;
    private javax.swing.JComboBox year_comp;
    // End of variables declaration//GEN-END:variables

    public void add_row(double number, int day, int month, int year, int colornumber, double total_price, double payed, double charge) {

        model.addRow(new Object[]{number, day, month, year, colornumber, total_price, payed, charge});

    }

    public int getselectedrow() {

        return this.table.getSelectedRow();

    }

    public DefaultTableModel get_table() {

        return this.model;

    }

    public void set_amount(String name) {

        amount.setText(name);

    }

    public void set_day(String day) {
        day_comb.getModel().setSelectedItem(day);

    }

    public void set_month(String month) {
        month_comb.getModel().setSelectedItem(month);

    }

    public void set_year(String year) {
        year_comp.getModel().setSelectedItem(year);

    }

    public void set_color_number(String day) {
        color_number.setText(day);

    }

    public void set_payed(String day) {
        payed.setText(day);

    }

    public void set_ll1(String name) {
        ll1.setText(name);

    }

    public void set_ll2(String name) {
        ll2.setText(name);

    }

//   public void new_() {
//
//   this.
//   }

}
