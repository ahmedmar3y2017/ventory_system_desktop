/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package print;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author programmer
 */
public class controller {

    public controller() {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                view v = new view();
                v.setVisible(true);

                model m = new model();
                //                 validate_amount all texts
                // methode validate_amount textfield 
                v.validate_amount(new KeyAdapter() {

                    @Override
                    public void keyTyped(KeyEvent e) {

                        m.validate_number(e);

                    }

                });
                v.validate_number_color(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                        m.validate_number(e);

                    }
                });
                v.validate_payed(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                        m.validate_number(e);

                    }
                });
                // action add button 
                v.action_ad(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (v.amountString().equals("")
                                || v.dayString().equals("")
                                || v.monthString().equals("")
                                || v.yearString().equals("")
                                || v.color_numberString().equals("")) {
                            if (v.amountString().equals("")) {

                                m.joption("ادخل الكميه");

                            } else if (v.dayString().equals("")) {
                                m.joption("اختر اليوم");

                            } else if (v.monthString().equals("")) {
                                m.joption("اختر الشهر");

                            } else if (v.yearString().equals("")) {
                                m.joption("اختر السنه");

                            } else if (v.color_numberString().equals("")) {
                                m.joption("ادخل عدد الالوان");

                            }
                        } else {
                            if (v.payedString().equals("")) {

                                double amount = v.amount();
                                int day = v.day_box();
                                int month = v.month_box();
                                int year = v.year_box();

                                try {
                                    int number = m.check_print(amount, day, month, year);
                                    if (number == 1) {

                                        double total_price = v.number_color() * 3.5;

                                        m.action_add(v.amount(), v.day_box(), v.month_box(), v.year_box(), v.number_color(), total_price, 0, total_price);
                                        v.add_row(v.amount(), v.day_box(), v.month_box(), v.year_box(), v.number_color(), total_price, 0, total_price);
                                        m.new_(v);

                                        m.joption("تمت الاضافه !");

                                    } else {
                                        m.joption("موجود");

                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } else if (!v.payedString().equals("")) {
                                double amount = v.amount();
                                int day = v.day_box();
                                int month = v.month_box();
                                int year = v.year_box();

                                try {
                                    int number = m.check_print(amount, day, month, year);
                                    if (number == 1) {

                                        double total_price = v.number_color() * 3.5;
                                        double ch = total_price - v.payed();
                                        m.action_add(v.amount(), v.day_box(), v.month_box(), v.year_box(), v.number_color(), total_price, v.payed(), ch);
                                        v.add_row(v.amount(), v.day_box(), v.month_box(), v.year_box(), v.number_color(), total_price, v.payed(), ch);
                                        m.new_(v);

                                        m.joption("تمت الاضافه !");

                                    } else {
                                        m.joption("موجود");

                                    }
                                } catch (SQLException ex) {
                                    Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                });
                v.table_listener(new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {

                        // فى حاله الضط على اليمين 
                        if (SwingUtilities.isRightMouseButton(e)) {
                            m.click_right(e, v.table_model(), v);

                        } else {
                            m.add_elemnt(v);
                        }

                    }

                });
                v.table_keylistener(new KeyAdapter() {

                    @Override
                    public void keyReleased(KeyEvent e) {

                        m.add_elemnt(v);

                    }

                });
                // print button action
                v.action(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        m.print_action(v.table());

                    }
                });
                // delete button action 
                v.delete_action(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        m.delete_action(v.table(), v.table_model(),v);

                    }
                });
            }

        });
 
