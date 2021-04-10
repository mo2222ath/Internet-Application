/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Moaaz Hasan
 */
@Entity
@Table(name="reservation")
public class reservation implements Serializable {
     @Id @GeneratedValue
    int reservitionId ;
    Date date;
    int office_hoursId;
    int userIdFrom;
    int userIdTo;

    public reservation() {
    }
    
    

    public reservation(Date date, int office_hoursId, int userIdFrom, int userIdTo) {
        this.date = date;
        this.office_hoursId = office_hoursId;
        this.userIdFrom = userIdFrom;
        this.userIdTo = userIdTo;
    }
    
    

    public int getReservitionId() {
        return reservitionId;
    }

    public void setReservitionId(int reservitionId) {
        this.reservitionId = reservitionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getOffice_hoursId() {
        return office_hoursId;
    }

    public void setOffice_hoursId(int office_hoursId) {
        this.office_hoursId = office_hoursId;
    }

    public int getUserIdFrom() {
        return userIdFrom;
    }

    public void setUserIdFrom(int userIdFrom) {
        this.userIdFrom = userIdFrom;
    }

    public int getUserIdTo() {
        return userIdTo;
    }

    public void setUserIdTo(int userIdTo) {
        this.userIdTo = userIdTo;
    }

    @Override
    public String toString() {
        return "reservition{" + "reservitionId=" + reservitionId + ", date=" + date + ", office_hoursId=" + office_hoursId + ", userIdFrom=" + userIdFrom + ", userIdTo=" + userIdTo + '}';
    }

    
    
    
    
}
