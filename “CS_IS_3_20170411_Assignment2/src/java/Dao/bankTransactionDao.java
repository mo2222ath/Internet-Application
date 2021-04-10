/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DB.ConnectionToDB;
import Model.BankTransaction;
import Model.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Moaaz Hasan
 */
public class bankTransactionDao {

    ConnectionToDB connection = null;
    ResultSet RS = null;
    BankTransaction bankTransaction = null;
    List<BankTransaction> bankTransactionList = new ArrayList();

    public bankTransactionDao() throws ClassNotFoundException, SQLException {
        connection = new ConnectionToDB();
    }

    public List<BankTransaction> SelectTransactionsList(int id) throws SQLException {
        String sql = " SELECT * FROM bank.banktransaction where fromAccount=" + id + " || toAccount=" + id + ";";
        RS = connection.Stmt.executeQuery(sql);

        while (RS.next()) {
            int bankTransactionId = RS.getInt("bankTransactionId");
            Date creationDate = RS.getDate("creationDate");
            int amount = RS.getInt("amount");
            int fromAccount = RS.getInt("fromAccount");
            int toAccount = RS.getInt("toAccount");
            bankTransaction = new BankTransaction(bankTransactionId, creationDate, amount, fromAccount, toAccount);
            bankTransactionList.add(bankTransaction);

        }

        return bankTransactionList;
    }
    
    public BankTransaction getTransaction(int id) throws SQLException {
        String sql = " SELECT * FROM bank.banktransaction where bankTransactionId=" + id + ";";
        RS = connection.Stmt.executeQuery(sql);

        while (RS.next()) {
            int bankTransactionId = RS.getInt("bankTransactionId");
            Date creationDate = RS.getDate("creationDate");
            int amount = RS.getInt("amount");
            int fromAccount = RS.getInt("fromAccount");
            int toAccount = RS.getInt("toAccount");
            bankTransaction = new BankTransaction(bankTransactionId, creationDate, amount, fromAccount, toAccount);
        }

        return bankTransaction;
    }
    
    public int AddTransaction(int Amount , int from , int to) throws SQLException {
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        
        String sql = "INSERT INTO `bank`.`banktransaction` (`creationDate`, `amount`, `fromAccount`, `toAccount`) VALUES ("
                + "'" + sqlDate + "',"
                + "'" + Amount + "',"
                + "'" + from + "',"
                + "'" + to + "');";
        int s = connection.Stmt.executeUpdate(sql);
        
        return s;
    }
    public int CancelTransaction(int id) throws SQLException {
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        
        String sql = "DELETE FROM `bank`.`banktransaction` WHERE (`bankTransactionId` = "+ id + ");";
        int s = connection.Stmt.executeUpdate(sql);
        
        return s;
    }
    
   
}