//                view v = new view();
//                v.setVisible(true);
//
//                model m = new model();
//                //                 validate_amount all texts
//                // methode validate_amount textfield 
//                v.validate_amount(new KeyAdapter() {
//
//                    @Override
//                    public void keyTyped(KeyEvent e) {
//
//                        m.validate_number(e);
//
//                    }
//
//                });
//                v.validate_number_color(new KeyAdapter() {
//                    @Override
//                    public void keyTyped(KeyEvent e) {
//
//                        m.validate_number(e);
//
//                    }
//                });
//                v.validate_payed(new KeyAdapter() {
//                    @Override
//                    public void keyTyped(KeyEvent e) {
//
//                        m.validate_number(e);
//
//                    }
//                });
//                // action add button 
//                v.action_ad(new ActionListener() {
//
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//
//                        if (v.amountString().equals("")
//                                || v.dayString().equals("")
//                                || v.monthString().equals("")
//                                || v.yearString().equals("")
//                                || v.color_numberString().equals("")) {
//                            if (v.amountString().equals("")) {
//
//                                m.joption("ادخل الكميه");
//
//                            } else if (v.dayString().equals("")) {
//                                m.joption("اختر اليوم");
//
//                            } else if (v.monthString().equals("")) {
//                                m.joption("اختر الشهر");
//
//                            } else if (v.yearString().equals("")) {
//                                m.joption("اختر السنه");
//
//                            } else if (v.color_numberString().equals("")) {
//                                m.joption("ادخل عدد الالوان");
//
//                            }
//                        } else {
//                            if (v.payedString().equals("")) {
//
//                                double amount = v.amount();
//                                int day = v.day_box();
//                                int month = v.month_box();
//                                int year = v.year_box();
//
//                                try {
//                                    int number = m.check_print(amount, day, month, year);
//                                    if (number == 1) {
//
//                                        double total_price = v.number_color() * 3.5;
//
//                                        m.action_add(v.amount(), v.day_box(), v.month_box(), v.year_box(), v.number_color(), total_price, 0, total_price);
//                                        v.add_row(v.amount(), v.day_box(), v.month_box(), v.year_box(), v.number_color(), total_price, 0, total_price);
//                                        m.new_(v);
//
//                                        m.joption("تمت الاضافه !");
//
//                                    } else {
//                                        m.joption("موجود");
//
//                                    }
//                                } catch (SQLException ex) {
//                                    Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
//                                }
//                            } else if (!v.payedString().equals("")) {
//                                double amount = v.amount();
//                                int day = v.day_box();
//                                int month = v.month_box();
//                                int year = v.year_box();
//
//                                try {
//                                    int number = m.check_print(amount, day, month, year);
//                                    if (number == 1) {
//
//                                        double total_price = v.number_color() * 3.5;
//                                        double ch = total_price - v.payed();
//                                        m.action_add(v.amount(), v.day_box(), v.month_box(), v.year_box(), v.number_color(), total_price, v.payed(), ch);
//                                        v.add_row(v.amount(), v.day_box(), v.month_box(), v.year_box(), v.number_color(), total_price, v.payed(), ch);
//                                        m.new_(v);
//
//                                        m.joption("تمت الاضافه !");
//
//                                    } else {
//                                        m.joption("موجود");
//
//                                    }
//                                } catch (SQLException ex) {
//                                    Logger.getLogger(controller.class.getName()).log(Level.SEVERE, null, ex);
//                                }
//                            }
//                        }
//                    }
//                });
//                v.table_listener(new MouseAdapter() {
//
//                    @Override
//                    public void mouseClicked(MouseEvent e) {
//
//                        // فى حاله الضط على اليمين 
//                        if (SwingUtilities.isRightMouseButton(e)) {
//                            m.click_right(e, v.table_model(), v);
//
//                        } else {
//                            m.add_elemnt(v);
//                        }
//
//                    }
//
//                });
//                v.table_keylistener(new KeyAdapter() {
//
//                    @Override
//                    public void keyReleased(KeyEvent e) {
//
//                        m.add_elemnt(v);
//
//                    }
//
//                });
//                // print button action
//                v.action(new ActionListener() {
//
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//
//                        m.print_action(v.table());
//
//                    }
//                });
//                // delete button action 
//                v.delete_action(new ActionListener() {
//
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//
//                        m.delete_action(v.table(), v.table_model(),v);
//
//                    }
//                });
    }

 
}
