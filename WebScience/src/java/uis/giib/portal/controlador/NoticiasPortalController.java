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
 * @author Cristhian Ruiz
 */
@Named(value = "noticiasPC")
@SessionScoped
public class NoticiasPortalController implements Serializable {

    private DataModel<Contenido> listadoNoticias;
    private TipoContenido tipoContenido;
    private Contenido contenidoActual;
    private Integer idTipo = new Integer(6);
    // LLama objeto encargado de hacer las consultas a la DB
    @EJB
    private uis.giib.administrador.dao.TipoContenidoFacade ejbFacade;

    /**
     * Creates a new instance of ProyectoPortalController
     */
    // en un ListDataModel colocamos todos los proyectos en la DB
    public NoticiasPortalController() {

        try {

            tipoContenido = ejbFacade.buscarContenidoPorTipo(idTipo);
            listadoNoticias = new ListDataModel(tipoContenido.getContenidoList());
        } catch (Exception e) {
            System.out.println("Error listando Noticias!");
        }
    }

    public String goNoticiasPortalController() {
        try {
            tipoContenido = ejbFacade.buscarContenidoPorTipo(idTipo);
            listadoNoticias = new ListDataModel(tipoContenido.getContenidoList());
        } catch (Exception e) {
            System.out.println("Error listando Noticias!");
        }
        return "/portal/noticias.xhtml?faces-redirect=true";
    }

    public DataModel getListadoNoticias() {
        return listadoNoticias;
    }

    public void setListadoNoticias(DataModel listadoNoticias) {
        this.listadoNoticias = listadoNoticias;
    }

    public Contenido getPublicacionActual() {
        return contenidoActual;
    }

    public void setPublicacionActual(Contenido publicacionActual) {
        this.contenidoActual = publicacionActual;
    }

    public TipoContenido getTipoPublicacion() {
        return tipoContenido;
    }

    public void setTipoPublicacion(TipoContenido tipoPublicacion) {
        this.tipoContenido = tipoPublicacion;
    }

    public TipoContenidoFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(TipoContenidoFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }
}
