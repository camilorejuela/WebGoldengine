package uis.giib.administrador.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uis.giib.entidades.Investigador;

/**
 *
 * @author Carlos David Prada Remolina
 */
@Stateless
public class InvestigadorFacade extends AbstractFacade<Investigador> {

    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InvestigadorFacade() {
        super(Investigador.class);
    }

    public Investigador loginAdministrador(String user, String password) {

        try {
            Query query = em.createNamedQuery("Investigador.findByLoginParameters");
            query.setParameter("usuarioInvestigador", user);
            query.setParameter("contrasenaInvestigador", password);
            return (Investigador) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
