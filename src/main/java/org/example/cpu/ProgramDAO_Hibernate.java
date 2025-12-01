package org.example.cpu;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProgramDAO_Hibernate extends ProgramDAO {

    Session session = null;
    Transaction transaction = null;


    @Override
    public void save(Program program) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(program);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Command command){
        try {
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            transaction = session.beginTransaction();
            session.remove(command);
            transaction.commit();
        } catch (Exception e){
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}