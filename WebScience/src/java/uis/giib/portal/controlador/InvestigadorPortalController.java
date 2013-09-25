package uis.giib.portal.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import uis.giib.administrador.dao.TipoInvestigadorFacade;
import uis.giib.entidades.Investigador;
import uis.giib.entidades.TipoInvestigador;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Named(value = "investigadorPC")
@SessionScoped
public class InvestigadorPortalController implements Serializable {

    //Atributos
    private List<Investigador> listadoInvestigadores;
    private List<Investigador> listadoInvestigadoresaux;
    private DataModel listaTiposInvestigador;
    private Investigador investigadorActual;
    private Integer idEstado = new Integer(1);
    @EJB
    private uis.giib.administrador.dao.TipoInvestigadorFacade ejbFacadeTipoInvestigador;

    //constructor
    public InvestigadorPortalController() {

        /*try {
         estadoGeneral = ejbFacadeEstadoGeneral.findByIdEstado(idEstado);
         listaTiposInvestigador = new ListDataModel(ejbFacadeTipoInvestigador.findAll());

         Iterator<TipoInvestigador> tipoInv = listaTiposInvestigador.iterator();
         while (tipoInv.hasNext()) {
         TipoInvestigador i = tipoInv.next();
         listadoInvestigadores = i.getInvestigadorList();

         Iterator<Investigador> investigadorIterator = listadoInvestigadores.iterator();
         while (investigadorIterator.hasNext()) {
         Investigador inv = investigadorIterator.next();

         if (inv.getIdEstado().getIdEstado() != idEstado) {
         listadoInvestigadores.remove(inv);
         }
         }
         i.setInvestigadorList(listadoInvestigadores);
         }

         } catch (Exception e) {
         System.out.println("Error listando investitadores Constructor!" + e.getLocalizedMessage() + " " + e.getMessage());
         }*/
    }

    //Métodos de navegación
    /**
     * Método que redirige al usuario a la página de investigadores.xhtml
     *
     * @return Dirección de la página de investigadores.xhtml
     */
    public String goInvestigadores() {

        try {
            //estadoGeneral = ejbFacadeEstadoGeneral.findByIdEstado(idEstado);
            listaTiposInvestigador = new ListDataModel(ejbFacadeTipoInvestigador.findAll());
            /*Iterator<TipoInvestigador> tipoInvIterator = listaTiposInvestigador.iterator();

            while (tipoInvIterator.hasNext()) {
                TipoInvestigador tipoInv = tipoInvIterator.next();
                listadoInvestigadores = tipoInv.getInvestigadorList();
                listadoInvestigadoresaux = listadoInvestigadores;
                Iterator<Investigador> investigadorIterator = listadoInvestigadores.iterator();

                try {
                    while (investigadorIterator.hasNext()) {
                        Investigador inv = investigadorIterator.next();

                        System.out.println(inv.getNombreInvestigador());
                        System.out.println(inv.getIdEstado().getNombreEstado());
                        System.out.println(tipoInv.getNombreTipoInvestigador());

                        if (inv.getIdEstado().getIdEstado().intValue() != idEstado.intValue()) {
                            listadoInvestigadores.remove(inv);
                        }

                        System.out.println(inv.getNombreInvestigador());
                        System.out.println(inv.getIdEstado().getNombreEstado());
                        System.out.println(tipoInv.getNombreTipoInvestigador());
                    }
                } catch (Exception e) {
                    System.out.println("Fin de la lista de Investigadores");
                }
                tipoInv.setInvestigadorList(listadoInvestigadores);
            */
        } catch (Exception e) {
            System.out.println("Error listando investitadores GoInvestigador!" + e.getLocalizedMessage() + " " + e.getMessage());
        }
        return "/portal/investigadores.xhtm?faces-redirect=truel";
    }

    /**
     * Método que redirige al usuario a la página de investigadoresDetalle.xhtml
     *
     * @param investigador: Objeto que contiene el investigdor cuyos detalles
     * serán explorados
     * @return Dirección de la página de investigadoresDetalle.xhtml
     */
    public String goDetallesInvestigador(Investigador investigador) {

        try {
            investigadorActual = (Investigador) investigador;
        } catch (Exception e) {
            System.out.println("Error Mostrando detalles Investigador!");
        }
        return "/portal/investigadoresDetalle.xhtml?faces-redirect=true";
    }

    // Getters - Setters
    public TipoInvestigadorFacade getEjbFacadeTipoInvestigador() {
        return ejbFacadeTipoInvestigador;
    }

    public void setEjbFacadeTipoInvestigador(TipoInvestigadorFacade ejbFacadeTipoInvestigador) {
        this.ejbFacadeTipoInvestigador = ejbFacadeTipoInvestigador;
    }

    public List<Investigador> getListadoInvestigadores() {
        return listadoInvestigadores;
    }

    public void setListadoInvestigadores(List<Investigador> listadoInvestigadores) {
        this.listadoInvestigadores = listadoInvestigadores;
    }

    public DataModel getListaTiposInvestigador() {
        return listaTiposInvestigador;
    }

    public void setListaTiposInvestigador(DataModel listaTiposInvestigador) {
        this.listaTiposInvestigador = listaTiposInvestigador;
    }

    public Investigador getInvestigadorActual() {
        return investigadorActual;
    }

    public void setInvestigadorActual(Investigador investigadorActual) {
        this.investigadorActual = investigadorActual;
    }

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public List<Investigador> getListadoInvestigadoresaux() {
        return listadoInvestigadoresaux;
    }

    public void setListadoInvestigadoresaux(List<Investigador> listadoInvestigadoresaux) {
        this.listadoInvestigadoresaux = listadoInvestigadoresaux;
    }
}
