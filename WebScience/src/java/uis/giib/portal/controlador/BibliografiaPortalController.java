
package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;


/**
 * @author Carlos David Prada Remolina
 * @author cristhian
 */
@Named(value = "bibliografiaPC")
@SessionScoped
public class BibliografiaPortalController implements Serializable {

    //Atributos 
    private DataModel listadoBibliografia;
    private DataModel listaTipoBibliografia;
    @EJB
    private uis.giib.administrador.dao.ProduccionIntelectualFacade ejbFacadeBibliografia;
    @EJB
    private uis.giib.administrador.dao.TipoProduccionFacade ejbFacadeTipoProduccion;

    //Constructor
    public void BibliografiaPortalController() {
    }

    //Métodos de Navegación
    public String goBibliografia() {
        try {
            listadoBibliografia = new ListDataModel(ejbFacadeBibliografia.findAll());
            listaTipoBibliografia = new ListDataModel(ejbFacadeTipoProduccion.findAll());
        } catch (Exception e) {
            System.out.println("Error listando la producción intelectual!" + e.getMessage());
        }
        return "/portal/referenciasBibliograficas.xhtml?faces-redirect=true";
    }
    
    //Getters - Setters

    public DataModel getListadoBibliografia() {
        return listadoBibliografia;
    }

    public void setListadoBibliografia(DataModel listadoBibliografia) {
        this.listadoBibliografia = listadoBibliografia;
    }

    public DataModel getListaTipoBibliografia() {
        return listaTipoBibliografia;
    }

    public void setListaTipoBibliografia(DataModel listaTipoBibliografia) {
        this.listaTipoBibliografia = listaTipoBibliografia;
    }

    public uis.giib.administrador.dao.ProduccionIntelectualFacade getEjbFacadeBibliografia() {
        return ejbFacadeBibliografia;
    }

    public void setEjbFacadeBibliografia(uis.giib.administrador.dao.ProduccionIntelectualFacade ejbFacadeBibliografia) {
        this.ejbFacadeBibliografia = ejbFacadeBibliografia;
    }

    public uis.giib.administrador.dao.TipoProduccionFacade getEjbFacadeTipoProduccion() {
        return ejbFacadeTipoProduccion;
    }

    public void setEjbFacadeTipoProduccion(uis.giib.administrador.dao.TipoProduccionFacade ejbFacadeTipoProduccion) {
        this.ejbFacadeTipoProduccion = ejbFacadeTipoProduccion;
    }
}
