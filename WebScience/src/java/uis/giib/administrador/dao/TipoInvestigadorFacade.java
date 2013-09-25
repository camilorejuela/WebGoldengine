/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.administrador.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uis.giib.entidades.Investigador;
import uis.giib.entidades.TipoInvestigador;

/**
 *
 * @author Carlos Humberto
 */
@Stateless
public class TipoInvestigadorFacade extends AbstractFacade<TipoInvestigador> {
    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoInvestigadorFacade() {
        super(TipoInvestigador.class);
    }
    
    public List<TipoInvestigador> findAllNombreTipoInvestigador() {

        try {
            Query query = em.createNamedQuery("TipoPublicacion.findAllNombreTipoInvestigador");
            return (List<TipoInvestigador>) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    
    public List<TipoInvestigador> listarInvestigadores() {
        Query query = em.createNamedQuery("SELECT t FROM TipoInvestigador t WHERE t.investigadorList.idEstado.idEstado=1");
        return query.getResultList();
    }
    
    
    
}
