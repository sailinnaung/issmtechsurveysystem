/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package survey.dao.hibernate;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import survey.exception.DAOException;

/**
 *
 * @author vivek
 */
public abstract class AbstractDAO {

    private Session session;
    private Transaction trx;
    
    protected AbstractDAO() {
        
        HibernateUtil.buildIfNeeded();
        session = null;
    }
    
    private void init() {
    
        if (session == null)
            session = HibernateUtil.openSession();
        
        if (trx == null)
            trx = session.beginTransaction();
    }
    
    private void deinit() {
        
        if (trx != null && trx.isActive())
            HibernateUtil.rollback(trx);
        
        if (session != null)
            HibernateUtil.close(session);
        
        trx = null;
        session = null;
    }
    
    private void handleException(HibernateException ex) throws DAOException {
        
        if (trx != null)
            HibernateUtil.rollback(trx);
        
        throw new DAOException(ex);
    }
    
    protected void save(Object obj) {
        try {
            
            init();
            session.save(obj);
            
        } catch (HibernateException e) {
            
            handleException(e);
        } finally {
            
            deinit();
        }
    }
    
    protected void saveOrUpdate(Object obj) {
        try {
            
            init();
            session.saveOrUpdate(obj);
        } catch (HibernateException e) {
            
            handleException(e);
        } finally {
            
            deinit();
        }
    }

    protected void delete(Object obj) {
        try {
            
            init();
            session.delete(obj);
            
        } catch (HibernateException e) {
            
            handleException(e);
        } finally {
            
            deinit();
        }
    }
    
    protected Query createQuery(String hql) {
        
        Query q = null;
        
        try {
            
            init();
            q = session.createQuery(hql);
            
        } catch (HibernateException e) {
            
            q = null;
            handleException(e);
        } finally {
            
            if (q == null)
                deinit();
        }
        
        return q;
    }
    
    protected void executeUpdate(Query q) {
        
        try {
            
            q.executeUpdate();
        } catch (HibernateException e) {
            
            handleException(e);
        } finally {
            
            deinit();
        }
    }
    
    protected Object find(Class cls, Integer id) {
        
        Object obj = null;
        
        try {
            
            init();
            obj = session.get(cls, id);
            
        } catch (HibernateException e) {
            
            obj = null;
            handleException(e);
        } finally {
            
            if (obj == null)
                deinit();
        }
        
        return obj;
    }
    
    protected Object find(Query q) {
        
        Object obj = null;
        
        try {
            
            List list = q.list();
            if (list != null && list.size() > 0)
                obj = list.get(0);
        } catch (HibernateException e) {
            
            obj = null;
            handleException(e);
        } finally {
            
            if (obj == null)
                deinit();
        }
        
        return obj;
    }
    
    protected List findList(Query q) {
        
        List list = null;
        
        try {
            
            list = q.list();
        } catch (HibernateException e) {
            
            list = null;
            handleException(e);
        } finally {
            
            if (list == null)
                deinit();
        }
        
        return list;
    }
    
    protected void endOperation() {
        
        if (trx != null && trx.isActive())
            trx.commit();
        
        deinit();
    }
}
