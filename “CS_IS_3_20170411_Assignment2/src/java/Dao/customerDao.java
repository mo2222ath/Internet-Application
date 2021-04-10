/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DB.ConnectionToDB;
import Model.BankAccount;
import Model.Customer;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Moaaz Hasan
 */
public class customerDao {

    ConnectionToDB connection = null;
    ResultSet RS = null;
    Customer customer = null;

    public customerDao() throws ClassNotFoundException, SQLException {
        connection = new ConnectionToDB();
    }

    public Customer getCustomer(int id) throws SQLException {
        String sql = "SELECT * FROM bank.customer where customerId=" + "'" + id + "'" + ";";
        
        RS = connection.Stmt.executeQuery(sql);
        
        if (RS.next()) {
            System.out.println(RS.getInt("customerId"));
            int customerId = RS.getInt("customerId");
            String customerEmail = RS.getString("customerEmail");
            String customerName = RS.getString("customerName");
            String customerAddress = RS.getString("customerAddress");
            String customerMobail = RS.getString("customerMobail");
            String customerPassword = RS.getString("customerPassword");

            customer = new Customer(customerId, customerEmail, customerName, customerAddress, customerMobail, customerPassword);
            return customer;
        } else {

            return customer;
        }

    }

}
