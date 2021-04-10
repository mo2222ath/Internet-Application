/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.office_hours;
import Model.user;
import static java.lang.System.out;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Moaaz Hasan
 */
public class userDao {

    Session session;
    Transaction tx = null;

    user u = null;

    public userDao() throws ClassNotFoundException, SQLException {
        session = HibernateUtil.openSession();
    }

    public void addUser(user u) {
        try {
            tx = session.getTransaction();
            tx.begin();
            session.save(u);
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
    
    public void updateUser(user u) {
        try {
            tx = session.getTransaction();
            tx.begin();
            session.update(u);
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
    
    
    

    public boolean usernameIsNotExist(String username) {
        List<user> userList = new ArrayList();

        try {
            tx = session.getTransaction();
            tx.begin();
            System.out.println(username + "*-*-*-*-*-*-*");
            userList = session.createQuery(" from user u where u.username='" + username + "'").list();
            tx.commit();
            
            System.out.println(userList + "<--------- usernameIsExist");

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return userList.isEmpty();
    }

    public boolean emailisNotExist(String email) {
        List<user> userList = new ArrayList();
        try {
            tx = session.getTransaction();
            tx.begin();
            userList = session.createQuery(" from user where email='" + email + "'").list();
            tx.commit();
            
            System.out.println(userList + "<------ emailIsExist");

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return userList.isEmpty();
    }

    public boolean PasswordIsExist(String password) {
        List<user> userList = new ArrayList();
        try {
            tx = session.getTransaction();
            tx.begin();
            userList = session.createQuery("from user where password='" + password + "'").list();
            tx.commit();
            
            System.out.println(userList + "<---- PasswordIsExist");

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return userList.isEmpty();
    }

    public List<user> checkLogin(String email) {
        List<user> userList = new ArrayList();
        try {
            tx = session.getTransaction();
            tx.begin();
            System.out.println(email);
            userList = session.createQuery(" from user where email='" + email + "'").list();
            tx.commit();
           
            System.out.println(userList + "<---- chickLogin");

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return userList;
    }
    
    public List<user> getAllUsers() {
        List<user> userList = new ArrayList();
        try {
            tx = session.getTransaction();
            tx.begin();

            userList = session.createQuery(" from user").list();
            tx.commit();
           
            System.out.println(userList + "<---- getAllUsers");

        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return userList;
    }
    

}
