/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.portal.controlador.util;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name = "idleBean")
public class InactividadControlador implements Serializable {

    public void activeListener() throws IOException{
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                "Bienvenido",
                "¡Ha vuelto! Le estamos esperando"));
                    
                FacesContext.getCurrentInstance().getExternalContext().redirect("/WebScience/portal/index.jsf");
        
    }
    
    
    public void logoutListener() throws IOException{
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                "Se ha perdido la sesión",
                "Se ha perdido la sesión"));

        // invalidate session, and redirect to other pages
    }
}
