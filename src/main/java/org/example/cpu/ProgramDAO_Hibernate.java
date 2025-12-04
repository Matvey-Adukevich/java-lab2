package org.example.cpu;

import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;

public class ProgramDAO_Hibernate extends ProgramDAO {


    @Override
    public void saveCommand(Command command) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.merge(command);
//            session.persist(program);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCommand(Command command){
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.remove(command);
            transaction.commit();
        } catch (Exception e){
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    @Override
    public void saveProgram(Program program) {
        if (program.getId() == null) {
            Transaction tx = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                tx = session.beginTransaction();
                session.persist(program);
                tx.commit();
            } catch (Exception e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            }
        }
    }

    @Override
    public Program getProg() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Program> programs = session.createQuery(
                    "FROM Program p LEFT JOIN FETCH p.commands",
                    Program.class
            ).getResultList();

            if (!programs.isEmpty()) {
                return programs.get(0);
            }

            Program newProgram = new Program();
            saveProgram(newProgram);
            return newProgram;

        } catch (Exception e) {
            return new Program();
        }
    }
}


