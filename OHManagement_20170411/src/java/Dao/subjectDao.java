/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.subject;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Moaaz Hasan
 */
public class subjectDao {

    Session session;
    Transaction tx = null;

    public subjectDao() {
        session = HibernateUtil.openSession();
    }

    public List<subject> getAllSubject() {

        List<subject> subjectList = new ArrayList();

        try {
//            session.beginTransaction();
            tx = session.getTransaction();
            System.out.println(tx.isActive());
            tx.begin();
            System.out.println(tx.isActive());
            subjectList = session.createQuery(" from subject").list();
            tx.commit();
            System.out.println("Done!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return subjectList;
    }

    public int getSubjectId(String name) {

        List<subject> subjectList = new ArrayList();
        int id = 0;

        try {
            tx = session.getTransaction();
            tx.begin();
            subjectList = session.createQuery(" from subject s where s.name='" + name + "'").list();
            System.out.println("subjectList ------from-getSubjectId------> " + subjectList);
            if (!subjectList.isEmpty()) {
                id = subjectList.get(0).getSubjectId();

            } else {
                id = -1;
            }
            tx.commit();
            System.out.println("Done!");
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
        return id;
    }

}
