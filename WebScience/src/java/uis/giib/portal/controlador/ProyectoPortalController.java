package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import uis.giib.administrador.dao.ProyectoFacade;
import uis.giib.administrador.dao.TipoProyectoFacade;
import uis.giib.entidades.EstadoProyecto;
import uis.giib.entidades.LineaInvestigacion;
import uis.giib.entidades.Proyecto;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "proyectoPC")
@SessionScoped
public class ProyectoPortalController implements Serializable {

    //Atributos
    private List<Proyecto> listadoProyectos;
    private DataModel estadoProyectoList;
    private Proyecto proyectoActual;
    private LineaInvestigacion lineaInvestigacion;
    private Integer idEstado = new Integer(1);
    @EJB
    private uis.giib.administrador.dao.ProyectoFacade ejbProyectoFacade;
    @EJB
    private uis.giib.administrador.dao.TipoProyectoFacade ejbTipoProyectoFacade;
    @EJB
    private uis.giib.administrador.dao.EstadoProyectoFacade ejbEstadoProyectoFacade;

    // Contructor
    public ProyectoPortalController() {

        /*try {
         listadoProyectos = new ListDataModel(ejbProyectoFacade.findAll());
         //listadoProyectos = new ListDataModel((List) ejbProyectoFacade.buscarProyectosPorEstado(idTipo));
         listaTiposProyecto = new ListDataModel(ejbTipoProyectoFacade.findAll());
         estadoProyectoList = new ListDataModel(ejbEstadoProyectoFacade.findAll());
         } catch (Exception e) {
         System.out.println("Error listando Proyectos!");
         }*/
    }

    //Métodos de navegación
    public String goProyectos() {

        try {
            estadoProyectoList = new ListDataModel(ejbEstadoProyectoFacade.findAll());
            Iterator<EstadoProyecto> estProyIterator = estadoProyectoList.iterator();

            while (estProyIterator.hasNext()) {
                EstadoProyecto estProy = estProyIterator.next();
                listadoProyectos = estProy.getProyectoList();

                Iterator<Proyecto> proyectoIterator = listadoProyectos.iterator();

                try {
                    while (proyectoIterator.hasNext()) {
                        Proyecto proy = proyectoIterator.next();

                        if (proy.getIdEstadoGeneral().getIdEstado().intValue() != idEstado.intValue()) {
                            listadoProyectos.remove(proy);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Fin de la lista de Proyectos");
                }
                estProy.setProyectoList(listadoProyectos);
            }
        } catch (Exception e) {
            System.out.println("Error listando Proyectos!" + e.getLocalizedMessage() + " " + e.getMessage());
        }
        return "/portal/proyecto.xhtml?faces-redirect=true";
    }

    public String goDetallesProyecto(Proyecto proyecto) {

        try {
            proyectoActual = (Proyecto) proyecto;
        } catch (Exception e) {
            System.out.println("Error listando proyectos!");
        }
        return "/portal/proyectoDetalle.xhtml?faces-redirect=true";
    }

    //Getters - Setters  

    public Proyecto getProyectoActual() {
        return proyectoActual;
    }

    public void setProyectoActual(Proyecto proyectoActual) {
        this.proyectoActual = proyectoActual;
    }

    public ProyectoFacade getEjbFacade() {
        return ejbProyectoFacade;
    }

    public void setEjbFacade(ProyectoFacade ejbFacade) {
        this.ejbProyectoFacade = ejbFacade;
    }

    public TipoProyectoFacade getEjbTipoProyectoFacade() {
        return ejbTipoProyectoFacade;
    }

    public void setEjbTipoProyectoFacade(TipoProyectoFacade ejbTipoProyectoFacade) {
        this.ejbTipoProyectoFacade = ejbTipoProyectoFacade;
    }

    public DataModel getEstadoProyectoList() {
        return estadoProyectoList;
    }

    public void setEstadoProyectoList(DataModel estadoProyectoList) {
        this.estadoProyectoList = estadoProyectoList;
    }

    public uis.giib.administrador.dao.ProyectoFacade getEjbProyectoFacade() {
        return ejbProyectoFacade;
    }

    public void setEjbProyectoFacade(uis.giib.administrador.dao.ProyectoFacade ejbProyectoFacade) {
        this.ejbProyectoFacade = ejbProyectoFacade;
    }

    public uis.giib.administrador.dao.EstadoProyectoFacade getEjbEstadoProyectoFacade() {
        return ejbEstadoProyectoFacade;
    }

    public void setEjbEstadoProyectoFacade(uis.giib.administrador.dao.EstadoProyectoFacade ejbEstadoProyectoFacade) {
        this.ejbEstadoProyectoFacade = ejbEstadoProyectoFacade;
    }

    public LineaInvestigacion getLineaInvestigacion() {
        return lineaInvestigacion;
    }

    public void setLineaInvestigacion(LineaInvestigacion lineaInvestigacion) {
        this.lineaInvestigacion = lineaInvestigacion;
    }

    public List<Proyecto> getListadoProyectos() {
        return listadoProyectos;
    }

    public void setListadoProyectos(List<Proyecto> listadoProyectos) {
        this.listadoProyectos = listadoProyectos;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }
}
