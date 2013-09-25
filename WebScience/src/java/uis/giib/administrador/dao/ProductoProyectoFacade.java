/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uis.giib.administrador.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uis.giib.entidades.ProductoProyecto;

/**
 *
 * @author Carlos
 */
@Stateless
public class ProductoProyectoFacade extends AbstractFacade<ProductoProyecto> {
    @PersistenceContext(unitName = "WebSciencePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductoProyectoFacade() {
        super(ProductoProyecto.class);
    }
    
}
