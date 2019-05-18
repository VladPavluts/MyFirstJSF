/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author osboxes
 */
@Stateless
@LocalBean
public class SessionFactoryService {
    private SessionFactory sessionFactory;
    
    @PostConstruct
    public void init(){
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }
    
    public Session getSession(){
        Session session=sessionFactory.openSession();
        
        return session;
    }
}
