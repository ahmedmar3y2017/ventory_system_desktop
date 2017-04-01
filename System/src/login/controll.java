
package login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author programmer
 */
public class controll {

    public controll() throws SQLException, ClassNotFoundException {

        view v = new view();
        model m = new model();

    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    view v = new view();
                    model m = new model();
                    v.setVisible(true);
                    v.set_login_action(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String username = v.get_name();
                            String password = v.get_pass();

                            if (username.equals("") || password.equals("")) {

                                if (username.equals("")) {

                                    JOptionPane.showMessageDialog(null, "اختر الاسم");
                                } else if (password.equals("")) {
                                    JOptionPane.showMessageDialog(null, "ادخل الرقم السرى ...");

                                }

                            } else {

                                try {
                                    m.login_action(username, password, v);
                                } catch (SQLException ex) {
                                    Logger.getLogger(controll.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }

                        }
                    });
                    v.validate_pass(new KeyAdapter() {

                        @Override
                        public void keyTyped(KeyEvent e) {

                            m.valisate_pass(e);

                        }

                    });
                } catch (SQLException ex) {
                    Logger.getLogger(controll.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(controll.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

}
