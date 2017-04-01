/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package print;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import workers.worker;

/**
 *
 * @author programmer
 */
public class model {

    database.database data;

    public model() {

        try {
            data = new database.database();
        } catch (SQLException ex) {
            Logger.getLogger(model.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(model.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void validate_number(KeyEvent e) {

        char c = e.getKeyChar();
        if (!Character.isDigit(c)) {
            e.consume();

        }

    }

    // action button add
    public void action_add(double number, int day, int month, int year, int colornumber, double total_price, double payed, double charge) {

        try {
            data.insert_print(number, day, month, year, colornumber, total_price, payed, charge);

        } catch (SQLException ex) {
            Logger.getLogger(model.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void joption(String message) {

        JOptionPane.showMessageDialog(null, message);

    }

    int check_print(double amount, int day, int month, int year) throws SQLException {

        return data.check_print(amount, day, month, year);

    }

    void add_elemnt(view v) {

        int row_select = v.getselectedrow();

        DefaultTableModel model = v.get_table();
        v.set_amount(model.getValueAt(row_select, 0) + "");
        v.set_day(model.getValueAt(row_select, 1) + "");
        v.set_month(model.getValueAt(row_select, 2) + "");
        v.set_year(model.getValueAt(row_select, 3) + "");
        v.set_color_number(model.getValueAt(row_select, 4) + "");
        v.set_payed(model.getValueAt(row_select, 6) + "");
        v.set_ll1(" الراتب الكلي  :  " + model.getValueAt(row_select, 5) + "");
        v.set_ll2("المتبقى   : " + model.getValueAt(row_select, 7) + "");

    }

    void print_action(JTable table) {

        try {
            table.print(JTable.PrintMode.NORMAL, new MessageFormat("Report print"), new MessageFormat("page{0,number,intege})"));
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void delete_action(JTable table, DefaultTableModel mo , view v) {
        int row = table.getSelectedRow();
        if (row == -1) {

            joption("اختر الطباعه من الجدول !!");

        } else {
            int number = JOptionPane.showConfirmDialog(null, "متاكدمن الحذف ؟");
            if (number == 0) {
                double amount = (double) table.getValueAt(row, 0);

                int day = (int) table.getValueAt(row, 1);
                int month = (int) table.getValueAt(row, 2);
                int year = (int) table.getValueAt(row, 3);

                boolean f = false;
                try {
                    f = data.delete_print(amount, day, month, year);
                } catch (SQLException ex) {
                    Logger.getLogger(model.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (f == true) {

//        model.remo
                    mo.removeRow(row);
                    new_(v);
                    joption("تم الحذف ");

                } else {

                    joption("لم يتم الحذف");
                }

            }

        }

    }

    public void new_(view v) {
        v.set_amount("");
        v.set_color_number("");
        v.set_day("");
        v.set_ll1("");
        v.set_ll2("");
        v.set_month("");
        v.set_payed("");
        v.set_year("");

    }

    public void click_right(MouseEvent e, DefaultTableModel model, view v) {

        JPopupMenu menu = new JPopupMenu();
        JMenuItem delete_all = new JMenuItem("حذف الكل");
        JMenuItem update = new JMenuItem("تعديل !");

        // update the table 
        update.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int row = v.getselectedrow();
                if (row == -1) {

                    joption("اختر من الجدول");

                } else {

                    int n = v.getselectedrow();

                    double num = (double) model.getValueAt(n, 0);
                    int day = (int) model.getValueAt(n, 1);
                    int month = (int) model.getValueAt(n, 2);
                    int year = (int) model.getValueAt(n, 3);
                    int color_number = (int) model.getValueAt(n, 4);
                    double total_price = color_number * 3.5;
                    double payed = Double.parseDouble(model.getValueAt(n, 6).toString());
                    double charge = total_price - payed;

                    if (charge < 0) {

                        int row_count = model.getRowCount();
                        for (int i = row_count - 1; i >= 0; i--) {

                            model.removeRow(i);

                        }
                        new_(v);
                        v.retrieve();
                        joption("المدفوع اكبر من السعر الكلى");

                    } else {

                        int number = JOptionPane.showConfirmDialog(null, "هل تريد التعديل ؟ ");
                        if (number == 0) {

                            try {
                                if(data.update_print(num,day,month,year,payed,charge)){
                                    
                                    int row_count = model.getRowCount();
                                    for (int i = row_count - 1; i >= 0; i--) {
                                        
                                        model.removeRow(i);
                                        
                                    }
                                    new_(v);
                                    v.retrieve();
                                    joption("تم التعديل");
                                }else
                                {
                                    
                                    joption("database error");
                                    
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(model.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }

                }

            }

        }
        );
        // delete all action 
        delete_all.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {

                        int number = JOptionPane.showConfirmDialog(null, "متاكد من حذف الكل ؟");
                        if (number == 0) {
                            try {
                                if (data.delete_all_print()) {

                                    int row_count = model.getRowCount();

                                    for (int i = row_count - 1; i >= 0; i--) {

//                                    delete_row(i);
                                        model.removeRow(i);

                                    }
                                    new_(v);
                                    JOptionPane.showMessageDialog(null, "تم الحذف");

                                } else {

                                    JOptionPane.showMessageDialog(null, "Error database");
                                }
                            } catch (SQLException ex) {
                                Logger.getLogger(model.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }

                    }
                }
        );

        menu.add(update);

        menu.add(
                new JPopupMenu.Separator());
        menu.add(delete_all);

        menu.show(e.getComponent(), e.getX(), e.getY());

    }

}
