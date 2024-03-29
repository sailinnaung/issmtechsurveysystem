/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import survey.exception.DAOException;

/**
 *
 * @author A0065956N
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Log log = LogFactory.getLog(HibernateUtil.class);
    
    /**
     * Constructs a new Singleton SessionFactory
     * @return
     * @throws HibernateException
     */
    public static SessionFactory buildSessionFactory() throws HibernateException {
        if (sessionFactory != null) {
            closeFactory();
        }
        return configureSessionFactory();
    }
    
    /**
     * Builds a SessionFactory, if it hasn't been already.
     */
    public static SessionFactory buildIfNeeded() throws HibernateException {
        if (sessionFactory != null) {
            
            return sessionFactory;
        }
        
        return configureSessionFactory();
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Session openSession() throws HibernateException {
        buildIfNeeded();
        return sessionFactory.openSession();
    }
    
    public static void closeFactory() {
        if (sessionFactory != null) {
            try {
                sessionFactory.close();
            } catch (HibernateException ignored) {
                log.error("Couldn't close SessionFactory", ignored);
            }
        }
    }
    
    public static void close(Session session) {
        if (session != null) {
            try {
                session.close();
            } catch (HibernateException ignored) {
                log.error("Couldn't close Session", ignored);
            }
        }
    }
    
    public static void rollback(Transaction tx) {
        try {
            if (tx != null) {
                tx.rollback();
            }
        } catch (HibernateException ignored) {
            log.error("Couldn't rollback Transaction", ignored);
        }
    }
   
    /**
     *
     * @return
     * @throws HibernateException
     */
    private static SessionFactory configureSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        return sessionFactory;
    }
}
