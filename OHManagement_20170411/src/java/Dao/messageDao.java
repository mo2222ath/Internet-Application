/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.message;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Moaaz Hasan
 */
public class messageDao {
    
     Session session;
    Transaction tx = null;
    
     public messageDao() {
        session = HibernateUtil.openSession();
    }
    
     public List<message> getAllMessage() {

        List<message> messageList = new ArrayList();

        try {
            tx = session.getTransaction();
            tx.begin();
            messageList = session.createQuery(" from message").list();
            tx.commit();
            System.out.println("Done!");
        } 
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } 
        finally {
            session.close();
        }
        return messageList;
    }
     
     public List<message> getmessage(int id) {

        List<message> messageList = new ArrayList();

        try {
            tx = session.getTransaction();
            tx.begin();
            messageList = session
                    .createQuery("from message where userIdFrom='" + id +"' or userIdTo='" + id +"'").list();

            
            tx.commit();
            System.out.println("Done!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return messageList;
    }
     
     public void addMessage(message msg) {

        try {
            tx = session.getTransaction();
            tx.begin();
            session.save(msg);
            tx.commit();
            System.out.println("Done!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
    
}
