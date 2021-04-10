/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Moaaz Hasan
 */

@Entity
@Table(name="user")
public class user implements Serializable {
    @Id @GeneratedValue
    int userId;
     
    String username ;
    String email ;
    String password ;
    String type ;
    String displayName;
    int subjectId;

    public user() {
    }
    
    

    public user(String username, String email, String password, String type, int subjectId) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.type = type;
        this.subjectId = subjectId;
    }

    public user(String username, String email, String password, String type) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.type = type;
        this.subjectId = 0;
    }

    public user(int userId, String username, String email, String password, String type, String displayName, int subjectId) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.type = type;
        this.displayName = displayName;
        this.subjectId = subjectId;
    }
    
    
    
    

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "user{" + "userId=" + userId + ", username=" + username + ", email=" + email + ", password=" + password + ", type=" + type + ", displayName=" + displayName + ", subjectId=" + subjectId + '}';
    }
    
    
}
