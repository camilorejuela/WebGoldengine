
package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import uis.giib.entidades.Proyecto;
import uis.giib.entidades.Contenido;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "indexPC")
@SessionScoped
public class IndexPortalController implements Serializable {

    
    // en un ListDataModel colocamos todos los proyectos en la DB
    public IndexPortalController() {        
        try{     
        }catch(Exception e){
            System.out.println("Error de Index!");
        }        
    }
    
    //Métodos de navegación
    // usado cuando hacemos click en el menú 
    
    public String goIndex(){
        try{       
        }catch(Exception e){
            System.out.println("Error de Index!");
        }        
        return "/portal/index.xhtml?faces-redirect=true";    
    }        
}
