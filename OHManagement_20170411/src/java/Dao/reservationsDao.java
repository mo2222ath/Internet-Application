/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.reservation;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Moaaz Hasan
 */
public class reservationsDao {
    
     Session session;
    Transaction tx = null;

    public reservationsDao() {
        session = HibernateUtil.openSession();
    }
    
    public List<reservation> getReservationByOH_Id(int id){
    
         List<reservation> reservationList = new ArrayList();
        
        try {
            tx = session.getTransaction();
            tx.begin();
            reservationList = session.createQuery(" from reservation where office_hoursId='" + id +"'").list();
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
        return reservationList;
    }
    
    public List<reservation> getReservationByStudentID(int id){
    
         List<reservation> reservationList = new ArrayList();
        
        try {
            tx = session.getTransaction();
            tx.begin();
            reservationList = session.createQuery(" from reservation where userIdFrom='" + id +"'").list();
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
        return reservationList;
    }
    
    public void addReservation(reservation r){
    
        try {
            tx = session.getTransaction();
            tx.begin();
            session.save(r);
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
       
    }
    
    public void deleteReservation(int id){
    
        try {
            tx = session.getTransaction();
            tx.begin();
            session.createQuery("delete from reservation where reservitionId='" + id +"'").executeUpdate();
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
       
    }
    
    
}
