/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.administrador.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uis.giib.entidades.LineasInvestigador;

/**
 *
 * @author Carlos Humberto
 */
@Stateless
public class LineasInvestigadorFacade extends AbstractFacade<LineasInvestigador> {
    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineasInvestigadorFacade() {
        super(LineasInvestigador.class);
    }
    
}
