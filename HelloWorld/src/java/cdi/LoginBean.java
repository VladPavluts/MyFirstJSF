/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cdi;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import service.LoginService;


@Named
@SessionScoped
public class LoginBean implements Serializable{
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
    
    
    public String loginn(){
        return "index.xhtml";
    }
    
   public String chechUser(){
       return loginService.chechUser(login, password);
   }
   

}
