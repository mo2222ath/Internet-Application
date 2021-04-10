/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.office_hours;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Moaaz Hasan
 */
public class office_hoursDao {
    
    Session session;
    Transaction tx = null;

    public office_hoursDao() {
        session = HibernateUtil.openSession();
    }
    
    
    
    public List<office_hours> getAlloffice_hoursByID(int id){
    
         List<office_hours> office_hoursList = new ArrayList();
         System.out.println("getAlloffice_hoursUserID ---> "+id);
        
        try {
            tx = session.getTransaction();
            tx.begin();
            office_hoursList = session.createQuery(" from office_hours where userId='" + id +"'").list();
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
        return office_hoursList;
    }
    
    
    public List<office_hours> getAlloffice_hours(){
    
         List<office_hours> office_hoursList = new ArrayList();
        try {
            tx = session.getTransaction();
            tx.begin();
            office_hoursList = session.createQuery(" from office_hours").list();
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
        return office_hoursList;
    }
    
    
    public void Add_office_hours(office_hours OH){
    
         
         System.out.println("Add_office_hours ---> " + OH);
        
        try {
            tx = session.getTransaction();
            tx.begin();
            session.save(OH);
            
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
    
    
    public void update_office_hours(office_hours OH){
    
         
         System.out.println("Add_office_hours ---> " + OH);
        
        try {
            tx = session.getTransaction();
            tx.begin();
            session.update(OH);
            
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
    
    public void delete_office_hours(int id){
    
                 
        try {
            tx = session.getTransaction();
            tx.begin();
            session.createQuery("delete from office_hours where office_hoursId='" + id + "'").executeUpdate();
            
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
