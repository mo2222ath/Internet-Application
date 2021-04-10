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
@Table(name="notification")
public class notification implements Serializable {
    
    @Id @GeneratedValue
    int notificationId;
    int IdFrom;
    int IdTo;
    String massage = "";
    Date date;

    public notification() {
    }

    public notification(int IdFrom, int IdTo,String massage, Date date) {
        this.IdFrom = IdFrom;
        this.IdTo = IdTo;
        this.massage = massage;
        this.date = date;
    }
    
    

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getIdFrom() {
        return IdFrom;
    }

    public void setIdFrom(int IdFrom) {
        this.IdFrom = IdFrom;
    }

    public int getIdTo() {
        return IdTo;
    }

    public void setIdTo(int IdTo) {
        this.IdTo = IdTo;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "notification{" + "notificationId=" + notificationId + ", IdFrom=" + IdFrom + ", IdTo=" + IdTo + ", massage=" + massage + ", date=" + date + '}';
    }
    
    
    
    
    
}
