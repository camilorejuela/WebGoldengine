/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.administrador.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uis.giib.entidades.TipoMultimedia;

/**
 *
 * @author Carlos
 */
@Stateless
public class TipoMultimediaFacade extends AbstractFacade<TipoMultimedia> {
    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoMultimediaFacade() {
        super(TipoMultimedia.class);
    }
    
}
