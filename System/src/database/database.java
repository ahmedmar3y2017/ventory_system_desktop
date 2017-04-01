package database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import javax.swing.table.DefaultTableModel;

public class database {

    Connection conn;
    Statement statement;
    ResultSet resultSet;
    PreparedStatement p;
    String username = "root";
    String password = "root";
    String url = "jdbc:mysql://localhost:3306/system";
    boolean f = false;

    public database() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = (Connection) DriverManager.getConnection(url, username, password);

        f = true;
    }

    public boolean re() {

        return f;

    }

    public void insert_trader_null(String trader_name, String paper_kind, String company_name, Timestamp date, double weight_kilo, double price_kilo, double t_price, double t_price0) throws SQLException {
        p = conn.prepareStatement("insert into `paper` (`name`,`paper_kind`,date_of_join,`company`,weight,kilo_price,total_price,charge) values (?,?,?,?,?,?,?,?)");
        p.setString(1, trader_name);
        p.setString(2, paper_kind);
        p.setTimestamp(3, date);
        p.setString(4, company_name);
        p.setDouble(5, weight_kilo);
        p.setDouble(6, price_kilo);
        p.setDouble(7, t_price);
        p.setDouble(8, t_price0);
        p.execute();

    }

    public boolean search_trader(String name, String paper_kind, Timestamp time) throws SQLException {
        f = true;

        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from `paper` ");
        while (resultSet.next()) {

            if (name.equals(resultSet.getString("name")) && paper_kind.equals(resultSet.getString("paper_kind")) && time.equals(resultSet.getTimestamp("date_of_join"))) {

                f = true;
                break;

            }

        }
        return f;
    }

    //------------------------------ workers frame ----------------------------------------------------
    public boolean insert_worker(String name, int month, int week, double day_salary, double days, double week_salary, double payed, double charge) throws SQLException {
        boolean f = false;

        p = conn.prepareStatement("insert into `workers` values (?,?,?,?,?,?,?,?)");
        p.setString(1, name);
        p.setInt(2, month);
        p.setInt(3, week);
        p.setDouble(4, day_salary);
        p.setDouble(5, days);
        p.setDouble(6, week_salary);
        p.setDouble(7, payed);
        p.setDouble(8, charge);

        p.execute();
        f = true;
        return f;
    }

    public boolean search_worker(String name, int month, int week) throws SQLException {
        boolean f = false;

        statement = conn.createStatement();

        resultSet = statement.executeQuery("select * from `workers`");
        while (resultSet.next()) {

            if (resultSet.getString("name").equals(name) && month == resultSet.getInt("month") && week == resultSet.getInt("week")) {
                f = true;
                break;
            }

        }

        return f;
    }

    public ResultSet retrieve() throws SQLException {

        statement = conn.createStatement();

        resultSet = statement.executeQuery("select * from `workers`");

        return resultSet;
    }

    public boolean delete_worker(String name, int month, int week) throws SQLException {

        boolean b = false;
        p = conn.prepareStatement("delete from `workers` where `name`='" + name + "' and month=" + month + " and week=" + week + "");
        p.execute();
        b = true;

        return b;
    }

    public boolean delete_all() throws SQLException {
        boolean f = false;
        p = conn.prepareStatement("delete from `workers` ");
        p.execute();
        f = true;
        return f;
    }

