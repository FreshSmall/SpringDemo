/**
 * Sample软件有限公司, 版权所有 违者必究
 *   Copyright 2010 
 * 2010-1-19
 */
package smart.tx;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈雄华
 * @version 1.0
 */
@Service
public class UserHibernateService {
    

     @Autowired
     private HibernateTemplate hibernateTemplate;

     public void addNotice(){

     }

     public boolean testSession(){
         List<Session> sessions = new ArrayList<Session>();
         sessions.add(getSessionBySessionFactoryUtils());
         sessions.add(getSessionBySessionFactoryUtils());
         sessions.add(getSessionBySessionFactory());
         return sessions.get(0) == sessions.get(1) && sessions.get(1) == sessions.get(2);
     }

     private Session getSessionBySessionFactoryUtils(){
        return SessionFactoryUtils.getSession(hibernateTemplate.getSessionFactory(),true);
     }

     private Session getSessionBySessionFactory(){
        return hibernateTemplate.getSessionFactory().getCurrentSession();
     }
}
