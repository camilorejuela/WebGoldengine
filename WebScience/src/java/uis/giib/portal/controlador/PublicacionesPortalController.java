package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Carlos Prada Remolina
 */
@Named(value = "publicacionesPC")
@SessionScoped
public class PublicacionesPortalController implements Serializable {

    //Atributos
    private DataModel listadoProduccionIntelectual;
    private DataModel listaTipoProduccion;
    @EJB
    private uis.giib.administrador.dao.ProduccionIntelectualFacade ejbFacadeProduccionIntelectual;
    @EJB
    private uis.giib.administrador.dao.TipoProduccionFacade ejbFacadeTipoProduccion;

    //Constructor
    public PublicacionesPortalController() {
        /*try {
            listadoProduccionIntelectual = new ListDataModel(ejbFacadeProduccionIntelectual.findAll());
            listaTipoProduccion = new ListDataModel(ejbFacadeTipoProduccion.findAll());
        } catch (Exception e) {
            System.out.println("Error listando la producción intelectual!" + e.getMessage());
        }*/
    }

    //Métodos de navegación
    public String goPublicaciones() {

        try {
            listadoProduccionIntelectual = new ListDataModel(ejbFacadeProduccionIntelectual.findAll());
            listaTipoProduccion = new ListDataModel(ejbFacadeTipoProduccion.findAll());
        } catch (Exception e) {
            System.out.println("Error listando la producción intelectual!" + e.getMessage());
        }
        return "/portal/publicaciones.xhtml?faces-redirect=true";
    }
    
    //Getters - Setters

    public DataModel getListadoProduccionIntelectual() {
        return listadoProduccionIntelectual;
    }

    public void setListadoProduccionIntelectual(DataModel listadoProduccionIntelectual) {
        this.listadoProduccionIntelectual = listadoProduccionIntelectual;
    }

    public DataModel getListaTipoProduccion() {
        return listaTipoProduccion;
    }

    public void setListaTipoProduccion(DataModel listaTipoProduccion) {
        this.listaTipoProduccion = listaTipoProduccion;
    }

    public uis.giib.administrador.dao.ProduccionIntelectualFacade getEjbFacadeProduccionIntelectual() {
        return ejbFacadeProduccionIntelectual;
    }

    public void setEjbFacadeProduccionIntelectual(uis.giib.administrador.dao.ProduccionIntelectualFacade ejbFacadeProduccionIntelectual) {
        this.ejbFacadeProduccionIntelectual = ejbFacadeProduccionIntelectual;
    }

    public uis.giib.administrador.dao.TipoProduccionFacade getEjbFacadeTipoProduccion() {
        return ejbFacadeTipoProduccion;
    }

    public void setEjbFacadeTipoProduccion(uis.giib.administrador.dao.TipoProduccionFacade ejbFacadeTipoProduccion) {
        this.ejbFacadeTipoProduccion = ejbFacadeTipoProduccion;
    }    
}
