package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Carlos David Prada Remolina
 * 
 */
@Named(value = "administradorPC")
@SessionScoped
public class AdministradorPortalController implements Serializable {

    /**
     * Creates a new instance of AdministradorPortalController
     */
    public AdministradorPortalController() {
    }
    
    public String goAdministrar(){
        try{
        }catch(Exception e){
            System.out.println("Error administrador");
        }        
        return "/administrador/indexAdministracion.xhtml?faces-redirect=truel";        
    } 
}
