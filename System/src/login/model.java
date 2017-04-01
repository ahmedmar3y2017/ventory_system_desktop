/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import database.database;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import start.welcome;

/**
 *
 * @author programmer
 */
public class model {

    database data;
// constructor

    public model() throws SQLException, ClassNotFoundException {
        data = new database();

    }

    // validate password
    public void valisate_pass(KeyEvent e) {

        if (!Character.isDigit(e.getKeyChar())) {
            e.consume();

        }

    }

    // login action button 

    public void login_action(String username, String password,view v) throws SQLException {

       if(data.search_username(username,password))
       {
           try {
              v.dispose();
               new welcome();
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(model.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }else 
       {
           
           JOptionPane.showMessageDialog(null, "المستخدم غير موجود");
           
       }
        
        
    }

}
