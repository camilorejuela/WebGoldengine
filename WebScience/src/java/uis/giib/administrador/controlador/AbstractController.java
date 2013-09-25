/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.administrador.controlador;

import java.io.Serializable;
import javax.inject.Inject;
import uis.giib.login.LoginAuthentication;


public class AbstractController implements Serializable {

    @Inject
    protected uis.giib.login.LoginAuthentication loginAutentication;

     
    public AbstractController() {
    }
    
    public LoginAuthentication getLoginAutentication() {
        return loginAutentication;
    }
       
    public boolean isAuthenticaded(){
        return getLoginAutentication().isLoggedIn();
        
    }
    
    
}
