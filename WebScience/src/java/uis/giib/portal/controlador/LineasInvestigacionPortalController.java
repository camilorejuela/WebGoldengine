package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import uis.giib.administrador.dao.LineaInvestigacionFacade;
import uis.giib.entidades.EstadoGeneral;
import uis.giib.entidades.LineaInvestigacion;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "lineasInvestigacionPC")
@SessionScoped
public class LineasInvestigacionPortalController implements Serializable {

    //private List<LineaInvestigacion> listadoLineasInvestigacion;
    private DataModel<LineaInvestigacion> listadoLineasInvestigacion;
    private LineaInvestigacion lineasInvestigacionActual;
    private EstadoGeneral estadoGeneral;
    private Integer idEstado = new Integer(1);
    @EJB
    private uis.giib.administrador.dao.EstadoGeneralFacade ejbFacadeEstadoGeneral;
    @EJB
    private uis.giib.administrador.dao.LineaInvestigacionFacade ejbFacadeLineaInvestigacion;

    //Constructor
    public LineasInvestigacionPortalController() {
        /*try {
         listadoLineasInvestigacion = new ListDataModel(ejbFacade.findAll());
         } catch (Exception e) {
         System.out.println("Error listando las Líneas de Investigaión!");
         }*/
    }

    //Métodos de navegación
    public String goLineasInvestigacion() {

        listadoLineasInvestigacion = new ListDataModel(ejbFacadeLineaInvestigacion.findAll());

        /*try {
         estadoGeneral = ejbFacadeEstadoGeneral.findByIdEstado(idEstado);
         listadoLineasInvestigacion = estadoGeneral.getLineaInvestigacionList();
         } catch (Exception e) {
         System.out.println("Error listando las Líneas de Investigaión!");
         }*/
        return "/portal/lineasInvestigacion.xhtml?faces-redirect=true";
    }

    public String goDetallesLineasInvestigacion(LineaInvestigacion linInvestiga) {

        try {
            lineasInvestigacionActual = (LineaInvestigacion) linInvestiga;
        } catch (Exception e) {
            System.out.println("Error Mostrando detalles Linea Investigación!");
        }
        return "/portal/lineasInvestigacionDetalle.xhtml?faces-redirect=true";
    }

    //Getters - Setters 
    public LineaInvestigacion getLineasInvestigacionActual() {
        return lineasInvestigacionActual;
    }

    public void setLineasInvestigacionActual(LineaInvestigacion lineasInvestigacionActual) {
        this.lineasInvestigacionActual = lineasInvestigacionActual;
    }
    
    

   /* public List<LineaInvestigacion> getListadoLineasInvestigacion() {
        return listadoLineasInvestigacion;
    }

    public void setListadoLineasInvestigacion(List<LineaInvestigacion> listadoLineasInvestigacion) {
        this.listadoLineasInvestigacion = listadoLineasInvestigacion;
    }*/

    public LineaInvestigacionFacade getEjbFacade() {
        return ejbFacadeLineaInvestigacion;
    }

    public void setEjbFacade(LineaInvestigacionFacade ejbFacade) {
        this.ejbFacadeLineaInvestigacion = ejbFacade;
    }

    public EstadoGeneral getEstadoGeneral() {
        return estadoGeneral;
    }

    public void setEstadoGeneral(EstadoGeneral estadoGeneral) {
        this.estadoGeneral = estadoGeneral;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public uis.giib.administrador.dao.EstadoGeneralFacade getEjbFacadeEstadoGeneral() {
        return ejbFacadeEstadoGeneral;
    }

    public void setEjbFacadeEstadoGeneral(uis.giib.administrador.dao.EstadoGeneralFacade ejbFacadeEstadoGeneral) {
        this.ejbFacadeEstadoGeneral = ejbFacadeEstadoGeneral;
    }

    public uis.giib.administrador.dao.LineaInvestigacionFacade getEjbFacadeLineaInvestigacion() {
        return ejbFacadeLineaInvestigacion;
    }

    public void setEjbFacadeLineaInvestigacion(uis.giib.administrador.dao.LineaInvestigacionFacade ejbFacadeLineaInvestigacion) {
        this.ejbFacadeLineaInvestigacion = ejbFacadeLineaInvestigacion;
    }

    public DataModel<LineaInvestigacion> getListadoLineasInvestigacion() {
        return listadoLineasInvestigacion;
    }

    public void setListadoLineasInvestigacion(DataModel<LineaInvestigacion> listadoLineasInvestigacion) {
        this.listadoLineasInvestigacion = listadoLineasInvestigacion;
    }
}
