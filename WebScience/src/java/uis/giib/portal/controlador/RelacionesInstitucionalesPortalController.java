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
import uis.giib.entidades.Contenido;
import uis.giib.entidades.TipoContenido;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "relacionesInstitucionalesPC")
@SessionScoped
public class RelacionesInstitucionalesPortalController implements Serializable {
    
    // Atributos
    
    private DataModel<Contenido> relacionesInstitucionales;
    private TipoContenido tipoContenido;
    private Integer idTipo = new Integer(3);
    @EJB
    private uis.giib.administrador.dao.TipoContenidoFacade ejbTipoContenido;


    public RelacionesInstitucionalesPortalController() {
        try {
            tipoContenido = ejbTipoContenido.buscarContenidoPorTipo(idTipo);
            relacionesInstitucionales = new ListDataModel(tipoContenido.getContenidoList());
        } catch (Exception e) {
            System.out.println("Error en relacionesInstirucionales!" + e.getCause());
        }
    }

    //Métodos de navegación
    public String goRelacionesInstitucionales(){
        try {
            tipoContenido = ejbTipoContenido.buscarContenidoPorTipo(idTipo);
            relacionesInstitucionales = new ListDataModel(tipoContenido.getContenidoList());
        } catch (Exception e) {
            System.out.println("Error en relacionesInstirucionales!" + e.getCause());
        }
        return "/portal/relacionesInstitucionales.xhtml?faces-redirect=true";
    }
    
    //Getters - Setters

    public DataModel<Contenido> getRelacionesInstitucionales() {
        return relacionesInstitucionales;
    }

    public void setRelacionesInstitucionales(DataModel<Contenido> relacionesInstitucionales) {
        this.relacionesInstitucionales = relacionesInstitucionales;
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

    public uis.giib.administrador.dao.TipoContenidoFacade getEjbTipoContenido() {
        return ejbTipoContenido;
    }

    public void setEjbTipoContenido(uis.giib.administrador.dao.TipoContenidoFacade ejbTipoContenido) {
        this.ejbTipoContenido = ejbTipoContenido;
    }    
}