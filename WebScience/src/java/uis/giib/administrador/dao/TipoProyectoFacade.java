/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.administrador.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uis.giib.entidades.TipoProyecto;

/**
 *
 * @author Carlos
 */
@Stateless
public class TipoProyectoFacade extends AbstractFacade<TipoProyecto> {
    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoProyectoFacade() {
        super(TipoProyecto.class);
    }
    
}
