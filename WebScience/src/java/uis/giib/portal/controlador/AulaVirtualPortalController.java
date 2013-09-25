/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import uis.giib.administrador.dao.TipoContenidoFacade;
import uis.giib.entidades.Contenido;
import uis.giib.entidades.TipoContenido;

/**
 *
 * @author cristhian ruiz
 */
@Named(value = "AulaVirtualesPortalController")
@SessionScoped
public class AulaVirtualPortalController implements Serializable {
     private DataModel<Contenido> AulaVirtual;
   private TipoContenido tipoContenido;
    private Integer idTipo = new Integer(5);
    @EJB
    private uis.giib.administrador.dao.TipoContenidoFacade ejbTipoContenido;

    /**Constructor*/
    public void AulaVirtualPortalController() {
        
        try {
            tipoContenido = ejbTipoContenido.buscarContenidoPorTipo(idTipo);
            AulaVirtual = new ListDataModel(tipoContenido.getContenidoList());
        } catch (Exception e) {
            System.out.println("Error de AulaVirtual!" + e.getCause());
        }
    

    }
//Métodos de navegación
    // usado cuando hacemos click en el menú 
    public String goAulaVirtual() {
        try {
            tipoContenido = ejbTipoContenido.buscarContenidoPorTipo(idTipo);
            AulaVirtual = new ListDataModel(tipoContenido.getContenidoList());
        } catch (Exception e) {
            System.out.println("Error de AulaVirtual!" + e.getCause());
        }
        return "/portal/aulaVirtual.xhtml?faces-redirect=true";
    }

    public DataModel<Contenido> getAulaVirtual() {
        return AulaVirtual;
    }

    public void setAulaVirtual(DataModel<Contenido> AulaVirtual) {
        this.AulaVirtual = AulaVirtual;
    }

    public TipoContenido getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(TipoContenido tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public TipoContenidoFacade getEjbTipoContenido() {
        return ejbTipoContenido;
    }

    public void setEjbTipoContenido(TipoContenidoFacade ejbTipoContenido) {
        this.ejbTipoContenido = ejbTipoContenido;
    }

    
    
    
}
