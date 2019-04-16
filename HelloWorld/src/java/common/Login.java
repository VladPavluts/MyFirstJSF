package common;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@ManagedBean(name="loginbean")
@SessionScoped
@Entity
@Table(name = "login")
public class Login implements Serializable{
    @Id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String login;
    private String password;
    public Login() {
       }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean chechUser(){
        try{
            SessionFactory sessionFactory;
            sessionFactory = new Configuration().configure().buildSessionFactory();
            Session session=sessionFactory.openSession();
            session.beginTransaction();
            
            Query query=session.createQuery("from Login where login=:login and password=:password");
            query.setString("login",login);
            query.setString("password",password);
            
            List list=query.list();
            System.out.println("list size= "+list.size());
            if(list.size()==1){
                return true;
            }
            else
                return false;                 
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;
        
    }
}
