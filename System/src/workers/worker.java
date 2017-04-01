/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workers;

import database.database;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.HeadlessException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.awt.image.ImageObserver.WIDTH;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collector;
import javax.accessibility.AccessibleText;
import javax.swing.DefaultCellEditor;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ahmed
 */
public class worker extends javax.swing.JFrame {

    /**
     * Creates new form worker
     */
    DefaultTableModel model;
    database data;
    private double week_salary;

    public worker() {
//                month.addItem("");

        try {
            data = new database();
        } catch (SQLException ex) {
            Logger.getLogger(worker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(worker.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        init_tablemodel();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("العماله");

        name.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        day_money.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        days.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        payed.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        label1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        label2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        month.getModel().setSelectedItem("");
        week.getModel().setSelectedItem("");
        table.setSelectionBackground(Color.green);
        table.setSelectionForeground(Color.black);
        table.setRowHeight(30);
        table.setShowGrid(true);
        table.setGridColor(Color.blue);
        table.setBackground(Color.PINK);

        System.out.println();

        retrieve();

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

    public void init_tablemodel() {

//        model = (DefaultTableModel) table.getModel();
        model = new DefaultTableModel() {

            boolean[] a = {false, true, false, false, false, false, false, false};

            @Override
            public boolean isCellEditable(int row, int column) {

                return a[column];

            }

        };
       
        table.setModel(model);
        model.addColumn(" المتبقى");
        model.addColumn("المدفوع");
        model.addColumn("الراتب الاسبوعى");
        model.addColumn("ايام العمل");
        model.addColumn("الراتب اليومى");
        model.addColumn("الاسبوع");
        model.addColumn("الشهر");
        model.addColumn("الاسم");

    }

    // to retrieve data from database 
    public void retrieve() {
        if (data.re()) {

            try {
                ResultSet res = data.retrieve();
                while (res.next()) {

                    add_table(res.getString("name"), res.getInt("month"), res.getInt("week"), res.getDouble("day_salary"), res.getDouble("day_work"), res.getDouble("week_salary"), res.getDouble("payed"), res.getDouble("charge"));

                }
                System.out.println("Done retrieve");
            } catch (SQLException ex) {
                Logger.getLogger(worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error database");

        }
    }
    // empty all cmponents 

    public void new_() {
        name.setText("");
        month.getModel().setSelectedItem("");
        week.getModel().setSelectedItem("");
        day_money.setText("");
        days.setText("");
        payed.setText("");
        label1.setText("");
        label2.setText("");
    }
// delete_all table in the table

    public void add_table(String name, int month, int week, double day_salary, double days, double week_salary, double payed, double charge) {
        model.addRow(new Object[]{charge, payed, week_salary, days, day_salary, week, month, name});

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        days = new javax.swing.JTextField();
        day_money = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        payed = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        add = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        update = new javax.swing.JButton();
        filter_text = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        week = new javax.swing.JComboBox();
        month = new javax.swing.JComboBox();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        clock = new javax.swing.JLabel();
        date = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("الاسم");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("الراتب اليومى");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("أيام العمل");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("مدفوع");

        days.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        days.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daysActionPerformed(evt);
            }
        });
        days.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                daysKeyTyped(evt);
            }
        });

        day_money.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        day_money.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                day_moneyActionPerformed(evt);
            }
        });
        day_money.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                day_moneyKeyTyped(evt);
            }
        });

        name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameKeyTyped(evt);
            }
        });

        payed.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        payed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payedActionPerformed(evt);
            }
        });
        payed.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                payedKeyTyped(evt);
            }
        });

        table.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.setGridColor(new java.awt.Color(0, 0, 0));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tableKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        add.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workers/add3.png"))); // NOI18N
        add.setText("إضافه");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workers/delete.png"))); // NOI18N
        delete.setText("حذف");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        update.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/workers/print.png"))); // NOI18N
        update.setText("طباعه");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        filter_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filter_textActionPerformed(evt);
            }
        });
        filter_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filter_textKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                filter_textKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("الشهر");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("الاسبوع");

        week.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        week.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", " " }));

        month.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        label1.setBackground(new java.awt.Color(204, 204, 255));
        label1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 0, 153));

        label2.setBackground(new java.awt.Color(204, 204, 255));
        label2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label2.setForeground(new java.awt.Color(0, 0, 204));

        clock.setBackground(new java.awt.Color(0, 255, 255));
        clock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        clock.setForeground(new java.awt.Color(102, 0, 102));
        clock.setOpaque(true);

        date.setBackground(new java.awt.Color(0, 255, 255));
        date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        date.setForeground(new java.awt.Color(102, 0, 102));
        date.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(clock, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filter_text, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 945, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(121, 121, 121))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(week, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(day_money, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(payed, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(37, 37, 37)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel1)
                                                .addComponent(jLabel5))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(jLabel3)))))
                                .addGap(51, 51, 51)))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(label2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(188, 188, 188))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(clock, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(delete)
                            .addComponent(filter_text, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addComponent(date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(week, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(day_money, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(payed, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(68, 68, 68)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add)
                            .addComponent(update))
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void daysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daysActionPerformed
        // TODO delete_all your handling code here:
    }//GEN-LAST:event_daysActionPerformed

    private void day_moneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_day_moneyActionPerformed
        // TODO delete_all your handling code here:
    }//GEN-LAST:event_day_moneyActionPerformed

    private void payedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payedActionPerformed
        // TODO delete_all your handling code here:
    }//GEN-LAST:event_payedActionPerformed

    public void delete_row(int number) {

//        table.remove(number);
        model.removeRow(number);

    }

    private void day_moneyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_day_moneyKeyTyped
        // TODO delete_all your handling code here:
        char c = evt.getKeyChar();

        if ((c < '0' || c > '9') && c != '\b') {
            getToolkit().beep();
            evt.consume();
            System.out.println("invalid");
        }
    }//GEN-LAST:event_day_moneyKeyTyped

    private void daysKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_daysKeyTyped
        char c = evt.getKeyChar();

        if ((c < '0' || c > '7') && c != '\b') {
            getToolkit().beep();
            evt.consume();
            System.out.println("invalid");
        }          // TODO delete_all your handling code here:
    }//GEN-LAST:event_daysKeyTyped

    private void payedKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_payedKeyTyped
        char c = evt.getKeyChar();

        if ((c < '0' || c > '9') && c != '\b') {
            getToolkit().beep();
            evt.consume();
            System.out.println("invalid");
        }          // TODO delete_all your handling code here:
    }//GEN-LAST:event_payedKeyTyped

    public void do_filter(String name) {

        TableRowSorter<DefaultTableModel> mod = new TableRowSorter<DefaultTableModel>(model);

        table.setRowSorter(mod);

        mod.setRowFilter(RowFilter.regexFilter(name));

    }

    // لطباعه البيانات من ال table 
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        try {

            table.print(JTable.PrintMode.NORMAL, new MessageFormat("Report print"), new MessageFormat("page{0,number,intege})"));
        } catch (Exception e) {

            e.printStackTrace();
        }
    }//GEN-LAST:event_updateActionPerformed

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed
        // TODO add your handling code here:


    }//GEN-LAST:event_tableKeyPressed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO delete_all your handling code here:

        // if click right click mouse event
        if (SwingUtilities.isRightMouseButton(evt)) {

            JPopupMenu menu = new JPopupMenu();

            JMenuItem delete_all = new JMenuItem("حذف الكل");
            JMenuItem update = new JMenuItem("تعديل !");
            // update action listener
            update.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    int number = table.getSelectedRow();
                    if (number == -1) {

                        JOptionPane.showMessageDialog(null, "اختر العامل ! ");

                    } // لو اختار العامل 
                    else {
                        try {
                            String name = (String) model.getValueAt(number, 7);
                            int month = (int) model.getValueAt(number, 6);
                            int week = (int) model.getValueAt(number, 5);
                            double day_sal = (double) model.getValueAt(number, 4);
                            double days = (double) model.getValueAt(number, 3);
                            double pa = Double.parseDouble(model.getValueAt(number, 1).toString());
//                        double ch = (double) model.getValueAt(number, 0);
                            System.out.println(pa);
                            double total = day_sal * days;
                            double chh = total - pa;
                            System.out.println(chh);

                            if (chh < 0) {

                                int row_count = model.getRowCount();

                                for (int i = row_count - 1; i >= 0; i--) {

                                    delete_row(i);

                                }
                                new_();
                                retrieve();
                                JOptionPane.showMessageDialog(null, "خطأ المدفوع اكبر من المتبقى  ! ");

                            } else {

                                if (data.update_workers(name, month, week, pa, chh)) {

                                    int row_count = model.getRowCount();

                                    for (int i = row_count - 1; i >= 0; i--) {

                                        delete_row(i);

                                    }
                                    new_();
                                    retrieve();
                                    JOptionPane.showMessageDialog(null, "تم التعديل ! ");

                                } else {
                                    JOptionPane.showMessageDialog(null, "Error database ");

                                }

                            }

                        } catch (SQLException ex) {
                            Logger.getLogger(worker.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }

                }
            });

            // delete action listsner
            delete_all.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    //                    table.getColumnModel().getSelectionModel().
                    try {

                        int number = JOptionPane.showConfirmDialog(null, "متاكد من حذف الكل ؟");

                        if (number == 0) {
                            if (data.delete_all()) {

                                int row_count = model.getRowCount();

                                for (int i = row_count - 1; i >= 0; i--) {

                                    delete_row(i);

                                }
                                new_();
                                JOptionPane.showMessageDialog(null, "تم الحذف");

                            } else {

                                JOptionPane.showMessageDialog(null, "Error database");
                            }

                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(worker.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
            menu.add(update);
            menu.add(new JPopupMenu.Separator());

            menu.add(delete_all);
            menu.show(evt.getComponent(), evt.getX(), evt.getY());

        } else {

            int column = table.getSelectedRow();

            name.setText(model.getValueAt(column, 7).toString());
            month.getModel().setSelectedItem(model.getValueAt(column, 6));
            week.getModel().setSelectedItem(model.getValueAt(column, 5));
            day_money.setText(model.getValueAt(column, 4).toString());
            days.setText(model.getValueAt(column, 3).toString());
            label1.setText("الراتب الاسبوعى : " + model.getValueAt(column, 2).toString());
            payed.setText(model.getValueAt(column, 1).toString());
            label2.setText("المتبقى   : " + model.getValueAt(column, 0).toString());
            //            name.setEditable(false);
            //            month.setEnabled(false);
            //            week.setEnabled(false);

        }
    }//GEN-LAST:event_tableMouseClicked

    private void nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyTyped
        // TODO delete_all your handling code here:

        char c = evt.getKeyChar();

        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            //            System.out.println("invalid");
        }
    }//GEN-LAST:event_nameKeyTyped

    private void nameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyReleased
        // TODO delete_all your handling code here:
    }//GEN-LAST:event_nameKeyReleased

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO delete_all your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void filter_textKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filter_textKeyTyped

        char c = evt.getKeyChar();

        if (Character.isDigit(c)) {
            getToolkit().beep();
            evt.consume();
            //            System.out.println("invalid");
        }
        // TODO delete_all your handling code here:
    }//GEN-LAST:event_filter_textKeyTyped

    private void filter_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filter_textKeyReleased
        // TODO delete_all your handling code here:

        do_filter(filter_text.getText());
    }//GEN-LAST:event_filter_textKeyReleased

    private void filter_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filter_textActionPerformed
        // TODO delete_all your handling code here:
    }//GEN-LAST:event_filter_textActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        int row = table.getSelectedRow();
        if (row == -1) {

            JOptionPane.showMessageDialog(null, "اختر العامل من الجدول");
        } else {

            int week = (int) table.getValueAt(row, 5);
            int month = (int) table.getValueAt(row, 6);
            String name = table.getValueAt(row, 7).toString();

            //        System.out.println(name + "   " + month + "   " + week);
            try {

                int number = JOptionPane.showConfirmDialog(null, "متاكد من الحذف ؟");
                // if the number = 0 this will execute
                if (number == 0) {
                    // check if yhe delete successfully in database or not
                    boolean b = data.delete_worker(name, month, week);
                    // if the check is true
                    if (b == true) {

                        // delete from table
                        delete_row(row);
                        //                retrieve();

                    } // if the check is false
                    else {

                        JOptionPane.showMessageDialog(null, "Database error");

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }//GEN-LAST:event_deleteActionPerformed

    // button delete_all
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        if (name.getText().equals("")
                || month.getSelectedItem().equals("")
                || week.getSelectedItem().equals("")
                || day_money.getText().equals("")
                || days.getText().equals("")) {

            if (name.getText().equals("")) {

                JOptionPane.showMessageDialog(null, "ادخل الاسم");

            } else if (month.getSelectedItem().equals("")) {

                JOptionPane.showMessageDialog(null, "اختر الشهر");

            } else if (week.getSelectedItem().equals("")) {

                JOptionPane.showMessageDialog(null, "اختر الاسبوع");

            } else if (day_money.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "ادخل الراتب اليومى");

            } else if (days.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "ادخل ايام العمل");

            }

        } //if the data is completed
        else {

            String nname = name.getText();
            int mmonth = Integer.parseInt(month.getSelectedItem().toString());
            int wweek = Integer.parseInt(week.getSelectedItem().toString());
            double dday_money = Double.parseDouble(day_money.getText());
            double ddays = Double.parseDouble(days.getText());
            try {
                // if database is connection
                if (data.re()) {

                    // if payed is empty
                    if (payed.getText().equals("")) {
                        int ppayed = 0;

                        double week_salary = 7 * dday_money;

                        if (!data.search_worker(nname, mmonth, wweek)) {
                            if (ddays > 7) {
                                JOptionPane.showMessageDialog(null, "ايام العمل اكبر من سبعه ايام");
                            } else {
                                data.insert_worker(nname, mmonth, wweek, dday_money, ddays, week_salary, 0, ddays * dday_money);

                                add_table(nname, mmonth, wweek, dday_money, ddays, week_salary, 0, ddays * dday_money);
                                JOptionPane.showMessageDialog(null, "تمت اضافه العامل");
                                //                            System.out.println("Done");
                                new_();

                            }

                        } // if this person is exist
                        else if (data.search_worker(nname, mmonth, wweek)) {
                            JOptionPane.showMessageDialog(null, "العامل موجود");

                        }

                    } // if payed is exists
                    else {
                        double p = Double.parseDouble(payed.getText());
                        double charge = ddays * dday_money;
                        double week_salary = dday_money * 7;

                        //                        double week_sal = week_salary - p;
                        double ch = charge - p;
                        if (p > charge) {
                            JOptionPane.showMessageDialog(null, "المدفوع اكبر من الباقى ....");
                        } else {

                            if (!data.search_worker(nname, mmonth, wweek)) {
                                if (ddays > 7) {
                                    JOptionPane.showMessageDialog(null, "ايام العمل اكبر من سبعه ايام");
                                } else {
                                    data.insert_worker(nname, mmonth, wweek, dday_money, ddays, week_salary, p, ch);

                                    add_table(nname, mmonth, wweek, dday_money, ddays, week_salary, p, ch);
                                    JOptionPane.showMessageDialog(null, "تمت اضافه العامل");
                                    new_();
                                }
                            } // if this person is exist
                            else if (data.search_worker(nname, mmonth, wweek)) {
                                JOptionPane.showMessageDialog(null, "العامل موجود");

                            }
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Database Error");

                }

            } catch (SQLException ex) {
                Logger.getLogger(worker.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        // TODO delete_all your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void tableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tableKeyTyped

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased
        // TODO add your handling code here:
        
                if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
            int column = table.getSelectedRow();

            name.setText(model.getValueAt(column, 7).toString());
            month.getModel().setSelectedItem(model.getValueAt(column, 6));
            week.getModel().setSelectedItem(model.getValueAt(column, 5));
            day_money.setText(model.getValueAt(column, 4).toString());
            days.setText(model.getValueAt(column, 3).toString());
            label1.setText("الراتب الاسبوعى : " + model.getValueAt(column, 2).toString());
            payed.setText(model.getValueAt(column, 1).toString());
            label2.setText("المتبقى   : " + model.getValueAt(column, 0).toString());


        }


        
    }//GEN-LAST:event_tableKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JLabel clock;
    private javax.swing.JLabel date;
    private javax.swing.JTextField day_money;
    private javax.swing.JTextField days;
    private javax.swing.JButton delete;
    private javax.swing.JTextField filter_text;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JComboBox month;
    private javax.swing.JTextField name;
    private javax.swing.JTextField payed;
    private javax.swing.JTable table;
    private javax.swing.JButton update;
    private javax.swing.JComboBox week;
    // End of variables declaration//GEN-END:variables
}
