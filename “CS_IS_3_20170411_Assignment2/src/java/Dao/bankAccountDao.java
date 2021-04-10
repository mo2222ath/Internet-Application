/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DB.ConnectionToDB;
import Model.BankAccount;
import Model.Customer;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static java.lang.String.format;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Moaaz Hasan
 */
public class bankAccountDao {

    ConnectionToDB connection = null;
    ResultSet RS = null;
    BankAccount bankAccount = null;

    public bankAccountDao() throws ClassNotFoundException, SQLException {
        connection = new ConnectionToDB();
    }

    public BankAccount SelectUserAccount(int id) throws SQLException {
        String sql = "SELECT * FROM bank.bankaccount where customerId = " + id + ";";
        RS = connection.Stmt.executeQuery(sql);
        if (RS.next()) {
            int bankAccountId = RS.getInt("bankAccountId");
            Date creationDate = RS.getDate("creationDate");
            int currentBalance = RS.getInt("currentBalance");
            int customerId = RS.getInt("customerId");
            bankAccount = new BankAccount(bankAccountId, creationDate, currentBalance, customerId);
        }
        

        return bankAccount;
    }

    public int AddAcount(int id) throws SQLException {
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        String sql = "INSERT INTO `bank`.`bankaccount` (`creationDate`, `currentBalance`, `customerId`) VALUES ("
                + "'" + sqlDate + "',"
                + "'" + 1000 + "',"
                + "'" + id + "');";
        int s = connection.Stmt.executeUpdate(sql);
        
        return s;
    }
    
    public int UpdateAmount(int id, int Amount) throws SQLException {
        
        String sql = "UPDATE `bank`.`bankaccount` SET `currentBalance` = "+ Amount +" WHERE (`bankAccountId` ="+ id +");";
        int s = connection.Stmt.executeUpdate(sql);
        
        return s;
    }

}
