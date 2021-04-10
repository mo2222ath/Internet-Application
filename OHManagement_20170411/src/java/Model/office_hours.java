/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.sql.Time;
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
@Table(name="office_hours")
public class office_hours implements Serializable {
    @Id @GeneratedValue
    int office_hoursId;
    String dateOH;
    int userId;
    String fromTime;
    String toTime;
    int reserved;
    int rememberMetting;

    public office_hours() {
    }

    
    
    
    public office_hours(String date, int userId, String from, String to) {
        this.dateOH = date;
        this.userId = userId;
        this.fromTime = from;
        this.toTime = to;
        this.reserved = 0;
        this.rememberMetting = 0;
    }

    public office_hours(int office_hoursId, int userId, String dateOH, String fromTime, String toTime) {
        this.office_hoursId = office_hoursId;
        this.userId = userId;
        this.dateOH = dateOH;
        this.fromTime = fromTime;
        this.toTime = toTime;
        this.rememberMetting = 0;
    }

    public int getRememberMetting() {
        return rememberMetting;
    }

    public void setRememberMetting(int rememberMetting) {
        this.rememberMetting = rememberMetting;
    }
    

    public int getOffice_hoursId() {
        return office_hoursId;
    }

    public void setOffice_hoursId(int office_hoursId) {
        this.office_hoursId = office_hoursId;
    }

    public String getDate() {
        return dateOH;
    }

    public void setDate(String date) {
        this.dateOH = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFrom() {
        return fromTime;
    }

    public void setFrom(String from) {
        this.fromTime = from;
    }

    public String getTo() {
        return toTime;
    }

    public void setTo(String to) {
        this.toTime = to;
    }

    public int isReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return "office_hours{" + "office_hoursId=" + office_hoursId + ", dateOH=" + dateOH + ", userId=" + userId + ", fromTime=" + fromTime + ", toTime=" + toTime + ", reserved=" + reserved + ", rememberMetting=" + rememberMetting + '}';
    }

    
    
    
    
    
    
    
}
