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
@Table(name="message")
public class message implements Serializable {
    
    @Id @GeneratedValue
    int messageId;
    int userIdFrom;
    int userIdTo;
    String actualMessage;
    Date date;

    public message() {
    }

    
    
    
    
    public message(int userIdFrom, int userIdTo, String actualMessage, Date date) {
        this.userIdFrom = userIdFrom;
        this.userIdTo = userIdTo;
        this.actualMessage = actualMessage;
        this.date = date;
    }

    
    
    
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
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

    public String getActualMessage() {
        return actualMessage;
    }

    public void setActualMessage(String actualMessage) {
        this.actualMessage = actualMessage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "message{" + "messageId=" + messageId + ", userIdFrom=" + userIdFrom + ", userIdTo=" + userIdTo + ", actualMessage=" + actualMessage + ", date=" + date + '}';
    }
    
    
    
    
}
