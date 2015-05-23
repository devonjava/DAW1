/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.work.dto;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import home.work.dto.Prod;
import org.hibernate.cfg.Configuration;
/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author micx
 */
public class HibernateUtil {
     //Создаем нашу SessionFactory.
    private static final SessionFactory sessionFactory;
    
    static {
        try {
             
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static SessionFactory getSessionFactory() {
      
        return sessionFactory;
    }
}
