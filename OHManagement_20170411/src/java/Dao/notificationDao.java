/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.notification;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Moaaz Hasan
 */
public class notificationDao {
    
    Session session;
    Transaction tx = null;

    public notificationDao() {
        session = HibernateUtil.openSession();
    }
    
     public List<notification> getAllNotification() {

        List<notification> notificationList = new ArrayList();

        try {
            tx = session.getTransaction();
            System.out.println(tx.isActive());
            tx.begin();
            System.out.println(tx.isActive());
            notificationList = session.createQuery(" from notification").list();
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
        return notificationList;
    }

    public List<notification> getnotification(int id) {

        List<notification> notificationList = new ArrayList();

        try {
            tx = session.getTransaction();
            tx.begin();
            notificationList = session.createQuery("from notification s where s.IdTo='" + id +"'").list();

            
            tx.commit();
            System.out.println("Done!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return notificationList;
    }
    public void addNotification(notification N) {

        try {
            tx = session.getTransaction();
            tx.begin();
            session.save(N);
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
