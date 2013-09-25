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
 * @author Carlos David Prada Remolina
 */
@Named(value = "quienesSomosPC")
@SessionScoped
public class QuienesSomosPortalController implements Serializable {

    private DataModel<Contenido> quinesSomos;
    private TipoContenido tipoContenido;
    private Integer idTipo = new Integer(2);
    @EJB
    private uis.giib.administrador.dao.TipoContenidoFacade ejbTipoContenido;

    // Constructor
    public void QuienesSomosPortalController() {
        try {
            tipoContenido = ejbTipoContenido.buscarContenidoPorTipo(idTipo);
            quinesSomos = new ListDataModel(tipoContenido.getContenidoList());
        } catch (Exception e) {
            System.out.println("Error de QuinesSomos!" + e.getCause());
        }
    }

    //Métodos de navegación
    // usado cuando hacemos click en el menú 
    public String goQuienesSomos() {
        try {
            tipoContenido = ejbTipoContenido.buscarContenidoPorTipo(idTipo);
            quinesSomos = new ListDataModel(tipoContenido.getContenidoList());
        } catch (Exception e) {
            System.out.println("Error de QuinesSomos!" + e.getCause());
        }
        return "/portal/quienesSomos.xhtml?faces-redirect=true";
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public TipoContenido getTipoPublicacion() {
        return tipoContenido;
    }

    public void setTipoPublicacion(TipoContenido tipoPublicacion) {
        this.tipoContenido = tipoPublicacion;
    }

    public TipoContenidoFacade getEjbTipoPublicacion() {
        return ejbTipoContenido;
    }

    public void setEjbTipoPublicacion(TipoContenidoFacade ejbTipoPublicacion) {
        this.ejbTipoContenido = ejbTipoPublicacion;
    }

    public DataModel<Contenido> getQuinesSomos() {
        return quinesSomos;
    }

    public void setQuinesSomos(DataModel<Contenido> quinesSomos) {
        this.quinesSomos = quinesSomos;
    }    
}
