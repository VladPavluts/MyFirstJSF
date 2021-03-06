package service;

import entity.Login;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.hibernate.Query;
import org.hibernate.Session;


@Stateless
@LocalBean
public class LoginService {
    @EJB
    private SessionFactoryService sessionFactoryService;
    
    public String chechUser(String login, String password){
        Session session = sessionFactoryService.getSession();
            session.beginTransaction();
            
            Query query=session.createQuery("from Login where login=:login and password=:password");
            query.setParameter("login",login);
            query.setParameter("password",password);
            
            
            List list=query.list();
            if("admin".equals(login) && "admin".equals(password))
                return "admin";
            if(list.size()==1){
                return "true";
            }
            else
                return "false";                 
           
        
    }
    
        public boolean createUser(String login, String password){
        
            Session session = sessionFactoryService.getSession();
            
            session.beginTransaction();
            
            Query query=session.createQuery("from Login where login=:login and password=:password");
            query.setString("login",login);
            query.setString("password",password);
            boolean pr=false;
            List list=query.list();
            if(list.size()==1){
                pr=true;
            }               
            if(!pr){
            Login newUser=new Login();
            newUser.setLogin(login);
            newUser.setPassword(password);
            session.save(newUser);
            session.getTransaction().commit();
            return true;
            } else {
              return false;
            }
                                     
           
               
    }
}
