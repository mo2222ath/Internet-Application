/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Moaaz Hasan
 */
public class BankTransaction {
    
    int bankTransactionId ;
    Date creationDate;
    int amount;
    int fromAccount;
    int toAccount;

    public BankTransaction(int bankTransactionId, Date creationDate, int amount, int fromAccount, int toAccount) {
        this.bankTransactionId = bankTransactionId;
        this.creationDate = creationDate;
        this.amount = amount;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
    }

    @Override
    public String toString() {
        return "BankTransaction{" + "bankTransactionId=" + bankTransactionId + ", creationDate=" + creationDate + ", amount=" + amount + ", fromAccount=" + fromAccount + ", toAccount=" + toAccount + '}';
    }
    
    

    public int getBankTransactionId() {
        return bankTransactionId;
    }

    public void setBankTransactionId(int bankTransactionId) {
        this.bankTransactionId = bankTransactionId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(int fromAccount) {
        this.fromAccount = fromAccount;
    }

    public int getToAccount() {
        return toAccount;
    }

    public void setToAccount(int toAccount) {
        this.toAccount = toAccount;
    }
    
    
    
    
}
