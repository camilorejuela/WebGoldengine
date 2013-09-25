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
 * @author Carlos David Prada Remolina y cristhian ruiz
 */
@Named(value = "herramientasSoftwarePC")
@SessionScoped
public class HerramientasSoftwarePortalController implements Serializable {

    private DataModel<Contenido> HerramientasSoftware;
    private TipoContenido tipoContenido;
    private Integer idTipo = new Integer(4);
    @EJB
    private uis.giib.administrador.dao.TipoContenidoFacade ejbTipoContenido;
//Constructor

    public void HerramientasSoftwarePortalController() {

        try {
            tipoContenido = ejbTipoContenido.buscarContenidoPorTipo(idTipo);
            HerramientasSoftware = new ListDataModel(tipoContenido.getContenidoList());
        } catch (Exception e) {
            System.out.println("Error de herramientas software!" + e.getCause());
        }


    }
//Métodos de navegación
    // usado cuando hacemos click en el menú 

    public String goHerramientasSoftware() {
        try {
            tipoContenido = ejbTipoContenido.buscarContenidoPorTipo(idTipo);
            HerramientasSoftware = new ListDataModel(tipoContenido.getContenidoList());
        } catch (Exception e) {
            System.out.println("Error de HerramientasSoftware!" + e.getCause());
        }
        return "/portal/herramientasSoftware.xhtml?faces-redirect=true";
    }

    public DataModel<Contenido> getHerramientaSoftware() {
        return HerramientasSoftware;

    }

    public void setHerramientaSoftware(DataModel<Contenido> herramientaSoftware) {
        this.HerramientasSoftware = herramientaSoftware;
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

    public DataModel<Contenido> getHerramientasSoftware() {
        return HerramientasSoftware;
    }

    public void setHerramientasSoftware(DataModel<Contenido> HerramientasSoftware) {
        this.HerramientasSoftware = HerramientasSoftware;
    }

    public TipoContenidoFacade getEjbTipoContenido() {
        return ejbTipoContenido;
    }

    public void setEjbTipoContenido(TipoContenidoFacade ejbTipoContenido) {
        this.ejbTipoContenido = ejbTipoContenido;
    }
}
