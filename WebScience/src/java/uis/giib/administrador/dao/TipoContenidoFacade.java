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
import uis.giib.entidades.TipoContenido;

/**
 *
 * @author Carlos
 */
@Stateless
public class TipoContenidoFacade extends AbstractFacade<TipoContenido> {

    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoContenidoFacade() {
        super(TipoContenido.class);
    }

    public TipoContenido buscarContenidoPorTipo(Integer idTipoContenido) {
        try {
            Query query = em.createNamedQuery("TipoContenido.findByIdTipoPublicacion");
            query.setParameter("idTipoPublicacion", idTipoContenido);
            return (TipoContenido) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
