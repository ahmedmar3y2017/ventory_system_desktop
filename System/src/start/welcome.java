package start;

import clients.Client;
import database.database;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import print.controller;
import register.register;
import users.users;

public class welcome extends JFrame {

    JMenuBar menu;
    JMenu Raw_materials, Agents, Workers, alot;
    JMenuItem paper, supples, print, about, register, users;
    Font f = new Font("serif", Font.BOLD, 20);
    ImageIcon image;
    JLabel label;

    database data;

    public welcome() throws SQLException, ClassNotFoundException {
        data = new database();

        init();



    }

    public void init() {

        this.setSize(1000, 600);
        this.setTitle("مـرحـبـــا");
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        image = new ImageIcon(getClass().getResource("factory.jpg"));
        label = new JLabel(image);
        label.setSize(1000, 600);

        menu = new JMenuBar();
        setJMenuBar(menu);

        Raw_materials = new JMenu("الخامــات");
        Raw_materials.setFont(f);
        menu.add(Raw_materials);

        paper = new JMenuItem("ورق");
        paper.setFont(f);
        paper.addActionListener(new action());

        supples = new JMenuItem("مؤن");
        supples.setFont(f);
        supples.addActionListener(new action());

        print = new JMenuItem("طبــاعة");
        print.setFont(f);
        print.addActionListener(new action());

        Raw_materials.add(paper);
        Raw_materials.add(supples);
        Raw_materials.add(print);

        Agents = new JMenu("العمــلاء");
        Agents.setFont(f);
        menu.add(Agents);
        Agents.addMouseListener(new action());
        Workers = new JMenu("العمــالة");
        Workers.setFont(f);
        menu.add(Workers);

        //----------------------------
        alot = new JMenu("المزيد");
        alot.setFont(f);
        menu.add(alot);
        about = new JMenuItem("about us");
        about.setFont(f);
        about.addActionListener(new action());
        register = new JMenuItem("تسجيل للدخول");
        register.setFont(f);
        register.addActionListener(new action());
        users = new JMenuItem("المستخدمين");
        users.setFont(f);
        users.addActionListener(new action());

        alot.add(about);
        alot.add(register);
        alot.add(users);

        //about,register,users,search_password
        Workers.addMouseListener(new action());
        this.add(label);

        this.setVisible(true);

    }

    public static void main(String[] args) {
        try {
            new welcome();
        } catch (SQLException ex) {
            Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    class action extends MouseAdapter implements ActionListener {

        // mouse menu click
        @Override
        public void mouseClicked(MouseEvent e) {

            if (e.getSource() == Workers) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        new workers.worker().setVisible(true);

                    }
                });
            } else if (e.getSource() == Agents) {

                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        try {
                            new clients.Client().setVisible(true);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InstantiationException ex) {
                            Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IllegalAccessException ex) {
                            Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(welcome.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                });

            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == supples) {
                new supplies.supplies();

            } else if (e.getSource() == print) {

                new controller();

            } else if (e.getSource() == about) {

                System.out.println(" aaaaaaaa");

            } //-------------------------- register action listener ------------------------------------
            else if (e.getSource() == register) {

                new register();

            } else if (e.getSource() == users) {

                new users();

            }

        }

    }

}
