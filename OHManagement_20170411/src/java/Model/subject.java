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
@Table(name="subject")
public class subject implements Serializable {
     @Id @GeneratedValue
    int subjectId;
    String name;

    public subject() {
    }
    
    

    public subject(String name) {
        this.name = name;
    }
    
    

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "subject{" + "subjectId=" + subjectId + ", name=" + name + '}';
    }
    
    
    
    
}
