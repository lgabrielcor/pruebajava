/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.modelo.Articulo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.modelo.Articulo_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.modelo.Tipoarticulo;

/**
 *
 * @author lgcorredor
 */
@Stateless
public class ArticuloFacade extends AbstractFacade<Articulo> {

    @PersistenceContext(unitName = "pruebajava2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticuloFacade() {
        super(Articulo.class);
    }

    public boolean isIdtipoarticuloEmpty(Articulo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Articulo> articulo = cq.from(Articulo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(articulo, entity), cb.isNotNull(articulo.get(Articulo_.idtipoarticulo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Tipoarticulo findIdtipoarticulo(Articulo entity) {
        return this.getMergedEntity(entity).getIdtipoarticulo();
    }
    
}
