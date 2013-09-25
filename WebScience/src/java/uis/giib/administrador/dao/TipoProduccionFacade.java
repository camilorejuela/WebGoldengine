/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.administrador.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uis.giib.entidades.TipoProduccion;

/**
 *
 * @author Carlos
 */
@Stateless
public class TipoProduccionFacade extends AbstractFacade<TipoProduccion> {
    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoProduccionFacade() {
        super(TipoProduccion.class);
    }
    
}
