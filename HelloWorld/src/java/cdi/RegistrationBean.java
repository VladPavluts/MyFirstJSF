

package cdi;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import service.LoginService;

/**
 *
 * @author osboxes
 */
@Named
@RequestScoped
public class RegistrationBean {
    @EJB
    private LoginService loginService;
    
    private String login;
    private String password;

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
    
    public boolean signUp(){
        return loginService.createUser(login, password);
    }
    public String register(){
        return "register.xhtml";
    }
}
