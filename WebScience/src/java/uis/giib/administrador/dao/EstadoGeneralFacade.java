/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.administrador.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uis.giib.entidades.EstadoGeneral;

/**
 *
 * @author Carlos David Prada Remolina 
 */
@Stateless
public class EstadoGeneralFacade extends AbstractFacade<EstadoGeneral> {
    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoGeneralFacade() {
        super(EstadoGeneral.class);
    }
    
     public EstadoGeneral findByIdEstado(Integer idEstado) {

        try {
            Query query = em.createNamedQuery("EstadoGeneral.findByIdEstado");
            query.setParameter("idEstado", idEstado);
            return (EstadoGeneral) query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Error en la consulta findByIdEstado!" + e.getLocalizedMessage());
            return null;
        }
    } 
}
