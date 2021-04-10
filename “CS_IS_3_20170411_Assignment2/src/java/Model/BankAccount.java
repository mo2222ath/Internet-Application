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
public class BankAccount {
    int bankAccountId;
    Date creationDate;
    int currentBalance;
    int customerId;

    public BankAccount(int bankAccountId, Date creationDate, int currentBalance, int customerId) {
        this.bankAccountId = bankAccountId;
        this.creationDate = creationDate;
        this.currentBalance = currentBalance;
        this.customerId = customerId;
    }

    
    public int getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "BankAccount{" + "bankAccountId=" + bankAccountId + ", creationDate=" + creationDate + ", currentBalance=" + currentBalance + ", customerId=" + customerId + '}';
    }
    
    
    
    
    
}
