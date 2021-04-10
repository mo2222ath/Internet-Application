/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Moaaz Hasan
 */
public class Customer {
    int customerId;
    String customerEmail ;
    String customerName ;
    String customerAddress ;
    String customerMobaile ;
    String customerPassword ;

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", customerEmail=" + customerEmail + ", customerName=" + customerName + ", customerAddress=" + customerAddress + ", customerMobaile=" + customerMobaile + ", customerPassword=" + customerPassword + '}';
    }

    
    
    public Customer(int customerId, String customerEmail, String customerName, String customerAddress, String customerMobaile, String customerPassword) {
        this.customerId = customerId;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerMobaile = customerMobaile;
        this.customerPassword = customerPassword;
    }

    public Customer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerMobaile() {
        return customerMobaile;
    }

    public void setCustomerMobaile(String customerMobaile) {
        this.customerMobaile = customerMobaile;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

   
    
    
    
    
    
}
