/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.modelo.Tipoarticulo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.modelo.Tipoarticulo_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.modelo.Articulo;
import java.util.Collection;

/**
 *
 * @author lgcorredor
 */
@Stateless
public class TipoarticuloFacade extends AbstractFacade<Tipoarticulo> {

    @PersistenceContext(unitName = "pruebajava2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoarticuloFacade() {
        super(Tipoarticulo.class);
    }

    public boolean isArticuloCollectionEmpty(Tipoarticulo entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Tipoarticulo> tipoarticulo = cq.from(Tipoarticulo.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tipoarticulo, entity), cb.isNotEmpty(tipoarticulo.get(Tipoarticulo_.articuloCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Articulo> findArticuloCollection(Tipoarticulo entity) {
        Tipoarticulo mergedEntity = this.getMergedEntity(entity);
        Collection<Articulo> articuloCollection = mergedEntity.getArticuloCollection();
        articuloCollection.size();
        return articuloCollection;
    }
    
}
