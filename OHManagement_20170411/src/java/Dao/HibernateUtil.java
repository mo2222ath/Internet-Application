/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Moaaz Hasan
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
 
    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (HibernateException ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static Session openSession() {
        System.out.println("sessionFactory : : : : ");
        System.out.println(sessionFactory);
        return sessionFactory.openSession();
    }
}
