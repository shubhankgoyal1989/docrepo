/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ams.documentor.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author kapil
 */
public class HibernateUtil {

    public static Session getSessionFromSessionFactory() {
        try {
            Configuration cfg = new Configuration().configure();
            ServiceRegistry serviceReg = new ServiceRegistryBuilder()
                    .applySettings(cfg.getProperties())
                    .buildServiceRegistry();
            SessionFactory factory = cfg.buildSessionFactory(serviceReg);
            Session openSession = factory.openSession();
            return openSession;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