//    public void update_workers(String name, int month, int week, double day_selary, double days, double week_selary, double payed, double charge) throws SQLException {
//
//        p = conn.prepareStatement("update `workers` set day_salary=? , day_work=? , week_salary=? , payed=?,charge=? where name='" + name + "' and month='" + month + "' and week='" + week + "'");
//
//        p.setDouble(1, day_selary);
//        p.setDouble(2, days);
//        p.setDouble(3, week_selary);
//        p.setDouble(4, payed);
//        p.setDouble(5, charge);
//
//        p.execute();
//
//    }
    //---------------------------------------------- clients -------------------------------------
    public void insert_when_the_record_is_not_found_in_the_table(String client_name, String cardbpard_sort, int day, int month, int year,
            int amount, float cardboard_price, double net_price, double payed, double remainning) throws SQLException {
        PreparedStatement p;
        p = conn.prepareStatement("insert into client values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        p.setString(1, client_name);
        p.setString(2, cardbpard_sort);
        p.setInt(3, day);
        p.setInt(4, month);
        p.setInt(5, year);
        p.setInt(6, amount);
        p.setFloat(7, cardboard_price);
        p.setDouble(8, net_price);
        p.setDouble(9, payed);
        p.setDouble(10, remainning);

        p.execute();

    }

    public void insert_when_the_record_is_found_in_the_table(String client_name, String cardbpard_sort, int day, int month, int year, int amount, float cardboard_price, double net_price, double payed, double remainning) throws SQLException {
        PreparedStatement p;
        p = conn.prepareStatement("update client set amount = ?, net_price = ?, payed = ?, remainning = ? where client_name = ? and cardboard_sort = ? and day = ? and month = ? and year = ? and cardboard_price = ?");

        p.setInt(1, amount);
        p.setDouble(2, net_price);
        p.setDouble(3, payed);
        p.setDouble(4, remainning);
        p.setString(5, client_name);
        p.setString(6, cardbpard_sort);
        p.setInt(7, day);
        p.setInt(8, month);
        p.setInt(9, year);
        p.setFloat(10, cardboard_price);

        p.execute();

    }

    public void update(String client_name, String cardbpard_sort, int day, int month, int year, int amount, float cardboard_price, double net_price, double payed, double remainning) throws SQLException {
        PreparedStatement p;
        p = conn.prepareStatement("update client set amount =? net_price = ? payed = ?, remainning = ? where client_name = ? and cardboard_sort = ?and day = ? and month = ? and year = ? and cardboard_price = ?");

        p.setInt(1, amount);
        p.setDouble(2, net_price);
        p.setDouble(3, payed);
        p.setDouble(4, remainning);
        p.setString(5, client_name);
        p.setString(6, cardbpard_sort);
        p.setInt(7, day);
        p.setInt(8, month);
        p.setInt(9, year);
        p.setFloat(10, cardboard_price);

        p.execute();

    }

    public void update2(String client_name, String cardbpard_sort, int day, int month, int year, double net_price, double payed, double remainning) throws SQLException {
        PreparedStatement p;
        p = conn.prepareStatement("update client set net_price = ?, payed = ?, remainning = ? where client_name = ? and cardboard_sort = ? and day = ? and month = ? and year = ?");

        p.setDouble(1, net_price);
        p.setDouble(2, payed);
        p.setDouble(3, remainning);
        p.setString(4, client_name);
        p.setString(5, cardbpard_sort);
        p.setInt(6, day);
        p.setInt(7, month);
        p.setInt(8, year);

        p.execute();

    }

    public DefaultTableModel retrieve_all() throws SQLException {
        DefaultTableModel dm = new DefaultTableModel();
        String[] column_headers = {"الاسم", "نوع الكرتونه", "التاريخ", "الكميه", "سعر الكرتونه", "السعر الكلى", "التحصيل", "الباقى"};
        dm.setColumnIdentifiers(column_headers);

        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from client");

        while (resultSet.next()) {
            String client_name = resultSet.getString("client_name");
            String cardboard_sort = resultSet.getString("cardboard_sort");
            Integer day = resultSet.getInt("day");
            Integer month = resultSet.getInt("month");
            Integer year = resultSet.getInt("year");
            Integer amount = resultSet.getInt("amount");
            Float cardboard_price = resultSet.getFloat("cardboard_price");
            Double net_price = resultSet.getDouble("net_price");
            Double payed = resultSet.getDouble("payed");
            Double remainnng = resultSet.getDouble("remainning");

            dm.addRow(new Object[]{client_name, cardboard_sort, day + "/" + month + "/" + year, amount, cardboard_price, net_price, payed, remainnng});

        }

        return dm;
    }

    public ResultSet check() throws SQLException {
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from client");
        return resultSet;
    }

    public void delete(String name, String cardboard_sort, int day, int month, int year) throws SQLException {
        PreparedStatement p = conn.prepareStatement("delete from client where client_name = ? and cardboard_sort = ? and day = ? and month = ? and year = ?");

        p.setString(1, name);
        p.setString(2, cardboard_sort);
        p.setInt(3, day);
        p.setInt(4, month);
        p.setInt(5, year);

        p.execute();
    }

    //-------------------------------------------------------------  supplies  ---------------------------------------
    public void insert_supplies(String supp, int d, int m, int y, double w, double p, double pay, double charge) throws SQLException {

        this.p = conn.prepareStatement("insert into `supplies` values (?,?,?,?,?,?,?,?)");

        this.p.setString(1, supp);
        this.p.setInt(2, d);
        this.p.setInt(3, m);
        this.p.setInt(4, y);
        this.p.setDouble(5, w);
        this.p.setDouble(6, p);
        this.p.setDouble(7, pay);
        this.p.setDouble(8, charge);

        this.p.execute();
    }

    public boolean check_spupplies(String name, int day, int month, int year) throws SQLException {
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from `supplies`");
        boolean f = false;
        while (resultSet.next()) {

            if (name.equals(resultSet.getString("kind")) && day == resultSet.getInt("day") && month == resultSet.getInt("month") && year == resultSet.getInt("year")) {

                f = true;
                break;

            }

        }

        return f;

    }

    public ResultSet retrieve_supplies() throws SQLException {

        statement = conn.createStatement();

        resultSet = statement.executeQuery("select * from `supplies`");

        return resultSet;

    }

    public boolean delete_supply(String name, int year, int month, int day) throws SQLException {

        boolean f = false;
        p = conn.prepareStatement("delete from `supplies` where `kind`='" + name + "' and day=" + day + " and month=" + month + " and year='" + year + "'");
        p.execute();
        f = true;
        return f;

    }

    public boolean delete_all_supplies() throws SQLException {

        boolean f = false;
        p = conn.prepareStatement("delete from `supplies`");
        p.execute();
        f = true;
        return f;

    }
// -------------------------------------- printer database ----------------------

    public void insert_print(double number, int day, int month, int year, int colornumber, double total_price, double payed, double charge) throws SQLException {
        p = conn.prepareStatement("insert into `print` values (?,?,?,?,?,?,?,?)");

        p.setDouble(1, number);
        p.setInt(2, day);
        p.setInt(3, month);
        p.setInt(4, year);
        p.setInt(5, colornumber);
        p.setDouble(6, total_price);
        p.setDouble(7, payed);
        p.setDouble(8, charge);

        p.execute();

    }

    public ResultSet retrieve_prints() throws SQLException {

        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from `print`");

        return resultSet;

    }

    public int check_print(double amount, int day, int month, int year) throws SQLException {

        int flag = 1;
        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from `print`");
        while (resultSet.next()) {

            if (resultSet.getDouble("number") == amount && day == resultSet.getInt("day") && resultSet.getInt("month") == month && resultSet.getInt("year") == year) {

                flag = 0;

            }
        }
        return flag;
    }

    public boolean delete_print(double amount, int day, int month, int year) throws SQLException {
        boolean f = false;
        p = conn.prepareStatement("delete from `print` where number=" + amount + " and day=" + day + " and month=" + month + " and year=" + year + "");

        p.execute();
        f = true;
        return f;

    }

    public boolean delete_all_print() throws SQLException {

        boolean f = false;
        p = conn.prepareStatement("delete  from `print`");

        p.execute();
        f = true;
        return f;
    }

    public boolean update_workers(String name, int month, int week, double payed, double total_ch) throws SQLException {

        boolean ff = false;

        p = conn.prepareStatement("update `workers` set payed=" + payed + " , charge=" + total_ch + "  where name='" + name + "' and month=" + month + " and week=" + week + "");
//        p.setDouble(1, payed);
//        p.setDouble(2, total_ch);
        p.execute();
        System.out.println(payed + "   " + total_ch);
        ff = true;
        return ff;
    }

    //-------------------------------- login page ----------------------------
    public boolean search_username(String username, String password) throws SQLException {

        boolean f = false;

        statement = conn.createStatement();
        resultSet = statement.executeQuery("select * from `login`");
        while (resultSet.next()) {
            if (username.equals(resultSet.getString("username")) && password.equals(resultSet.getString("password"))) {

                f = true;

                break;
            }

        }

        return f;

    }

    public boolean update_print(double num, int day, int month, int year, double payed, double charge) throws SQLException {

        boolean f = false;
        p = conn.prepareStatement("update `print` set payed=? , charge= ? where number=" + num + " and day= " + day + " and month=" + month + " and year =" + year + "");
        p.setDouble(1, payed);
        p.setDouble(2, charge);
        p.execute();

        f = true;
        return f;
    }

    public void insert_user(String nname, String pass, String ttel) throws SQLException {

        p = conn.prepareStatement("insert into `login` values (?,?,?)");
        p.setString(1, nname);
        p.setString(2, pass);
        p.setString(3, ttel);

        p.execute();

    }

    public ResultSet return_names() throws SQLException {
        statement = conn.createStatement();

        return statement.executeQuery("select distinct username from `login`");

    }

    public ResultSet retrieve_users() throws SQLException {

        statement = conn.createStatement();
        return statement.executeQuery("select * from `login`");

    }

    public boolean delete_user(String toString, String toString0) throws SQLException {
        boolean f = false;
        p = conn.prepareStatement("delete from `login` where `username`='" + toString + "' and `password`='" + toString0 + "'");
        p.execute();
        f = true;
        return f;
    }

}
